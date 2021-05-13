package com.turk.composetry.presentation.feed.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.turk.composetry.domain.models.League
import com.turk.composetry.presentation.feed.view.components.LeagueCardView
import com.turk.composetry.presentation.feed.viewmodel.FeedViewModel

class FeedFragment: Fragment() {

    private lateinit var viewModel: FeedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("TAGG", "Fragment")
        viewModel = FeedViewModel(requireContext())
        return ComposeView(requireContext()).apply {
            setContent {
                val leagues = viewModel.leagues

                LazyColumn{
                    itemsIndexed(
                        items = leagues
                    ) { _, league ->
                        LeagueCardView(league = league, onClick = { it -> onLeagueClicked(it) })
                    }
                }

            }
        }
    }

    private fun onLeagueClicked(league: League) {
        findNavController().navigate(
            FeedFragmentDirections.actionLeagueFragmentToDetailsFragment(league)
        )
    }
}