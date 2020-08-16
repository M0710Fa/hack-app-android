package com.example.re_com

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_survey_button.*

class SurveyActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey_button)


        val questionsArray: Array<String> = resources.getStringArray(R.array.questions)

        val intent = getIntent()


        val list = arrayOf(1,2,3,4)

        var clickTimes = 0
        var check = 0



        button_1.text = questionsArray[0]
        button_2.text = questionsArray[1]
        button_3.text = questionsArray[2]
        button_4.text = questionsArray[3]

        val intentSub = Intent()

            button_1.setOnClickListener {
                var flag = 1
                Toast.makeText(this, "ふーん", Toast.LENGTH_SHORT).show()
                if(check==0) {

                    button_1.text = questionsArray[4]
                    button_2.text = questionsArray[5]
                    button_3.text = questionsArray[6]
                    button_4.text = questionsArray[7]
                    button_5.text = questionsArray[8]

                    intentSub.putExtra(MainActivity.EXTRA_MESSAGE, list[1])
                }
                if(clickTimes==1) {
                    setResult(Activity.RESULT_OK,intent )
                    finish()
                }
                clickTimes=clickTimes+1

            }
            button_2.setOnClickListener {
                Toast.makeText(this, "本当にそれでいいの？", Toast.LENGTH_SHORT).show()
                check=check+2
                if(check==2) {
                    button_1.text = questionsArray[9]
                    button_2.text = questionsArray[10]
                    button_3.text = questionsArray[11]
                    button_4.text = questionsArray[12]
                }
                if(clickTimes==1) {
                    finish()
                }
                clickTimes=clickTimes+1
            }
            button_3.setOnClickListener {
                Toast.makeText(this, "君ってスタバにmac持って行きそう", Toast.LENGTH_SHORT).show()
                check=check+5
                if(check==5) {
                    button_1.text = questionsArray[13]
                    button_2.text = questionsArray[14]
                    button_3.text = questionsArray[15]
                    button_4.text = questionsArray[16]
                }
                if(clickTimes==1) {
                    finish()
                }
                clickTimes=clickTimes+1

            }
            button_4.setOnClickListener {
                Toast.makeText(this, "いいセンスしてるね！", Toast.LENGTH_SHORT).show()
                check=check+10
                if(check==10) {
                    button_1.text = questionsArray[17]
                    button_2.text = questionsArray[18]
                }
                if(clickTimes==1) {
                    finish()
                }
                clickTimes=clickTimes+1

            }

        button_5.setOnClickListener {
            Toast.makeText(this, "いいセンスしてるね！", Toast.LENGTH_SHORT).show()

            if(clickTimes==1) {
                finish()
            }
            clickTimes=clickTimes+1

        }
        }
    }
