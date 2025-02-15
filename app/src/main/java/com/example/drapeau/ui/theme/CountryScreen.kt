package com.example.drapeau.ui.theme

import coil.compose.AsyncImage
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.request.ImageRequest

import com.example.drapeau.R
import com.example.drapeau.data.Country
import com.example.drapeau.viewmodel.CountryViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryApp(region: String? = null, viewModel: CountryViewModel = viewModel()) {
    val countries by viewModel.countries.collectAsState()

    // ⚠️ Charge les pays selon la région sélectionnée
    LaunchedEffect(region) {
        viewModel.loadCountries(region)
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth() // Prend toute la largeur
                            .clip(RoundedCornerShape(12.dp)) // Coins arrondis
                            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)) // Fond coloré
                            .padding(horizontal = 16.dp, vertical = 8.dp), // Espacement
                        contentAlignment = Alignment.Center // Centre le texte
                    ) {
                        Text(
                            text = if (region == "africa") "Pays d'Afrique" else "Tous les pays",
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            items(countries) { country ->
                CountryItem(country)
            }
        }
    }
}





@Composable
fun CountryItem(country: Country) {
    Log.i("CountryItem", "Chargement du pays: ${country.name.common} - Drapeau: ${country.flags.png}")

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = MaterialTheme.shapes.medium, // Coins arrondis

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(MaterialTheme.colorScheme.surfaceVariant) // Ajout d'un fond distinct
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(country.flags.png)
                    .crossfade(true)
                    .error(R.drawable.error)
                    .placeholder(R.drawable.load)
                    .build(),
                contentDescription = "Drapeau de ${country.name.common}",
                modifier = Modifier
                    .size(64.dp)
                    .clip(MaterialTheme.shapes.small) // Coins arrondis
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = country.name.common,
                    style = MaterialTheme.typography.titleLarge,

                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Capitale: ${country.capital?.joinToString() ?: "N/A"}",
                        style = MaterialTheme.typography.bodyMedium,

                    )

                    Spacer(modifier = Modifier.width(8.dp)) // Espacement entre les deux

                    Text(
                        text = "Code: ${country.idd.root ?: "N/A"}${country.idd.suffixes?.joinToString() ?: "N/A"}",
                        style = MaterialTheme.typography.bodyMedium,

                    )
                }
            }
        }
    }
}


