package com.example.rushandroid.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rushandroid.data.entities.Rewards
import com.example.rushandroid.databinding.FragmentDashboardBinding
import com.example.rushandroid.databinding.RewardsListItemBinding
import com.example.rushandroid.utils.getBitmapFromURL

class RewardsAdapter (private val listener: OnClickListener) :
    RecyclerView.Adapter<RewardsAdapter.OrderViewDetailsViewHolder>()
{

    private var items:List<Rewards> = arrayListOf()


    fun setRewardItems(list:List<Rewards>){
        items = list
        notifyDataSetChanged()
    }

   interface OnClickListener{
       fun onSelectedRewards( rewward: Rewards)
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewDetailsViewHolder {
        val binding: RewardsListItemBinding = RewardsListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return OrderViewDetailsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderViewDetailsViewHolder, position: Int) {

        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner  class  OrderViewDetailsViewHolder(
        val binding: RewardsListItemBinding
    ) :
        RecyclerView.ViewHolder(binding.root){

        fun bind(reward: Rewards)= with(binding){
            val bmp =  getBitmapFromURL(reward.image)
            binding.cardviewImage.setImageBitmap(bmp)
            binding.cardviewTxtTitle.text = reward.name
            binding.cardview.setOnClickListener {
                listener.onSelectedRewards(reward)
            }
        }
    }

}