package com.example.severinoswork

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class Floor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_floor)

        val edtPieceWidth = findViewById<TextInputEditText>(R.id.edt_piece_width)
        edtPieceWidth.text?.clear()
        val edtPieceLength = findViewById<TextInputEditText>(R.id.edt_piece_length)
        val edtFloorWidth = findViewById<TextInputEditText>(R.id.edt_floor_width)
        val edtFloorLength = findViewById<TextInputEditText>(R.id.edt_floor_length)
        val floorTotal = findViewById<TextView>(R.id.textResult)
        val btnRecalculateFloor = findViewById<Button>(R.id.btn_recalculate_floor)
        val btnFinishFloor = findViewById<Button>(R.id.btn_finish_floor)
        val btnCalculateFloor = findViewById<Button>(R.id.btn_calculate_floor)

        btnCalculateFloor.setOnClickListener {

            val pieceWidthStr: String = edtPieceWidth.text.toString()
            val pieceLengthStr: String = edtPieceLength.text.toString()
            val floorWidthStr: String = edtFloorWidth.text.toString()
            val floorLengthStr: String = edtFloorLength.text.toString()


            if (pieceWidthStr == "" || pieceLengthStr == "" || floorWidthStr == "" || floorLengthStr == "") {
                Snackbar.make(
                    edtPieceWidth,
                    "Favor preencher todos os campos!",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {

                val pieceWidth = pieceWidthStr.toFloat()
                val pieceLength = pieceLengthStr.toFloat()
                val floorWidth = floorWidthStr.toFloat()
                val floorLength = floorLengthStr.toFloat()

                //calcula qauntidade necessária de piso
                val pieceMeters = pieceWidth * pieceLength
                val floorMeters = (floorWidth * floorLength) / 10000
                val floorQuantity = pieceMeters / floorMeters
                val reserve = floorQuantity * 0.10
                val totalFloor = floorQuantity + reserve
                val squareMeters = totalFloor * floorMeters
                val squareMetersFormat = ("%.2f".format(squareMeters))
                val totalFloorFormat = (" Você vai precisar de %.2f" +
                        "").format(totalFloor) + " unidades de pisos ou $squareMetersFormat m²"
                floorTotal.text = totalFloorFormat
            }
        }
        btnRecalculateFloor.setOnClickListener {
            val intent = Intent(this, Floor::class.java)
            startActivity(intent)
            floorTotal.text = ""
            Snackbar.make(btnRecalculateFloor, "Refazer cálculo...", Snackbar.LENGTH_SHORT).show()
            btnRecalculateFloor.postDelayed({
                finishAffinity()
            }, 200)
        }

        btnFinishFloor.setOnClickListener {
            Snackbar.make(btnFinishFloor, "Finalizando o aplicativo...", Snackbar.LENGTH_SHORT)
                .show()
            btnFinishFloor.postDelayed({
                finishAffinity()
            }, 200)
        }
    }
}