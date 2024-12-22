package com.example.severinoswork

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.severinoswork.databinding.ActivityCalculateInkBinding


const val KEY_RESULT_WALL_CEILING = "WALL_CEILING"
const val KEY_RESULT_WALL = "WALL"

class CalculateInk : AppCompatActivity() {

    private lateinit var binding: ActivityCalculateInkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculateInkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var inkSize: Int = 0

        binding.rbInk09.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                inkSize = 17
            }
        }
        binding.rbInk36.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                inkSize = 62
            }
        }
        binding.rbInk18.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                inkSize = 500
            }
        }
        binding.rbInk20.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                inkSize = 555
            }
        }

        binding.btnCalcInk.setOnClickListener {
            val resultWallCeiling = intent.getFloatExtra(KEY_RESULT_WALL_CEILING, 0f)
            val resultWall = intent.getFloatExtra(KEY_RESULT_WALL, 0f)
            val resultFinal = findViewById<TextView>(R.id.tv_calc_final)

            if (resultWallCeiling > 0) {

                val paintYieldCeiling = inkSize / 2
                val finalWall = resultWallCeiling / paintYieldCeiling
                val resultFinalFormat = "%.2f Latas de tinta".format(finalWall) + " para pintar $resultWallCeiling m² com duas de mãos. "
                resultFinal.text = "Você precisará de $resultFinalFormat"

            } else {
                val paintYield = inkSize / 2
                val finalWall = resultWall / paintYield
                val resultFinalFormat = "%.2f Latas de tinta".format(finalWall) + " para pintar $resultWall m² com duas de mãos."

                resultFinal.text = "Você precisará de $resultFinalFormat"

            }
        }
        binding.btnFinishInk.setOnClickListener {
            Toast.makeText(
                this, "Finalizando aplicativo",
                Toast.LENGTH_LONG
            ).show()
            binding.btnFinishInk.postDelayed({
                finishAffinity()
            }, 200)
        }
    }
}