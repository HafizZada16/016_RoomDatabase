package com.example.questroom.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.questroom.repositori.RepositoriSiswa

class EntryViewModel(private val repositoriSiswa: RepositoriSiswa): viewmodel()
    {
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
            private set

            private fun
    }