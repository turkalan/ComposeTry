package com.turk.composetry.presentation.feed.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.turk.composetry.common.util.loadPicture
import com.turk.composetry.domain.models.League

@Composable
fun LeagueCardView(
    league: League,
    onClick: (League) -> Unit
) {
    Card(
        backgroundColor = Color.White,
        shape = MaterialTheme.shapes.small,
        elevation = 10.dp,
        modifier = Modifier
            .padding(
                bottom = 10.dp,
                top = 10.dp
            )
            .fillMaxWidth()
            .clickable(onClick = { onClick(league) })

    ) {
        Column {
            league.image.let { url ->
                val image = loadPicture(url = url).value
                image?.let { img ->
                    Image(
                        bitmap = img.asImageBitmap(),
                        modifier = Modifier
                            .padding(
                                top = 10.dp,
                                bottom = 10.dp
                            )
                            .fillMaxSize()
                            .preferredHeight(230.dp),
                        contentScale = ContentScale.Fit
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp, start = 10.dp, end = 10.dp)
            ) {
                Text(
                    text = league.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.Start),
                    style = MaterialTheme.typography.h5
                )
            }
        }
    }
}