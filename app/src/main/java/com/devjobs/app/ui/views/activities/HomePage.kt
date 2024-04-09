package com.devjobs.app.ui.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.devjobs.app.R
import com.devjobs.app.core.util.ManageSharedPreferences
import com.devjobs.app.databinding.ActivityHomePageBinding
import com.devjobs.app.databinding.ActivityMainBinding
import com.devjobs.app.ui.views.fragments.JobsFragmentDirections
import kotlin.math.log

class HomePage : AppCompatActivity() {

    private lateinit var binding: ActivityHomePageBinding
    private var locationSelected = ""
    private var professionSelected = ""
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragmentPages) as NavHostFragment
        navController = navHostFragment.navController
        initValues()
        selectedLocation()
        selectedProfession()
        navigation()
    }

    private fun navigation() {
        binding.btnCuantoGana.setOnClickListener {
            binding.btnEmpleos.setBackgroundResource(R.drawable.border_menu_item_no_selected)
            binding.btnCuantoGana.setBackgroundResource(R.drawable.border_menu_item_selected)
            navigateToFragment(R.id.salaryJobFragment)
        }

        binding.btnEmpleos.setOnClickListener {
            binding.btnCuantoGana.setBackgroundResource(R.drawable.border_menu_item_no_selected)
            binding.btnEmpleos.setBackgroundResource(R.drawable.border_menu_item_selected)
            navigateToFragment(R.id.jobsFragment)
        }
    }

    private fun initValues() {
        locationSelected = ManageSharedPreferences.getPreferences(getString(R.string.key_location_selected), this)
        professionSelected = ManageSharedPreferences.getPreferences(getString(R.string.key_profession_selected), this)
    }


    private fun navigateToFragment(idFragment:Int){
        navController.navigate(idFragment)
    }

    private fun selectedLocation(){
        if (locationSelected != "") {
            binding.etSearchCountry.setText(locationSelected)
        }

        binding.etSearchCountry.setOnFocusChangeListener {_, hasFocus ->
            if (hasFocus) {
                ManageSharedPreferences.savePreferences(getString(R.string.key_location_selected),
                    binding.etSearchCountry.text.toString(),
                    this)
                binding.linearlayoutHome.visibility = View.GONE
                navigateToFragment(R.id.chooseLocationFragment2)
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
                    this@HomePage)
                binding.linearlayoutHome.visibility = View.GONE
                //findNavController().navigate(JobsFragmentDirections.actionJobsFragmentToChooseProfessionFragment())
                navigateToFragment(R.id.chooseProfessionFragment)
            }
        }
    }


}