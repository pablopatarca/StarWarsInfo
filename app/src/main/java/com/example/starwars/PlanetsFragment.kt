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
import kotlinx.android.synthetic.main.fragment_planets.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PlanetsFragment : Fragment() {

    val TYPE_TAG = "fragment_type"
    var planetsList = LinkedHashMap<String,String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_planets, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        makeCall("https://swapi.dev/api/planets/")
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
                        planetsList.put(it.name, it.url)
                    }

                    if(!next.isNullOrEmpty()) {
                        makeCall(next)
                    }
                    else
                        buildRecyclerView(planetsList)
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

    fun buildRecyclerView(planetsList: LinkedHashMap<String,String>)
    {
        val itemAdapter = ItemAdapter(planetsList.keys)
        itemAdapter.setListener {
            val args = Bundle()
            args.putString("url", planetsList.get(planetsList.keys.elementAt(itemAdapter.getPosition())))
            val fragment = PlanetDetailsFragment()
            fragment.arguments = args
            fragmentManager?.beginTransaction()?.replace(R.id.container, fragment)?.addToBackStack(TYPE_TAG)?.commit()
        }
        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = itemAdapter
        }

        progress_circular.visibility = View.GONE
    }



    fun startNewFragment(planet: Planet_Data)
    {
        val args = Bundle()
        args.putSerializable("planet", planet)
        val fragment = PlanetDetailsFragment()
        fragment.arguments = args
        fragmentManager?.beginTransaction()?.replace(R.id.container, fragment)?.addToBackStack(TYPE_TAG)?.commit()
    }
}