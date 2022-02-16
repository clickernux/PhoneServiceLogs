package com.taureanx.phoneservicelogs.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.taureanx.phoneservicelogs.databinding.ServiceItemLayoutBinding
import com.taureanx.phoneservicelogs.model.ServiceData

class ServiceRecyclerAdapter (private val onServiceClickListener: OnServiceClickListener):
    ListAdapter<ServiceData, ServiceRecyclerAdapter.ServiceViewHolder>(ServiceDiff()) {
    class ServiceViewHolder(private val binding: ServiceItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ServiceData, onServiceClickListener: OnServiceClickListener) {
            binding.serviceData = item
            binding.serviceCardView.setOnClickListener {
                onServiceClickListener.onClick(item)
            }
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ServiceViewHolder(ServiceItemLayoutBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, onServiceClickListener)
    }
}

class ServiceDiff : DiffUtil.ItemCallback<ServiceData>() {
    override fun areItemsTheSame(oldItem: ServiceData, newItem: ServiceData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ServiceData, newItem: ServiceData): Boolean {
        return oldItem == newItem
    }
}

class OnServiceClickListener(private val onItemClick: (serviceData: ServiceData) -> Unit){
    fun onClick(serviceData: ServiceData) = onItemClick(serviceData)
}

