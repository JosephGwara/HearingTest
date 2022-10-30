package com.josephgwara.hearingtest

import android.app.Activity
import android.app.Application
import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.josephgwara.hearingtest.databinding.FragmentTestScreenBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Dispatchers.IO


class Test_Screen_Fragment : Fragment() {
    private lateinit var binding: FragmentTestScreenBinding
    private val sm = SoundManager()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTestScreenBinding.inflate(inflater,container,false)

        countDown()
        binding.submitBtn.setOnClickListener{
            if(binding.tripletEditText.text.isEmpty()){
                binding.tripletEditText.error = "Enter what you heard"

            }else{

            }

        }
        // Inflate the layout for this fragment
        return binding.root
    }


private fun countDown(){
    object :CountDownTimer(3000,1000){
        override fun onTick(millis: Long) {
            binding.countTextView.text = "Test will begin in\n"+"             "+millis/1000
        }

        override fun onFinish() {
            binding.countTextView.visibility = View.GONE
            binding.exitTestBtn.visibility = View.VISIBLE
            binding.tripletEditText.visibility = View.VISIBLE
            binding.submitBtn.visibility = View.VISIBLE


            sm.triplet(layoutInflater.context,0,1,2)
        }

    }.start()


}
    fun testLoop(){
        for(i in 1..10){

            var difficulty = 5
            sm.playNoise(layoutInflater.context,difficulty)




        }
    }


}
