package com.nahom.androidprojectlab.ui.notifications

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.nahom.androidprojectlab.R
import com.nahom.androidprojectlab.ui.AddNewsDialogFragment
import com.nahom.androidprojectlab.ui.Archive
import com.nahom.androidprojectlab.ui.ArchiveDialogFragment
import com.nahom.androidprojectlab.ui.ArchivesAdapter
import com.nahom.androidprojectlab.ui.NewsItem

class HistoricalFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var archivesAdapter: ArchivesAdapter
    private val archivesList = ArrayList<Archive>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_archives, container, false)

        // Populate archivesList with dummy data (replace this with your actual data)
        archivesList.add(Archive("FIFA World Cup 2018", "June 14 - July 15, 2018", "The 2018 FIFA World Cup was the 21st FIFA"))
        archivesList.add(Archive("Summer Olympics 2008", "August 8 - August 24, 2008", "The 2008 Summer Olympics, officially known as the Games of the XXIX Olympiad, were held in Beijing, China."))
        archivesList.add(Archive("FIFA World Cup 2002", "May 31 - June 30, 2002", "The 2002 FIFA World Cup was held in South Korea and Japan."))
        archivesList.add(Archive("Wimbledon 2019", "July 1 - July 14, 2019", "The 2019 Wimbledon Championships was the 133rd edition of the tournament."))

        recyclerView = rootView.findViewById(R.id.recyclerView)
        archivesAdapter = ArchivesAdapter(archivesList)
        recyclerView.adapter = archivesAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val fabAddNews = rootView.findViewById<FloatingActionButton>(R.id.fabAddNews)

        fabAddNews.setOnClickListener {
            val dialog = ArchiveDialogFragment()
            dialog.show(childFragmentManager, "AddNewsDialog")
            dialog.setAddArchiveListener(object : ArchiveDialogFragment.AddArchiveListener {
                @SuppressLint("NotifyDataSetChanged")
                override fun onArchiveAdded(archive: Archive) {
                    archivesList.add(0,archive)
                    // Notify the adapter of the data set change
                    recyclerView.adapter?.notifyDataSetChanged()
                }
            })
        }
        return rootView
    }
}