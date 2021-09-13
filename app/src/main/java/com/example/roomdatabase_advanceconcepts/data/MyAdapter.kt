package com.example.roomdatabase_advanceconcepts.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.roomdatabase_advanceconcepts.R
import kotlinx.android.synthetic.main.row_layout.view.*

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>()  {
    private var personList = emptyList<Person>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentView = holder.itemView
        val currentModel = personList[position]

        currentView.text_first_name.text = currentModel.firstName
        currentView.text_last_name.text = currentModel.lastName
        //currentView.text_age.text = currentModel.age.toString()
        currentView.image_view.load(currentModel.profilePhoto)

        currentView.text_street_name.text = currentModel.address.streetName
        currentView.text_street_number.text = currentModel.address.streetNumber.toString()
    }

    override fun getItemCount() = personList.size

    fun setData(person: List<Person>) {
        personList = person
        notifyDataSetChanged()
    }

    inner class MyViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView)
}