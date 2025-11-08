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
