package com.example.drapeau.ui.theme

import coil.compose.AsyncImage
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.request.ImageRequest

import com.example.drapeau.R
import com.example.drapeau.data.Country
import com.example.drapeau.viewmodel.CountryViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryApp(viewModel: CountryViewModel = viewModel()) {
    val countries by viewModel.countries.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Liste des Pays") })
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(countries) { country ->
                CountryItem(country)
            }
        }
    }
}

@Composable
fun CountryItem(country: Country) {
    Log.i("CountryItem", "Chargement du pays: ${country.name.common} - Drapeau: ${country.flags.png}")

    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(country.flags.png)
                .crossfade(true)
                .error(R.drawable.error)
                .placeholder(R.drawable.load)
                .build(),
            contentDescription = "Drapeau de ${country.name.common}",
            modifier = Modifier.size(64.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = country.name.common, style = MaterialTheme.typography.bodyMedium)
            Text(text = "Capitale: ${country.capital?.joinToString() ?: "N/A"}")
            Text(text = "Population: ${country.population}")
            Text(text = "Continent: ${country.continents.joinToString()}")
        }
    }
}
