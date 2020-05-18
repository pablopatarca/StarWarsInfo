package com.example.starwars

interface PeopleContract {

    interface View : BaseView<Presenter> {

        fun buildRecyclerView(peopleList: LinkedHashMap<String,String>)

        fun startNewFragment(person: PersonData)

        fun showError(e: String)

    }

    interface Presenter {

        fun makePersonDetailsCall(peopleList: LinkedHashMap<String,String>, position: Int)

    }
}