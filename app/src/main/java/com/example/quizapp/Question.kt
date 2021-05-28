package com.example.quizapp
// Maksim Pasnitsenko 1910066
// it will only have data info text
data class Question (
    val id: Int,  // so I will know which question I'm looking at
    val question: String, // the question it self
    val image: Int,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctOption: Int
)

