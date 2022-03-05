package com.mili.features.countries

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.mili.core.network.Resource
import com.mili.features.countries.databinding.ActivityCountrySelectionBinding
import com.mili.features.countries.domain.CountryDomainModel
import com.mili.features.countries.presentation.CountryRVAdapter
import com.mili.features.countries.presentation.CountryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountrySelectionActivity : AppCompatActivity(), CountryRVAdapter.CountrySelectionListener {

    private val TAG = "CountrySelectionActivit"

    companion object {
        fun startCountrySelection(context: Context) {
            context.startActivity(Intent(context, CountrySelectionActivity::class.java))
        }
    }

    private val countryViewModel: CountryViewModel by viewModels()
    private lateinit var binding: ActivityCountrySelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountrySelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeDataChanges()
        countryViewModel.getCountries()
    }

    private fun observeDataChanges() {
        countryViewModel.countries.observe(this, {
            when (it) {
                is Resource.Error -> showErrorState(it.errorMessage)
                is Resource.Loading -> {
                    binding.pbCountries.visibility = View.VISIBLE
                }
                is Resource.Success -> it.data?.let { countries ->
                    showCountrySelection(
                        countries
                    )
                }
            }
        })
    }

    private fun showCountrySelection(data: List<CountryDomainModel>) {
        val adapter = CountryRVAdapter(data, this@CountrySelectionActivity)
        binding.rvCountry.adapter = adapter
        adapter.notifyDataSetChanged()
        binding.pbCountries.visibility = View.GONE
    }

    private fun showErrorState(errorMessage: String?) {
        binding.pbCountries.visibility = View.GONE
    }

    override fun onCountrySelected(countryDomainModel: CountryDomainModel) {
        countryViewModel.updateDefaultCountry(countryDomainModel,this)
    }
}