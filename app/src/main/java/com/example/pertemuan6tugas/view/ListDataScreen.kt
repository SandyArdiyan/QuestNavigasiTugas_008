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

    }