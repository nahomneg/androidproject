package com.nahom.androidprojectlab.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nahom.androidprojectlab.R

class AthletesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var athletesAdapter: AthletesAdapter
    private val athletesList = ArrayList<Athlete>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_athlete, container, false)

        // Populate athletesList with dummy data (replace this with your actual data)
        athletesList.add(Athlete("Michael Phelps", "Swimming", "United States", "23 Olympic gold medals", "28 Olympic medals", "Most successful Olympian of all time"))
        athletesList.add(Athlete("Usain Bolt", "Athletics", "Jamaica", "100m - 9.58s", "8 Olympic gold medals", "Fastest man in the world"))
        athletesList.add(Athlete("Simone Biles", "Gymnastics", "United States", "Four-time Olympic gold medalist", "5 Olympic medals", "One of the greatest gymnasts of all time"))
        athletesList.add(Athlete("Serena Williams", "Tennis", "United States", "23 Grand Slam singles titles", "73 WTA singles titles", "One of the greatest tennis players of all time"))
        athletesList.add(Athlete("Lionel Messi", "Football", "Argentina", "7 Ballon d'Or titles", "10 La Liga titles", "Considered one of the greatest footballers of all time"))
        athletesList.add(Athlete("Katie Ledecky", "Swimming", "United States", "7 Olympic gold medals", "15 World Championship gold medals", "World record holder in multiple freestyle events"))

        recyclerView = rootView.findViewById(R.id.recyclerView)
        athletesAdapter = AthletesAdapter(athletesList)
        recyclerView.adapter = athletesAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        return rootView
    }
}

data class Athlete(
    val name: String,
    val sport: String,
    val country: String,
    val bestPerformance: String,
    val medals: String,
    val facts: String
)
