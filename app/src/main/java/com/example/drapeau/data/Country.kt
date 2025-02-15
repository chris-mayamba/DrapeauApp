package com.example.drapeau.data

data class Country(
    val name: Name,
    val flags: Flags,
    val capital : List<String>?,
    val population : Long,
    val continents : List<String>,
    val idd : Idd
)

data class Name(
    val common : String
)

data class Flags(
    val png : String
)

data class Idd(
    val root: String?,
    val suffixes : List<String>?
)
