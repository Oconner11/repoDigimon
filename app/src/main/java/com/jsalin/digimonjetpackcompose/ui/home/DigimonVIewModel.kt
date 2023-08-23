package com.jsalin.digimonjetpackcompose.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.jsalin.digimonjetpackcompose.data.remote.DigimonService
import com.jsalin.digimonjetpackcompose.data.remote.model.DigimonModelItem

class DigimonVIewModel : ViewModel() {
    var digimonList: List<DigimonModelItem> by mutableStateOf(listOf())

    init {
        loadDigimonData()
    }

    private fun loadDigimonData() {
        DigimonService.getDigimon({ digimon ->
            digimonList = digimon
        }, {
            println("Error en la carga de datos")
        })
    }

}