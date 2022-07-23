package com.example.navigationcomponentpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationcomponentpractice.databinding.Fragment3Binding

class Fragment3 : Fragment() {

    private lateinit var binding: Fragment3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = Fragment3Binding.inflate(inflater, container, false)

        val args = Fragment3Args.fromBundle(requireArguments())
        binding.tvDataFromMainActivity.text = args.dataToFragment3

        // Inflate the layout for this fragment
        return binding.root
    }
}