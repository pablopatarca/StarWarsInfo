package com.example.starwars

import android.annotation.SuppressLint
import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.*
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

class PeoplePresenter(val view: PeopleContract.View, val repository: Repository = Repository()
) : PeopleContract.Presenter, CoroutineScope {

    override val coroutineContext: CoroutineContext = Job() + Dispatchers.IO

    init {
        view.setPresenter(this)

    }

    override fun makePersonDetailsCall(peopleList: LinkedHashMap<String,String>, position: Int) {
        val url = peopleList.get(peopleList.keys.elementAt(position))
        if (url != null) {
//            repository.makePersonDetailsCall(url, this)

            launch {

                try {
                    //retrieve data
                    val retrievedData : Observable<PersonData> = repository.getPerson(url)
                    var person : PersonData? = null
                    val x = retrievedData.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                            //onSuccess
                            {
                                val person = PersonData(
                                    it.name,
                                    it.height,
                                    it.mass,
                                    it.hair_color,
                                    it.skin_color
                                )
                                //present data
                                view.startNewFragment(person)
                            },
                            //onError
                            {
                                Log.d("myapp", "error")
                            }
                        )



                    //present data
//                    withContext(Dispatchers.Main)   {
//                        person?.let { view.startNewFragment(it) }
//                    }
                }
                catch (e: Exception)    {
                    withContext(Dispatchers.Main)   {
                        e.message?.let { view.showError(it) }
                    }
                }

            }
        }
    }
}