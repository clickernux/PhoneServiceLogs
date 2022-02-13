package com.taureanx.phoneservicelogs.subfragments

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.taureanx.phoneservicelogs.R
import com.taureanx.phoneservicelogs.databinding.FragmentAddServiceBinding
import com.taureanx.phoneservicelogs.util.PhoneBrand

class AddServiceFragment : Fragment() {
    private var _binding: FragmentAddServiceBinding? = null
    private val binding get() = _binding!!

    private val phoneBrand = listOf(
        PhoneBrand.XIAOMI.toString(),
        PhoneBrand.VIVO.toString(),
        PhoneBrand.OPPO.toString(),
        PhoneBrand.HONOR.toString(),
        PhoneBrand.HUAWEI.toString(),
        PhoneBrand.REALME.toString(),
        PhoneBrand.TECNO.toString(),
        PhoneBrand.OTHER.toString()
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAddServiceBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        val adapter = ArrayAdapter(requireContext(), R.layout.phone_brand_list_item, phoneBrand)
        binding.phoneBrandList.setAdapter(adapter)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.add_service_fragment_option_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.menu_done -> {
                Toast.makeText(requireContext(), "Done!", Toast.LENGTH_SHORT).show()
                this.activity?.finish()
            }
        }
        return false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{

        fun newInstance() = AddServiceFragment()
    }
}