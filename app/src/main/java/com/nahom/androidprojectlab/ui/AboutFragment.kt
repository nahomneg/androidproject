package com.nahom.androidprojectlab.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.nahom.androidprojectlab.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AboutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_about, container, false)

        val nameTextView: TextView = rootView.findViewById(R.id.nameTextView)
        val bioTextView: TextView = rootView.findViewById(R.id.bioTextView)

        val name = "Nahom Demessie"
        val bio = "I am Nahom Demessie working at Walgreens. and Studying masters in computer science at MIU."

        nameTextView.text = name
        bioTextView.text = bio

        return rootView
    }
}