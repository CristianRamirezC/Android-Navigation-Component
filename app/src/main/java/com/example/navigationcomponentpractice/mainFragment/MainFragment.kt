package com.example.navigationcomponentpractice.mainFragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.navigationcomponentpractice.R
import com.example.navigationcomponentpractice.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var redirectToReceivingArgsFragmentBtn: Button
    private lateinit var dataToReceivingArgsFragment: EditText
    private lateinit var redirectToWebViewButton: Button
    private lateinit var redirectToEmptyFragmentButton: Button
    private lateinit var redirectToCloseAppAlertDialogButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        setUpViewLogic()
        return binding.root
    }

    private fun setUpViewLogic() {
        redirectToReceivingArgsFragmentBtn = binding.btnRedirectToReceivingArgsFragment
        dataToReceivingArgsFragment = binding.etDataToReceivingArgsFragment
        redirectToWebViewButton = binding.btnButtonWebView
        redirectToEmptyFragmentButton = binding.btnRedirectToEmptyView
        redirectToCloseAppAlertDialogButton = binding.btnOpenAlertDialog

        redirectToReceivingArgsFragmentBtn.setOnClickListener {
            if (dataToReceivingArgsFragment.text.toString().isEmpty()) {
                //Implementing alert dialog if etDataToReceivingArgsFragment is empty
                receivingArgsFragmentAlertDialogSetUp()
            } else {
                //Or redirecting to fragment 3 with an argument otherwise
                navigateToReceivingArgsFragment()
            }
        }

        redirectToWebViewButton.setOnClickListener {
            navigateToWebViewFragment()
        }

        redirectToEmptyFragmentButton.setOnClickListener {
            navigateToEmptyFragment()
        }
        redirectToCloseAppAlertDialogButton.setOnClickListener {
            closeAppAlertDialogSetUp()
        }


    }

    private fun receivingArgsFragmentAlertDialogSetUp() {
        val alertDialogBuilder = AlertDialog
            .Builder(requireActivity())
        alertDialogBuilder.setTitle(getString(R.string.error))
        alertDialogBuilder.setMessage(getString(R.string.send_data_mandatory))
        alertDialogBuilder.setNeutralButton("OK") { _, _ ->
        }
        val alertDialog: AlertDialog = alertDialogBuilder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    private fun closeAppAlertDialogSetUp() {
        val alertDialogBuilder = AlertDialog
            .Builder(requireActivity())
        alertDialogBuilder.setTitle("Exit")
        alertDialogBuilder.setMessage("Do you want to close this app?")
        alertDialogBuilder.setPositiveButton("Yes") { _, _ ->

        }
        alertDialogBuilder.setNegativeButton("No") { _, _ ->

        }
        val alertDialog: AlertDialog = alertDialogBuilder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()

    }

    private fun navigateToReceivingArgsFragment() {
        binding.root.findNavController().navigate(
            MainFragmentDirections.actionMainFragmentToReceivingArgsFragment(
                dataToReceivingArgsFragment.text.toString()
            )
        )
    }

    private fun navigateToWebViewFragment() {
        binding.root.findNavController().navigate(
            MainFragmentDirections.actionMainFragmentToWebViewFragment()
        )
    }

    private fun navigateToEmptyFragment() {
        binding.root.findNavController().navigate(
            MainFragmentDirections.actionMainFragmentToEmptyFragment()
        )
    }

}


