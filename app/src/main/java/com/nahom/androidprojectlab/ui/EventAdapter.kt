package com.nahom.androidprojectlab.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nahom.androidprojectlab.R

class EventsAdapter(private val eventsList: List<Event>) : RecyclerView.Adapter<EventsAdapter.EventViewHolder>() {

    inner class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewEventName: TextView = itemView.findViewById(R.id.textViewEventName)
        val textViewDescription: TextView = itemView.findViewById(R.id.textViewDescription)
        val textViewDate: TextView = itemView.findViewById(R.id.textViewDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_events, parent, false)
        return EventViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val currentItem = eventsList[position]
        holder.textViewEventName.text = currentItem.name
        holder.textViewDescription.text = currentItem.description
        holder.textViewDate.text = currentItem.date
    }

    override fun getItemCount() = eventsList.size
}
data class Event(
    val name: String,
    val description: String,
    val date: String
)
