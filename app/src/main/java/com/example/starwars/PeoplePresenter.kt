package com.example.starwars

class PeoplePresenter(fragment: PeopleFragment) {

    private val fragment = fragment         //view
    private val repository = Repository()   //model

    fun makePersonDetailsCall(peopleList: LinkedHashMap<String,String>, position: Int)
    {
        val url = peopleList.get(peopleList.keys.elementAt(position))
        val person = Person_Data()
        if (url != null) {
            repository.makePersonDetailsCall(url, person,this)
        }
    }
}