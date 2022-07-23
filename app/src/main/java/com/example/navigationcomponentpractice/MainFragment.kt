package com.example.navigationcomponentpractice

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponentpractice.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This callback will only be called when MyFragment is at least Started.
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {

                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)

        //setting click listener to btnRedirectToView3
        //Implementing alert dialog if etDataToFragment3 is empty
        //Or redirecting to fragment 3 with an argument otherwise
        binding.btnRedirectToFragment3.setOnClickListener { view: View ->
            if (binding.etDataToFragment3.text.toString().isNullOrEmpty()) {
                val alertDialogBuilder = AlertDialog.Builder(binding.btnRedirectToFragment3.context)
                //setting title for the alert dialog
                alertDialogBuilder.setTitle("Error!")
                //setting message for the alert dialog
                alertDialogBuilder.setMessage("The 'Send data to Fragment 3' field is mandatory!")
                //setting OK button for the alter dialog
                alertDialogBuilder.setNeutralButton("OK") { _, _ ->
                }
                //creating the alert dialog
                val alertDialog: AlertDialog = alertDialogBuilder.create()
                alertDialog.setCancelable(false)
                //showing alert dialog
                alertDialog.show()
            } else {
                view.findNavController()
                    .navigate(MainFragmentDirections.actionMainFragmentToFragment3(binding.etDataToFragment3.text.toString()))
            }
        }

        //setting btnButtonWebView click listener
        binding.btnButtonWebView.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(MainFragmentDirections.actionMainFragmentToWebViewFragment())
        }
        return binding.root
    }
}