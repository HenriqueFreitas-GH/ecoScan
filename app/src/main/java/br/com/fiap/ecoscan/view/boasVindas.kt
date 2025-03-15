package br.com.fiap.ecoscan.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay


@Composable
fun WelcomeScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(3000) // Aguarda 3 segundos
        navController.navigate("login") {
            popUpTo("welcome") { inclusive = true }
        }// Remove Splash da pilha de navegação
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1540DE))
            .padding(16.dp)
            .padding(top = 74.dp),
        contentAlignment = Alignment.Center
    )
    {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            Text(
                "Bem-vindo ao EcoScan!",
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text("Escaneie produtos e descubra o quão sustentável eles são.",
                    color = Color.White
                )
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}
