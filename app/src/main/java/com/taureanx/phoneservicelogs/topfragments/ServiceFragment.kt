package com.taureanx.phoneservicelogs.topfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.taureanx.phoneservicelogs.R
import com.taureanx.phoneservicelogs.adapter.ServiceRecyclerAdapter
import com.taureanx.phoneservicelogs.databinding.FragmentServiceBinding
import com.taureanx.phoneservicelogs.model.DummyData

class ServiceFragment : Fragment() {
    private var _binding: FragmentServiceBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentServiceBinding.inflate(inflater, container, false)
        val recyclerAdapter = ServiceRecyclerAdapter()
        binding.serviceRecyclerView.adapter = recyclerAdapter
        recyclerAdapter.submitList(DummyData.data)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}