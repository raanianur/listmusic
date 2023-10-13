package com.raniara.listmusic

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize



@Parcelize
data class LaguData(
    val judul: String,
    val Album: String,
) : Parcelable
