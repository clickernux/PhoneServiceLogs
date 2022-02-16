package com.taureanx.phoneservicelogs

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentTransaction
import com.taureanx.phoneservicelogs.databinding.ActivityServiceBinding
import com.taureanx.phoneservicelogs.subfragments.AddServiceFragment
import com.taureanx.phoneservicelogs.subfragments.EditServiceFragment

private const val GET_ITEM_INDEX = "ITEM_INDEX"

class ServiceActivity : AppCompatActivity() {
    private var _binding: ActivityServiceBinding? = null
    private val binding get() = _binding!!
    private lateinit var toolbar: Toolbar
    private lateinit var fragmentTransaction: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toolbar = binding.serviceToolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        fragmentTransaction = supportFragmentManager.beginTransaction()

        val itemIndex = intent.getLongExtra(GET_ITEM_INDEX, -1)

        if(itemIndex == -1L){
            supportActionBar?.title = getString(R.string.add_service)
        }else{
            supportActionBar?.title = getString(R.string.edit_service)
        }

        manageFragments(itemIndex)
    }

    private fun manageFragments(itemIndex: Long) {
        when (itemIndex){
            -1L -> {
                addNewServiceFragment()
            }
            else -> {
                editServiceFragment(itemIndex)
            }
        }
    }

    private fun editServiceFragment(itemIndex: Long) {
        val editService = EditServiceFragment.newInstance(itemIndex)
        fragmentTransaction.replace(R.id.service_fragment_container, editService)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }

    private fun addNewServiceFragment() {
        val addService = AddServiceFragment.newInstance()
        fragmentTransaction.replace(R.id.service_fragment_container, addService)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object{
        fun newIntent(packageContext: Context, itemIndex: Long): Intent{
            return Intent(packageContext, ServiceActivity::class.java).apply {
                putExtra(GET_ITEM_INDEX, itemIndex)
            }
        }
    }
}