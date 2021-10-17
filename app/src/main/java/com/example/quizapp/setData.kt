package com.example.quizapp

object setData {

    const val name = "name"
    const val score = "score"

    fun getQuestion(): ArrayList<QuestionData>{
        var ques: ArrayList<QuestionData> = arrayListOf()
        var question1 = QuestionData(
            1,
            "What your name?",
            "Alu",
            "Bede",
            "Sakura",
            "Narungu",
            1
        )
        var question5 = QuestionData(
            5,
            "What time is it?",
            "9pm",
            "10pm",
            "1pm",
            "HaNoi",
            1
        )
        var question2 = QuestionData(
            2,
            "What are you doing?",
            "Code",
            "Fix Code",
            "Bug",
            "Fix Bug",
            2
        )
        var question3 = QuestionData(
            3,
            "How are you?",
            "Thanks",
            "Yes",
            "No",
            "Ok",
            3
        )
        var question4 = QuestionData(
            4,
            "What up man?",
            "Nothing",
            "Im Ok",
            "Im headache",
            "So tired",
            4
        )

        ques.add(question1)
        ques.add(question2)
        ques.add(question3)
        ques.add(question4)
        ques.add(question5)

        return ques
    }
}