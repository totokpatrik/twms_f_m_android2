package com.twms.twms_f_m_android.data.remote

import com.twms.twms_f_m_android.data.model.Auth
import com.twms.twms_f_m_android.data.model.AuthResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("Auth/login")
    suspend fun authLogin(
        @Body auth : Auth
    ) : Response<AuthResponse>
}