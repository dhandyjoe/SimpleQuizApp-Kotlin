package com.example.quizapp.db

import com.example.quizapp.R
import com.example.quizapp.model.ModelQuestion

object  Constants {

     const val name = "Dhandy"
     const val answer = "answer"
     const val totalAnswer = "total_answer"

    fun getQuestion(): ArrayList<ModelQuestion>{
        val questionList = ArrayList<ModelQuestion>()

// 1
        val que1 = ModelQuestion(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "America",
            "Austria",
            1
        )

// 2
        val que2 = ModelQuestion(
            2,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Angola", "Austria",
            "Australia", "Armenia", 3
        )

// 3
        val que3 = ModelQuestion(
            3, "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Belarus", "Belize",
            "Brunei", "Brazil", 4
        )

// 4
        val que4 = ModelQuestion(
            4, "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Bahamas", "Belgium",
            "Barbados", "Belize", 2
        )

// 5
        val que5 = ModelQuestion(
            5, "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Gabon", "France",
            "Fiji", "Finland", 3
        )

// 6
        val que6 = ModelQuestion(
            6, "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany", "Georgia",
            "Greece", "Indonesia", 1
        )

// 7
        val que7 = ModelQuestion(
            7, "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Dominica", "Egypt",
            "Denmark", "Ethiopia", 3
        )

// 8
        val que8 = ModelQuestion(
            8, "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Ireland", "Iran",
            "Hungary", "India", 4
        )

        // 9
        val que9 = ModelQuestion(
            9, "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia", "New Zealand",
            "Tuvalu", "United States of America", 2
        )

// 10
        val que10 = ModelQuestion(
            10, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait", "Jordan",
            "Sudan", "Palestine", 1
        )

        questionList.add(que1)
        questionList.add(que2)
        questionList.add(que3)
        questionList.add(que4)
        questionList.add(que5)
        questionList.add(que6)
        questionList.add(que7)
        questionList.add(que8)
        questionList.add(que9)
        questionList.add(que10)
        return questionList
    }
}