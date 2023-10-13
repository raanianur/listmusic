package com.raniara.listmusic

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class PenyanyiData(
    val nama: String,
    val gambar: Int,
    val daftarLagu: List<LaguData>
) : Parcelable

