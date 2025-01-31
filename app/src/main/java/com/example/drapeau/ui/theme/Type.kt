package com.example.drapeau.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.drapeau.R


val andika = FontFamily(
    Font(R.font.andika_regular)
)

val alef = FontFamily(
    Font(R.font.alef_regular),
    Font(R.font.alef_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = andika,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),
    displayMedium = TextStyle(
        fontFamily = alef,
        fontWeight = FontWeight.Bold,
        fontSize =  20.sp
    ),
    labelSmall = TextStyle(
        fontFamily = alef,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = alef,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    )
)