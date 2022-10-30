package com.josephgwara.hearingtest

import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class Home_Fragment : Fragment() {
    private val sm = SoundManager()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_, container, false)


        val beginButton = view.findViewById<Button>(R.id.beginTestBtn)

        beginButton.setOnClickListener{

            findNavController().navigate(R.id.action_home_Fragment_to_test_Screen_Fragment)
        }

        return  view
    }



}