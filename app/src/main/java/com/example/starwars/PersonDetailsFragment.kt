package com.example.starwars

import android.app.Person
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_person_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonDetailsFragment : Fragment() {

    val DETAILS_TAG = "fragment_details"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_person_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var position = arguments?.getInt("position")
        position = position?.plus(1)        //incrementa di 1 la posizione perchè gli indici di un json array partono da 1



        val request = APIClient.buildService(APIInterface::class.java)
        val call = request.getPerson(position.toString())

        call.enqueue(object : Callback<Person_Data> {
            override fun onResponse(call: Call<Person_Data>, response: Response<Person_Data>) {
                if (response.isSuccessful) {
                    val resource = response.body()
                    title_details_tv.text = resource?.name
                    height_tv_content.text = resource?.height.toString()
                    mass_tv_content.text = resource?.mass.toString()
                    hair_color_tv_content.text = resource?.hair_color
                    skin_color_tv_content.text = resource?.skin_color
                }
                else {
                    Log.e("myapp", "SOMETHING WENT WRONG")
                }
            }
            override fun onFailure(call: Call<Person_Data>, t: Throwable) {
                Log.e("myapp", t.message)
            }
        })
    }
}