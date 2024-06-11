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
fun PromedioNotas() {
    var nota1 by rememberSaveable { mutableStateOf("") }
    var nota2 by rememberSaveable { mutableStateOf("") }
    var nota3 by rememberSaveable { mutableStateOf("") }
    var nota4 by rememberSaveable { mutableStateOf("") }
    var promedio by remember { mutableStateOf(0.0) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Calculadora de Promedio de Notas")

            espacio(16)

            OutlinedTextField(
                value = nota1,
                onValueChange = { nota1 = it },
                label = { Text("Nota 1") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            espacio(8)

            OutlinedTextField(
                value = nota2,
                onValueChange = { nota2 = it },
                label = { Text("Nota 2") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            espacio(8)

            OutlinedTextField(
                value = nota3,
                onValueChange = { nota3 = it },
                label = { Text("Nota 3") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            espacio(8)

            OutlinedTextField(
                value = nota4,
                onValueChange = { nota4 = it },
                label = { Text("Nota 4") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            espacio(16)

            Button(onClick = {
                val notas = listOfNotNull(
                    nota1.toDoubleOrNull(),
                    nota2.toDoubleOrNull(),
                    nota3.toDoubleOrNull(),
                    nota4.toDoubleOrNull()
                )

                if (notas.size == 4) {
                    promedio = calcularPromedioNotas(notas)
                } else {
                    promedio = 0.0
                }
            }) {
                Text(text = "Calcular promedio")
            }

            espacio(16)

            Text(text = "Promedio: $promedio")
        }
    }
}



fun calcularPromedioNotas(notas: List<Double>): Double {
    val notasOrdenadas = notas.sorted()
    val mejoresTresNotas = notasOrdenadas.drop(1) // Elimina la nota más baja
    return mejoresTresNotas[0] * 0.2 + mejoresTresNotas[1] * 0.3 + mejoresTresNotas[2] * 0.5
}