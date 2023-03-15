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
import androidx.navigation.Navigation
import com.example.rushandroid.R
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
            val isValid = loginSignupVM.validatePtn(ptn)
            if(isValid.second){
                loginSignupVM.loginTest(ptn,mpin)
                observe()
            }else{
                Toast.makeText(requireContext(),isValid.first,Toast.LENGTH_SHORT).show()
            }

        }

        binding.btnBack.setOnClickListener {
           requireActivity().onBackPressed()
        }

    }

    private fun observe(){
        loginSignupVM.currentPerson.observe(viewLifecycleOwner, Observer {
            if(it.status==200){
                Toast.makeText(requireContext(),it.message,Toast.LENGTH_SHORT).show()
                Navigation.findNavController(requireView()).navigate(R.id.action_login_to_dashboard)
            }
        })
    }
}