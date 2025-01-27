package com.example.drapeau.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Drapeau(
    @StringRes val stringResourceID : Int,
    @DrawableRes val imageResourceID : Int
)
