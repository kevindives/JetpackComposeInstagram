package com.magicworld.jetpackcomposeinstagram.rv

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.magicworld.jetpackcomposeinstagram.R
import com.magicworld.jetpackcomposeinstagram.model.Superhero
import kotlinx.coroutines.launch

@Composable
fun SimpleRecyclerView() {
    val names = listOf("kevin", "aris", "laura", "pepe")
    LazyColumn {
        item { Text(text = "header") }
        items(7) {
            Text(text = "esto se repite $it")
        }
        items(names) {
            Text(text = "hola me llamo $it")
        }
        item { Text(text = "footer") }
    }
}

@Composable
fun SuperheroView() {
    val context = LocalContext.current
    LazyColumn(/*verticalArrangement = Arrangement.spacedBy(8.dp)*/) {
        items(getSuperheros()) { superhero ->
            ItemHero(superhero = superhero)
            { Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show() }
        }
    }
}

@Composable
fun SuperheroSpecialControlView() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Column {
        LazyColumn(state = rvState, modifier = Modifier.weight(1f)) {
            items(getSuperheros()) { superhero ->
                ItemHero(superhero = superhero)
                { Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show() }
            }
        }
        //es para saber si estamos haciendo scroll hacia bajo o hacia arriba
        rvState.firstVisibleItemScrollOffset

        val showButton by remember {
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
            }
        }
        if (showButton) {
            Button(onClick = { coroutineScope.launch { rvState.animateScrollToItem(0) } },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)) {
                Text(text = "Boton feo")
            }
        }

    }

}


@ExperimentalFoundationApi
@Composable
fun SuperheroStickyView() {
    val context = LocalContext.current
    val superhero: Map<String, List<Superhero>> =  getSuperheros().groupBy { it.publisher }

    LazyColumn(/*verticalArrangement = Arrangement.spacedBy(8.dp)*/) {

        superhero.forEach { (publisher, mySuperhero) ->
            stickyHeader {
                Text(text = publisher , modifier = Modifier.fillMaxWidth().background(Color.Blue), color = Color.DarkGray )
            }
            items(mySuperhero) { superhero ->
                ItemHero(superhero = superhero)
                { Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show() }
            }
        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperheroGridView() {
    val context = LocalContext.current
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        content = {
            items(getSuperheros()) { superhero ->
                ItemHero(superhero = superhero)
                { Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show() }
            }
        },
        contentPadding = PaddingValues(8.dp)
    )
}

@Composable
fun ItemHero(superhero: Superhero, onItemSelected: (Superhero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red), modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onItemSelected(superhero) }
    ) {
        Column() {

            Image(
                painter = painterResource(id = superhero.photo),
                contentDescription = "Superhero avatar",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superhero.superheroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superhero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superhero.publisher,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp),
                fontSize = 10.sp
            )
        }
    }
}

fun getSuperheros(): List<Superhero> {
    return listOf(
        Superhero("Spiderman", "Peter Parker", "Marvel",  R.drawable.spiderman),
        Superhero("Batman", "Bruno wayne", "Marvel", R.drawable.batman),
        Superhero("Wolverine", "James Howlett", "Marvel", R.drawable.logan),
        Superhero("Thor", "Thor Odison", "DC", R.drawable.thor),
        Superhero("Flash", "Jay Garrick", "DC", R.drawable.flash),
        Superhero("Green Latern", "Alan Scott", "DC", R.drawable.green_lantern),
        Superhero("Wonder Woman", "Princess Diana", "DC", R.drawable.wonder_woman)
    )
}

