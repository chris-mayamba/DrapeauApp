package com.example.drapeau.ui.theme

import coil.compose.AsyncImage
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

@Composable
fun SearchBar(query: String, onQueryChanged: (String) -> Unit) {
    TextField(
        value = query,
        onValueChange = onQueryChanged,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        placeholder = { Text("Rechercher un pays...") },
        singleLine = true,
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Recherche"
            )
        }
    )
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryApp(region: String? = null, viewModel: CountryViewModel = viewModel()) {
    val countries by viewModel.countries.collectAsState()
    var searchQuery by remember { mutableStateOf("") }


    LaunchedEffect(region) {
        viewModel.loadCountries(region)
    }


    val filteredCountries = countries.filter {
        it.name.common.contains(searchQuery, ignoreCase = true)
    }

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(24.dp))

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.2f))
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = when (region) {
                            "africa" -> "Pays d'Afrique"
                            else -> "Liste pays"
                        },
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                SearchBar(query = searchQuery, onQueryChanged = { searchQuery = it })
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            items(filteredCountries) { country ->
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
        shape = MaterialTheme.shapes.medium,

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(MaterialTheme.colorScheme.surfaceVariant)
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
                    .clip(MaterialTheme.shapes.small)
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

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Code: ${country.idd.root ?: "N/A"}${country.idd.suffixes?.joinToString() ?: "N/A"}",
                        style = MaterialTheme.typography.bodyMedium,

                    )
                }
            }
        }
    }
}


