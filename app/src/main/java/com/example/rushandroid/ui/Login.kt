package com.example.rushandroid.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.rushandroid.data.entities.RequestUser
import com.example.rushandroid.databinding.FragmentLoginBinding
import com.example.rushandroid.viewModel.LoginSignupVIewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers

@AndroidEntryPoint
class Login : Fragment() {

    private val loginSignupVM: LoginSignupVIewModel by activityViewModels()

    lateinit var binding: FragmentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentLoginBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            val ptn = binding.editPtn.text.toString()
            val mpin = binding.editMpin.text.toString()
            loginSignupVM.loginTest(ptn,mpin)
        }

        binding.btnBack.setOnClickListener {
           requireActivity().onBackPressed()
        }

        loginSignupVM.currentPerson.observeForever {
            if(it.message!=""){
             Toast.makeText(requireContext(),it.message,Toast.LENGTH_SHORT).show()
            }
        }
    }
}