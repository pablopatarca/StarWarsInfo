package com.example.starwars

import com.fasterxml.jackson.databind.ser.Serializers

interface MainContract {

    interface View : BaseView<Presenter> {

        fun startNewPeopleFragment(namesList: LinkedHashMap<String,String>)

        fun startNewPlanetsFragment(namesList: LinkedHashMap<String,String>)

        fun startNewStarshipsFragment(namesList: LinkedHashMap<String,String>)
    }

    interface Presenter {

        fun makePeopleCall()

        fun makePlanetsCall()

        fun makeStarshipsCall()

        fun finishPeopleCall(namesList: LinkedHashMap<String,String>)

        fun finishPlanetsCall(namesList: LinkedHashMap<String,String>)

        fun finishStarshipsCall(namesList: LinkedHashMap<String,String>)

    }
}