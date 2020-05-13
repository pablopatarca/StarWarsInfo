package com.example.starwars

class MainPresenter(val view: MainContract.View, val repository: Repository = Repository()) : MainContract.Presenter {

    init {
        view.setPresenter(this)
    }

    override fun makePeopleCall()
    {
        val next = repository.getPeopleNext()
        val namesList = LinkedHashMap<String,String>()
        repository.makePeopleCall(next, namesList, this)
    }

    override fun makePlanetsCall()
    {
        val next = repository.getPlanetsNext()
        val namesList = LinkedHashMap<String,String>()
        repository.makePlanetsCall(next, namesList, this)
    }

    override fun makeStarshipsCall()
    {
        val next = repository.getStarshipsNext()
        val namesList = LinkedHashMap<String,String>()
        repository.makeStarshipsCall(next, namesList, this)
    }

    override fun finishPeopleCall(namesList: LinkedHashMap<String,String>)
    {
        view.startNewPeopleFragment(namesList)
    }

    override fun finishPlanetsCall(namesList: LinkedHashMap<String,String>)
    {
        view.startNewPlanetsFragment(namesList)
    }

    override fun finishStarshipsCall(namesList: LinkedHashMap<String,String>)
    {
        view.startNewStarshipsFragment(namesList)
    }
}