package com.example.shoesapp.ui.onboarding

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.shoesapp.R
import com.example.shoesapp.databinding.FragmentWelcomeBinding
import com.example.shoesapp.ui.AppViewModel


class WelcomeFragment : Fragment() {

   lateinit var binding :FragmentWelcomeBinding

    private val viewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_welcome, container, false)

        binding.buttonNext.setOnClickListener {

            if (viewModel.getSessionState()){

                it.findNavController().navigate(R.id.action_welcomeFragment_to_shoeListFragment3)
         }
            else{
                it.findNavController().navigate(R.id.action_welcomeFragment_to_shoeListInstructionFragment)
                viewModel.startSession()
            }
        }


        return binding.root
    }


}