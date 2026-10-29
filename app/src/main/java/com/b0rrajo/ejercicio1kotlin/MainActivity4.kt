package com.b0rrajo.ejercicio1kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.b0rrajo.ejercicio1kotlin.ui.theme.Ejercicio1kotlinTheme

class MainActivity4: ComponentActivity() {
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
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
        ){
            Box(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
                    .height(180.dp)
                    .shadow(elevation = 3.dp, shape = RoundedCornerShape(20.dp))
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White)
            ){
                Column(
                    modifier = Modifier.fillMaxSize()
                        .padding(10.dp),
                    verticalArrangement = Arrangement.Center,
                ){
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.25f)
                    ){
                        Text(text = "Historias", color = Color.Black, fontSize = 24.sp,  modifier = Modifier.fillMaxWidth()
                            .padding(horizontal = 6.dp, vertical = 8.dp))
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.5f)
                    ){
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 5.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                contentDescription = "Icono de la aplicación", // Obligatorio por accesibilidad
                                modifier = Modifier
                                    .padding(horizontal = 10.dp)
                                    .size(60.dp)
                                    .clip(CircleShape)
                                    .background(Color(230,128,180))// Tamaño fijo tanto de ancho como de alto
                            )
                            Image(
                                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                contentDescription = "Icono de la aplicación", // Obligatorio por accesibilidad
                                modifier = Modifier
                                    .padding(horizontal = 10.dp)
                                    .size(60.dp)
                                    .clip(CircleShape)
                                    .background(Color(255,128,25))// Tamaño fijo tanto de ancho como de alto
                            )
                            Image(
                                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                contentDescription = "Icono de la aplicación", // Obligatorio por accesibilidad
                                modifier = Modifier
                                    .padding(horizontal = 10.dp)
                                    .size(60.dp)
                                    .clip(CircleShape)
                                    .background(Color(121,230,180))// Tamaño fijo tanto de ancho como de alto
                            )
                            Image(
                                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                contentDescription = "Icono de la aplicación", // Obligatorio por accesibilidad
                                modifier = Modifier
                                    .padding(horizontal = 10.dp)
                                    .size(60.dp)
                                    .clip(CircleShape)
                                    .background(Color(121,128,230))// Tamaño fijo tanto de ancho como de alto
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.25f)
                    ){
                        Row(modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 5.dp, vertical = 5.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(text = "Ana", color = Color.Black, fontSize = 12.sp, modifier = Modifier.padding(horizontal = 10.dp).size(60.dp), textAlign = TextAlign.Center)
                            Text(text = "Carlos", color = Color.Black, fontSize = 12.sp, modifier = Modifier.padding(horizontal = 10.dp).size(60.dp), textAlign = TextAlign.Center)
                            Text(text = "David", color = Color.Black, fontSize = 12.sp, modifier = Modifier.padding(horizontal = 10.dp).size(60.dp), textAlign = TextAlign.Center)
                            Text(text = "Laura", color = Color.Black, fontSize = 12.sp, modifier = Modifier.padding(horizontal = 10.dp).size(60.dp), textAlign = TextAlign.Center)
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