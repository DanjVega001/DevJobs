package com.devjobs.app.ui.views.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.devjobs.app.R
import com.devjobs.app.databinding.FragmentJobsBinding
import com.devjobs.app.core.util.ManageSharedPreferences


class JobsFragment : Fragment() {

    private var _binding:FragmentJobsBinding? = null
    private val binding get() = _binding!!
    private var locationSelected = ""
    private var professionSelected = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJobsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initValues()
        selectedLocation()
        selectedProfession()
    }

    private fun initValues() {
        locationSelected = ManageSharedPreferences.getPreferences(getString(R.string.key_location_selected), requireContext())
        professionSelected = ManageSharedPreferences.getPreferences(getString(R.string.key_profession_selected), requireContext())

    }

    private fun selectedLocation(){
        if (locationSelected != "") {
            binding.etSearchCountry.setText(locationSelected)
        }
        ManageSharedPreferences.savePreferences(getString(R.string.key_location_selected),
            binding.etSearchCountry.text.toString(),
            requireContext())
        binding.etSearchCountry.setOnFocusChangeListener {_, hasFocus ->
            if (hasFocus) {
                findNavController().navigate(JobsFragmentDirections.actionJobsFragmentToChooseLocationFragment2())
            }
        }
    }

    private fun selectedProfession(){
        if (professionSelected != "") {
            binding.etSearchJob.setText(professionSelected)
        }
        binding.etSearchJob.setOnFocusChangeListener {_, hasFocus ->
            if (hasFocus) {
                ManageSharedPreferences.savePreferences(getString(R.string.key_profession_selected),
                    binding.etSearchJob.text.toString(),
                    requireContext())
                findNavController().navigate(JobsFragmentDirections.actionJobsFragmentToChooseProfessionFragment())
            }
        }
    }
}