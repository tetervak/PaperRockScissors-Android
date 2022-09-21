package ca.tetervak.paperrockscissors

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment


class AboutFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val builder = AlertDialog.Builder(requireContext())
            builder
                .setTitle(R.string.app_name)
                .setMessage(R.string.author)
                .setPositiveButton(android.R.string.ok,null)
            return builder.create()
    }
}