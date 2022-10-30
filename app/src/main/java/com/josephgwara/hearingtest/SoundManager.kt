package com.josephgwara.hearingtest


import android.app.Application
import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.CountDownTimer
import android.util.Log
import kotlinx.coroutines.*




class SoundManager{
private lateinit var  mediaPlayer:MediaPlayer



fun playNoise(context: Context,noise:Int){

    val noises = intArrayOf(
        R.raw.noise_1,
        R.raw.noise_2,
        R.raw.noise_3,
        R.raw.noise_4,
        R.raw.noise_5,
        R.raw.noise_6,
        R.raw.noise_7,
        R.raw.noise_8,
        R.raw.noise_9,
        R.raw.noise_10)

        mediaPlayer = MediaPlayer.create(context,noises[noise])
        mediaPlayer.start()

}
    fun triplet(context: Context,voice1:Int,voice2: Int,voice3:Int){

       val voices = intArrayOf(
           R.raw.voice_1,
           R.raw.voice_2,
           R.raw.voice_3,
           R.raw.voice_4,
           R.raw.voice_5,
           R.raw.voice_6,
           R.raw.voice_7,
           R.raw.voice_8,
           R.raw.voice_9)
        mediaPlayer = MediaPlayer.create(context,voices[voice1])
        object :CountDownTimer(1000,1000){
            override fun onTick(p0: Long) {
                //Do nothing
            }

            override fun onFinish() {
                val mediaPlayer1:MediaPlayer = MediaPlayer.create(context,voices[voice2])
                object:CountDownTimer(1000,1000){
                    override fun onTick(p0: Long) {

                    }

                    override fun onFinish() {
                        val mediaPlayer3:MediaPlayer = MediaPlayer.create(context,voices[voice3])
                        mediaPlayer3.start()
                    }
                }.start()
                mediaPlayer1.start()
            }

        }.start()
        mediaPlayer.start()


    }


}


