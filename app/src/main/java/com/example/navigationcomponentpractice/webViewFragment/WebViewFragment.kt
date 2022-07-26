package com.example.navigationcomponentpractice.webViewFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponentpractice.R
import com.example.navigationcomponentpractice.databinding.FragmentWebViewBinding

class WebViewFragment : Fragment() {

    private lateinit var binding: FragmentWebViewBinding
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        webViewFragmentOnBackHandling()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWebViewBinding.inflate(inflater, container, false)
        webViewSetUp()
        return binding.root
    }

    private fun webViewFragmentOnBackHandling() {
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (webView.canGoBack()) {
                        webView.goBack()
                    } else {
                        findNavController().popBackStack(R.id.mainFragment, false)
                    }
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    private fun webViewSetUp() {
        webView = binding.wvGoogle
        webView.webViewClient = WebViewClient()
        webView.loadUrl(getString(R.string.web_view_URL))
        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)
    }
}