package com.twms.twms_f_m_android.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.twms.twms_f_m_android.ui.inbound.InboundViewModel
import com.twms.twms_f_m_android.ui.login.LoginViewModel

abstract class BaseFragment<T : ViewBinding>(private val inflateMethod : (LayoutInflater, ViewGroup?, Boolean) -> T) : Fragment(){

    private var _binding : T? = null

    val binding : T get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = inflateMethod.invoke(inflater, container, false)

        return binding.root
    }

    open fun onViewCreated() { }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}