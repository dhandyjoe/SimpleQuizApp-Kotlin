package com.example.quizapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizapp.db.Constants
import com.example.quizapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start.setOnClickListener {
            if(inputWelcome.text.toString().isEmpty()){
                Toast.makeText(this, "Masukan nama anda", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, QuizQuestionActivity::class.java)
                intent.putExtra(Constants.name, inputWelcome.text.toString())
                startActivity(intent)
                finish() // fungsi finish agar tidak bisa kembali lagi ke activity inii
            }
        }
    }
}