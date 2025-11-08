package com.example.pertemuan6tugas.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
// 🔹 1. IMPORT ICON BARU UNTUK TOMBOL KEMBALI
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pertemuan6tugas.model.Peserta
import com.example.pertemuan6tugas.ui.theme.Pertemuan6TugasTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListDataScreen(
    pesertaList: List<Peserta>,
    onFormClick: () -> Unit,
    onBackClick: () -> Unit // 🔹 2. TAMBAHKAN PARAMETER BARU INI
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Daftar Peserta") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                // 🔹 3. TAMBAHKAN TOMBOL KEMBALI (NAVIGATION ICON)
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Kembali ke Beranda"
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onFormClick) {
                Icon(Icons.Default.Add, contentDescription = "Tambah Peserta")
            }
        }
    ) { paddingValues ->
        if (pesertaList.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("Belum ada data peserta.")
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(pesertaList) { peserta ->
                    PesertaCard(peserta = peserta)
                }
            }
        }
    }
}

@Composable
fun PesertaCard(peserta: Peserta) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = peserta.nama,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Gender: ${peserta.gender}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Status: ${peserta.status}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Alamat: ${peserta.alamat}",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListDataScreenPreview() {
    Pertemuan6TugasTheme {
        val dummyList = listOf(
            Peserta(
                nama = "Pascal Pahlevi Pasha",
                gender = "Laki-laki",
                status = "Lajang",
                alamat = "Bantul"
            )
        )
        ListDataScreen(
            pesertaList = dummyList,
            onFormClick = {},
            onBackClick = {} // 🔹 4. TAMBAHKAN INI DI PREVIEW
        )
    }
}