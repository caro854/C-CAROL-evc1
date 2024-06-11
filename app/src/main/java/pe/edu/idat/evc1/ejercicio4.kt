package pe.edu.idat.evc1

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun NumerosPares() {
    val numerosPares = (10..20).filter { it % 2 == 0 }.sortedDescending()

    Box(
        Modifier
            .fillMaxSize()
            .padding(top = 30.dp)
    ) {
        Column {
            Text(
                text = "Números Pares entre 20 y 10",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
            numerosPares.forEach { numero ->
                Text(
                    text = numero.toString(),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(5.dp))
            }
        }
    }
}