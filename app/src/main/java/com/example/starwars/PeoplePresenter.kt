package com.example.starwars

import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
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
                    val retrievedData = repository.getPerson(url)
                    val person = PersonData(
                        retrievedData?.name.toString(),
                        retrievedData?.height.toString(),
                        retrievedData?.mass.toString(),
                        retrievedData?.hair_color.toString(),
                        retrievedData?.skin_color.toString()
                    )

                    //present data
                    withContext(Dispatchers.Main)   {
                        view.startNewFragment(person)
                    }
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