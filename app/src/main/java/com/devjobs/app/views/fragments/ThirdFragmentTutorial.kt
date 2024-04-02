package com.devjobs.app.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.devjobs.app.R
import com.devjobs.app.databinding.FragmentThirdTutorialBinding


class ThirdFragmentTutorial : Fragment() {
    private var _binding:FragmentThirdTutorialBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdTutorialBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        botones()
    }

    private fun botones(){
        binding.btnBackSecondTutorial.setOnClickListener {
            findNavController().navigate(ThirdFragmentTutorialDirections.actionThirdFragmentTutorialToSecondFragmentTutorial())
        }
        binding.btnGoApp.setOnClickListener {
            findNavController().navigate(ThirdFragmentTutorialDirections.actionThirdFragmentTutorialToHomePage())
        }
    }


}