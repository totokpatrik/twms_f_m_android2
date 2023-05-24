package com.twms.twms_f_m_android.ui.login

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.twms.twms_f_m_android.data.model.Auth
import com.twms.twms_f_m_android.data.model.AuthResponse
import com.twms.twms_f_m_android.repository.AuthRepository
import com.twms.twms_f_m_android.ui.base.BaseViewModel
import com.twms.twms_f_m_android.util.NetworkUtil.Companion.hasInternetConnection
import com.twms.twms_f_m_android.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    @ApplicationContext private val context: Context
) : BaseViewModel() {

    val auth: MutableLiveData<Resource<AuthResponse>> = MutableLiveData()
    var authResponse: AuthResponse? = null


    fun auth(userName: String, password: String) = viewModelScope.launch() {
        safeAuth(Auth(userName, password))
    }

    private suspend fun safeAuth(a: Auth) {
        auth.postValue(Resource.Loading())
        try {
            if (hasInternetConnection(context)) {
                val response = authRepository.authLogin(a)
                auth.postValue(handleAuthResponse(response))
            } else {
                auth.postValue(Resource.Error("No Internet Connection"))
            }
        } catch (ex: Exception) {
            when(ex){
                is IOException -> auth.postValue(Resource.Error("Network Failure"))
                else -> auth.postValue(Resource.Error("Conversion Error"))
            }
        }
    }

    private fun handleAuthResponse(response: Response<AuthResponse>): Resource<AuthResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                if (authResponse == null)
                    authResponse = resultResponse

                return Resource.Success(authResponse ?: resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    fun getRandomText(): String {
        return "Ciao"
    }


}