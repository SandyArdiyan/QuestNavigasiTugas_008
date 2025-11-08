package com.example.pertemuan6tugas.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pertemuan6tugas.model.Peserta
import com.example.pertemuan6tugas.viewmodel.PesertaViewModel
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults

@OptIn(ExperimentalMaterial3Api::class) @Composable
fun ListDataScreen(
    viewModel: PesertaViewModel,
    onFormClick: () -> Unit,
    onHomeClick: () -> Unit
) {
    val pesertaList = viewModel.pesertaList

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("List Daftar Peserta") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(onClick = onHomeClick) {
                        Text("Beranda")
                    }
                    Button(onClick = onFormClick) {
                        Text("Formulir")
                    }
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding) // Terapkan padding dari Scaffold
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            // Gunakan 'items' untuk menampilkan data dari pesertaList
            items(pesertaList) { peserta ->
                PesertaCard(peserta = peserta)
            }
        }
    }
}

// Composable terpisah untuk satu kartu peserta (sesuai desain di gambar)
@Composable
fun PesertaCard(peserta: Peserta) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Kolom Kiri
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                InfoLabel("NAMA LENGKAP", peserta.nama)
                InfoLabel("STATUS PERKAWINAN", peserta.statusPerkawinan)
            }
            // Kolom Kanan
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                InfoLabel("JENIS KELAMIN", peserta.jenisKelamin)
                InfoLabel("ALAMAT", peserta.alamat)
            }
        }
    }
}

@Composable
fun InfoLabel(label: String, value: String) {
    Column {
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
    }
}