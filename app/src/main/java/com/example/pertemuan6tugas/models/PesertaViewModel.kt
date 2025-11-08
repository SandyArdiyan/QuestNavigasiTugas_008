package com.example.pertemuan6tugas.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.pertemuan6tugas.model.Peserta

class PesertaViewModel : ViewModel() {

    // Daftar ini akan otomatis memperbarui UI saat ada perubahan
    val pesertaList = mutableStateListOf<Peserta>()

    init {
        // Langsung isi dengan data contoh saat ViewModel pertama kali dibuat
        pesertaList.addAll(
            listOf(
                Peserta("Asroni Sukirman", "Laki-Laki", "Cerai", "Bantul"),
                Peserta("Aprilia Kurnianti", "Perempuan", "Lajang", "Bantul"),
                Peserta("Haris Setyawan", "Laki-Laki", "Kawin", "Jogja")
            )
        )
    }

    fun tambahPeserta(pesertaBaru: Peserta) {
        pesertaList.add(pesertaBaru)
    }
}

