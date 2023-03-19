package com.example.shoesapp.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoesapp.R
import com.example.shoesapp.databinding.FragmentShoeListInstructionBinding


class ShoeListInstructionFragment : Fragment() {


   lateinit var binding:FragmentShoeListInstructionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

       binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_list_instruction, container, false)

        binding.buttonNextInst1.setOnClickListener {
            it.findNavController().navigate(R.id.action_shoeListInstructionFragment_to_shoeDetailInstructionFragment)
        }
        return binding.root
    }


}