package com.nahom.androidprojectlab.ui

import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.nahom.androidprojectlab.R

class ArchiveDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_archive_fragment, null)

        builder.setView(dialogView)
            .setTitle("Add News")
            .setPositiveButton("Add") { dialog, id ->
                val historyName = dialogView.findViewById<EditText>(R.id.editTextHistoryName).text.toString()
                val date = dialogView.findViewById<EditText>(R.id.editTextDate).text.toString()
                val newsDescription = dialogView.findViewById<EditText>(R.id.editTextDescription).text.toString()
                addArchiveListener?.onArchiveAdded(Archive(historyName, date,newsDescription))
            }
            .setNegativeButton("Cancel") { dialog, id ->
                dialog.cancel()
            }



        return builder.create()
    }
    interface AddArchiveListener {
        fun onArchiveAdded(archive: Archive)
    }

    private var addArchiveListener: AddArchiveListener? = null

    fun setAddArchiveListener(listener: AddArchiveListener) {
        addArchiveListener = listener
    }

}
