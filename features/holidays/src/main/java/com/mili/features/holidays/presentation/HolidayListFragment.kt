package com.mili.features.holidays.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.mili.core.network.Resource
import com.mili.features.holidays.SELECTED_COUNTRY
import com.mili.features.holidays.SELECTED_COUNTRY_CODE
import com.mili.features.holidays.databinding.FragmentHolidayListBinding
import com.mili.features.holidays.domain.models.HolidayDomainModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HolidayListFragment : Fragment(), HolidayRVAdapter.OnHolidaySelect {
    private var _binding: FragmentHolidayListBinding? = null

    private val binding get() = _binding!!

    private val holidayViewModel: HolidayViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHolidayListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val country = requireActivity().intent.getStringExtra(SELECTED_COUNTRY_CODE) ?: "In"
        holidayViewModel.getHolidayList(country)
        observeDataChange()
    }

    private fun observeDataChange() {
        holidayViewModel.holidays.observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Error -> {}
                is Resource.Loading -> {}
                is Resource.Success -> {
                    it.data?.let { it1 -> updateRecyclerView(it1) }
                }
            }
        })
    }

    private fun updateRecyclerView(data: List<HolidayDomainModel>) {
        val adapter = HolidayRVAdapter(data, this)
        binding.rvHoliday.adapter = adapter
        adapter.notifyDataSetChanged()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onHolidaySelected(holiday: HolidayDomainModel) {
        findNavController().navigate(
            HolidayListFragmentDirections.actionHolidayListFragmentToHolidayDetailsFragment(holiday)
        )
    }
}