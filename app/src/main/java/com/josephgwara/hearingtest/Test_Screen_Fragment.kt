package com.josephgwara.hearingtest

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
private lateinit var pool: SoundPool
private lateinit var audioAttributes: AudioAttributes
class Test_Screen_Fragment : Fragment() {
   private lateinit var binding: FragmentTestScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTestScreenBinding.inflate(inflater,container,false)
countDown()

        val sm = SoundManager()
        sm.loadSounds(inflater.context)

        binding.submitBtn.setOnClickListener{


        }
        // Inflate the layout for this fragment
        return binding.root
    }


fun countDown(){
    object :CountDownTimer(3000,1000){
        override fun onTick(p0: Long) {
            binding.countTextView2.text = ""+p0/1000
        }

        override fun onFinish() {
            binding.countTextView2.text = "God is Great"
        }

    }.start()


}


}
