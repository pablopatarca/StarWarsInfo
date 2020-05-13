package com.example.starwars

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


        call.enqueue(object : Callback<NamesData> {
            override fun onResponse(call: Call<NamesData>, response: Response<NamesData>) {
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
            override fun onFailure(call: Call<NamesData>, t: Throwable) {
                Log.e("myapp", t.message)
            }
        })
    }

    fun makePlanetsCall(next: String, namesList: LinkedHashMap<String,String>, presenter: MainPresenter)
    {
        val request = APIClient.buildService(APIInterface::class.java)
        val call = request.getNames(next)


        call.enqueue(object : Callback<NamesData> {
            override fun onResponse(call: Call<NamesData>, response: Response<NamesData>) {
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
            override fun onFailure(call: Call<NamesData>, t: Throwable) {
                Log.e("myapp", t.message)
            }
        })
    }

    fun makeStarshipsCall(next: String, namesList: LinkedHashMap<String,String>, presenter: MainPresenter)
    {
        val request = APIClient.buildService(APIInterface::class.java)
        val call = request.getNames(next)


        call.enqueue(object : Callback<NamesData> {
            override fun onResponse(call: Call<NamesData>, response: Response<NamesData>) {
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
            override fun onFailure(call: Call<NamesData>, t: Throwable) {
                Log.e("myapp", t.message)
            }
        })
    }


    /*********************************************************************************/
    /***    Make a call to the get[Person]() method, returns Person_Data object    ***/
    /*********************************************************************************/
    fun makePersonDetailsCall(url: String, person: PersonData, presenter: PeoplePresenter)
    {
        val request = APIClient.buildService(APIInterface::class.java)
        val call = url.let { request.getPerson(it) }

        call.enqueue(object : Callback<PersonData> {
            override fun onResponse(call: Call<PersonData>, response: Response<PersonData>) {
                if (response.isSuccessful) {
                    val resource = response.body()
                    person.name = resource?.name.toString()
                    person.height = resource?.height.toString()
                    person.mass = resource?.mass.toString()
                    person.hair_color = resource?.hair_color.toString()
                    person.skin_color = resource?.skin_color.toString()
                    presenter.finishPersonDetailsCall(person)
                } else {
                    Log.e("myapp", "SOMETHING WENT WRONG")
                }
            }

            override fun onFailure(call: Call<PersonData>, t: Throwable) {
                Log.e("myapp", t.message)
            }
        })
    }

    fun makePlanetDetailsCall(url: String, planet: PlanetData, presenter: PlanetsPresenter)
    {
        val request = APIClient.buildService(APIInterface::class.java)
        val call = url.let { request.getPlanet(it) }

        call.enqueue(object : Callback<PlanetData> {
            override fun onResponse(call: Call<PlanetData>, response: Response<PlanetData>) {
                if (response.isSuccessful) {
                    val resource = response.body()
                    planet.name = resource?.name.toString()
                    planet.rotation_period = resource?.rotation_period.toString()
                    planet.orbital_period = resource?.orbital_period.toString()
                    planet.diameter = resource?.diameter.toString()
                    planet.climate = resource?.climate.toString()
                    presenter.finishPersonDetailsCall(planet)
                } else {
                    Log.e("myapp", "SOMETHING WENT WRONG")
                }
            }

            override fun onFailure(call: Call<PlanetData>, t: Throwable) {
                Log.e("myapp", t.message)
            }
        })
    }

    fun makeStarshipDetailsCall(url: String, starship: StarshipData, presenter: StarshipsPresenter)
    {
        val request = APIClient.buildService(APIInterface::class.java)
        val call = url.let { request.getStarship(it) }

        call.enqueue(object : Callback<StarshipData> {
            override fun onResponse(call: Call<StarshipData>, response: Response<StarshipData>) {
                if (response.isSuccessful) {
                    val resource = response.body()
                    starship.name = resource?.name.toString()
                    starship.model = resource?.model.toString()
                    starship.manufacturer = resource?.manufacturer.toString()
                    starship.cost_in_credits = resource?.cost_in_credits.toString()
                    starship.length = resource?.length.toString()
                    presenter.finishStarshipDetailsCall(starship)
                } else {
                    Log.e("myapp", "SOMETHING WENT WRONG")
                }
            }

            override fun onFailure(call: Call<StarshipData>, t: Throwable) {
                Log.e("myapp", t.message)
            }
        })
    }

}