package com.taureanx.phoneservicelogs.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.taureanx.phoneservicelogs.topfragments.Home
import com.taureanx.phoneservicelogs.topfragments.ServiceFragment

class HomeViewPagerAdapter(fragmentManager: FragmentManager, lifeCycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifeCycle) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {
                Home()
            }
            else -> {
                ServiceFragment()
            }
        }
    }
}