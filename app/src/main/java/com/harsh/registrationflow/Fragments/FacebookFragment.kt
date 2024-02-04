package com.harsh.registrationflow.Fragments

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.harsh.registrationflow.R
import com.harsh.registrationflow.databinding.FragmentFacebookBinding


class FacebookFragment : Fragment() {
    lateinit var binding : FragmentFacebookBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFacebookBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnContinueFacebook.setOnClickListener(){
            if (binding.emailFacebook.text.toString().isNullOrEmpty()){
                binding.emailFacebook.error = "Enter E-mail"
            }
            else if (binding.passFacebook.text.toString().isNullOrEmpty()){
                binding.passFacebook.error = "Enter Password"
            }
            else{
                findNavController().navigate(R.id.action_facebookFragment_to_loggedInFragment)
            }
        }

    }
    companion object {

    }
}