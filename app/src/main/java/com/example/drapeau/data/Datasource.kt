package com.example.drapeau.data

import com.example.drapeau.R
import com.example.drapeau.model.Drapeau

class Datasource() {
    fun loadDrapeau(): List<Drapeau>{
        return listOf<Drapeau>(
                Drapeau(R.string.pays1, R.drawable.drapeau1),
                Drapeau(R.string.pays2, R.drawable.drapeau2),
                Drapeau(R.string.pays3, R.drawable.drapeau3),
                Drapeau(R.string.pays4, R.drawable.drapeau4),
                Drapeau(R.string.pays5, R.drawable.drapeau5),
                Drapeau(R.string.pays6, R.drawable.drapeau6),
                Drapeau(R.string.pays7, R.drawable.drapeau7),
                Drapeau(R.string.pays8, R.drawable.drapeau8),
                Drapeau(R.string.pays9, R.drawable.drapeau9),
                Drapeau(R.string.pays10, R.drawable.drapeau10),
                Drapeau(R.string.pays11, R.drawable.drapeau11),
                Drapeau(R.string.pays12, R.drawable.drapeau12),
                Drapeau(R.string.pays13, R.drawable.drapeau13),
                Drapeau(R.string.pays14, R.drawable.drapeau14),
                Drapeau(R.string.pays15, R.drawable.drapeau15),
                Drapeau(R.string.pays16, R.drawable.drapeau16),
                Drapeau(R.string.pays17, R.drawable.drapeau17),
                Drapeau(R.string.pays18, R.drawable.drapeau18),
                Drapeau(R.string.pays19, R.drawable.drapeau19),
                Drapeau(R.string.pays20, R.drawable.drapeau20)

        )
    }
}