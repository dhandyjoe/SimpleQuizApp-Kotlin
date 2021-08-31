package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val username = intent.getStringExtra(Constants.name)
        usernameFinish.text = username!!

        val answer = intent.getIntExtra(Constants.answer, 0)
        val totalAnswer = intent.getIntExtra(Constants.totalAnswer, 0)

        scoreFinish.text = "Your score is $answer out of $totalAnswer"

        btn_finish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}