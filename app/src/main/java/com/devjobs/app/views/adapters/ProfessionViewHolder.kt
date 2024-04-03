package com.devjobs.app.views.adapters

import android.view.View
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.devjobs.app.R
import com.devjobs.app.util.ManageSharedPreferences
import com.devjobs.app.views.fragments.ChooseLocationFragmentDirections
import com.devjobs.app.views.fragments.ChooseProfessionFragmentDirections

class ProfessionViewHolder(private val view: View) : ViewHolder(view) {

    private val btnChooseProfession:Button = view.findViewById(R.id.btnChooseProfession)

    fun bind(profession: String) {
        btnChooseProfession.text = profession

        btnChooseProfession.setOnClickListener {
            ManageSharedPreferences.savePreferences(
                view.context.getString(R.string.key_profession_selected),
                profession,
                view.context
            )
            view.findNavController().navigate(ChooseProfessionFragmentDirections.actionChooseProfessionFragmentToJobsFragment())
        }
    }

}
