package com.devjobs.app.ui.views.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.devjobs.app.R
import com.devjobs.app.databinding.FragmentJobsBinding
import com.devjobs.app.core.util.ManageSharedPreferences
import com.devjobs.app.ui.viewmodels.JobViewModel
import com.devjobs.app.ui.views.activities.HomePage
import com.devjobs.app.ui.views.adapters.JobAdapter


class JobsFragment : Fragment() {

    private var _binding:FragmentJobsBinding? = null
    private val binding get() = _binding!!
    private var locationSelected = ""
    private var professionSelected = ""
    private val jobViewModel:JobViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJobsBinding.inflate(layoutInflater)
        Log.d("PASS", "EFEF")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initValues()
        initSearch()
    }

    private fun initSearch() {
        if (professionSelected.isNotEmpty()) {
            jobViewModel.searchJobs(professionSelected, locationSelected)
        }
        val act = requireActivity()
        if (act is HomePage){
            val linearLayout = act.findViewById<LinearLayout>(R.id.linearlayoutHome)
            linearLayout.visibility = View.VISIBLE
            jobViewModel.jobsModel.observe(viewLifecycleOwner, Observer {
                binding.rvJobs.setHasFixedSize(true)
                binding.rvJobs.layoutManager = LinearLayoutManager(context)
                binding.rvJobs.adapter = JobAdapter(it, linearLayout)
                binding.txtResTotales.text = it.size.toString()
            })
        }



    }

    private fun initValues() {
        locationSelected = ManageSharedPreferences.getPreferences(getString(R.string.key_location_selected), requireContext())
        professionSelected = ManageSharedPreferences.getPreferences(getString(R.string.key_profession_selected), requireContext())
    }


}