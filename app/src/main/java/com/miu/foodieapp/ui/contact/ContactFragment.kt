package com.miu.foodieapp.ui.contact

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.miu.foodieapp.R
import com.miu.foodieapp.databinding.FragmentContactBinding

class ContactFragment : Fragment() {

    private lateinit var binding: FragmentContactBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactBinding.inflate(layoutInflater)

        binding.contactPhoneCard.setOnClickListener { onPhoneClicked() }
        binding.contactEmailCard.setOnClickListener { onEmailClicked() }

        return binding.root
    }

    private fun onPhoneClicked() {
        val phoneNumber = getString(R.string.contact_phone)
        val uri = Uri.parse("tel:$phoneNumber")
        val phoneIntent = Intent(Intent.ACTION_DIAL, uri)
        startActivity(phoneIntent)
    }

    private fun onEmailClicked() {
        val uri = Uri.parse("mailto:${R.string.contact_email}")
        val emailIntent = Intent(Intent.ACTION_SENDTO, uri)
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "FoodiePal: Query from contact")
//        if (emailIntent.resolveActivity(requireContext().packageManager) != null) {
            startActivity(emailIntent)
//        } else{
//            Toast.makeText(requireContext(), "Email application not available", Toast.LENGTH_LONG).show()
//        }
    }
}