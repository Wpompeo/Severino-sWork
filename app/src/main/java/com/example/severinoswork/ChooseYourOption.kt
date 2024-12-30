package com.example.severinoswork

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class ChooseYourOption : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_choose_your_option)

        val radioButtons = listOf<RadioButton>(
            findViewById(R.id.rb_one),
            findViewById(R.id.rb_two),
            findViewById(R.id.rb_three),
        )
        for (radioButton in radioButtons) {
            radioButton.setOnClickListener {
                // Desmarcar os outros RadioButtons
                radioButtons.forEach { it.isChecked = it == radioButton }
            }
        }
        val btnInit = findViewById<Button>(R.id.btn_task)
        btnInit.setOnClickListener {

            val selectedRadioButton = radioButtons.find { it.isChecked }

            if (selectedRadioButton != null) {
                when (selectedRadioButton.id) {
                    R.id.rb_one -> {
                        val intent = Intent(this, Plastering::class.java)
                        startActivity(intent)
                    }

                    R.id.rb_two -> {
                        val intent = Intent(this, Floor::class.java)
                        startActivity(intent)
                    }

                    R.id.rb_three -> {
                        val intent = Intent(this, Painting::class.java)
                        startActivity(intent)
                    }
                }
            } else {
                // Caso nenhum RadioButton esteja selecionado
                Toast.makeText(this, "Por favor, selecione uma opção!", Toast.LENGTH_LONG).show()
            }
        }
    }
}
