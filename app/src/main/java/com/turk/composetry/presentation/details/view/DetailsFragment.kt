package com.turk.composetry.presentation.details.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.turk.composetry.common.util.loadPicture

class DetailsFragment: Fragment() {

    private val args by navArgs<DetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 10.dp, start = 10.dp, end = 10.dp)
                ) {
                    Text(
                        text = args.league.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.CenterHorizontally)
                            .padding(top = 20.dp),
                        style = MaterialTheme.typography.h3
                    )
                }
                Column {
                    args.league.image.let { url ->
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
                }
            }
        }
    }
}