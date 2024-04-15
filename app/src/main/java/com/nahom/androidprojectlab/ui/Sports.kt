package com.nahom.androidprojectlab.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.nahom.androidprojectlab.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Sports.newInstance] factory method to
 * create an instance of this fragment.
 */
class Sports : Fragment(),SportsDialogFragment.AddSportListener {
    private val sportsList = ArrayList<SportsItem>()
    private lateinit var recyclerView : RecyclerView;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_sports, container, false)

        // Populate newsList with dummy data (replace this with your actual data)
        sportsList.add(SportsItem("Measure", "Car Racing", "Auto racing is a motorsport involving the racing of automobiles for competition. In North America, the term is commonly used to describe all forms of automobile sport including non-racing disciplines. Auto racing has existed since the invention of the automobile."))
        sportsList.add(SportsItem("Precision", "Precision", "Precision sports are like Measured sports, but with the goal of accuracy. The goal is to hit a target, not a min/max with no bound. You win a precision sport by being the most precise with your movement.\n"))
        sportsList.add(SportsItem("Spectacle", "Figure Skating", "Spectacle sports are subjectively judged and aesthetics matter. They often have panels of judges.\n" +
                "\n" +
                "For example, figure skating is judged on “interpretation of music” among other more technical criteria. Almost any physical activity could be turned into a spectacle sport if a point system is designed around it to determine who wins and who loses"))
        sportsList.add(SportsItem("Combat", "Combat", "Boxing (also known as \"western boxing\" or \"pugilism\") is a combat sport and a martial art[1] in which two people, usually wearing protective gloves and other protective equipment such as hand wraps and mouthguards, throw punches at each other for a predetermined amount of time in a boxing ring."))
        sportsList.add(SportsItem("Play", "Play", "Play is the leftover, catch-all category which encompasses all sports that don’t fit the other definitions. The top 9 most popular sports in the world are all Play sports, and they are perhaps the most natural expression of “play” even as kids. You can complete the sentence “I play ___” with any Play sport."))

        recyclerView = rootView.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = SportAdapter(sportsList)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val fabAddNews = rootView.findViewById<FloatingActionButton>(R.id.fabAddNews)

        fabAddNews.setOnClickListener {
            val dialog = SportsDialogFragment()
            dialog.show(childFragmentManager, "AddNewsDialog")
            dialog.setAddSportListener(object : SportsDialogFragment.AddSportListener {
                @SuppressLint("NotifyDataSetChanged")
                override fun onSportAdded(sports: SportsItem) {
                    sportsList.add(0,sports)
                    // Notify the adapter of the data set change
                    recyclerView.adapter?.notifyDataSetChanged()
                }
            })
        }
        return rootView
    }
    @SuppressLint("NotifyDataSetChanged")
    override fun onSportAdded(sports: SportsItem) {
        sportsList.add(sports)
        recyclerView.adapter?.notifyDataSetChanged()
    }

}
data class SportsItem(val sportType: String, val sportName: String, val instruction: String)