package com.b0rrajo.ejercicio1kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.b0rrajo.ejercicio1kotlin.ui.theme.Ejercicio1kotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejercicio1kotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Bandera(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }

    @Composable
    fun Bandera(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier.fillMaxSize()){
            Box(
                modifier = Modifier
                    .fillMaxWidth() // Ocupa todo el ancho de la pantalla
                    .weight(1f)
                    .padding(16.dp) // Margen externo alrededor de la tarjeta
                    .clip(RoundedCornerShape(20.dp)) // Bordes redondeados
                    .background(Color.Red), // Color de fondo
                contentAlignment = Alignment.Center
            ) {
                Text(text = "<header>")
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth() // Ocupa todo el ancho de la pantalla
                    .weight(1f)
                    .padding(16.dp) // Margen externo alrededor de la tarjeta
                    .clip(RoundedCornerShape(20.dp)) // Bordes redondeados
                    .background(Color.Red), // Color de fondo
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Hola que tal?")
            }

            Box(
                modifier = Modifier
                    .width(210.dp)
                    .weight(5f)
                    .padding(16.dp) // Margen externo alrededor de la tarjeta
                    .clip(RoundedCornerShape(20.dp)) // Bordes redondeados
                    .background(Color.Red), // Color de fondo
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Hola que tal?")
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth() // Ocupa todo el ancho de la pantalla
                    .weight(1f)
                    .padding(16.dp) // Margen externo alrededor de la tarjeta
                    .clip(RoundedCornerShape(20.dp)) // Bordes redondeados
                    .background(Color.Red), // Color de fondo
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Hola que tal?")
            }
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun BanderaPreview() {
        BanderaKTheme {
            Bandera()
        }
    }

    @Composable
    fun BanderaKTheme(content: @Composable () -> Unit) {
        Ejercicio1kotlinTheme(content = content)
    }

}