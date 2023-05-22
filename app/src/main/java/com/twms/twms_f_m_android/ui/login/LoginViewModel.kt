package com.twms.twms_f_m_android.ui.login

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.twms.twms_f_m_android.data.model.Auth
import com.twms.twms_f_m_android.data.model.AuthResponse
import com.twms.twms_f_m_android.repository.AuthRepository
import com.twms.twms_f_m_android.ui.base.BaseViewModel
import com.twms.twms_f_m_android.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    @ApplicationContext private val context: Context
) : BaseViewModel() {

    val auth: MutableLiveData<Resource<Auth>> = MutableLiveData()
    var authResponse: AuthResponse? = null

    val breakingNews: MutableLiveData<Resource<Auth>> = MutableLiveData()

    init {

    }

    fun auth(userName: String, password : String) = viewModelScope.launch() {
        safeAuth(Auth(userName,password))
    }

    private suspend fun safeAuth(a: Auth) {
        auth.postValue(Resource.Loading())
        
    }

    fun getRandomText(): String {
        return "Ciao"
    }


}