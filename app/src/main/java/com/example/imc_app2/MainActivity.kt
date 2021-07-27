package com.example.imc_app2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        alturaEDT?.doAfterTextChanged { text ->
            //Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT).show()
        }

        pesoEDT?.doOnTextChanged { text, _, _, _ ->
            tittleTXT.text = text
        }
        CalcularBTN?.setOnClickListener {
            calcularIMC(pesoEDT.text.toString(), alturaEDT.text.toString())

        }
    }

    private fun calcularIMC(peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        if (peso != null && altura != null) {
            val imc = peso / (altura * altura)
            val result = String.format("Seu IMC é: %.2f", imc)
            tittleTXT.text = result
        }

    }

}
