package com.sena.micalculadora

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {

    private lateinit var etNum1: EditText
    private lateinit var etNum2: EditText
    private lateinit var spinnerOperation: Spinner
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNum1 = findViewById(R.id.etNum1)
        etNum2 = findViewById(R.id.etNum2)
        spinnerOperation = findViewById(R.id.spinnerOperation)
        btnCalculate = findViewById(R.id.btnCalculate)
        tvResult = findViewById(R.id.tvResult)

        val operations = arrayOf("+ Suma", "- Resta", "* Multiplicasion", "/ Division")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, operations)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerOperation.adapter = adapter

        btnCalculate.setOnClickListener {
            calculate()
        }
    }

    private fun calculate() {
        val num1 = etNum1.text.toString().toDouble()
        val num2 = etNum2.text.toString().toDouble()
        val operation = spinnerOperation.selectedItem.toString()

        val result = when (operation) {
            "+ Suma" -> num1 + num2
            "- Resta" -> num1 - num2
            "* Multiplicasion" -> num1 * num2
            "/ Division" -> if (num2 != 0.0) num1 / num2 else Double.NaN
            else -> Double.NaN
        }

        tvResult.text = "Resultado: $result"
    }
}