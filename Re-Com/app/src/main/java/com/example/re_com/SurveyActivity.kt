package com.example.re_com


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_survey_button.*

class SurveyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey_button)

        val serectWeight = arrayOf(-1,0,1,5,10)

        var weightSum = 0

        var clickTimes = 1


for(i in 0..1){

    button_1.setOnClickListener {
        Toast.makeText(this, "ふーん", Toast.LENGTH_SHORT).show()
    }
    button_2.setOnClickListener {
        Toast.makeText(this, "本当にそれでいいの？", Toast.LENGTH_SHORT).show()


    }
    button_3.setOnClickListener {
        Toast.makeText(this, "君ってスタバにmac持って行きそう", Toast.LENGTH_SHORT).show()

    }
    button_4.setOnClickListener {
        Toast.makeText(this, "いいセンスしてるね！", Toast.LENGTH_SHORT).show()

    }


}


    }
}