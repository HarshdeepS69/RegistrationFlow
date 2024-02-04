package com.harsh.registrationflow.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.harsh.registrationflow.R
import com.harsh.registrationflow.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    lateinit var binding : FragmentLoginBinding
    var nameOfUser : String = ""
    var email : String = ""
    var pass : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {

            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments.let {
            nameOfUser = it?.getString("name") ?: ""
            email = it?.getString("email") ?: ""
            pass = it?.getString("pass") ?: ""

            binding.tvName.setText(nameOfUser)
            binding.tvEmail.setText(email)
        }

        binding.btnContinue.setOnClickListener(){
            if (binding.edtPassLogin.text.toString() == pass){
                findNavController().navigate(R.id.action_loginFragment_to_loggedInFragment)
            }
            else if (binding.edtPassLogin.text.toString().isNullOrEmpty()){
                binding.edtPassLogin.error = "Enter Password"
            }
            else{
                Toast.makeText(context,"Incorrect Password",Toast.LENGTH_SHORT).show()
            }
        }
        binding.txtForgotPasswordlogin.setOnClickListener(){
            findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
        }
        binding.txtSignUpForLogin.setOnClickListener(){
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }
    }

    companion object {

    }
}