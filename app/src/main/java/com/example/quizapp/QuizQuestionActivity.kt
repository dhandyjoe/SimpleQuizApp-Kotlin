package com.example.quizapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.Typeface.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<DataQuestion>? = null
    private var mSelectedOption: Int = 0
    private var mCorrectAnswer: Int = 0
    private var mUsername: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUsername = intent.getStringExtra(Constants.name)

        mQuestionList = Constants.getQuestion()

        setQuestion()

        answer1.setOnClickListener(this)
        answer2.setOnClickListener(this)
        answer3.setOnClickListener(this)
        answer4.setOnClickListener(this)
        btn_submit.setOnClickListener(this)

    }

    private fun setQuestion(){
        // function digunakan untuk menampilkan pertanyaan
        answerClick(answer1)
        answerClick(answer2)
        answerClick(answer3)
        answerClick(answer4)

        val question = mQuestionList!![mCurrentPosition - 1]

        defaultOption()

        if(mCurrentPosition <= mQuestionList!!.size){
            btn_submit.text = "SUBMIT"
        }

        progresBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progresBar.max

        pertanyaanQ.text = question.question
        gambarQ.setImageResource(question.image)
        answer1.text = question.optionOne
        answer2.text = question.optionTwo
        answer3.text = question.optionThree
        answer4.text = question.optionFour

    }

    private fun defaultOption() {
        // function ini digunakan untuk mengembalikan kondisi option
        val option = ArrayList<TextView>()
        option.add(0, answer1)
        option.add(1, answer2)
        option.add(2, answer3)
        option.add(3, answer4)

        for(options in option){
            options.setTextColor(Color.parseColor("#7A8089"))
            options.typeface = DEFAULT
            options.background = ContextCompat.getDrawable(this, R.drawable.background_answer)
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.answer1 -> selectedOption(answer1, 1)
            R.id.answer2 -> selectedOption(answer2, 2)
            R.id.answer3 -> selectedOption(answer3, 3)
            R.id.answer4 -> selectedOption(answer4, 4)
            R.id.btn_submit -> {
                if (mSelectedOption == 0) {
                    mCurrentPosition++
                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, FinishActivity::class.java)
                            intent.putExtra(Constants.name, mUsername)
                            intent.putExtra(Constants.answer, mCorrectAnswer)
                            intent.putExtra(Constants.totalAnswer, mQuestionList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionList!![mCurrentPosition - 1]
                    if(question.correctAnswer != mSelectedOption) {
                        answerView(mSelectedOption, R.drawable.incorrect_background_answer)
                        answerView(question.correctAnswer, R.drawable.correct_background_answer)
                        answer1.isClickable = false
                        answer2.isClickable = false
                        answer3.isClickable = false
                        answer4.isClickable = false
                    } else {
                        mCorrectAnswer++
                        answerView(question.correctAnswer, R.drawable.correct_background_answer)
                        answer1.isClickable = false
                        answer2.isClickable = false
                        answer3.isClickable = false
                        answer4.isClickable = false
                    }

                    if(mCurrentPosition == mQuestionList!!.size){
                        btn_submit.text = "FINISH"
                    } else {
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOption = 0
                }
            }
        }
    }
    private fun answerView(answer: Int, drawable: Int){
        // function ini digunakan untuk mengubah option jika salah / benar
        when(answer){
            1 -> answer1.background = ContextCompat.getDrawable(this, drawable)
            2 -> answer2.background = ContextCompat.getDrawable(this, drawable)
            3 -> answer3.background = ContextCompat.getDrawable(this, drawable)
            4 -> answer4.background = ContextCompat.getDrawable(this, drawable)
        }
    }

    private fun selectedOption(tv: TextView, selectionOptionNum: Int){
        // function ini digunakan mengubah tampilan option setelah di klik
        defaultOption()
        mSelectedOption = selectionOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_background_answer)
    }

    fun answerClick(view: View) {
        // function ini berguna saat pegguna sudah submit pertanyaan,
        view.isClickable = true
    }
}