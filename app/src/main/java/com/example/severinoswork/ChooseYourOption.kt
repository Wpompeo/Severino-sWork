package com.example.severinoswork

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class ChooseYourOption : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_choose_your_option)

        val radioButtons = listOf <RadioButton>(
            findViewById(R.id.rb_one),
            findViewById(R.id.rb_two),
            findViewById(R.id.rb_three),
            findViewById(R.id.rb_four),
            findViewById(R.id.rb_five),
            findViewById(R.id.rb_six),
        )

        for (radioButton in radioButtons) {
            radioButton.setOnClickListener {
                // Desmarcar os outros RadioButtons
                radioButtons.forEach { it.isChecked = it == radioButton }
            }
        }

        val btnInit = findViewById<Button>(R.id.btn_task)
        btnInit.setOnClickListener{
            val intent = Intent(this, Floor::class.java)
            startActivity(intent)
        }
    }
}