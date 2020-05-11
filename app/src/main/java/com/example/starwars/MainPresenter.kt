package com.example.starwars

class MainPresenter(fragment: MainFragment) {

    private val fragment = fragment         //view
    private val repository = Repository()   //model

    fun makePeopleCall()
    {
        val next = repository.getPeopleNext()
        val namesList = LinkedHashMap<String,String>()
        repository.makePeopleCall(next, namesList, this)
    }

    fun makePlanetsCall()
    {
        val next = repository.getPlanetsNext()
        val namesList = LinkedHashMap<String,String>()
        repository.makePlanetsCall(next, namesList, this)
    }

    fun makeStarshipsCall()
    {
        val next = repository.getStarshipsNext()
        val namesList = LinkedHashMap<String,String>()
        repository.makeStarshipsCall(next, namesList, this)
    }

    fun finishPeopleCall(namesList: LinkedHashMap<String,String>)
    {

    }

    fun finishPlanetsCall(namesList: LinkedHashMap<String,String>)
    {

    }

    fun finishStarshipsCall(namesList: LinkedHashMap<String,String>)
    {

    }
}