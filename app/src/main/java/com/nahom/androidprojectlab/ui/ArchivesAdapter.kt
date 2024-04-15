package com.nahom.androidprojectlab.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nahom.androidprojectlab.R

class ArchivesAdapter(private val archivesList: List<Archive>) : RecyclerView.Adapter<ArchivesAdapter.ArchiveViewHolder>() {

    inner class ArchiveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewHistoryName: TextView = itemView.findViewById(R.id.textViewHistoryName)
        val textViewDate: TextView = itemView.findViewById(R.id.textViewDate)
        val textViewDescription: TextView = itemView.findViewById(R.id.textViewDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArchiveViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_archive, parent, false)
        return ArchiveViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ArchiveViewHolder, position: Int) {
        val currentItem = archivesList[position]
        holder.textViewHistoryName.text = currentItem.historyName
        holder.textViewDate.text = currentItem.date
        holder.textViewDescription.text = currentItem.description
    }

    override fun getItemCount() = archivesList.size
}
data class Archive(
    val historyName: String,
    val date: String,
    val description: String
)
