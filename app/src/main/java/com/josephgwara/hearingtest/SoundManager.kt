package com.josephgwara.hearingtest

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool


private lateinit var pool:SoundPool
private lateinit var audioAttributes: AudioAttributes

class SoundManager {

    fun getSounds(){

        noisePool()

    }

    private fun noisePool() {
        audioAttributes = AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .setUsage(AudioAttributes.USAGE_GAME)
            .build()

        pool = SoundPool.Builder()
            .setMaxStreams(4)
            .setAudioAttributes(audioAttributes)
            .build()


    }



}