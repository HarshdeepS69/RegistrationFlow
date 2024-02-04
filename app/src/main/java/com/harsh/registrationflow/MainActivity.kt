package com.harsh.registrationflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.window.OnBackInvokedDispatcher
import androidx.activity.OnBackPressedCallback
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.harsh.registrationflow.databinding.ActivityMainBinding
import com.harsh.registrationflow.databinding.FragmentHiBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var controller :NavController ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        controller = findNavController(R.id.mainLayout)


    }


    }
