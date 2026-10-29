package com.b0rrajo.ejercicio1kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.b0rrajo.ejercicio1kotlin.ui.theme.Ejercicio1kotlinTheme

class MainActivity6 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejercicio1kotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CalculadoraScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CalculadoraScreen(modifier: Modifier = Modifier) {
    var displayValue by remember { mutableStateOf("00") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF8FAFC)) // Light background for screen
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Calculadora(
            displayValue = displayValue,
            onButtonClick = { symbol ->
                when (symbol) {
                    "=" -> {
                        // Keep display or reset for demo
                    }
                    else -> {
                        if (displayValue == "00") {
                            displayValue = symbol
                        } else {
                            displayValue += symbol
                        }
                    }
                }
            }
        )
    }
}

@Composable
fun Calculadora(
    displayValue: String,
    onButtonClick: (String) -> Unit
) {
    val bodyOrange = Color(0xFFFA9E1B)
    val bodyBorder = Color(0xFF6B3300)
    val buttonBg = Color(0xFFFEF2D1)
    val displayBg = Color(0xFFC5EFFF)
    val displayBorder = Color(0xFF284D6B)
    val solarBg = Color(0xFF5A5046)
    val solarBorder = Color(0xFF3D352E)

    // Main Calculator Outer Container
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(32.dp))
            .background(bodyOrange)
            .border(4.dp, bodyBorder, RoundedCornerShape(32.dp))
            .padding(18.dp)
    ) {
        // Glossy White Highlight overlay
        Canvas(modifier = Modifier.matchParentSize()) {
            // Top-left curved white reflection
            drawRoundRect(
                color = Color.White.copy(alpha = 0.5f),
                topLeft = Offset(12f, 12f),
                size = Size(18f, size.height * 0.35f),
                cornerRadius = CornerRadius(10f, 10f)
            )
            // Bottom-right curved white reflection
            drawRoundRect(
                color = Color.White.copy(alpha = 0.5f),
                topLeft = Offset(size.width - 26f, size.height * 0.7f),
                size = Size(14f, size.height * 0.22f),
                cornerRadius = CornerRadius(8f, 8f)
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Solar Panel (Top Right)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Box(
                    modifier = Modifier
                        .width(110.dp)
                        .height(32.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(solarBg)
                        .border(2.5.dp, solarBorder, RoundedCornerShape(8.dp))
                ) {
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        val cellCount = 6
                        val cellWidth = size.width / cellCount
                        for (i in 1 until cellCount) {
                            drawLine(
                                color = solarBorder,
                                start = Offset(i * cellWidth, 0f),
                                end = Offset(i * cellWidth, size.height),
                                strokeWidth = 3f
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // LCD Display Screen
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(displayBg)
                    .border(3.dp, displayBorder, RoundedCornerShape(8.dp))
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Text(
                    text = displayValue,
                    fontSize = 36.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF33424E),
                    textAlign = TextAlign.End
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Keypad Buttons Grid (4x4)
            val buttons = listOf(
                listOf("7", "8", "9", "÷"),
                listOf("4", "5", "6", "x"),
                listOf("1", "2", "3", "-"),
                listOf("0", ".", "=", "+")
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                for (row in buttons) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        for (symbol in row) {
                            CalculadoraBoton(
                                symbol = symbol,
                                buttonBg = buttonBg,
                                bodyBorder = bodyBorder,
                                onClick = { onButtonClick(symbol) },
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CalculadoraBoton(
    symbol: String,
    buttonBg: Color,
    bodyBorder: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .aspectRatio(1.05f)
            .clip(RoundedCornerShape(12.dp))
            .background(buttonBg)
            .border(3.dp, bodyBorder, RoundedCornerShape(12.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = symbol,
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold,
            color = bodyBorder,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CalculadoraPreview() {
    Ejercicio1kotlinTheme {
        CalculadoraScreen()
    }
}
