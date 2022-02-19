package com.taureanx.phoneservicelogs.dialog_fragments

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.taureanx.phoneservicelogs.ServiceActivity
import com.taureanx.phoneservicelogs.databinding.ServiceInfoLayoutBinding

private const val SERVICE_ID = "service_id"

class ServiceInfoDialog : DialogFragment() {

    private var serviceId: Long? = null
    private val dialogViewModel: DialogViewModel by viewModels()
    private var _binding: ServiceInfoLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            serviceId = it.getLong(SERVICE_ID)
            serviceId?.let { id ->
                dialogViewModel.getServiceData(id)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ServiceInfoLayoutBinding.inflate(inflater, container, false)
        binding.viewModel = dialogViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.dismissDialogBtn.setOnClickListener {
            dismiss()
        }

        binding.editServiceBtn.setOnClickListener {
            dismiss()
            dialogViewModel.startServiceActivity { id ->
                val serviceActivity = ServiceActivity.newIntent(this.requireContext(), id)
                startActivity(serviceActivity)
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(itemId: Long) = ServiceInfoDialog().apply {
            arguments = Bundle().apply {
                putLong(SERVICE_ID, itemId)
            }
        }
    }
}