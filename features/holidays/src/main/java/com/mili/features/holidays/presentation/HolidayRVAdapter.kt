package com.mili.features.holidays.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.mili.features.holidays.databinding.ItemHolidayBinding
import com.mili.features.holidays.domain.models.HolidayDomainModel

class HolidayRVAdapter(private val holidays: List<HolidayDomainModel>, private val selectHoliday: OnHolidaySelect) :
    RecyclerView.Adapter<HolidayRVAdapter.ViewHolder>() {

    interface OnHolidaySelect {
        fun onHolidaySelected(holiday: HolidayDomainModel)
    }

    inner class ViewHolder(private val binding: ItemHolidayBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(holiday: HolidayDomainModel) {
            binding.tvHolidayName.text = holiday.holidayName
            binding.tvHolidayDate.text = holiday.holidayDate
            binding.cgExtraInfo.removeAllViews()
            holiday.types.forEach {
                val chip = Chip(binding.root.context)
                chip.text = it
                binding.cgExtraInfo.addView(chip)
            }

            if (holiday.types.isNotEmpty()) {
                binding.cgExtraInfo.visibility = View.VISIBLE
            }

            binding.root.setOnClickListener {
                selectHoliday.onHolidaySelected(holiday)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHolidayBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(holidays[position])
    }

    override fun getItemCount(): Int = holidays.size
}