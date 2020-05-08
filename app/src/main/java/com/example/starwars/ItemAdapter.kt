package com.example.starwars

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.android.synthetic.main.item.view.*


class ItemAdapter(val items : MutableSet<String>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    private var listener: (() -> Unit)? = null
    private var position: Int = 0

    fun setListener(listener: (() -> Unit)?) {
        this.listener = listener
    }

    fun getPosition() : Int {
        return position
    }


    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val nameBtn = view.name_btn
    }

    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)

        return ViewHolder(view)
    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameBtn?.text = items.elementAt(position)

        holder.nameBtn?.setOnClickListener  {
            this.position = position
            listener?.invoke()
        }
    }
}

