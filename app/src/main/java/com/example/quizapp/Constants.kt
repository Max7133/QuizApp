package com.example.quizapp

import kotlin.collections.ArrayList

// Maksim Pasnitsenko 1910066
object Constants { // it will contain all of the questions

    const val TOTAL_QUESTIONS: String = "total questions" // I use this constants in the OnClick function in the QuizActivity using intent
    const val CORRECT_ANSWERS: String = "correct_answers"

    // I'm using getQuestions function in order to get different questions and what type are they, and they are type question, and they are in ArrayList
    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val questionOne = Question(1,"Microwave in Finnish ?",
        R.drawable.ic_question_one, "mikroaltouni","mikroaaltouuni","mikrooaltouuni","mikroaltouuni", 2
        )

        questionsList.add(questionOne)

        val questionTwo = Question(1,"Chair in Finnish ?",
            R.drawable.ic_question_two, "toli","tuli","tuoli","tuolii", 3
        )

        questionsList.add(questionTwo)

        val questionThree = Question(1,"Table in Finnish ?",
            R.drawable.ic_question_three, "poytä","poyttä","poytää","poyttä", 1
        )

        questionsList.add(questionThree)

        val questionFour = Question(1,"Cat in Finnish ?",
            R.drawable.ic_question_four, "kiissa","kiisa","kisa","kissa", 4
        )

        questionsList.add(questionFour)

        val questionFive = Question(1,"Bear in Finnish ?",
            R.drawable.ic_question_five, "kaaru","karhuu","karu","karhu", 4
        )

        questionsList.add(questionFive)

        val questionSix = Question(1,"Coffee in Finnish ?",
            R.drawable.ic_question_six, "kahvi","kaahvi","kaahvii","kahhvi", 1
        )

        questionsList.add(questionSix)

        val questionSeven = Question(1,"Pen in Finnish ?",
            R.drawable.ic_question_seven, "Kynää","Kynnä","Kynä","Kynnää", 3
        )

        questionsList.add(questionSeven)

        val questionEight = Question(1,"Sun in Finnish ?",
            R.drawable.ic_question_eight, "aurinkoo","aurinkko","aurinko","aurrinko", 3
        )

        questionsList.add(questionEight)

        val questionNine = Question(1,"Book in Finnish ?",
            R.drawable.ic_question_nine, "kirjaa","kirja","kirrja","kirrjaa", 2
        )

        questionsList.add(questionNine)

        val questionTen = Question(1,"Lamp in Finnish ?",
            R.drawable.ic_question_ten, "lampu","lammppu","lamppu","laampu", 3
        )

        questionsList.add(questionTen)


        return questionsList

    }

}