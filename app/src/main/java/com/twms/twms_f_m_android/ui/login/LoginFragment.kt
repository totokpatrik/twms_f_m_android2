package com.twms.twms_f_m_android.ui.login

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.twms.twms_f_m_android.R
import com.twms.twms_f_m_android.databinding.FragmentLoginBinding
import com.twms.twms_f_m_android.ui.base.BaseFragment
import com.twms.twms_f_m_android.ui.base.BaseViewModel

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private lateinit var viewModel: LoginViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        /*viewModel.observableLiveData.observe(viewLifecycleOwner) {auth ->
            binding.btnLogin.text = auth.TokenString
        }*/



        // binding.btnLogin.text = viewModel.getRandomText()
        binding.btnLogin.setOnClickListener{
            viewModel.auth(binding.txtUserId.text.toString(), binding.txtPassword.text.toString())
        }
    }
}