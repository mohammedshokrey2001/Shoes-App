package com.example.shoesapp.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoesapp.R
import com.example.shoesapp.databinding.FragmentShoeDetailBinding
import com.example.shoesapp.databinding.FragmentShoeDetailInstructionBinding


class ShoeDetailInstructionFragment : Fragment() {

    lateinit var binding: FragmentShoeDetailInstructionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_detail_instruction, container, false)

        binding.buttonNextInst2.setOnClickListener {
            it.findNavController().navigate(R.id.action_shoeDetailInstructionFragment_to_shoeListFragment)
        }
   return binding.root

    }


}