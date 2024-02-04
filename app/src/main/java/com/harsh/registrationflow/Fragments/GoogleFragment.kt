package com.harsh.registrationflow.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.harsh.registrationflow.R
import com.harsh.registrationflow.databinding.FragmentGoogleBinding


class GoogleFragment : Fragment() {
    lateinit var binding : FragmentGoogleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGoogleBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnContinueGoogle.setOnClickListener(){
            if (binding.emailGoogle.text.toString().isNullOrEmpty()){
                binding.emailGoogle.error = "Enter E-mail"
            }
            else if (binding.passGoogle.text.toString().isNullOrEmpty()){
                binding.passGoogle.error = "Enter Password"
            }
            else{
                findNavController().navigate(R.id.action_googleFragment_to_loggedInFragment)
            }
        }
    }

    companion object {

    }
}