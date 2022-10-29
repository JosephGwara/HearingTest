package com.josephgwara.hearingtest


import android.app.Application
import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool


private lateinit var pool:SoundPool
private lateinit var audioAttributes: AudioAttributes

class SoundManager{
    private lateinit var context: Context

   private val voices = IntArray(9)
  private  var noises = IntArray(10)

    fun loadNoises(context: Context):IntArray{
        this.context = context.applicationContext
        audioAttributes = AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .setUsage(AudioAttributes.USAGE_GAME)
            .build()

        pool = SoundPool.Builder()
            .setMaxStreams(4)
            .setAudioAttributes(audioAttributes)
            .build()

        noises[0] = pool.load(context,R.raw.noise_1,0)
        noises[1] = pool.load(context,R.raw.noise_2,0)
        noises[2] = pool.load(context,R.raw.noise_3,0)
        noises[3] = pool.load(context,R.raw.noise_4,0)
        noises[4] = pool.load(context,R.raw.noise_5,0)
        noises[5] = pool.load(context,R.raw.noise_6,0)
        noises[6] = pool.load(context,R.raw.noise_7,0)
        noises[7] = pool.load(context,R.raw.noise_8,0)
        noises[8] = pool.load(context,R.raw.noise_9,0)
        noises[9] = pool.load(context,R.raw.noise_10,0)


        pool.setOnLoadCompleteListener { soundPool, i, i2 ->
            noises
        }
return noises

    }
    fun loadVoices(context: Context):IntArray{
        this.context = context.applicationContext
        audioAttributes = AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .setUsage(AudioAttributes.USAGE_GAME)
            .build()

        pool = SoundPool.Builder()
            .setMaxStreams(4)
            .setAudioAttributes(audioAttributes)
            .build()

        voices[0]= pool.load(context,R.raw.voice_1,0)
        voices[1]= pool.load(context,R.raw.voice_2,0)
        voices[2]= pool.load(context,R.raw.voice_3,0)
        voices[3]= pool.load(context,R.raw.voice_4,0)
        voices[4]= pool.load(context,R.raw.voice_5,0)
        voices[5]= pool.load(context,R.raw.voice_6,0)
        voices[6]= pool.load(context,R.raw.voice_7,0)
        voices[7]= pool.load(context,R.raw.voice_8,0)
        voices[8]= pool.load(context,R.raw.voice_9,0)
        pool.setOnLoadCompleteListener { soundPool, i, i2 ->
            voices
        }
    return voices
    }

    fun PlaySounds(context: Context,noise:Int,voice:Int){
        this.context = context.applicationContext
        pool.play(loadNoises(context)[noise],1f,1f,0,0,1f)
        pool.play(loadVoices(context)[voice],1f,1f,0,0,1f)

    }



}


