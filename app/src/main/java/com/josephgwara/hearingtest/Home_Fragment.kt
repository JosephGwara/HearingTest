package com.josephgwara.hearingtest


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import androidx.navigation.fragment.findNavController
import com.josephgwara.hearingtest.databinding.FragmentHomeBinding



class Home_Fragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)

        binding.beginTestBtn.setOnClickListener {
            findNavController().navigate(R.id.action_home_Fragment_to_test_Screen_Fragment)
        }
        binding.viewResultsButton.setOnClickListener{
            showMenu()
        }


        return binding.root
    }


    private fun showMenu() {
        val popupMenu = PopupMenu(layoutInflater.context,binding.viewResultsButton)
        popupMenu.menu.add("Show Results")

        popupMenu.setOnMenuItemClickListener { item ->
            if (item.title == "Show Results") {

                findNavController().navigate(R.id.action_home_Fragment_to_results)
            }
            false
        }
        popupMenu.show()
    }



}