package com.example.re_com

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.result_layout.*

class ResultActivity : AppCompatActivity (){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_layout)

        val intent = getIntent()
        val flag = intent.extras?.getString(MainActivity.EXTRA_MESSAGE)?:""

        val rWordArray: Array<String> = resources.getStringArray(R.array.results_word)
        val rPriceArray: Array<String> = resources.getStringArray(R.array.result_prices)
        val rKeyArray: Array<String> = resources.getStringArray(R.array.result_keywords)
        imageView.setImageResource(R.drawable.desktop)
        textResultTop.text = rWordArray[0]
        //textResultTop.text = flag
        textPrice.text =  rPriceArray[0]
        textSentence.text = getString(R.string.result_high)
        textKeyWord.text = rKeyArray[0]
        when(flag){
            "high" -> {
                imageView.setImageResource(R.drawable.desktop)
                textResultTop.text = rWordArray[0]
                textPrice.text =  rPriceArray[0]
                textSentence.text = getString(R.string.result_high)
                textKeyWord.text = rKeyArray[0]
            }
            "middle" -> {
                imageView.setImageResource(R.drawable.desktop)
                textResultTop.text = rWordArray[1]
                textPrice.text =  rPriceArray[1]
                textSentence.text = getString(R.string.result_middle)
                textKeyWord.text = rKeyArray[1]
            }

            "low" -> {
                imageView.setImageResource(R.drawable.note)
                textResultTop.text = rWordArray[2]
                textPrice.text =  rPriceArray[2]
                textSentence.text = getString(R.string.result_low)
                textKeyWord.text = rKeyArray[2]
            }
            "mac" -> {
                imageView.setImageResource(R.drawable.apple)
                textResultTop.text = rWordArray[3]
                textPrice.text =  rPriceArray[3]
                textSentence.text = getString(R.string.result_mac)
                textKeyWord.text = rKeyArray[3]
            }
        }

        button.setOnClickListener{
            finish()
        }

    }

}