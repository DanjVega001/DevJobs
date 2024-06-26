package com.devjobs.app.ui.views.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.devjobs.app.R
import com.devjobs.app.databinding.FragmentChooseLocationBinding
import com.devjobs.app.core.util.ManageSharedPreferences
import com.devjobs.app.ui.viewmodels.LocationViewModel
import com.devjobs.app.ui.views.adapters.LocationAdapter


class ChooseLocationFragment : Fragment() {

    private var _binding:FragmentChooseLocationBinding? = null
    private val binding get() = _binding!!
    private val locationViewModel: LocationViewModel by viewModels()
    private var locationSelected:String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseLocationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initValues()
        initSearch()
        setupBotones()
        searchLocations()
    }

    private fun initValues() {
        locationSelected = ManageSharedPreferences.getPreferences(getString(R.string.key_location_selected), requireContext())
        Log.d("locatiopn", locationSelected)
    }

    private fun initSearch() {
        locationViewModel.searchLocations(locationSelected)
    }

    private fun searchLocations() {
        val etChooseLocation:EditText = binding.etChooseLocation
        etChooseLocation.setText(locationSelected)
        binding.btnClearQuery.visibility = View.VISIBLE
        etChooseLocation.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.toString() != ""){
                    binding.btnClearQuery.visibility = View.VISIBLE
                }
                else {
                    binding.btnClearQuery.visibility = View.INVISIBLE
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("S",s.toString())
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                locationViewModel.searchLocations(s.toString())
            }
        })

        setupRecyclerView()

    }

    private fun setupRecyclerView() {

        locationViewModel.locationsModel.observe(viewLifecycleOwner,
            Observer {data ->
                binding.rvChooseLocation.setHasFixedSize(true)
                binding.rvChooseLocation.layoutManager = LinearLayoutManager(context)
                binding.rvChooseLocation.adapter = LocationAdapter(
                    data
                )
            })
    }

    private fun setupBotones() {

        binding.btnBackArrow.setOnClickListener {
            findNavController().navigate(ChooseLocationFragmentDirections.actionChooseLocationFragment2ToHomePage())
        }

        binding.btnClearQuery.setOnClickListener {
            binding.etChooseLocation.setText("")
        }
    }

}