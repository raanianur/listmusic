package com.raniara.fraglistmuic

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Singer(
    val name: String,
    val image : Int,
    val listSong: List<Song>
) : Parcelable
