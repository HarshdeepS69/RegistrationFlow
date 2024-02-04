package com.harsh.registrationflow.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.harsh.registrationflow.R
import com.harsh.registrationflow.databinding.FragmentAppleBinding
import com.harsh.registrationflow.databinding.FragmentFacebookBinding

class AppleFragment : Fragment() {
    lateinit var binding : FragmentAppleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAppleBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnContinueapple.setOnClickListener(){
            if (binding.emailApple.text.toString().isNullOrEmpty()){
                binding.emailApple.error = "Enter E-mail"
            }
            else if (binding.passApple.text.toString().isNullOrEmpty()){
                binding.passApple.error = "Enter Password"
            }
            else{
                findNavController().navigate(R.id.action_appleFragment_to_loggedInFragment)
            }
        }
    }

    companion object {

    }
}