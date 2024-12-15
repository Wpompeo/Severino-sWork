package com.example.severinoswork

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText


class Painting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_painting)

        val edtWidthPiece = findViewById<TextInputEditText>(R.id.edt_til_width_of_the_wall_width)
        val edtLengthPiece = findViewById<TextInputEditText>(R.id.edt_length_wall_piece)
        val edtLengthWidthPiece = findViewById<TextInputEditText>(R.id.edt_length_wall_width)
        val edtLengthLengthPiece = findViewById<TextInputEditText>(R.id.edt_length_of_the_wall_length)
        val edtWidthCeiling = findViewById<TextInputEditText>(R.id.edt_width_wall_ceiling)
        val edtLengthCeiling = findViewById<TextInputEditText>(R.id.edt_length_wall_width)
        val btnNextTint = findViewById<Button>(R.id.btn_calculate_tint)




    }
}