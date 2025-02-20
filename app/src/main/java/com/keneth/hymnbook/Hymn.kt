package com.keneth.hymnbook

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hymn(
    val number: Int,
    val title: String,
    var isFavourite: Boolean,
    val stanzas: List<String>,
    val chorus: String
):Parcelable