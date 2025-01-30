package com.example.drapeau

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
//import com.example.drapeau.data.Datasource
import com.example.drapeau.data.Flag
import com.example.drapeau.data.flags
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
    Scaffold { it ->
        LazyColumn(contentPadding = it) {
            items(flags){
                FlagItem(
                    flag = it,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }

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
}

@Composable
fun FlagItem(
    flag : Flag,
    modifier: Modifier = Modifier
    ){
    Card(modifier = Modifier.padding(8.dp)) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_small))

        ){
            FlagIcon(flag.imageResourceId)
            FlagInformation(flag.name, flag.capital, flag.code)
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
    @StringRes flagName : Int,
    @StringRes flagcode : Int,
    @StringRes flagcapital : Int,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier){
        Text(
            text = stringResource(flagName),
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
        )
        Row(modifier = modifier){
            Text(
                text = stringResource(flagcapital)
            )
            Text(
                text = stringResource(flagcode),
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

@Composable
fun DrapeauTopappBar(modifier: Modifier = Modifier){

}



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