package com.example.severinoswork

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
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
        val edtLengthLengthPiece =
            findViewById<TextInputEditText>(R.id.edt_length_of_the_wall_length)
        val edtWidthCeiling = findViewById<TextInputEditText>(R.id.edt_width_wall_ceiling)
        val edtLengthCeiling = findViewById<TextInputEditText>(R.id.edt_length_wall_width)
        val cbRoof = findViewById<CheckBox>(R.id.cb_roof)
        val btnNextTint = findViewById<Button>(R.id.btn_calculate_tint)

        btnNextTint.setOnClickListener {
            val widthPieceStr: String = edtWidthPiece.text.toString()
            val lengthPieceStr: String = edtLengthPiece.text.toString()
            val lengthWidthPieceStr: String = edtLengthWidthPiece.text.toString()
            val lengthLengthPieceStr: String = edtLengthLengthPiece.text.toString()
            val widthCeilingStr: String = edtWidthCeiling.text.toString()
            val lengthCeilingStr: String = edtLengthCeiling.text.toString()
            val spinnerWidth: Spinner = findViewById(R.id.spn_wall_width)
            val spinnerLength: Spinner = findViewById(R.id.spn_wall_length)

            if (cbRoof.isChecked) {
                if (widthPieceStr == "" || lengthPieceStr == "" || lengthWidthPieceStr == "" || lengthLengthPieceStr == ""
                    || widthCeilingStr == "" || lengthCeilingStr == ""
                ) {
                    Toast.makeText(
                        this, "Preencha todos os campos para avançar!",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } else {
                if (widthPieceStr == "" || lengthPieceStr == "" || lengthWidthPieceStr == "" || lengthLengthPieceStr == ""
                    && widthCeilingStr != "" || lengthCeilingStr != ""
                ) {
                    Toast.makeText(
                        this, "Favor rever os campos, campo desnecessário preenchido!",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
            //carrega itens array definido no strings xml
            val numbresWall = resources.getStringArray(R.array.quantityWall)

            //cria o adpater
            val adapter = ArrayAdapter(
                this, android.R.layout.simple_spinner_item,
                numbresWall
            )

            //define o layout para o dropdown
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            //associa o adapter ao spinner
            spinnerWidth.adapter = adapter
            spinnerLength.adapter = adapter


            if (cbRoof.isChecked) {
                val widthPiece = widthPieceStr.toFloat()
                val lengthPiece = lengthPieceStr.toFloat()
                val lengthWidthPiece = lengthWidthPieceStr.toFloat()
                val lengthLengthPiece = lengthLengthPieceStr.toFloat()
                val widthCeiling = widthCeilingStr.toFloat()
                val lengthCeiling = lengthCeilingStr.toFloat()

                //Medidas da peça com teto
                val areaWallPiece =
                    (widthPiece * lengthPiece) + (lengthWidthPiece * lengthLengthPiece)
                val areaCeilingPiece = widthCeiling * lengthCeiling

                val areaTotal = areaWallPiece + areaCeilingPiece
                val intent = Intent(this, CalculateInk::class.java)
                intent.putExtra(KEY_RESULT_WALL_CEILING, areaTotal)


            } else {
                val widthPiece = widthPieceStr.toFloat()
                val lengthPiece = lengthPieceStr.toFloat()
                val lengthWidthPiece = lengthWidthPieceStr.toFloat()
                val lengthLengthPiece = lengthLengthPieceStr.toFloat()


                //Medidas da peça sem teto
                val areaWallPiece =
                    (widthPiece * lengthPiece) + (lengthWidthPiece * lengthLengthPiece)
                val intent = Intent(this, CalculateInk::class.java)
                intent.putExtra(KEY_RESULT_WALL, areaWallPiece)

            }
        }
    }
}