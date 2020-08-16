package com.example.re_com

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_survey_button.*

class SurveyActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey_button)
        val questionsArray: Array<String> = resources.getStringArray(R.array.questions)
        val stringArray = arrayOf<String>()
        var clickTimes = 0
        var check = 0
        button_1.text = questionsArray[0]
        button_2.text = questionsArray[1]
        button_3.text = questionsArray[2]
        button_4.text = questionsArray[3]
        button_5.text = questionsArray[4]
        button_6.text = questionsArray[5]
        button_7.text = questionsArray[6]
        button_8.text = questionsArray[7]

        val intent = getIntent()
        val intentSub = Intent()

        button_1.setOnClickListener {
            intentSub.putExtra(MainActivity.EXTRA_MESSAGE, "high")
            setResult(Activity.RESULT_OK, intentSub)
            finish()
        }
        button_2.setOnClickListener {
            intentSub.putExtra(MainActivity.EXTRA_MESSAGE, "middle")
            setResult(Activity.RESULT_OK, intentSub)
            finish()
        }
        button_3.setOnClickListener {
            intentSub.putExtra(MainActivity.EXTRA_MESSAGE, "high")
            setResult(Activity.RESULT_OK, intentSub)
            finish()
        }
        button_4.setOnClickListener {
            intentSub.putExtra(MainActivity.EXTRA_MESSAGE, "middle")
            setResult(Activity.RESULT_OK, intentSub)
            finish()
        }
        button_5.setOnClickListener {
            intentSub.putExtra(MainActivity.EXTRA_MESSAGE, "mac")
            setResult(Activity.RESULT_OK, intentSub)
            finish()
        }
        button_6.setOnClickListener {
            intentSub.putExtra(MainActivity.EXTRA_MESSAGE, "high")
            setResult(Activity.RESULT_OK, intentSub)
            finish()
        }
        button_7.setOnClickListener {
            intentSub.putExtra(MainActivity.EXTRA_MESSAGE, "mac")
            setResult(Activity.RESULT_OK, intentSub)
            finish()
        }
        button_8.setOnClickListener {
            intentSub.putExtra(MainActivity.EXTRA_MESSAGE, "low")
            setResult(Activity.RESULT_OK, intentSub)
            finish()

        }
    }
}