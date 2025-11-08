package com.example.pertemuan6tugas.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pertemuan6tugas.model.Peserta
import com.example.pertemuan6tugas.ui.theme.Pertemuan6TugasTheme

@Composable
fun FormulirScreen(
    onSubmit: (Peserta) -> Unit,
    onBack: () -> Unit
) {
    // 🔹 PERBAIKAN: Buat 4 state untuk 4 data
    var nama by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()), // Agar bisa di-scroll
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Formulir Pendaftaran", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(24.dp))

        // 🔹 Field 1: Nama
        OutlinedTextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Nama Peserta") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))

        // 🔹 Field 2: Gender (BARU)
        OutlinedTextField(
            value = gender,
            onValueChange = { gender = it },
            label = { Text("Gender (Laki-laki/Perempuan)") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))

        // 🔹 Field 3: Status (BARU)
        OutlinedTextField(
            value = status,
            onValueChange = { status = it },
            label = { Text("Status (Kawin/Lajang/dll)") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))

        // 🔹 Field 4: Alamat (BARU)
        OutlinedTextField(
            value = alamat,
            onValueChange = { alamat = it },
            label = { Text("Alamat (Contoh: Bantul)") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = onBack) {
                Text("Batal")
            }
            Button(onClick = {
                // 🔹 PERBAIKAN: Cek ke-4 field
                if (nama.isNotBlank() && gender.isNotBlank() && status.isNotBlank() && alamat.isNotBlank()) {
                    // 🔹 PERBAIKAN: Kirim 4 data saat submit
                    onSubmit(Peserta(nama, gender, status, alamat))
                }
            }) {
                Text("Submit")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormulirScreenPreview() {
    Pertemuan6TugasTheme {
        FormulirScreen(onSubmit = {}, onBack = {})
    }
}