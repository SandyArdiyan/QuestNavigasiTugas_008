package com.example.pertemuan6tugas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel // <-- PENTING
import androidx.navigation.compose.NavHost            // <-- PENTING
import androidx.navigation.compose.composable      // <-- PENTING
import androidx.navigation.compose.rememberNavController // <-- PENTING
import com.example.pertemuan6tugas.ui.theme.Pertemuan6TugasTheme // <-- Pastikan nama Tema ini benar
import com.example.pertemuan6tugas.view.FormulirScreen
import com.example.pertemuan6tugas.view.ListDataScreen
import com.example.pertemuan6tugas.view.WelcomeScreen
import com.example.pertemuan6tugas.viewmodel.PesertaViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Ganti "Pertemuan6TugasTheme" dengan nama tema di proyek Anda
            // (Nama ini ada di file ui/theme/Theme.kt)
            Pertemuan6TugasTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PesertaApp()
                }
            }
        }
    }
}

@Composable
fun PesertaApp() {
    // NavHost & ViewModel adalah cara yang benar untuk
    // mengatur layar dan data di Compose

    val navController = rememberNavController()
    val viewModel: PesertaViewModel = viewModel() // <-- Data dipegang di sini

    NavHost(navController = navController, startDestination = "welcome") {

        composable("welcome") {
            WelcomeScreen(
                onNavigateToList = { navController.navigate("listdata") }
            )
        }

        composable("listdata") {
            ListDataScreen(
                viewModel = viewModel, // Berikan ViewModel
                onFormClick = { navController.navigate("form") },
                onHomeClick = { navController.navigate("welcome") }
            )
        }

        composable("form") {
            FormulirScreen(
                viewModel = viewModel, // Berikan ViewModel
                onNavigateBack = { navController.popBackStack() } // Aksi untuk kembali
            )
        }
    }
}