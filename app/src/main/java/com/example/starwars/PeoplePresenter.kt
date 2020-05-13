package com.example.starwars

class PeoplePresenter(view: PeopleContract.View) : PeopleContract.Presenter {

    private val view = view         //view
    private val repository = Repository()   //model

    init {
        view.setPresenter(this)
    }

    override fun makePersonDetailsCall(peopleList: LinkedHashMap<String,String>, position: Int)
    {
        val url = peopleList.get(peopleList.keys.elementAt(position))
        if (url != null) {
            repository.makePersonDetailsCall(url, this)
        }
    }

    override fun finishPersonDetailsCall(person: PersonData)
    {
        view.startNewFragment(person)
    }
}