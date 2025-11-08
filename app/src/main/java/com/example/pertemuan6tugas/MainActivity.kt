package com.example.pertemuan6tugas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pertemuan6tugas.models.PesertaViewModel
import com.example.pertemuan6tugas.view.FormulirScreen
import com.example.pertemuan6tugas.view.ListDataScreen
import com.example.pertemuan6tugas.view.WelcomeScreen
import com.example.pertemuan6tugas.ui.theme.Pertemuan6TugasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pertemuan6TugasTheme {
                val viewModel: PesertaViewModel = viewModel()
                var currentScreen by remember { mutableStateOf("welcome") }
                val pesertaList = viewModel.pesertaList

                when (currentScreen) {
                    "welcome" -> WelcomeScreen(
                        onNavigateToForm = { currentScreen = "form" }
                    )

                    "form" -> FormulirScreen(
                        onSubmit = { peserta ->
                            viewModel.tambahPeserta(peserta)
                            currentScreen = "list"
                        },
                        onBack = {
                            currentScreen = if (pesertaList.isEmpty()) "welcome" else "list"
                        }
                    )

                    "list" -> ListDataScreen(
                        pesertaList = pesertaList,
                        onFormClick = { currentScreen = "form" },
                        // 🔹 5. INI PERUBAHANNYA: Tambahkan logika untuk kembali ke Beranda
                        onBackClick = { currentScreen = "welcome" }
                    )
                }
            }
        }
    }
}