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
        val person = Person_Data()
        if (url != null) {
            repository.makePersonDetailsCall(url, person,this)
        }
    }

    override fun finishPersonDetailsCall(person: Person_Data)
    {
        view.startNewFragment(person)
    }
}