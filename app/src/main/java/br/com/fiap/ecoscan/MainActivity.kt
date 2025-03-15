package br.com.fiap.ecoscan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.fiap.ecoscan.ui.theme.EcoScanTheme
import br.com.fiap.ecoscan.view.DescarteScreen
import br.com.fiap.ecoscan.view.HomeScreen
import br.com.fiap.ecoscan.view.LoginScreen
import br.com.fiap.ecoscan.view.ResultadoScreen
import br.com.fiap.ecoscan.view.ScannerScreen
import br.com.fiap.ecoscan.view.WelcomeScreen
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EcoScanTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberAnimatedNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "welcome"
                    )
                    {
                        composable("welcome") { WelcomeScreen(navController) }
                        composable("login") { LoginScreen(navController) }
                        composable("home") { HomeScreen(navController) }
                        composable("scanner") { ScannerScreen(navController) }
                        composable("resultado") { ResultadoScreen(navController) }
                        composable("descarte") { DescarteScreen(navController) }

                    }
                }
            }
        }
    }
}




