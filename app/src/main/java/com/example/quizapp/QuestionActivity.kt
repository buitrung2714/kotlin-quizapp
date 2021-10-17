package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {
    private var Name:String ? = null;
    private var score:Int = 0;

    var currentPosition: Int = 1
    var questionList: ArrayList<QuestionData>? = null
    var selectedOption: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        Name = intent.getStringExtra(setData.name)

        questionList = setData.getQuestion()

        setQuestion()

        txtOption1.setOnClickListener {
            selectedOptionStyle(txtOption1,1)
        }
        txtOption2.setOnClickListener {
            selectedOptionStyle(txtOption2,2)
        }
        txtOption3.setOnClickListener {
            selectedOptionStyle(txtOption3,3)
        }
        txtOption4.setOnClickListener {
            selectedOptionStyle(txtOption4,4)
        }

        btnResult.setOnClickListener {
            if(selectedOption != 0){
                val question = questionList!![currentPosition - 1]

                if(selectedOption != question.correct){
                    setColor(selectedOption, R.drawable.wrong_question_option)
                }else{
                    score++
                }
                setColor(question.correct, R.drawable.correct_question_option)

                if(currentPosition === questionList!!.size){
                    btnResult.text = "FINISH"
                }else{
                    btnResult.text = "Go to Next"
                }
            }else{
                currentPosition++
                when{
                    currentPosition<=questionList!!.size -> {
                        setQuestion()
                    }
                    else -> {
                        var intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra(setData.name,Name.toString())
                        intent.putExtra(setData.score,score.toString())
                        intent.putExtra("total size",questionList!!.size.toString())
                        startActivity(intent)
                    }
                }
            }
            selectedOption = 0
        }
    }

    fun setColor(opt: Int, color: Int){
        when(opt){
            1 -> txtOption1.background = ContextCompat.getDrawable(this, color)
            2 -> txtOption2.background = ContextCompat.getDrawable(this, color)
            3 -> txtOption3.background = ContextCompat.getDrawable(this, color)
            4 -> txtOption4.background = ContextCompat.getDrawable(this, color)
        }
    }

    fun setQuestion(){
        val question = questionList!![currentPosition - 1]
        setOptionStyle()
        progressBar.progress = currentPosition
        progressBar.max = questionList!!.size
        txtProgress.text = "$currentPosition/${questionList!!.size}"
        txtQuestion.text = question.question
        txtOption1.text = question.option_one
        txtOption2.text = question.option_two
        txtOption3.text = question.option_three
        txtOption4.text = question.option_four
    }

    fun setOptionStyle(){
        var optionList: ArrayList<TextView> = arrayListOf()
        optionList.add(txtOption1)
        optionList.add(txtOption2)
        optionList.add(txtOption3)
        optionList.add(txtOption4)

        for (op in optionList){
            op.setTextColor(Color.parseColor("#555151"))
            op.background = ContextCompat.getDrawable(this, R.drawable.question_option)
            op.typeface = Typeface.DEFAULT
        }
    }

    fun selectedOptionStyle(view: TextView, opt: Int){
        setOptionStyle()
        selectedOption = opt
        view.background = ContextCompat.getDrawable(this,R.drawable.selected_question_option)
        view.typeface = Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))
    }
}