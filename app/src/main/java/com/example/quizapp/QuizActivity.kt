package com.example.quizapp
// Maksim Pasnitsenko 1910066
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity(), View.OnClickListener { // I implement OnClickListener to the class QuizActivity

    private var aCurrentPosition:Int = 1 // each time I get to this activity it should start with the first question
    private var aQuestionsList: ArrayList<Question>? = null // I need to have and object that I can use in order to set questionsList variable
    private var aSelectedOptionPosition : Int = 0 // I need to know which option is selected, so it can check if the answer is correct
    private var aCorrectAnswers: Int = 0 // It will know how many correct answers the user did



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        aQuestionsList = Constants.getQuestions() // It's going to give me all the different questions that I have

        setQuestion()

        option_one.setOnClickListener(this)    ///so I can click on the buttons
        option_two.setOnClickListener(this)
        option_three.setOnClickListener(this)
        option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)

    }


    private fun setQuestion() {

        val theQuestion = aQuestionsList!![aCurrentPosition-1]

        defaultOptionsView() // so that all the buttons are back to the default appearance before I select one of them by clicking on them

        if (aCurrentPosition == aQuestionsList!!.size) {
            btn_submit.text = "FINISH" // on the last question the button will change to FINISH, otherwise it will be SUBMIT
        }else{
            btn_submit.text = "SUBMIT"
        }
        progress_bar.progress = aCurrentPosition // to access the progress bar
        progress.text = "$aCurrentPosition" +  "/" + progress_bar.max



        // we set the question text, this all is tied to data class Question
        l_question.text = theQuestion!!.question
        image.setImageResource(theQuestion.image)  // I set the image resource
        option_one.text = theQuestion.optionOne
        option_two.text = theQuestion.optionTwo
        option_three.text = theQuestion.optionThree
        option_four.text = theQuestion.optionFour

    }

    // default UI for buttons
    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0,option_one)
        options.add(1,option_two)
        options.add(2,option_three)
        options.add(3,option_four)
    // this for loop will go in to all the options and will assign the UI
        for (option in options) {
            option.setTextColor(Color.parseColor("#FF0000")) // button corner color when the button is pressed
            option.typeface = Typeface.DEFAULT  // for style like bold, italic in the text
            option.background = ContextCompat.getDrawable(this,R.drawable.oone) // boarder color
        }

    }

    override fun onClick(v: View?) { // for using SelectedOptionView function
        when(v?.id){
            R.id.option_one -> { // option_one is a TextView from SelectedOptionView function
                selectedOptionsView(option_one,1) // I called fun selectedOptionNumber, and pass in the option_one and the number
            }
            R.id.option_two -> {
                selectedOptionsView(option_two,2) // I called fun selectedOptionNumber, and pass in the option_two and the number
            }
            R.id.option_three -> {
                selectedOptionsView(option_three,3) // I called fun selectedOptionNumber, and pass in the option_three and the number
            }
            R.id.option_four -> {
                selectedOptionsView(option_four,4) // I called fun selectedOptionNumber, and pass in the option_four and the number
            }
            R.id.btn_submit -> {
                if(aSelectedOptionPosition == 0) {   
                    aCurrentPosition ++ // if aSelectedOptionPosition is 0 then I want to go to the next question, and it is done with aCurrentPosition, I increase the position by one, therefore going to the next question
                    // the aSelectedOptionPosition will be checked and changed, when the user will press any of the other buttons

                    when{
                        aCurrentPosition <= aQuestionsList!!.size ->{
                            setQuestion() // resets the screen and goes to the next question
                        } else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            // I put all the extra info from the Constant and the values
                            intent.putExtra(Constants.CORRECT_ANSWERS, aCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, aQuestionsList!!.size) // aQuestionsList is a nullable that's why !!
                            startActivity(intent)
                       }
                    }
                }else{
                    val question = aQuestionsList?.get(aCurrentPosition -1) // aQuestionsList is a arrayList its starts at 0
                    if(question!!.correctOption!= aSelectedOptionPosition){
                        answerView(aSelectedOptionPosition, R.drawable.wrong_oone) // for setting wrong answer
                        }else{
                            aCorrectAnswers++ // if the answer was incorrect, it increases by 1
                        }
                        answerView(question.correctOption, R.drawable.correct_oone)  // for setting correct answer

                    if(aCurrentPosition == aQuestionsList!!.size){      
                        btn_submit.text = "FINISH"
                    }else{
                        btn_submit.text = "GO TO THE NEXT QUESTION"
                    }
                    aSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int){ // this fun is going to assign the right color to options, and drawableView: Int because drawables are stored as Integers
        when(answer){ // if the answer is 1 it will set the option_one background
            1 ->{
                option_one.background = ContextCompat.getDrawable(this, drawableView) // drawableView is going to be a Int passed through answerView
            }
            2 ->{
                option_two.background = ContextCompat.getDrawable(this, drawableView) // drawableView is going to be a Int passed through answerView
            }
            3 ->{
                option_three.background = ContextCompat.getDrawable(this, drawableView) // drawableView is going to be a Int passed through answerView
            }
            4 ->{
                option_four.background = ContextCompat.getDrawable(this, drawableView) // drawableView is going to be a Int passed through answerView
            }
        }
    }




    private fun selectedOptionsView(tv: TextView, selectedOptionNumber: Int){

        defaultOptionsView() // resets the buttons to the default view
        aSelectedOptionPosition = selectedOptionNumber // selection

        tv.setTextColor(Color.parseColor("#FF0000")) // sets the text color
        tv.setTypeface(tv.typeface, Typeface.BOLD) // sets the text to bold
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_oone) // sets the background
    }

}