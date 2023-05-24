package com.twms.twms_f_m_android.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
data class Auth (
    var userName: String,
    var password: String
) : Parcelable