package com.harsh.registrationflow.Fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.harsh.registrationflow.R
import com.harsh.registrationflow.databinding.FragmentSignUpBinding
import java.util.regex.Pattern


class SignUpFragment : Fragment() {
    lateinit var binding :FragmentSignUpBinding
    private var email = ""


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
        binding = FragmentSignUpBinding.inflate(layoutInflater)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments.let {
            email = it?.getString("email") ?: ""
        }
        if (email.isNullOrEmpty()){
            binding.enteredEmail.setText("example@gmail.com")
        }else {
            binding.enteredEmail.setText(email)
        }
        binding.edtPass.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                validatePassword(p0.toString())
            }

        })
        binding.txtTermsOfService.setOnClickListener(){
            findNavController().navigate(R.id.action_signUpFragment_to_termsofServiceFragment)
        }
        binding.txtLoginForSignUp.setOnClickListener(){
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }
        binding.btnAgreeContinue.setOnClickListener(){
            if (binding.edtNameSignup.text.toString().isEmpty()) {
                binding.edtNameSignup.error = "Name cannot be empty"
            }
            else if (binding.edtPass.text.toString().isEmpty()){
                binding.edtPass.error = "Password cannot be Empty"
            }
            else
            {
                var bundle = Bundle()
                bundle.putString("email",email)
                bundle.putString("name",binding.edtNameSignup.text.toString())
                bundle.putString("pass",binding.edtPass.text.toString())
                findNavController().navigate(R.id.action_signUpFragment_to_loginFragment,bundle)
            }

        }
        binding.txtDifMethod.setOnClickListener(){
            findNavController().navigate(R.id.action_signUpFragment_to_hiFragment)
        }

    }

    private fun validatePassword(password: String) {

        if (password.length < 8){
            binding.edtPass.error = "Password length should be greater than or equal to 8"
        }
        else{
            binding.edtPass.error = null
        }

    }

    companion object {

    }
}