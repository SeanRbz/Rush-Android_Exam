package com.example.rushandroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.rushandroid.R
import com.example.rushandroid.databinding.FragmentLoginBinding
import com.example.rushandroid.databinding.FragmentSignupBinding
import com.example.rushandroid.viewModel.LoginSignupVIewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Signup : Fragment(){
    private val loginSignupVM: LoginSignupVIewModel by activityViewModels()
    lateinit var binding: FragmentSignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            val lname = binding.editLname.text.toString()
            val fname = binding.editFname.text.toString()
            val ptn = binding.editPtn.text.toString()
            val mpin = binding.editMpin.text.toString()
            val cMPin = binding.editConfirmMpin.text.toString()
            if(mpin==cMPin){
                loginSignupVM.registerTest(ptn,mpin, fname, lname)
            }else{
                Toast.makeText(requireContext(),"PINs didnt match",Toast.LENGTH_SHORT).show()
            }
        }

        loginSignupVM.currentPerson.observeForever {
            if(it.status==200){
                Toast.makeText(requireContext(),it.message,Toast.LENGTH_SHORT).show()
                Navigation.findNavController(requireView()).navigate(R.id.action_signup_to_dashboard)
            }
        }
    }



}