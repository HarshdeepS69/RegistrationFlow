package com.harsh.registrationflow.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.harsh.registrationflow.R
import com.harsh.registrationflow.databinding.FragmentForgotPasswordBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ForgotPasswordFragment : Fragment() {
 lateinit var binding : FragmentForgotPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentForgotPasswordBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnContinueForgotPassword.setOnClickListener(){
            if (binding.edtPassForgot1.text.toString().isNullOrEmpty()){
                binding.edtPassForgot1.error = "Enter Password"

            }else if (binding.edtPassForgot2.text.toString().isNullOrEmpty()){
                binding.edtPassForgot2.error = "Enter Password"

            }
            else if (binding.edtPassForgot1.text.toString() != binding.edtPassForgot2.text.toString()){
                binding.edtPassForgot2.error = "Passwords don't Match"
            }
            else{
                Toast.makeText(context,"Password Updated",Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_forgotPasswordFragment_to_loginFragment)
            }

        }
        binding.imgBackFP.setOnClickListener(){
            findNavController().navigate(R.id.action_forgotPasswordFragment_to_loginFragment)
        }
    }

    companion object {

    }
}