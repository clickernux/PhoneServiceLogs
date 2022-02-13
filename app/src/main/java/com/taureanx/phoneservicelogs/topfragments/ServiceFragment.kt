package com.taureanx.phoneservicelogs.topfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.taureanx.phoneservicelogs.MainViewModel
import com.taureanx.phoneservicelogs.ServiceActivity
import com.taureanx.phoneservicelogs.databinding.FragmentServiceBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

const val NEW_SERVICE = -1

class ServiceFragment : Fragment() {
    private var _binding: FragmentServiceBinding? = null
    private val binding get() = _binding!!
    private lateinit var scope: CoroutineScope
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentServiceBinding.inflate(inflater, container, false)
        scope = CoroutineScope(Dispatchers.Default)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fabAddService.setOnClickListener {
            val intent = ServiceActivity.newIntent(this.requireContext(), NEW_SERVICE)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}