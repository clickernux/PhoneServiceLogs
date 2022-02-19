package com.taureanx.phoneservicelogs.topfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.taureanx.phoneservicelogs.MainViewModel
import com.taureanx.phoneservicelogs.ServiceActivity
import com.taureanx.phoneservicelogs.adapter.OnServiceClickListener
import com.taureanx.phoneservicelogs.adapter.ServiceRecyclerAdapter
import com.taureanx.phoneservicelogs.databinding.FragmentServiceBinding
import com.taureanx.phoneservicelogs.dialog_fragments.ServiceInfoDialog

const val NEW_SERVICE = -1L

class ServiceFragment : Fragment() {
    private var _binding: FragmentServiceBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentServiceBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        val recyclerAdapter = ServiceRecyclerAdapter(OnServiceClickListener {
            showServiceInfoDialog(it.id!!)
        })
        binding.serviceDataList.adapter = recyclerAdapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fabAddService.setOnClickListener {
            val intent = ServiceActivity.newIntent(this.requireContext(), NEW_SERVICE)
            startActivity(intent)
        }
    }

    private fun showServiceInfoDialog(itemId: Long) {
        val fragmentManager = this.parentFragmentManager
        val infoDialogFragment = ServiceInfoDialog.newInstance(itemId)
        infoDialogFragment.show(fragmentManager, "ServiceInfo")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}