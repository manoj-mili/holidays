package com.mili.features.countries.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mili.core.ui.updateVisibility
import com.mili.features.countries.databinding.ItemCountryBinding
import com.mili.features.countries.domain.CountryDomainModel

class CountryRVAdapter(private val countries: List<CountryDomainModel>, private val listener:CountrySelectionListener) :
    RecyclerView.Adapter<CountryRVAdapter.ViewHolder>() {

    interface CountrySelectionListener {
        fun onCountrySelected(countryDomainModel: CountryDomainModel)
    }

    inner class ViewHolder(private val binding: ItemCountryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(countryDomainModel: CountryDomainModel) {
            binding.ivCountryFlag.load(countryDomainModel.flagURL)
            binding.tvCountryName.text = countryDomainModel.countryName
            binding.tvHolidays.text = "Holidays ${countryDomainModel.totalHolidays}"
            binding.ivSelected.updateVisibility(countryDomainModel.isSelected)
            binding.root.setOnClickListener {
                listener.onCountrySelected(countryDomainModel)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount(): Int = countries.size

}