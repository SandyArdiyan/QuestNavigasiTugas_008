package com.example.pertemuan6tugas.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pertemuan6tugas.model.Peserta
import com.example.pertemuan6tugas.viewmodel.PesertaViewModel

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormulirScreen(
    viewModel: PesertaViewModel,
    onNavigateBack: () -> Unit
) {
    var nama by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var statusPerkawinan by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    var expanded by remember { mutableStateOf(false) }
    val statusList = listOf("Lajang", "Kawin", "Cerai")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Formulir Pendaftaran") },
                colors = TopAppBarDefaults.topAppBarColors( // <-- SEKARANG SUDAH AMAN
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            OutlinedTextField(
                value = nama,
                onValueChange = { nama = it },
                label = { Text("Nama Lengkap") },
                modifier = Modifier.fillMaxWidth()
            )

            Column {
                Text("Jenis Kelamin", style = MaterialTheme.typography.bodyLarge)
                Row(Modifier.fillMaxWidth()) {
                    RadioOption(
                        text = "Laki-Laki",
                        selected = jenisKelamin == "Laki-Laki",
                        onClick = { jenisKelamin = "Laki-Laki" }
                    )
                    RadioOption(
                        text = "Perempuan",
                        selected = jenisKelamin == "Perempuan",
                        onClick = { jenisKelamin = "Perempuan" }
                    )
                }
            }

            // Dropdown untuk Status Perkawinan
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                OutlinedTextField(
                    value = statusPerkawinan,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Status Perkawinan") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor()
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    statusList.forEach { status ->
                        DropdownMenuItem(
                            text = { Text(status) },
                            onClick = {
                                statusPerkawinan = status
                                expanded = false
                            }
                        )
                    }
                }
            }

            OutlinedTextField(
                value = alamat,
                onValueChange = { alamat = it },
                label = { Text("Alamat") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Tombol Submit
            Button(
                onClick = {
                    // Buat objek Peserta baru
                    val pesertaBaru = Peserta(
                        nama = nama,
                        jenisKelamin = jenisKelamin,
                        statusPerkawinan = statusPerkawinan,
                        alamat = alamat
                    )
                    // Tambahkan ke ViewModel
                    viewModel.tambahPeserta(pesertaBaru)

                    // Kembali ke layar sebelumnya
                    onNavigateBack()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("SUBMIT DATA")
            }
        }
    }
}

// Helper Composable untuk Radio Button
@Composable
fun RowScope.RadioOption(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        Modifier
            .selectable(
                selected = selected,
                onClick = onClick
            )
            .padding(end = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick
        )
        Text(text)
    }
}