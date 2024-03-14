package com.fiap.imc

import androidx.compose.ui.graphics.Color
import kotlin.math.pow

fun calculateIMC(weight: Double, height: Double): Double{
    var imc = weight / (height / 100).pow(2)
    return imc
}

fun getStatusIMC(imc: Double): Pair<String, Long>{
     return when(imc){
        in 0.0 ..16.9 -> "Muito Abaixo do Peso" to 0xfff44336
        in 17.0..18.4 -> "Abaixo do Peso" to 0xfffbc02d
                 in 18.5..24.9 -> "Peso Ideal" to 0xff4caf50
        in 25.0..29.9 -> "Acima do Peso" to 0xffffeb3b
        in 30.0..34.9 -> "Obesidade Grau I" to 0xfff44336
        in 35.0..40.0 -> "Obesidade Grau II" to 0xffb71c1c
        else -> {
            "Obesidade Grau III" to 0xff000000
        }
    }
}
