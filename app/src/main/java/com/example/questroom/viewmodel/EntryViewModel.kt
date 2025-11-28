package com.example.questroom.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.questroom.repositori.RepositoriSiswa
import com.example.questroom.room.Siswa

class EntryViewModel(private val repositoriSiswa: RepositoriSiswa): viewmodel() {
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    private fun validasiInput(
        uiState: DetailSiswa = uiStateSiswa.detailSiswa
    ): Boolean {

        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }


}