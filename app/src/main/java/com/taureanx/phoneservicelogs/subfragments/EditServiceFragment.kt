package com.taureanx.phoneservicelogs.subfragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.taureanx.phoneservicelogs.R
import com.taureanx.phoneservicelogs.databinding.FragmentEditServiceBinding
import com.taureanx.phoneservicelogs.subfragments.viewmodels.AddServiceViewModel
import logcat.logcat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "item_index"

/**
 * A simple [Fragment] subclass.
 * Use the [EditServiceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditServiceFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var itemIndex: Long? = null
    private var _binding: FragmentEditServiceBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AddServiceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            itemIndex = it.getLong(ARG_PARAM1)
            logcat {
                "Item ID: $itemIndex"
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentEditServiceBinding.inflate(inflater, container, false)
        itemIndex?.let {
            viewModel.getServiceData(it)
        }
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.edit_fragment_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.menu_delete_service -> {
                viewModel.deleteServiceData()
                this.activity?.finish()
            }

            R.id.menu_update_service -> {
                viewModel.updateServiceData()
                this.activity?.finish()
            }
        }
        return false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(itemIndex: Long) =
            EditServiceFragment().apply {
                arguments = Bundle().apply {
                    putLong(ARG_PARAM1, itemIndex)
                }
            }
    }
}