package com.josephgwara.hearingtest



import android.content.Context
import android.media.MediaPlayer
import java.util.*
import kotlin.concurrent.schedule


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

    Timer().schedule(5500){
        mediaPlayer.stop()
    }
}
    fun triplet(context: Context,voice1:Int,voice2:Int,voice3:Int){

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

        var mediaPlayer1 = MediaPlayer.create(context,voices[voice1])
        val mediaPlayer2 = MediaPlayer.create(context,voices[voice2])
        val mediaPlayer3 = MediaPlayer.create(context,voices[voice3])
        mediaPlayer1.start()

        Timer().schedule(1000) {
            mediaPlayer2.start()
            Timer().schedule(1000){
                mediaPlayer3.start()
            }
        }

    }


}


