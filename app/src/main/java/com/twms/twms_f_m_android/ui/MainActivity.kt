package com.twms.twms_f_m_android.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.twms.twms_f_m_android.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}