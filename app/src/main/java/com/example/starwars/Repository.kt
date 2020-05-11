package com.example.starwars

import android.database.StaleDataException
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    private val peopleNext = "https://swapi.dev/api/people/"
    private val planetsNext = "https://swapi.dev/api/planets/"
    private val starshipsNext = "https://swapi.dev/api/starships/"

    /*********************************************************************************/
    /***        Returns the URL of people list      ***/
    /*********************************************************************************/
    fun getPeopleNext(): String
    {
        return peopleNext
    }

    fun getPlanetsNext(): String
    {
        return planetsNext
    }

    fun getStarshipsNext(): String
    {
        return starshipsNext
    }


    /*********************************************************************************/
    /***    Make a call to the getNames() method, returns a list of strings        ***/
    /*********************************************************************************/
    fun makePeopleCall(next: String, namesList: LinkedHashMap<String,String>, presenter: MainPresenter)
    {
        val request = APIClient.buildService(APIInterface::class.java)
        val call = request.getNames(next)


        call.enqueue(object : Callback<Names_Data> {
            override fun onResponse(call: Call<Names_Data>, response: Response<Names_Data>) {
                if (response.isSuccessful) {
                    val resource = response.body()
                    val resultsList = resource?.results
                    val next = resource?.next
                    resultsList?.forEach {
                        namesList.put(it.name, it.url)
                    }

                    if(!next.isNullOrEmpty()) {
                        makePeopleCall(next, namesList, presenter)
                    }
                    else
                    {
                        presenter.finishPeopleCall(namesList)
                    }
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

    fun makePlanetsCall(next: String, namesList: LinkedHashMap<String,String>, presenter: MainPresenter)
    {
        val request = APIClient.buildService(APIInterface::class.java)
        val call = request.getNames(next)


        call.enqueue(object : Callback<Names_Data> {
            override fun onResponse(call: Call<Names_Data>, response: Response<Names_Data>) {
                if (response.isSuccessful) {
                    val resource = response.body()
                    val resultsList = resource?.results
                    val next = resource?.next
                    resultsList?.forEach {
                        namesList.put(it.name, it.url)
                    }

                    if(!next.isNullOrEmpty()) {
                        makePlanetsCall(next, namesList, presenter)
                    }
                    else
                    {
                        presenter.finishPlanetsCall(namesList)
                    }
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

    fun makeStarshipsCall(next: String, namesList: LinkedHashMap<String,String>, presenter: MainPresenter)
    {
        val request = APIClient.buildService(APIInterface::class.java)
        val call = request.getNames(next)


        call.enqueue(object : Callback<Names_Data> {
            override fun onResponse(call: Call<Names_Data>, response: Response<Names_Data>) {
                if (response.isSuccessful) {
                    val resource = response.body()
                    val resultsList = resource?.results
                    val next = resource?.next
                    resultsList?.forEach {
                        namesList.put(it.name, it.url)
                    }

                    if(!next.isNullOrEmpty()) {
                        makeStarshipsCall(next, namesList, presenter)
                    }
                    else
                    {
                        presenter.finishStarshipsCall(namesList)
                    }
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


    /*********************************************************************************/
    /***    Make a call to the get[Person]() method, returns Person_Data object    ***/
    /*********************************************************************************/
    fun makePersonDetailsCall(url: String, person: Person_Data, presenter: PeoplePresenter)
    {
        val request = APIClient.buildService(APIInterface::class.java)
        val call = url.let { request.getPerson(it) }

        call.enqueue(object : Callback<Person_Data> {
            override fun onResponse(call: Call<Person_Data>, response: Response<Person_Data>) {
                if (response.isSuccessful) {
                    val resource = response.body()
                    //TODO complete call
                } else {
                    Log.e("myapp", "SOMETHING WENT WRONG")
                }
            }

            override fun onFailure(call: Call<Person_Data>, t: Throwable) {
                Log.e("myapp", t.message)
            }
        })
    }

    fun makePlanetDetailsCall(url: String, planet: Planet_Data, presenter: PlanetsPresenter)
    {
        val request = APIClient.buildService(APIInterface::class.java)
        val call = url.let { request.getPlanet(it) }

        call.enqueue(object : Callback<Planet_Data> {
            override fun onResponse(call: Call<Planet_Data>, response: Response<Planet_Data>) {
                if (response.isSuccessful) {
                    val resource = response.body()
                    //TODO complete call
                } else {
                    Log.e("myapp", "SOMETHING WENT WRONG")
                }
            }

            override fun onFailure(call: Call<Planet_Data>, t: Throwable) {
                Log.e("myapp", t.message)
            }
        })
    }

    fun makeStarshipDetailsCall(url: String, starship: Starship_Data, presenter: StarshipsPresenter)
    {
        val request = APIClient.buildService(APIInterface::class.java)
        val call = url.let { request.getStarship(it) }

        call.enqueue(object : Callback<Starship_Data> {
            override fun onResponse(call: Call<Starship_Data>, response: Response<Starship_Data>) {
                if (response.isSuccessful) {
                    val resource = response.body()
                    //TODO complete call
                } else {
                    Log.e("myapp", "SOMETHING WENT WRONG")
                }
            }

            override fun onFailure(call: Call<Starship_Data>, t: Throwable) {
                Log.e("myapp", t.message)
            }
        })
    }

}