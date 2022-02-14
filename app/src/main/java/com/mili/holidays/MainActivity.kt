package com.mili.holidays

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.mili.features.holidays.HolidayActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler(Looper.getMainLooper())
            .postDelayed({
                startActivity(Intent(this@MainActivity, HolidayActivity::class.java))
            }, 2000)
    }
}