package com.twms.twms_f_m_android.repository

import com.twms.twms_f_m_android.data.model.Auth
import com.twms.twms_f_m_android.data.model.AuthResponse
import com.twms.twms_f_m_android.data.remote.AuthApi
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject  constructor(
    private val authApi: AuthApi
){
    suspend fun authLogin(auth : Auth) : Response<AuthResponse> {
        return authApi.authLogin(auth)
    }

}