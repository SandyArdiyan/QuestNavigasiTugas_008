package com.example.pertemuan6tugas.models

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.pertemuan6tugas.model.Peserta // Import data class Peserta

class PesertaViewModel : ViewModel() {

    // Daftar ini akan otomatis memperbarui UI
    val pesertaList = mutableStateListOf<Peserta>()

    init {
        // Data contoh awal
        pesertaList.addAll(
            listOf(
                Peserta(
                    nama = "Harun Sukirman",
                    gender = "Laki-laki",
                    status = "Ceraf",
                    alamat = "Bantul"
                ),
                Peserta(
                    nama = "Aprilla Nurdianti",
                    gender = "Perempuan",
                    status = "Lajang",
                    alamat = "Bantul"
                ),
                Peserta(
                    nama = "Haris Setyawan",
                    gender = "Laki-laki",
                    status = "Kawin",
                    alamat = "Jogja"
                )
            )
        )
    }

    // Fungsi untuk menambah data dari formulir
    fun tambahPeserta(peserta: Peserta) {
        pesertaList.add(peserta)
    }
}