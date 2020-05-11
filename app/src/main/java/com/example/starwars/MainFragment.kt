package com.example.starwars

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    val ROOT_TAG = "fragment_root"
    val presenter = MainPresenter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        people_btn.setOnClickListener {
            presenter.makePeopleCall()
        }

        planets_btn.setOnClickListener {
            presenter.makePlanetsCall()
        }

        starships_btn.setOnClickListener {
            presenter.makeStarshipsCall()
        }

    }

    fun startNewPeopleFragment(namesList: LinkedHashMap<String,String>)
    {
        val args = Bundle()
        args.putSerializable("namesList", namesList)
        val fragment = PeopleFragment()
        fragment.arguments = args
        fragmentManager?.beginTransaction()?.replace(R.id.container, fragment)?.addToBackStack(ROOT_TAG)?.commit()
    }

    fun startNewPlanetsFragment(namesList: LinkedHashMap<String,String>)
    {
        val args = Bundle()
        args.putSerializable("namesList", namesList)
        val fragment = PlanetsFragment()
        fragment.arguments = args
        fragmentManager?.beginTransaction()?.replace(R.id.container, fragment)?.addToBackStack(ROOT_TAG)?.commit()
    }
    fun startNewStarshipsFragment(namesList: LinkedHashMap<String,String>)
    {
        val args = Bundle()
        args.putSerializable("namesList", namesList)
        val fragment = StarshipsFragment()
        fragment.arguments = args
        fragmentManager?.beginTransaction()?.replace(R.id.container, fragment)?.addToBackStack(ROOT_TAG)?.commit()
    }

}