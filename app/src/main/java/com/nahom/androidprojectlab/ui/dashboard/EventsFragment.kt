package com.nahom.androidprojectlab.ui.dashboard

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
import com.nahom.androidprojectlab.ui.Event
import com.nahom.androidprojectlab.ui.EventsAdapter
import com.nahom.androidprojectlab.ui.EventsDialogFragment
import com.nahom.androidprojectlab.ui.SportsDialogFragment

class EventsFragment : Fragment(), EventsDialogFragment.AddEventListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var eventsAdapter: EventsAdapter
    private val eventsList = ArrayList<Event>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.events_fragment, container, false)

        // Populate eventsList with dummy data (replace this with your actual data)
        eventsList.add(Event("Olympic Games", "The Olympic Games are the world's foremost sports competition, with more than 200 nations participating.", "July 23 - August 8, 2024"))
        eventsList.add(Event("FIFA World Cup", "The FIFA World Cup is the most prestigious association football tournament in the world.", "November 21 - December 18, 2026"))
        eventsList.add(Event("Summer Paralympics", "The Summer Paralympics are an international multi-sport event for athletes with physical disabilities.", "August 24 - September 5, 2024"))
        eventsList.add(Event("Super Bowl", "The Super Bowl is the annual championship game of the National Football League.", "February 6, 2025"))
        eventsList.add(Event("Wimbledon", "Wimbledon is the oldest tennis tournament in the world.", "June 28 - July 11, 2024"))
        eventsList.add(Event("Tour de France", "The Tour de France is an annual men's multiple stage bicycle race primarily held in France.", "July 3 - July 25, 2024"))
        eventsList.add(Event("UEFA Champions League Final", "The UEFA Champions League Final is the most prestigious club football match in the world.", "May 29, 2024"))
        eventsList.add(Event("NBA Finals", "The NBA Finals is the championship series of the National Basketball Association.", "June 5 - June 20, 2024"))

        recyclerView = rootView.findViewById(R.id.recyclerView)
        eventsAdapter = EventsAdapter(eventsList)
        recyclerView.adapter = eventsAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val fabAddNews = rootView.findViewById<FloatingActionButton>(R.id.fabAddNews)

        fabAddNews.setOnClickListener {
            val dialog = EventsDialogFragment()
            dialog.show(childFragmentManager, "AddNewsDialog")
            dialog.setAddEventListener(object : EventsDialogFragment.AddEventListener {

                @SuppressLint("NotifyDataSetChanged")
                override fun onEventAdded(event: Event) {
                    eventsList.add(0,event)
                    recyclerView.adapter?.notifyDataSetChanged()
                }
            })
        }
        return rootView
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onEventAdded(event: Event) {
        eventsList.add(event)
        recyclerView.adapter?.notifyDataSetChanged()
    }
}
