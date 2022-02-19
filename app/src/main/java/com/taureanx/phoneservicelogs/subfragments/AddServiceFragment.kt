package com.taureanx.phoneservicelogs.subfragments

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.taureanx.phoneservicelogs.R
import com.taureanx.phoneservicelogs.databinding.FragmentAddServiceBinding
import com.taureanx.phoneservicelogs.model.ServiceData
import com.taureanx.phoneservicelogs.subfragments.viewmodels.AddServiceViewModel
import com.taureanx.phoneservicelogs.util.DataSource
import com.taureanx.phoneservicelogs.util.PhoneBrand
import com.taureanx.phoneservicelogs.util.getFormattedDate
import logcat.logcat
import java.util.*

class AddServiceFragment : Fragment() {
    private var _binding: FragmentAddServiceBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AddServiceViewModel by lazy {
        ViewModelProvider(this).get(AddServiceViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAddServiceBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        val adapter = ArrayAdapter(requireContext(), R.layout.phone_brand_list_item, DataSource.phoneBrand)
        binding.phoneBrandList.setAdapter(adapter)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.collectedDateTv.text = getFormattedDate(Date())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.add_service_fragment_option_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_done -> {
                saveData()
            }
        }
        return false
    }

    private fun saveData() {
        val customerName = binding.cusNameField.editText?.text.toString()
        val phoneBrand = binding.phoneBrandList.text.toString()
        val phoneModel = binding.phoneModelField.editText?.text.toString()
        val repairCase = binding.repairCaseField.editText?.text.toString()
        val contactPhoneNo = binding.phoneNoField.editText?.text.toString()
        val cost = binding.repairCostField.editText?.text.toString()
        val isUrgent = binding.isUrgentCheckbox.isChecked
        val note = binding.noteField.editText?.text.toString()

        if (customerName.isEmpty() || phoneBrand.isEmpty() || phoneModel.isEmpty() || repairCase.isEmpty()) {
            Snackbar.make(binding.root, "အရေးကြီးအချက်အလက် ဖြည့်ရန်လိုသည်", Snackbar.LENGTH_SHORT).show()
        }else{
            val serviceData = ServiceData(
                cusName = customerName,
                phBrand = phoneBrand,
                phModel = phoneModel,
                repair_case = repairCase,
                contactPhone = contactPhoneNo,
                cost = cost,
                urgent = isUrgent,
                note = note
            )

            viewModel.addNewService(serviceData)
            logcat {
                "Repair Case: ${serviceData.repair_case}"
            }
            Snackbar.make(binding.root, "Done!", Snackbar.LENGTH_SHORT).show()
            logcat {
                "Data Saved Successfully!"
            }
            this.activity?.finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = AddServiceFragment()
    }
}