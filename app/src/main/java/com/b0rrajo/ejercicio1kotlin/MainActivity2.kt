package com.b0rrajo.ejercicio1kotlin

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.b0rrajo.ejercicio1kotlin.ui.theme.Ejercicio1kotlinTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejercicio1kotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Tarjeta(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }

    @Composable
    fun Tarjeta(modifier: Modifier = Modifier) {
        val contexto = LocalContext.current

        // Un Box con un Column dentro para que funcione weight
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
        ){
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    
                    .padding(16.dp) // Margen externo
                    .clip(RoundedCornerShape(20.dp)) // Bordes redondeados
                    .border(
                        width = 3.dp,
                        color = Color.DarkGray,
                        shape = RoundedCornerShape(20.dp)
                    ) // Borde
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    // Mitad superior (50% de la altura)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .background(Color.White)
                            .padding(horizontal = 16.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .padding(start = 16.dp),
                            horizontalAlignment = Alignment.End,
                            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically)
                        ) {
                            Box(
                                modifier = Modifier
                                    .width(20.dp)
                                    .height(20.dp)
                                    .background(Color(101, 178, 110))
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(2f)
                            .background(Color.White)
                            .padding(horizontal = 16.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Círculo
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_foreground),
                            contentDescription = "Icono de la aplicación", // Obligatorio por accesibilidad
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)

                                .background(Color(121,128,180))// Tamaño fijo tanto de ancho como de alto
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .padding(start = 16.dp),
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically)
                        ) {
                            Box(
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(30.dp)
                                    .background(Color.DarkGray)
                                    .padding(horizontal = 6.dp, vertical = 4.dp)
                            ){
                                Text(text = "Daniel Borrajo", color = Color.White, fontSize = 12.sp)
                            }
                            Box(
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(30.dp)
                                    .background(Color.DarkGray)
                                    .padding(horizontal = 6.dp, vertical = 4.dp)
                            ){
                                Text(text = "Alumno DAM DUAL", color = Color.White, fontSize = 12.sp)
                            }
                        }
                    }

                    // Mitad inferior (50% de la altura)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1.2f)
                            .background(Color.Gray)
                            .padding(horizontal = 16.dp, vertical = 6.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = {
                                Toast.makeText(contexto, "¡Botón pulsado!", Toast.LENGTH_SHORT).show()
                            },
                            modifier = Modifier.height(36.dp),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
                        ) {
                            Text(text = "Púlsame", color = Color.White, fontSize = 12.sp)
                        }
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun BanderaPreview() {
        TarjetaKTheme {
            Tarjeta()
        }
    }

    @Composable
    fun TarjetaKTheme(content: @Composable () -> Unit) {
        Ejercicio1kotlinTheme(content = content)
    }
}
