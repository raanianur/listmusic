package com.raniara.listmusic

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.Year

@Parcelize
data class LaguData(
    val judul: String,
    val Album: String,
) : Parcelable
