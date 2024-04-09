package com.devjobs.app.ui.views.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.devjobs.app.R
import com.devjobs.app.databinding.FragmentChooseProfessionBinding
import com.devjobs.app.core.util.ManageSharedPreferences
import com.devjobs.app.ui.viewmodels.LocationViewModel
import com.devjobs.app.ui.viewmodels.ProfessionViewModel
import com.devjobs.app.ui.views.adapters.LocationAdapter
import com.devjobs.app.ui.views.adapters.ProfessionAdapter


class ChooseProfessionFragment : Fragment() {

    private var _binding:FragmentChooseProfessionBinding? = null
    private val binding get() = _binding!!
    private val professionViewModel: ProfessionViewModel by viewModels()
    private var professionSelected = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChooseProfessionBinding.inflate(layoutInflater)
        Log.d("PASSS,", "ERER")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initValues()
        initSearch()
        setupBotones()
        searchProfessions()
    }

    private fun initValues() {
        professionSelected = ManageSharedPreferences.getPreferences(getString(R.string.key_profession_selected), requireContext())
    }

    private fun initSearch() {
        professionViewModel.searchProfession(professionSelected)
    }

    private fun searchProfessions() {
        val etChooseProfession = binding.etChooseProfession
        etChooseProfession.setText(professionSelected)
        binding.btnClearQueryProfession.visibility = View.VISIBLE
        etChooseProfession.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.toString() != ""){
                    binding.btnClearQueryProfession.visibility = View.VISIBLE
                }
                else {
                    binding.btnClearQueryProfession.visibility = View.INVISIBLE
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("S",s.toString())
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                professionViewModel.searchProfession(s.toString())
            }
        })

        setupRecyclerView()
    }

    private fun setupRecyclerView() {

        professionViewModel.professionModel.observe(viewLifecycleOwner,
            Observer {data ->
                binding.rvChooseProfession.setHasFixedSize(true)
                binding.rvChooseProfession.layoutManager = LinearLayoutManager(context)
                binding.rvChooseProfession.adapter = ProfessionAdapter(
                    data,
                )
            })
    }

    private fun setupBotones() {

        binding.btnBackArrowProfession.setOnClickListener {
            findNavController().navigate(ChooseProfessionFragmentDirections.actionChooseProfessionFragmentToHomePage())
        }

        binding.btnClearQueryProfession.setOnClickListener {
            binding.etChooseProfession.setText("")
        }
    }

}