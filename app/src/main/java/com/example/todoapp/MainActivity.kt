package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val questionBank: Array<Question> = arrayOf(
        Question("test1", true),
        Question("test2", false),
        Question("test3", true),
        Question("test4", false)
    )

    private var streak = 0
    private var score = 0

    private fun checkAnswer(answer: Boolean): Boolean {
        return if (answer == questionBank[currentIndex].getAnswer()) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            true
        } else {
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_LONG).show()
            false
        }
    }

    private var currentIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val trueButton = findViewById<Button>(R.id.true_button)
        val falseButton = findViewById<Button>(R.id.false_button)
        val questionText = findViewById<TextView>(R.id.question_view)
        val nextButton = findViewById<Button>(R.id.next_button)
        val streakScore = findViewById<TextView>(R.id.streak_val)
        val scoreValue = findViewById<TextView>(R.id.score_val)
        val backButton = findViewById<Button>(R.id.back_button)

        questionText.text = questionBank[currentIndex].getTitle()


        trueButton.setOnClickListener {
            val flag: Boolean = checkAnswer(true)
            if (flag) {
                streak++
                streakScore.text = streak.toString()

                score++
                scoreValue.text = score.toString()

                nextButton.visibility = View.VISIBLE
            } else {
                streakScore.text = "0"
            }
        }

        falseButton.setOnClickListener {
            val flag: Boolean = checkAnswer(false)
            if (flag) {
                streak++
                streakScore.text = streak.toString()

                score++
                scoreValue.text = score.toString()

                nextButton.visibility = View.VISIBLE
            } else {
                streakScore.text = "0"
            }
        }

        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            questionText.text = questionBank[currentIndex].getTitle()

            nextButton.visibility = View.GONE
            if (currentIndex > 0) {
                backButton.visibility = View.VISIBLE
            } else {
                backButton.visibility = View.GONE
            }
        }

        backButton.setOnClickListener {
            currentIndex = (currentIndex - 1) % questionBank.size
            questionText.text = questionBank[currentIndex].getTitle()
            if (currentIndex == 0) {
                backButton.visibility = View.GONE
            } else {
                backButton.visibility = View.VISIBLE
            }
        }

    }

}