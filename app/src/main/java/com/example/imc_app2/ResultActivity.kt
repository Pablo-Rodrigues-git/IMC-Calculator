package com.example.imc_app2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class Activity_main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()

    }

    private fun setListeners(){
        alturaEDT?.doAfterTextChanged { text ->
        }

        pesoEDT?.doOnTextChanged { text, _, _, _ ->
            // txtTitle?.text = text
        }

        CalcularBTN.setOnClickListener {
            calcularIMC(pesoEDT.text.toString(), alturaEDT.text.toString())
        }
    }

    @SuppressLint("SetTextI18n")
    private fun calcularIMC(peso:String, altura:String){
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        if(peso!=null && altura!=null){
            val imc = peso / (altura * altura)
            var classificacao:String=""

            when {
                imc in 1.0..18.5 -> {
                    classificacao = "🚨 MAGREZA"
                    tittleTXT.text = "$classificacao\n" +
                            "Atenção, seu nivel de IMC esta muito baixo"
                    tittleTXT.text = "Seu IMC é $imc%2f".format((imc))
                }
                imc in 18.6..24.9 -> {
                    classificacao = "👍 NORMAL"
                    tittleTXT.text =
                        "$classificacao\n😀 Parabens você esta no seu nivel ideal de IMC"
                    tittleTXT.text = "Seu IMC é de $imc%2f".format((imc))
                }
                imc in 25.0..29.9 -> {
                    classificacao = "⚠ SOBREPESO NIVEL 1"
                    tittleTXT.text =
                        "$classificacao\nAtenção, seu nivel de IMC esta levemente elevado"
                    tittleTXT.text = "Seu IMC é de $imc%2f".format((imc))
                }
                imc in 30.0..39.9 -> {
                    classificacao = "⚠ OBESIDADE NIVEL 2"
                    tittleTXT.text = "$classificacao\n" +
                            "Atenção, seu nivel de IMC esta acima do ideal"
                    tittleTXT.text = "Seu IMC é de $imc%2f".format((imc))
                }
                imc > 40.0 -> {
                    classificacao = "🚨 OBESIDADE GRAVE NIVEL 3"
                    tittleTXT.text =
                        "$classificacao\nMenos disso \uD83C\uDF54 \uD83C\uDF55 e mais disso \uD83D\uDEB4\u200D♂️\uD83C\uDFCB️\u200D♀"
                    tittleTXT.text = "Seu IMC é de $imc%2f".format((imc))
                }
            }
        }
    }
}