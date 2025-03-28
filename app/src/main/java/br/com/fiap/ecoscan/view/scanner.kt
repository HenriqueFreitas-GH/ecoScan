package br.com.fiap.ecoscan.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.ecoscan.R

@Composable
fun ScannerScreen(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text = "scanner",
            modifier = Modifier.offset(y = -200.dp))
        IconButton(
            onClick = {navController.navigate("home")},
            modifier = Modifier.align(Alignment.TopStart)
                .padding(top = 18.dp))
            {
            Icon(
                painter = painterResource(id = R.drawable.seta),
                contentDescription = ""
            )
        }

        Button(onClick = {navController.navigate("resultado")})
        {
            Text(text = "Resultado")
        }
    }
}