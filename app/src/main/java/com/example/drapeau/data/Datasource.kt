package com.example.drapeau.data

import com.example.drapeau.model.Drapeau

class Datasource() {
    fun loadDrapeau(): List<Drapeau>{
        return listOf<Drapeau>(
            Drapeau()
        )
    }
}