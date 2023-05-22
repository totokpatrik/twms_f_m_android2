package com.twms.twms_f_m_android.data.model

import java.util.Date

data class AuthResponse(
    var tokenString: String,
    var expiration: Date
)