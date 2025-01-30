package com.example.drapeau.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.drapeau.R

data class Flag(
    @DrawableRes val imageResourceId : Int,
    @StringRes val name : Int,
    @StringRes val code : Int,
    @StringRes val capital : Int
)

val flags = listOf(
    Flag(R.drawable.drapeau1, R.string.pays1 , R.string.pays1_code, R.string.pays1_capital),
    Flag(R.drawable.drapeau2, R.string.pays2 , R.string.pays2_code, R.string.pays2_capital),
    Flag(R.drawable.drapeau3, R.string.pays3 , R.string.pays3_code, R.string.pays3_capital),
    Flag(R.drawable.drapeau4, R.string.pays4 , R.string.pays4_code, R.string.pays4_capital),
    Flag(R.drawable.drapeau5, R.string.pays5 , R.string.pays5_code, R.string.pays5_capital),
    Flag(R.drawable.drapeau6, R.string.pays6 , R.string.pays6_code, R.string.pays6_capital),
    Flag(R.drawable.drapeau7, R.string.pays7 , R.string.pays7_code, R.string.pays7_capital),
    Flag(R.drawable.drapeau8, R.string.pays8 , R.string.pays8_code, R.string.pays8_capital),
    Flag(R.drawable.drapeau9, R.string.pays9 , R.string.pays9_code, R.string.pays9_capital),
    Flag(R.drawable.drapeau10, R.string.pays10 ,R.string.pays10_code, R.string.pays10_capital)

)