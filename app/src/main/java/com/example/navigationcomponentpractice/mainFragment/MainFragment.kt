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

        redirectToReceivingArgsFragmentBtn.setOnClickListener {
            if (dataToReceivingArgsFragment.text.toString().isEmpty()) {
                //Implementing alert dialog if etDataToReceivingArgsFragment is empty
                alertDialogSetUp()
            } else {
                //Or redirecting to fragment 3 with an argument otherwise
                navigateToReceivingArgsFragment()
            }
        }

        redirectToWebViewButton.setOnClickListener {
            navigateToWebViewFragment()
        }
    }

    private fun alertDialogSetUp() {
        val alertDialogBuilder = AlertDialog
            .Builder(requireActivity())
        //setting title for the alert dialog
        alertDialogBuilder.setTitle(getString(R.string.error))
        //setting message for the alert dialog
        alertDialogBuilder.setMessage(getString(R.string.sendDataMandatory))
        //setting OK button for the alter dialog
        alertDialogBuilder.setNeutralButton("OK") { _, _ ->
        }
        //creating the alert dialog
        val alertDialog: AlertDialog = alertDialogBuilder.create()
        alertDialog.setCancelable(false)
        //showing alert dialog
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
}


