package com.example.starwars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_people.*


class PeopleFragment : Fragment(), PeopleContract.View {

    val TYPE_TAG = "fragment_type"
    var peopleList = LinkedHashMap<String,String>()
    var presenter = PeoplePresenter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_people, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val namesList = arguments?.getSerializable("namesList") as LinkedHashMap<String,String>

        buildRecyclerView(namesList)
    }

    override fun setPresenter(@NonNull presenter: PeopleContract.Presenter) {
        this.presenter = checkNotNull(presenter) as PeoplePresenter
    }

    override fun buildRecyclerView(peopleList: LinkedHashMap<String,String>)
    {
        val itemAdapter = ItemAdapter(peopleList.keys)
        itemAdapter.setListener {
            presenter.makePersonDetailsCall(peopleList, itemAdapter.getPosition())
        }

        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = itemAdapter
        }

        progressCircular.visibility = View.GONE
    }


    override fun startNewFragment(person: PersonData)
    {
        val args = Bundle()
        args.putSerializable("person", person)
        val fragment = PersonDetailsFragment()
        fragment.arguments = args
        fragmentManager?.beginTransaction()?.replace(R.id.container, fragment)?.addToBackStack(TYPE_TAG)?.commit()
    }
}
