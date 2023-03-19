package com.example.shoesapp.ui.login

import android.opengl.Visibility
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.shoesapp.R
import com.example.shoesapp.databinding.FragmentLoginBinding
import com.example.shoesapp.ui.AppViewModel

class LoginFragment : Fragment() {

    private val viewModel: AppViewModel by activityViewModels()





     lateinit var binding: FragmentLoginBinding
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)

        binding.textViewWarring.visibility=View.INVISIBLE
        binding.buttonLogIn.setOnClickListener {

            if (viewModel.login(
                    binding.editTextTextEmail.text.toString(),
                    binding.editTextTextPassword.text.toString()
                )
            ) {
                binding.editTextTextEmail.setText(" ")
                binding.editTextTextPassword.setText(" ")
                it.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
                Log.i("login status", "onCreateView: done")


                Toast.makeText(requireContext(),"logged in successfully",Toast.LENGTH_LONG).show()
            }
             else{
                Toast.makeText(requireContext(),"please fill fields with correct data "
                        ,Toast.LENGTH_LONG).show()

                binding.textViewWarring.visibility = View.VISIBLE
                Log.i("login status", "onCreateView: error")
            }

        }



        binding.buttonSignUp.setOnClickListener {
            viewModel.signup(binding.editTextTextEmail.text.toString(),
                binding.editTextTextPassword.text.toString())


            it.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)

        }
         return  binding.root


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onPause() {
        super.onPause()
        binding.textViewWarring.visibility = View.INVISIBLE
    }




}