package com.nahom.androidprojectlab.ui

import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.nahom.androidprojectlab.R

class AthleteDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_athletes_fragment, null)

        builder.setView(dialogView)
            .setTitle("Add Athelete")
            .setPositiveButton("Add") { dialog, id ->
                val name = dialogView.findViewById<EditText>(R.id.editTextAthleteName).text.toString()
                val sportname = dialogView.findViewById<EditText>(R.id.editTextSportName).text.toString()
                val country = dialogView.findViewById<EditText>(R.id.editTextCountry).text.toString()
                val editTextBestPerformance = dialogView.findViewById<EditText>(R.id.editTextBestPerformance).text.toString()
                val editTextMedals = dialogView.findViewById<EditText>(R.id.editTextMedals).text.toString()
                val editTextFacts = dialogView.findViewById<EditText>(R.id.editTextFacts).text.toString()
                addAthleteListener?.onAthleteAdded(Athlete(name,sportname,country, editTextBestPerformance,editTextMedals,editTextFacts))
            }
            .setNegativeButton("Cancel") { dialog, id ->
                dialog.cancel()
            }



        return builder.create()
    }
    interface AddAthleteListener {
        fun onAthleteAdded(athlete: Athlete)
    }

    private var addAthleteListener: AddAthleteListener? = null

    fun setAddAthleteListener(listener: AddAthleteListener) {
        addAthleteListener = listener
    }

}
