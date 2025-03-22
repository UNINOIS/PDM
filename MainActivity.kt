package com.example.guizin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alturaEditText = findViewById<EditText>(R.id.editTextNumberDecimal)
        val pesoEditText = findViewById<EditText>(R.id.editTextNumberDecimal)
        val calcularButton = findViewById<Button>(R.id.buttonCalcular)
        val resultadoTextView = findViewById<TextView>(R.id.textView)

        calcularButton.setOnClickListener {
            val altura = alturaEditText.text.toString().toFloatOrNull()
            val peso = pesoEditText.text.toString().toFloatOrNull()

            if (altura != null && peso != null && altura > 0) {
                val imc = peso / (altura * altura)
                var classificacao = ""

                if (imc < 18.5) {
                    classificacao = "Abaixo do peso"
                } else if (imc < 24.9) {
                    classificacao = "Peso normal"
                } else if (imc < 29.9) {
                    classificacao = "Sobrepeso"
                } else if (imc < 34.9) {
                    classificacao = "Obesidade grau 1"
                } else if (imc < 39.9) {
                    classificacao = "Obesidade grau 2"
                } else {
                    classificacao = "Obesidade grau 3"
                }

                resultadoTextView.text = "IMC: %.2f\n%s".format(imc, classificacao)
            } else {
                resultadoTextView.text = "Por favor, insira valores válidos."
            }
        }
    }
}