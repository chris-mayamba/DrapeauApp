package com.example.drapeau

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.drapeau.model.Drapeau
import com.example.drapeau.ui.theme.DrapeauTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DrapeauTheme {
                    DrapeauApp()
            }
        }
    }
}

@Composable
fun DrapeauApp(){

}


@Preview
@Composable
private fun DrapeauCardPreview(){
    DrapeauCard(Drapeau(R.string.pays1, R.drawable.drapeau1));
}

@Composable
fun DrapeauList(drapeauList : List<Drapeau>, modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier) {
        items(drapeauList){ drapeau ->
            DrapeauCard(
                drapeau = drapeau,
                modifier = Modifier.padding(8.dp)
            )

        }
    }
}

@Composable
fun DrapeauCard(drapeau: Drapeau, modifier: Modifier = Modifier) {
    Card (modifier = modifier){
        Column{
            Image(
                painter = painterResource(drapeau.imageResourceID),
                contentDescription = stringResource(drapeau.stringResourceID),
                modifier = Modifier
                    .fillMaxSize()
                    .height(194.dp),
                contentScale = ContentScale.Crop

            )
            Text(
                text = LocalContext.current.getString(drapeau.stringResourceID),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }

}