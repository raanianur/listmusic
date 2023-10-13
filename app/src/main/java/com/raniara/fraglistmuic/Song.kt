package com.raniara.fraglistmuic

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Song(
    val title: String,
    val Album: String,
) : Parcelable
