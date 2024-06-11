package pe.edu.idat.evc1

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import java.util.Calendar

@Composable
fun VerificarDNI() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(top = 30.dp)
    ) {
        var yearOfBirth by rememberSaveable {
            mutableStateOf("")
        }
        var result by rememberSaveable {
            mutableStateOf("")
        }
        Column {
            Text(
                text = "Verificar necesidad de DNI",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            espacio(tamanio = 10)
            OutlinedTextField(
                value = yearOfBirth,
                onValueChange = { yearOfBirth = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese su año de nacimiento") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            espacio(tamanio = 10)
            Button(
                onClick = {
                    result = verificarDNI(yearOfBirth.toIntOrNull())
                },
                Modifier.fillMaxWidth()
            ) {
                Text(text = "Verificar")
            }
            espacio(tamanio = 10)
            Text(text = result)
        }
    }
}

fun verificarDNI(yearOfBirth: Int?): String {
    if (yearOfBirth == null) {
        return "Por favor, ingrese un año de nacimiento válido."
    }
    val currentYear = Calendar.getInstance().get(Calendar.YEAR)
    val age = currentYear - yearOfBirth
    return if (age >= 18) {
        "Debe sacar su DNI. Su edad es $age años."
    } else {
        "No necesita sacar su DNI. Su edad es $age años."
    }
}

