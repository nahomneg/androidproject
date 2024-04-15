package com.nahom.androidprojectlab.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.nahom.androidprojectlab.R

class AthletesAdapter(private val athletesList: List<Athlete>) : RecyclerView.Adapter<AthletesAdapter.AthleteViewHolder>() {

    inner class AthleteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: MaterialCardView = itemView.findViewById(R.id.cardView)
        val textViewAthleteName: TextView = itemView.findViewById(R.id.textViewAthleteName)
        val textViewSportName: TextView = itemView.findViewById(R.id.textViewSportName)
        val textViewCountry: TextView = itemView.findViewById(R.id.textViewCountry)
        val textViewBestPerformance: TextView = itemView.findViewById(R.id.textViewBestPerformance)
        val textViewMedals: TextView = itemView.findViewById(R.id.textViewMedals)
        val textViewFacts: TextView = itemView.findViewById(R.id.textViewFacts)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AthleteViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_athlete, parent, false)
        return AthleteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AthleteViewHolder, position: Int) {
        val currentItem = athletesList[position]
        holder.textViewAthleteName.text = currentItem.name
        holder.textViewSportName.text = currentItem.sport
        holder.textViewCountry.text = currentItem.country
        holder.textViewBestPerformance.text = currentItem.bestPerformance
        holder.textViewMedals.text = currentItem.medals
        holder.textViewFacts.text = currentItem.facts
    }

    override fun getItemCount() = athletesList.size
}
