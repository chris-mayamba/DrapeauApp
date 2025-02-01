package com.example.drapeau

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
//import com.example.drapeau.data.Datasource
import com.example.drapeau.data.Flag
import com.example.drapeau.data.flags
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
    Scaffold(
        topBar = {
            DrapeauTopappBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(flags){
                FlagItem(
                    flag = it,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }

    }

}

@Composable
fun FlagItem(
    flag : Flag,
    modifier: Modifier = Modifier
    ){

    val expanded = remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable { expanded.value = !expanded.value }
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_small)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            )
            {
                FlagIcon(flag.imageResourceId)
                FlagInformation(
                    flag.name,
                    flag.capital,
                    flag.code,
                    flag.desc,
                    expanded = expanded.value
                )
            }
            Icon(
                imageVector = if (expanded.value)
                    Icons.Filled.KeyboardArrowUp
                else
                    Icons.Filled.KeyboardArrowDown,

                contentDescription = if (expanded.value) "Réduire"
                else "Afficher",
                modifier = Modifier.padding(start = 8.dp)
            )

        }


    }

}

@Composable
fun FlagIcon(
    @DrawableRes flagIcon : Int,
    modifier: Modifier = Modifier
){
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),

        contentScale = ContentScale.Crop,
        painter = painterResource(flagIcon),

        contentDescription = null
    )
}

@Composable
fun FlagInformation(
    @StringRes flagName: Int,
    @StringRes flagcode: Int,
    @StringRes flagcapital: Int,
    @StringRes flagdesc: Int,

    expanded:Boolean,

    modifier: Modifier = Modifier,

){

    Column(modifier = modifier){
        Text(
            text = stringResource(flagName),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
        )
        Row(modifier = modifier){
            Text(
                text = stringResource(flagcapital),
                style = MaterialTheme.typography.bodyLarge

            )
            Text(
                text = stringResource(flagcode),
                style = MaterialTheme.typography.bodyLarge
            )

        }
        AnimatedVisibility(visible = expanded) {
            Text(
                text = stringResource(flagdesc),
                modifier = Modifier.padding(top = 8.dp)
            )
        }

    }
}

@Preview
@Composable
fun FlagPreview(){
    DrapeauTheme(darkTheme = true){
        DrapeauApp()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrapeauTopappBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.image_size))
                        .padding(dimensionResource(id = R.dimen.padding_small)),
                    painter = painterResource(R.drawable.mboka),
                    contentDescription = null
                )
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )

            }
        },
        modifier = modifier
    )
}

//    val layoutDirection = LocalLayoutDirection.current
//    Surface(
//        modifier = Modifier
//        .fillMaxSize()
//        .statusBarsPadding()
//        .padding(
//            start = WindowInsets.safeDrawing.asPaddingValues().calculateStartPadding(layoutDirection),
//            end = WindowInsets.safeDrawing.asPaddingValues().calculateEndPadding(layoutDirection),
//        ),
//    ) {
//        DrapeauList(
//            drapeauList = Datasource().loadDrapeau(),
//        )
//
//    }

//@Preview
//@Composable
//private fun DrapeauCardPreview(){
//    DrapeauCard(Drapeau(R.string.pays1, R.drawable.drapeau1));
//}

//@Composable
//fun DrapeauList(drapeauList : List<Drapeau>, modifier: Modifier = Modifier){
//    LazyColumn(modifier = modifier) {
//        items(drapeauList){ drapeau ->
//            DrapeauCard(
//                drapeau = drapeau,
//                modifier = Modifier.padding(8.dp)
//            )
//
//        }
//    }
//}

//@Composable
//fun DrapeauCard(drapeau: Drapeau, modifier: Modifier = Modifier) {
//    Card(modifier = modifier){
//        Column{
//            Image(
//                painter = painterResource(drapeau.imageResourceID),
//                contentDescription = stringResource(drapeau.stringResourceID),
//                modifier = Modifier
//                    .fillMaxSize()
//                    .height(194.dp),
//                contentScale = ContentScale.Crop
//
//            )
//            Text(
//                text = LocalContext.current.getString(drapeau.stringResourceID),
//                modifier = Modifier.padding(16.dp),
//                style = MaterialTheme.typography.headlineSmall
//            )
//        }
//    }
//
//}