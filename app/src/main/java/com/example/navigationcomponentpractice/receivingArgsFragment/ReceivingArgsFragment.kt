package com.example.navigationcomponentpractice.receivingArgsFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.navigationcomponentpractice.databinding.FragmentReceivingArgsBinding


class ReceivingArgsFragment : Fragment() {

    private lateinit var binding: FragmentReceivingArgsBinding
    private lateinit var dataFromMainFragment: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReceivingArgsBinding.inflate(inflater, container, false)
        setUpViewLogic()
        return binding.root
    }

    private fun setUpViewLogic() {
        dataFromMainFragment = binding.tvDataFromMainActivity
        setUpTvDataFromMainActivity()
    }

    private fun setUpTvDataFromMainActivity() {
        val args = ReceivingArgsFragmentArgs.fromBundle(
            requireArguments()
        )
        dataFromMainFragment.text = args.dataToReceivingArgsFragment
    }
}