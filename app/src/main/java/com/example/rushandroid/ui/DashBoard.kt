package com.example.rushandroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rushandroid.R
import com.example.rushandroid.data.entities.Rewards
import com.example.rushandroid.databinding.FragmentDashboardBinding
import com.example.rushandroid.ui.adapter.RewardsAdapter
import com.example.rushandroid.viewModel.LoginSignupVIewModel
import com.example.rushandroid.viewModel.RewardsViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DashBoard: Fragment() , RewardsAdapter.OnClickListener {

    lateinit var binding: FragmentDashboardBinding

    private val loginSignupVM: LoginSignupVIewModel by activityViewModels()

    private val rewardsVM: RewardsViewModel by activityViewModels()

    private lateinit var adapter: RewardsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentDashboardBinding.inflate(inflater)
        setAdapter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginSignupVM.currentPerson.observe(viewLifecycleOwner, Observer {
            val fname = it.data?.first_name?:""
            val lname = it.data?.last_name?:""
            val ptn = it.data?.mobile
            val referral = it.data?.referral_code?:""
            binding.textUserName.text = "$fname $lname"
            binding.textUserPtn.text = ptn
            binding.textUserReferral.text = referral
        })


       lifecycleScope.launch {
            rewardsVM.getList().observe(viewLifecycleOwner, Observer {
                adapter.setRewardItems(it.list?: arrayListOf())
            })
        }

    }
    private fun setAdapter(){
        binding.recyclerItems.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = RewardsAdapter(this@DashBoard)
        }
        adapter = binding.recyclerItems.adapter as RewardsAdapter
    }
    override fun onSelectedRewards(reward: Rewards) {
        val bundle = Bundle()
        bundle.putParcelable(RewardsDetailsPage.REWARDS_SELECTED,reward)
        Navigation
            .findNavController(requireView())
            .navigate(R.id.action_dashboard_to_RewardsDetailsPage,bundle)


    }
}