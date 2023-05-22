package com.twms.twms_f_m_android.ui.inbound

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.twms.twms_f_m_android.R
import com.twms.twms_f_m_android.databinding.FragmentInboundBinding
import com.twms.twms_f_m_android.databinding.FragmentLoginBinding
import com.twms.twms_f_m_android.ui.login.LoginViewModel

class InboundFragment : Fragment() {

    companion object {
        fun newInstance() = InboundFragment()
    }

    private lateinit var viewModel: InboundViewModel

    private var _binding: FragmentInboundBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInboundBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(InboundViewModel::class.java)


        binding.btnNav.setOnClickListener{
            findNavController().navigateUp()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigateUp()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}