package com.devjobs.app.ui.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.devjobs.app.R
import com.devjobs.app.databinding.FragmentSecondTutorialBinding

class SecondFragmentTutorial : Fragment() {

    private var _binding:FragmentSecondTutorialBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondTutorialBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        botones()
    }

    private fun botones() {
        binding.btnBackPrimaryTutorial.setOnClickListener {
            findNavController().navigate(SecondFragmentTutorialDirections.actionSecondFragmentTutorialToFirstFragmentTutorial())
        }
        binding.btnGoThirdTutorial.setOnClickListener {
            findNavController().navigate(SecondFragmentTutorialDirections.actionSecondFragmentTutorialToThirdFragmentTutorial())
        }
    }

}