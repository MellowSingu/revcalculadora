package br.com.inova7.revcalculadora.datasource

import androidx.compose.ui.text.font.FontWeight

object Calculations {
    fun calculateIMC (
        height: String,
        weight: String,
        response:(result: String,isError: Boolean) -> Unit
    ) {
        if (height.isNotEmpty() && weight.isNotEmpty()) {
            val weightFormatted = weight.replace(",",".").toDoubleOrNull()
            val heightFormatted = height.toDoubleOrNull()

                if (weightFormatted!=null && heightFormatted!=null){

                    val imc = weightFormatted / ((heightFormatted/100) * (heightFormatted/100))

                    val imcFormatted = String.format("%.2f",imc)

                        when {
                            imc < 18.5 -> response("IMC: $imcFormatted\nAbaixo do Peso",false)
                            imc in 18.5..24.9 -> response("IMC: $imcFormatted\nPeso normal",false)
                            imc in 25.0..29.9 -> response("IMC: $imcFormatted\nSobrepeso",false)
                            imc in 30.0..34.9 -> response("IMC: $imcFormatted\nObsidade Grau 1",false)
                            imc in 35.0..39.9 -> response("IMC: $imcFormatted\nObsidade Grau 2",false)
                            else -> response("IMC: $imcFormatted\nObsidade Grau 3",false)
                        }


                } else {
                    response("Preencha todos os campos",true)
                }

        }

    }
}