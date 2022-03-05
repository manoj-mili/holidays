package com.mili.features.holidays.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.mili.features.holidays.databinding.FragmentHolidayDetailsBinding


class HolidayDetailsFragment : Fragment() {
    private var _binding: FragmentHolidayDetailsBinding? = null

    private val holidayArgs: HolidayDetailsFragmentArgs by navArgs()

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHolidayDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvDate.text = holidayArgs.selectedHoliday.holidayDate
        binding.tvHolidayOneLine.text = holidayArgs.selectedHoliday.description
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}