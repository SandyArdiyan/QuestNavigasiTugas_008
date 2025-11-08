package com.example.pertemuan6tugas.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pertemuan6tugas.R // Pastikan ini mengarah ke file R Anda
import com.example.pertemuan6tugas.ui.theme.Pertemuan6TugasTheme

@Composable
fun WelcomeScreen(onNavigateToForm: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround // Menata elemen agar tersebar
    ) {
        // Teks "Selamat Datang"
        Text(
            text = "Selamat Datang",
            fontSize = 24.sp,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(top = 64.dp)
        )

        // Logo baru
        Image(
            painter = painterResource(id = R.drawable.logo_cardlst), // Menggunakan logo_cardlst Anda
            contentDescription = "Logo Card-LST Mobile App",
            modifier = Modifier
                .size(200.dp) // Sesuaikan ukuran sesuai kebutuhan
                .padding(vertical = 32.dp)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(bottom = 32.dp)
        ) {
            Text(text = "Sandy Ardiyan", fontSize = 16.sp)
            Text(text = "20230140008", fontSize = 14.sp)
        }


        Button(
            onClick = onNavigateToForm,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 32.dp)
        ) {
            Text(text = "Masuk", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(64.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    Pertemuan6TugasTheme {
        WelcomeScreen(onNavigateToForm = {})
    }
}