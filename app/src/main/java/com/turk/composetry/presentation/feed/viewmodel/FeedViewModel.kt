package com.turk.composetry.presentation.feed.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.turk.composetry.R
import com.turk.composetry.domain.models.League

class FeedViewModel(
    private val context: Context
): ViewModel() {

    var leagues: ArrayList<League> = ArrayList()

    init {
        populateList()
    }

    private fun populateList() {
        leagues.apply {
            add(League(context.getString(R.string.premier_league), context.getString(R.string.premier_league_photo_url)))
            add(League(context.getString(R.string.la_liga), context.getString(R.string.la_liga_photo_url)))
            add(League(context.getString(R.string.serie_a), context.getString(R.string.serie_A_photo_url)))
            add(League(context.getString(R.string.bundesliga), context.getString(R.string.bundesliga_photo_url)))
            add(League(context.getString(R.string.ligue_1), context.getString(R.string.ligue_1_photo_url)))
        }
    }

}