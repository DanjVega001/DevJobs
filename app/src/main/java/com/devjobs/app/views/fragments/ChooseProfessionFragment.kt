package com.devjobs.app.views.fragments

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
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.devjobs.app.R
import com.devjobs.app.databinding.FragmentChooseProfessionBinding
import com.devjobs.app.viewmodels.LocationViewModel
import com.devjobs.app.viewmodels.ProfessionViewModel
import com.devjobs.app.views.adapters.LocationAdapter
import com.devjobs.app.views.adapters.ProfessionAdapter


class ChooseProfessionFragment : Fragment() {

    private var _binding:FragmentChooseProfessionBinding? = null
    private val binding get() = _binding!!
    private val professionViewModel: ProfessionViewModel by viewModels()
    private val args:ChooseProfessionFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChooseProfessionBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSearch()
        setupBotones()
        searchProfessions()
    }

    private fun initSearch() {
        professionViewModel.searchProfession(args.professionSelected!!)
    }

    private fun searchProfessions() {
        val etChooseProfession = binding.etChooseProfession
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
                    data
                )
            })
    }

    private fun setupBotones() {

        binding.btnBackArrowProfession.setOnClickListener {
            findNavController().navigate(ChooseProfessionFragmentDirections.actionChooseProfessionFragmentToJobsFragment(
                locationSelected = null,
                professionSelected = args.professionSelected
            ))
        }

        binding.btnClearQueryProfession.setOnClickListener {
            binding.etChooseProfession.setText("")
        }
    }

}