package com.example.starwars

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_person_details.*
import kotlinx.android.synthetic.main.fragment_person_details.title_details_tv
import kotlinx.android.synthetic.main.fragment_planet_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlanetDetailsFragment : Fragment() {

    val DETAILS_TAG = "fragment_details"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_planet_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var url = arguments?.getString("url")
        url = url?.replace("http://swapi.dev/api/planets/", "")
        //elimina tutto dall'url, tranne l'indice

        val request = APIClient.buildService(APIInterface::class.java)
        val call = url?.let { request.getPlanet(it) }

        call?.enqueue(object : Callback<Planet_Data> {
            override fun onResponse(call: Call<Planet_Data>, response: Response<Planet_Data>) {
                if (response.isSuccessful) {
                    val resource = response.body()
                    title_details_tv.text = resource?.name
                    rotation_tv_content.text = resource?.rotation_period.toString()
                    orbital_tv_content.text = resource?.orbital_period.toString()
                    diameter_tv_content.text = resource?.diameter.toString()
                    climate_tv_content.text = resource?.climate
                }
                else {
                    Log.e("myapp", "SOMETHING WENT WRONG")
                }
            }
            override fun onFailure(call: Call<Planet_Data>, t: Throwable) {
                Log.e("myapp", t.message)
            }
        })
    }
}