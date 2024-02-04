package com.harsh.registrationflow.Fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.harsh.registrationflow.R
import com.harsh.registrationflow.databinding.FragmentHiBinding

class HiFragment : Fragment() {

    lateinit var binding: FragmentHiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHiBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        binding.btnContinue.setOnClickListener() {

            if (binding.edtEmail.text.toString().isEmpty()) {
                binding.edtEmail.error = "Email cannot be empty"
            } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.edtEmail.text.toString()).matches()) {
                binding.edtEmail.error = "Enter a valid email address"
            }
           else {
                var email = binding.edtEmail.text.toString()
                arguments.let {
                    var bundle = Bundle()
                    bundle.putString("email", email)
                    findNavController().navigate(R.id.action_hiFragment_to_signUpFragment, bundle)
                }
            }

            }

        binding.tvSignUp.setOnClickListener() {
            findNavController().navigate(R.id.action_hiFragment_to_signUpFragment)
        }
        binding.cvFacebook.setOnClickListener(){
            findNavController().navigate(R.id.action_hiFragment_to_facebookFragment)
        }
        binding.cvGoogle.setOnClickListener(){
            findNavController().navigate(R.id.action_hiFragment_to_googleFragment)
        }
        binding.cvApple.setOnClickListener(){
            findNavController().navigate(R.id.action_hiFragment_to_appleFragment)
        }

    }



    companion object {
    }
}