package com.example.starwars

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_starship_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StarshipDetailsFragment : Fragment() {

    val DETAILS_TAG = "fragment_details"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_starship_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var url = arguments?.getString("url")

        val request = APIClient.buildService(APIInterface::class.java)
        val call = url?.let { request.getStarship(it) }

        call?.enqueue(object : Callback<Starship_Data> {
            override fun onResponse(call: Call<Starship_Data>, response: Response<Starship_Data>) {
                if (response.isSuccessful) {
                    val resource = response.body()
                    title_details_tv.text = resource?.name
                    model_tv_content.text = resource?.model
                    manufacturer_tv_content.text = resource?.manufacturer
                    cost_in_tv_content.text = resource?.cost_in_credits.toString()
                    length_tv_content.text = resource?.length.toString()

                    progress_circular.visibility = View.GONE
                }
                else {
                    Log.e("myapp", "SOMETHING WENT WRONG")
                }
            }
            override fun onFailure(call: Call<Starship_Data>, t: Throwable) {
                Log.e("myapp", t.message)
            }
        })
    }
}