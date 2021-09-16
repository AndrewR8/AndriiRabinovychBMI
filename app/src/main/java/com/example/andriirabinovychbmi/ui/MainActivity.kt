package com.example.andriirabinovychbmi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.andriirabinovychbmi.R
import com.example.andriirabinovychbmi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.fragment_details_bmi) {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}