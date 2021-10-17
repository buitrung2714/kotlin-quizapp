package com.example.quizapp

data class QuestionData (
     val id: Int,
     val question: String,
     val option_one: String,
     val option_two: String,
     val option_three: String,
     val option_four: String,
     val correct: Int
        ){}