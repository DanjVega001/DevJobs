package com.devjobs.app.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.devjobs.app.R
import com.devjobs.app.databinding.FragmentJobsBinding


class JobsFragment : Fragment() {

    private var _binding:FragmentJobsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJobsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.etSearchCountry.setOnFocusChangeListener {_, hasFocus ->
            if (hasFocus) {
                findNavController().navigate(JobsFragmentDirections.actionJobsFragmentToChooseLocationFragment2())
            }
        }
    }
}