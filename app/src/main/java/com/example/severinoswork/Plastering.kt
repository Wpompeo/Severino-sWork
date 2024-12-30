package com.example.severinoswork

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class Plastering : AppCompatActivity() {
    private var quantMassa: Double = 0.13

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plastering)

        val rButton15 = findViewById<RadioButton>(R.id.rb_1_5)
        val rButton20 = findViewById<RadioButton>(R.id.rb_2_0)
        val edtAreaPlastering = findViewById<TextInputEditText>(R.id.edt_area_reboco)
        val resultFinalPlastering = findViewById<TextView>(R.id.tv_result_plastering)
        val btnCalculatePlastering = findViewById<Button>(R.id.btn_calc_plastering)
        val btnFinishPlastering = findViewById<Button>(R.id.btn_finish_plastering)
        val btnRecalculatePlastering = findViewById<Button>(R.id.btn_recalculate_plastering)

        btnCalculatePlastering.setOnClickListener {
            val edtAreaPlasteringStr: String = edtAreaPlastering.text.toString()

            if (edtAreaPlasteringStr.isEmpty()) {
                Toast.makeText(
                    this, "Por favor, insira a área para reboco.",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            val areaPlastering = edtAreaPlasteringStr.toDoubleOrNull()
            if (areaPlastering == null) {
                Toast.makeText(
                    this, "Insira um valor númerico válido para a área.",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            val resultFinal = when {
                rButton15.isChecked -> (areaPlastering * 1.5 / 100) / quantMassa
                rButton20.isChecked -> (areaPlastering * 2.0 / 100) / quantMassa
                else -> {
                    Toast.makeText(
                        this, "Selecione uma opção de consumo de material.",
                        Toast.LENGTH_LONG
                    ).show()
                    return@setOnClickListener
                }
            }
            resultFinalPlastering.text =
                "Você precisará de : %.2f sacos de cimento".format(resultFinal)
        }

        btnFinishPlastering.setOnClickListener {
            Snackbar.make(btnFinishPlastering, "Finalizando o aplicativo...", Snackbar.LENGTH_SHORT)
                .show()
            btnFinishPlastering.postDelayed({
                finishAffinity()
            }, 200)
        }

        btnRecalculatePlastering.setOnClickListener {
            val intent = Intent(this, Plastering::class.java)
            startActivity(intent)
            resultFinalPlastering.text = ""
            Snackbar.make(btnRecalculatePlastering, "Refazer cálculo...", Snackbar.LENGTH_SHORT)
                .show()
            btnRecalculatePlastering.postDelayed({
                finishAffinity()
            }, 200)
        }
    }
}
