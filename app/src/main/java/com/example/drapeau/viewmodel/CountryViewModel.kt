package com.example.drapeau.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drapeau.data.Country
import com.example.drapeau.model.CountryApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CountryViewModel : ViewModel() {

    private val _countries = MutableStateFlow<List<Country>>(emptyList())
    val countries: StateFlow<List<Country>> = _countries

    private val api = CountryApi.create()

    // Charger uniquement tous les pays si aucun filtre n'est défini
    fun loadCountries(region: String? = null) {
        viewModelScope.launch {
            _countries.value = try {
                when (region) {
                    "africa" -> api.getAfricanCountries()
                    else -> api.getCountries()
                }
            } catch (e: Exception) {
                emptyList()
            }
        }
    }
}

