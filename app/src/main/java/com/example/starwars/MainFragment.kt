package com.example.starwars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*

import com.google.common.base.Preconditions.checkNotNull


class MainFragment : Fragment(), MainContract.View {

    val ROOT_TAG = "fragment_root"
    var presenter = MainPresenter(this)

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

    override fun setPresenter(@NonNull presenter: MainContract.Presenter) {
        this.presenter = checkNotNull(presenter) as MainPresenter
    }

    override fun startNewPeopleFragment(namesList: LinkedHashMap<String,String>)
    {
        val args = Bundle()
        args.putSerializable("namesList", namesList)
        val fragment = PeopleFragment()
        fragment.arguments = args
        fragmentManager?.beginTransaction()?.replace(R.id.container, fragment)?.addToBackStack(ROOT_TAG)?.commit()
    }

    override fun startNewPlanetsFragment(namesList: LinkedHashMap<String,String>)
    {
        val args = Bundle()
        args.putSerializable("namesList", namesList)
        val fragment = PlanetsFragment()
        fragment.arguments = args
        fragmentManager?.beginTransaction()?.replace(R.id.container, fragment)?.addToBackStack(ROOT_TAG)?.commit()
    }

    override fun startNewStarshipsFragment(namesList: LinkedHashMap<String,String>)
    {
        val args = Bundle()
        args.putSerializable("namesList", namesList)
        val fragment = StarshipsFragment()
        fragment.arguments = args
        fragmentManager?.beginTransaction()?.replace(R.id.container, fragment)?.addToBackStack(ROOT_TAG)?.commit()
    }

}