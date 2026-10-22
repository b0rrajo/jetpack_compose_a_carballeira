package com.b0rrajo.ejercicio1kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.b0rrajo.ejercicio1kotlin.ui.theme.Ejercicio1kotlinTheme

class MainActivity3: ComponentActivity() {
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
            modifier = Modifier.fillMaxSize()
                .border(
                    width = 3.dp,
                    color = Color.DarkGray,
                ),
            verticalArrangement = Arrangement.Center,
        ){
            Column(modifier = modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color(199, 228, 206)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically)
            ){
                Row(modifier = modifier
                    .width(120.dp)
                    .height(120.dp)
                    .background(Color(138, 205, 164))
                    .border(
                        width = 3.dp,
                        color = Color(54, 97, 69),
                    ) // Borde

                ){
                }
                Row(modifier = modifier){
                    Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed", color = Color.Black, fontSize = 16.sp, modifier = Modifier.fillMaxWidth()
                        .padding(20.dp))
                }
            }
            Column(modifier = modifier
                .fillMaxWidth()
                .weight(1.7f)
                .background(Color(199, 228, 206)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically)
            ){
                Row(modifier = modifier){
                    Text(text = "\n" +
                            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam feugiat vel neque vitae fringilla. Morbi eu elit ac neque cursus suscipit id ut enim. Sed lacus quam, ultricies vitae metus vel, auctor rutrum nisi. In hac habitasse platea dictumst. Vestibulum at est ac est.", color = Color.Black, fontSize = 12.sp, modifier = Modifier.fillMaxWidth()
                        .padding())
                }
            }
            Column(modifier = modifier
                .fillMaxWidth()
                .weight(0.3f)
                .background(Color(199, 228, 206)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically)
            ){
                Row(modifier = modifier

                ){
                }
                Row(modifier = modifier){
                    Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed", color = Color.Black, fontSize = 12.sp)
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