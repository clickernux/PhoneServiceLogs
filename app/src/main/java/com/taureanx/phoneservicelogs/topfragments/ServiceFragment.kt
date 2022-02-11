package com.taureanx.phoneservicelogs.topfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.taureanx.phoneservicelogs.MainViewModel
import com.taureanx.phoneservicelogs.databinding.FragmentServiceBinding
import com.taureanx.phoneservicelogs.databinding.ServiceTableRowBinding
import com.taureanx.phoneservicelogs.model.DummyData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

//        DummyData.data.map { data ->
//            scope.launch {
//
//                withContext(Dispatchers.Main){
//                    val myLayoutInflater = LayoutInflater.from(requireContext())
//                    val tableRow = ServiceTableRowBinding.inflate(myLayoutInflater, binding.serviceTable, false)
//                    tableRow.serviceData = data
//                    binding.serviceTable.addView(tableRow.customTableRow)
//                    tableRow.customTableRow.setOnLongClickListener {
//                        Toast.makeText(requireContext(), data.cusName, Toast.LENGTH_SHORT).show()
//                        true
//                    }
//                }
//            }
//        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}