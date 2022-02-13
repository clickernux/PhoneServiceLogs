package com.taureanx.phoneservicelogs.subfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.taureanx.phoneservicelogs.R

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
    private var itemIndex: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            itemIndex = it.getInt(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_service, container, false)
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(itemIndex: String) =
            EditServiceFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, itemIndex)
                }
            }
    }
}