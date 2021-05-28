package com.example.quizapp
// Maksim Pasnitsenko 1910066
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)  // int because of aCorrectAnswers function in the QuizActivity and it is a Int, so I'm passing that here
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        val textView:TextView = findViewById(R.id.congratulation)

        if(correctAnswers<5){

            textView.setText("Failed")
        }
        else if(correctAnswers>=5 && correctAnswers <10){
            textView.setText("Great!")
        }
        else if(correctAnswers==10){
            textView.setText("Excellent")
        }

        score.text = "Your score is $correctAnswers out of $totalQuestions"

        btn_finish_quiz.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java)) // It will send the user to the MainActivity because of Intent
            finish() // it will close the activity
        }
    }
}