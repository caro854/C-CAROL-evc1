package pe.edu.idat.evc1

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment

@Composable
fun Estacionamiento() {
    var horas by rememberSaveable { mutableStateOf("") }
    var minutos by rememberSaveable { mutableStateOf("") }
    var totalPagar by remember { mutableStateOf(0.0) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Calculadora de Costo de Estacionamiento")

            espacio(16)

            OutlinedTextField(
                value = horas,
                onValueChange = { horas = it },
                label = { Text("Horas estacionadas") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            espacio(8)

            OutlinedTextField(
                value = minutos,
                onValueChange = { minutos = it },
                label = { Text("Minutos adicionales estacionados") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            espacio(16)

            Button(onClick = {
                totalPagar = calcularCostoEstacionamiento(horas.toIntOrNull() ?: 0, minutos.toIntOrNull() ?: 0)
            }) {
                Text(text = "Calcular costo")
            }

            espacio(16)

            Text(text = "Total a pagar: S/. $totalPagar")
        }
    }
}

@Composable
fun espacio(tamanio: Int) {
    Spacer(modifier = Modifier.height(tamanio.dp))
}

fun calcularCostoEstacionamiento(horas: Int, minutos: Int): Double {
    val tiempoTotalHoras = horas + (minutos / 60.0)
    val costoPorHora = 1500.0
    return tiempoTotalHoras * costoPorHora
}

