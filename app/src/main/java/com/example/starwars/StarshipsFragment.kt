package com.example.starwars

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_starships.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class StarshipsFragment : Fragment() {

    val TYPE_TAG = "fragment_type"


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_starships, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val request = APIClient.buildService(APIInterface::class.java)
        val call = request.getStarships()

        call.enqueue(object : Callback<Names_Data> {
            override fun onResponse(call: Call<Names_Data>, response: Response<Names_Data>) {
                if (response.isSuccessful) {
                    val resource = response.body()
                    val resultsList = resource?.results
                    var starshipsList = LinkedHashMap<String,String>()
                    resultsList?.forEach {
                        starshipsList.put(it.name, it.url)
                    }

                    buildRecyclerView(starshipsList)
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


    fun buildRecyclerView(starshipsList: LinkedHashMap<String,String>)
    {
        val itemAdapter = ItemAdapter(starshipsList.keys)
        itemAdapter.setListener {
            val args = Bundle()
            args.putString("url", starshipsList.get(starshipsList.keys.elementAt(itemAdapter.getPosition())))
            val fragment = StarshipDetailsFragment()
            fragment.arguments = args
            fragmentManager?.beginTransaction()?.replace(R.id.container, fragment)?.addToBackStack(TYPE_TAG)?.commit()
        }
        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = itemAdapter
        }
    }
}