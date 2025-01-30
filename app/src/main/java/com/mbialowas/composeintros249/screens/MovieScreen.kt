package com.mbialowas.composeintros249.screens

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mbialowas.composeintros249.data.Movie
import com.mbialowas.composeintros249.vm.MoviesViewModel

@Composable
fun MovieScreen(modifier: Modifier = Modifier, viewModel: MoviesViewModel){

    LazyColumn{
        items(viewModel.movies){ movie->
            Log.i("Movie Title", movie.title)
            MovieCard(
                movie = movie,
                onFavoriteClick = { isFavorite ->
                    viewModel.toggleFavorite(movie.id, isFavorite)
                }
            )

        }

    }
}



@Composable
fun MovieCard(movie: Movie, onFavoriteClick: (Boolean) -> Unit) {
    var modifier = Modifier
        .border(3.dp, Color.Red)
        .padding(5.dp)
    Card{
        Row(modifier = modifier){
            Column(modifier = Modifier.padding(10.dp)){
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .height(2.dp)
                )
                Text(text = movie.title)
                Text(text = movie.description)

                Row{
                    Text(text = "Year: ${movie.year}")
                    FavCheckBox(
                        isFavorite = movie.isFavorite,
                        onCheckedChange = onFavoriteClick
                    )
                }
            }
        }
    }

}
@Composable
fun FavCheckBox(
    isFavorite: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    var checked by rememberSaveable {
        mutableStateOf(isFavorite)
    }
    Checkbox(
        checked = isFavorite,
        onCheckedChange = { isChecked ->
            checked = isChecked
            onCheckedChange(isChecked)
        }
    )
}
