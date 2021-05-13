package com.turk.composetry.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class League(
    var name: String,
    var image: String
): Parcelable