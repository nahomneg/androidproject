package com.nahom.androidprojectlab.ui

import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.nahom.androidprojectlab.R

class EventsDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_sport_fragment, null)

        builder.setView(dialogView)
            .setTitle("Add Sport")
            .setPositiveButton("Add") { dialog, id ->
                val eventName = dialogView.findViewById<EditText>(R.id.editTextHistoryName).text.toString()
                val date = dialogView.findViewById<EditText>(R.id.editTextDate).text.toString()
                val description = dialogView.findViewById<EditText>(R.id.editTextDescription).text.toString()
                addEventListener?.onEventAdded(Event(eventName, date,description))
            }
            .setNegativeButton("Cancel") { dialog, id ->
                dialog.cancel()
            }



        return builder.create()
    }
    interface AddEventListener {
        fun onEventAdded(event: Event)
    }

    private var addEventListener: AddEventListener? = null

    fun setAddEventListener(listener: AddEventListener) {
        addEventListener = listener
    }

}
