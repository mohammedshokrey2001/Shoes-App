package com.example.shoesapp.ui.shoelist

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.ViewGroup.MarginLayoutParams
import android.widget.*
import androidx.activity.OnBackPressedCallback
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView.LayoutParams
import com.example.shoesapp.R
import com.example.shoesapp.databinding.FragmentShoeListBinding
import com.example.shoesapp.model.ShoeModel
import com.example.shoesapp.ui.AppViewModel


@Suppress("DEPRECATION")
class ShoeListFragment : Fragment() {



     private lateinit var binding: FragmentShoeListBinding
    private val appViewModel: AppViewModel by activityViewModels()



    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_list, container, false)

        binding.lifecycleOwner = this

        val baseLayout =  LinearLayout(context)
        baseLayout.orientation = LinearLayout.VERTICAL




        appViewModel.shoeLit.observe(viewLifecycleOwner, Observer {
             binding.shoeList.removeAllViews()

            for (shoe in it){
                
                
                baseLayout.addView(prepareNewCard(requireContext(),shoe))
                val space = Space(context)

                space.minimumHeight =30
                baseLayout.addView(space)
            }

            binding.shoeList.addView(baseLayout)
        })



        binding.floatingActionButtonAddNewShoes.setOnClickListener{


            it.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)

        }



        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {

                    if (isEnabled) {
                        isEnabled = false
                        view?.findNavController()?.navigate(R.id.action_shoeListFragment_to_loginFragment2)
                    }
                }
            }
            )


       setHasOptionsMenu(true)
         return binding.root




    }


    @SuppressLint("SetTextI18n")
    private fun prepareNewCard(context: Context, shoeModel: ShoeModel):CardView{

        val cardView = CardView(context)
        cardView.setCardBackgroundColor(resources.getColor(R.color.card_background_care))
        cardView.preventCornerOverlap = true
        cardView.radius = 7f

        val layoutparam = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
       cardView.layoutParams = layoutparam

        val textViewName = TextView(context)
        textViewName.text = "shoe name: ${shoeModel.name}"
        textViewName.textSize= 18f

        val textViewCompany = TextView(context)
        textViewCompany.text ="manufacture: ${shoeModel.company}"
        textViewCompany.textSize= 16f

        val textViewSize = TextView(context)
        textViewSize.text = "shoe size: ${shoeModel.size.toString()}"
        textViewSize.textSize= 16f

        val textDesc = TextView(context)
        textDesc.text = "shoe description: ${shoeModel.description.toString()}"
        textDesc.textSize= 16f


        val image = ImageView(context)
        image.setBackgroundResource(R.drawable.shoeimgjpg)

        val parms: LinearLayout.LayoutParams = LinearLayout.LayoutParams(400, 300)

        image.layoutParams = parms



        val textLayout = LinearLayout(context)
        textLayout.orientation = LinearLayout.VERTICAL
        textLayout.addView(textViewName,0)
        textLayout.addView(textViewCompany,1)
        textLayout.addView(textDesc,2)
        textLayout.addView(textViewSize,3)


        val gridLayout = GridLayout(context)
        gridLayout.addView(image)
        gridLayout.addView(textLayout)

        cardView.addView(gridLayout)
        return cardView

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu,menu)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.menu_item_log_out) {
             appViewModel.logout()
            view?.findNavController()?.navigate(R.id.action_shoeListFragment_to_loginFragment2)
        }

        return true
    }



}
