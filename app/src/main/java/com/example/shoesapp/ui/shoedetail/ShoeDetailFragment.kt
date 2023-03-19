package com.example.shoesapp.ui.shoedetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.get
import androidx.navigation.findNavController
import com.example.shoesapp.R
import com.example.shoesapp.databinding.FragmentShoeDetailBinding
import com.example.shoesapp.model.ShoeModel
import com.example.shoesapp.ui.AppViewModel

class ShoeDetailFragment : Fragment() {

    lateinit var binding :FragmentShoeDetailBinding
    private val viewModel: AppViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_detail, container, false)

        binding.buttonAddShoe.setOnClickListener {

            var check = viewModel.checkValidationShoe(  binding.editTextShoeName,
                binding.editTextShoeDesc,
                binding.editTextShoeSize,
                binding.editTextShoeCompany )
                  if (check!=null){

                      viewModel.addShoe(check)
                      it.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)

                  }
            else{
                Toast.makeText(requireContext(),"please fill all text areas with true data",Toast.LENGTH_LONG).show()
            }




        }

       binding.buttonCancel.setOnClickListener {
           it.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)

       }

        return binding.root



    }





}