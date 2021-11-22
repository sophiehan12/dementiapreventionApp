package com.example.dementiaprevention

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.tts.TextToSpeech
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.survey_activity_main.*
import java.util.*

class SurveyMainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    private val REQUEST_CODE = 1
    //private var speechRecognizer: SpeechRecognizer? = null
    private var tts: TextToSpeech? = null
    private var mystring: String = "질문이 끝나면 생각하시는 답을 입력하시고, 다음 버튼을 클릭하여 다음 검사페이지로 이동해 주시기 바랍니다. 질문을 듣고 싶으시면 질문 듣기 버튼을 클릭해주세요.     치매 진단 테스트를 시작하시겠습니까?"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.survey_activity_main)

        if(Build.VERSION.SDK_INT >= 23)
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.INTERNET, Manifest.permission.RECORD_AUDIO),REQUEST_CODE)

        // tts에 TextToSpeech 값 넣어줌
        tts = TextToSpeech(this, this)

        //실행 시
        listenbutton.setOnClickListener { startTTS() }


        buttonstartsurvey.setOnClickListener {
            //var intent1 = Intent(application, Survey1::class.java)
            //startActivity(intent1)
        }
    }
    // TTS 예제
    private fun startTTS() {
        tts!!.speak(mystring, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    // TextToSpeech override 함수
    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            // set US English as language for tts
            val result = tts!!.setLanguage(Locale.KOREA)

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                //doSomething
            } else {
                //doSomething
            }
        } else {
            //doSomething
        }

    }


    override fun onDestroy() {

        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }

        super.onDestroy()
    }

}