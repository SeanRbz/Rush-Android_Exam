package com.example.rushandroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rushandroid.data.entities.Rewards
import com.example.rushandroid.databinding.RewardsListItemBinding
import com.example.rushandroid.utils.getBitmapFromURL

class RewardsDetailsPage: Fragment() {

    lateinit var binding: RewardsListItemBinding

    private var reward: Rewards = Rewards()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        arguments.let {
            reward = it?.getParcelable(REWARDS_SELECTED)?:Rewards()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  RewardsListItemBinding.inflate(inflater)
        binding.cardviewTxtDesc.visibility = View.VISIBLE
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bmp =  getBitmapFromURL(reward.image)
        binding.cardviewImage.setImageBitmap(bmp)
        binding.cardviewTxtTitle.text = reward.name
        binding.cardviewTxtDesc.text = reward.description
    }

    companion object{
        const val REWARDS_SELECTED :String = "REWARDS_SELECTED"
    }

}