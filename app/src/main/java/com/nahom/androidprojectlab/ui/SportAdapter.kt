package com.nahom.androidprojectlab.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nahom.androidprojectlab.R

class SportAdapter(private val newsList: List<SportsItem>) : RecyclerView.Adapter<SportAdapter.SportsViewHolder>() {

    inner class SportsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sportTypeTextView: TextView = itemView.findViewById(R.id.textViewSportType)
        val textViewTitle: TextView = itemView.findViewById(R.id.textViewSportName)
        val textViewDescription: TextView = itemView.findViewById(R.id.textViewInstruction)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_sports, parent, false)
        return SportsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SportsViewHolder, position: Int) {
        val currentItem = newsList[position]

        holder.sportTypeTextView.text = currentItem.sportType
        holder.textViewTitle.text = currentItem.sportName
        holder.textViewDescription.text = currentItem.instruction
    }

    override fun getItemCount() = newsList.size
}
