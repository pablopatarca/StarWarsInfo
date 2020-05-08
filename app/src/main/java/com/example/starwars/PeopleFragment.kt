package com.example.starwars

import android.app.Person
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_people.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PeopleFragment : Fragment() {

    val TYPE_TAG = "fragment_type"
    var peopleList = LinkedHashMap<String,String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_people, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        makeCall("https://swapi.dev/api/people/")
    }



    fun makeCall(next: String)
    {
        val request = APIClient.buildService(APIInterface::class.java)
        val call = request.getNames(next)

        call.enqueue(object : Callback<Names_Data> {
            override fun onResponse(call: Call<Names_Data>, response: Response<Names_Data>) {
                if (response.isSuccessful) {
                    val resource = response.body()
                    val resultsList = resource?.results
                    var next = resource?.next
                    resultsList?.forEach {
                        peopleList.put(it.name, it.url)
                    }

                    if(!next.isNullOrEmpty()) {
                        makeCall(next)
                    }
                    else
                        buildRecyclerView(peopleList)
                }
                else {
                    Log.e("myapp", "SOMETHING WENT WRONG")
                }
            }
            override fun onFailure(call: Call<Names_Data>, t: Throwable) {
                Log.e("myapp", t.message)
            }
        })
    }


    fun buildRecyclerView(peopleList: LinkedHashMap<String,String>)
    {
        val itemAdapter = ItemAdapter(peopleList.keys)
        itemAdapter.setListener {
            val args = Bundle()
            args.putString("url", peopleList.get(peopleList.keys.elementAt(itemAdapter.getPosition())))
            val fragment = PersonDetailsFragment()
            fragment.arguments = args
            fragmentManager?.beginTransaction()?.replace(R.id.container, fragment)?.addToBackStack(TYPE_TAG)?.commit()
        }

        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = itemAdapter
        }

        progress_circular.visibility = View.GONE
    }
}