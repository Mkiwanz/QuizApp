package com.example.quizapp

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.R
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var submitButton: Button
    private lateinit var resetButton: Button
    private lateinit var radioGroupQuestion1: RadioGroup
    private lateinit var checkBox1: CheckBox
    private lateinit var checkBox2: CheckBox
    private lateinit var checkBox3: CheckBox
    private lateinit var checkBox4: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submitButton = findViewById(R.id.submitButton)
        resetButton = findViewById(R.id.resetButton)
        radioGroupQuestion1 = findViewById(R.id.radioGroupQuestion1)
        checkBox1 = findViewById(R.id.checkOption1)
        checkBox2 = findViewById(R.id.checkOption2)
        checkBox3 = findViewById(R.id.checkOption3)
        checkBox4 = findViewById(R.id.checkOption4)
        submitButton.setOnClickListener { handleSubmit() }
        resetButton.setOnClickListener { handleReset() }
    }

    private fun handleSubmit() {
        val score = calculateScore()
        val currentDateTime =
            SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
        val scorePercentage = score * 50
        showAlertDialog("Congratulations! You submitted on $currentDateTime, you achieved $scorePercentage%")
    }

    private fun handleReset() {
        radioGroupQuestion1.clearCheck()
        checkBox1.isChecked = false
        checkBox2.isChecked = false
        checkBox3.isChecked = false
        checkBox4.isChecked = false
    }

    private fun calculateScore(): Int {
        var score = 0
        if (radioGroupQuestion1.checkedRadioButtonId == R.id.radioOption2) score++
        if (checkBox1.isChecked && checkBox2.isChecked && checkBox3.isChecked && !checkBox4.isChecked) score++
        return score
    }

    private fun showAlertDialog(message: String) {
        AlertDialog.Builder(this)
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }
}
