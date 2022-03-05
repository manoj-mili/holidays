package com.mili.features.holidays

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import com.mili.features.holidays.databinding.ActivityHolidayBinding
import com.mili.features.holidays.domain.models.HolidayDomainModel
import dagger.hilt.android.AndroidEntryPoint

const val SELECTED_COUNTRY_CODE = "SELECTED_COUNTRY_CODE"
const val SELECTED_COUNTRY = "SELECTED_COUNTRY"
private const val TAG = "HolidayActivity"
@AndroidEntryPoint
class HolidayActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {

    companion object {
        fun startHolidayActivity(context: Context, countryCode: String, country: String) {
            val intent = Intent(context, HolidayActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.putExtra(SELECTED_COUNTRY_CODE, countryCode)
            intent.putExtra(SELECTED_COUNTRY, country)
            context.startActivity(intent)
        }
    }

    private lateinit var binding: ActivityHolidayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHolidayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeViews()
    }

    private fun initializeViews() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.frag_root) as NavHostFragment
        val navController = navHostFragment.navController
        navController.addOnDestinationChangedListener(this)
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        when (destination.id) {
            R.id.holidayListFragment -> {
                supportActionBar?.title = intent.getStringExtra(SELECTED_COUNTRY)
            }
            R.id.holidayDetailsFragment -> {
                val data = arguments?.getParcelable<HolidayDomainModel>("selectedHoliday")
                supportActionBar?.title = data?.holidayName
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.frag_root) as NavHostFragment
        val navController = navHostFragment.navController
        return if (navHostFragment.childFragmentManager.backStackEntryCount == 0
        ) {
            finish()
            true
        } else navController.navigateUp()
    }

    override fun onBackPressed() {
        onSupportNavigateUp()
    }
}