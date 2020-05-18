package com.example.starwars

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import retrofit2.http.GET

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
    val request = APIClient.buildService(APIInterface::class.java)

//    @Throws(Exception::class)
//    suspend fun getPerson(url: String) : Observable<PersonData>? {
//
//        val call: Response<Observable<PersonData>> = request.getPerson(url).execute()
////        val call : Response<PersonData>? = null        //to test exception throwing
//
//        if (call == null) {
//            throw Exception("Call returned a null value")
//        } else {
//            val ret = call.body()
//
//            if(ret == null) {
//                throw Exception("Call returned a null value")
//            }
//            else {
//                ret.subscribeOn(Schedulers.io())
//                return ret
//            }
//        }
//    }

    @Throws(Exception::class)
    suspend fun getPerson(url: String) : Observable<PersonData> {

        val observable = request.getPerson(url)
        observable.subscribeOn(Schedulers.io())
        return observable
    }

    fun makePersonDetailsCall(url: String, presenter: PeoplePresenter)
    {
//        val request = APIClient.buildService(APIInterface::class.java)
//        val call = url.let { request.getPerson(it) }



//        call.enqueue(object : Callback<PersonData> {
//            override fun onResponse(call: Call<PersonData>, response: Response<PersonData>) {
//                if (response.isSuccessful) {
//                    val resource = response.body()
//                    val person = PersonData(
//                        resource?.name.toString(),
//                        resource?.height.toString(),
//                        resource?.mass.toString(),
//                        resource?.hair_color.toString(),
//                        resource?.skin_color.toString()
//                    )
//                    presenter.finishPersonDetailsCall(person)
//                } else {
//                    Log.e("myapp", "SOMETHING WENT WRONG")
//                }
//            }
//
//            override fun onFailure(call: Call<PersonData>, t: Throwable) {
//                Log.e("myapp", t.message)
//            }
//        })
    }

    fun makePlanetDetailsCall(url: String, presenter: PlanetsPresenter)
    {
        val request = APIClient.buildService(APIInterface::class.java)
        val call = url.let { request.getPlanet(it) }

        call.enqueue(object : Callback<PlanetData> {
            override fun onResponse(call: Call<PlanetData>, response: Response<PlanetData>) {
                if (response.isSuccessful) {
                    val resource = response.body()
                    val planet = PlanetData(
                        resource?.name.toString(),
                        resource?.rotation_period.toString(),
                        resource?.orbital_period.toString(),
                        resource?.diameter.toString(),
                        resource?.climate.toString()
                    )
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

    fun makeStarshipDetailsCall(url: String, presenter: StarshipsPresenter)
    {
        val request = APIClient.buildService(APIInterface::class.java)
        val call = url.let { request.getStarship(it) }

        call.enqueue(object : Callback<StarshipData> {
            override fun onResponse(call: Call<StarshipData>, response: Response<StarshipData>) {
                if (response.isSuccessful) {
                    val resource = response.body()
                    val starship = StarshipData(
                        resource?.name.toString(),
                        resource?.model.toString(),
                        resource?.manufacturer.toString(),
                        resource?.cost_in_credits.toString(),
                        resource?.length.toString()
                    )
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