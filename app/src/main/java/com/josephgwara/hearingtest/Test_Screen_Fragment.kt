package com.josephgwara.hearingtest


import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.josephgwara.hearingtest.databinding.FragmentTestScreenBinding
import kotlinx.android.synthetic.main.fragment_test__screen_.view.*
import java.util.*
import kotlin.concurrent.schedule


class Test_Screen_Fragment : Fragment() {
    private lateinit var binding: FragmentTestScreenBinding
    private val sm = SoundManager()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTestScreenBinding.inflate(inflater,container,false)
        binding.exitTestBtn.setOnClickListener {
         showMenu()
        }
        countDown()


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
            test()
        }

    }.start()
}

    private fun test(){

        testRound()




    }

private fun testRound(){
    var score = 0
    var noise = 4
    var difficulty = noise + 1

    var triplet =randomTriplet()
    playSounds(noise,triplet[0],triplet[1],triplet[2])
    var tripletP = "${triplet[0]+1}${triplet[1]+1}${triplet[2]+1}"

    binding.submitBtn.setOnClickListener {
        if (binding.tripletEditText.text.isEmpty()){
            binding.tripletEditText.error
        }
        else{
            var tripletA =binding.tripletEditText.text.toString()
            if ( tripletA == tripletP){
                score += difficulty
                noise ++
            }
            else{
                    if (noise == 0){
                        noise = 0
                    }else if (noise == 9){
                        noise = 9
                    }else{
                        noise --
                    }
            }

        }
    }

}

    private fun randomTriplet(): IntArray {
        return (0..8).shuffled().take(3).toIntArray()
    }


private fun playSounds(noise:Int,v1:Int,v2:Int,v3:Int){
    sm.playNoise(layoutInflater.context,noise)
    Timer().schedule(1500) {
        sm.triplet(layoutInflater.context,v1,v2,v3)
    }
}
    private fun showMenu() {
        val popupMenu = PopupMenu(layoutInflater.context,binding.exitTestBtn)
        popupMenu.menu.add("Exit Test?")

        popupMenu.setOnMenuItemClickListener { item ->
            if (item.title == "Exit Test?") {

              findNavController().navigate(R.id.action_test_Screen_Fragment_to_home_Fragment)

            }
            false
        }
        popupMenu.show()
    }

}
