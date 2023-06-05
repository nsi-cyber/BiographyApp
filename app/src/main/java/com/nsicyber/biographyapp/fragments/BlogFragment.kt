package com.nsicyber.biographyapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import com.google.android.material.card.MaterialCardView
import com.nsicyber.biographyapp.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlogFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var twitterCard: MaterialCardView
    lateinit var linkedinCard: MaterialCardView
    lateinit var instagramCard: MaterialCardView
    lateinit var githubCard: MaterialCardView
    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_blog, container, false)


        with(view){
            twitterCard=findViewById(R.id.twitter)
            linkedinCard=findViewById(R.id.linkedin)
            instagramCard=findViewById(R.id.instagram)
            githubCard=findViewById(R.id.github)
            webView=findViewById(R.id.webView)
        }
        webView.settings.javaScriptEnabled=true


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webView.loadUrl("https://twitter.com/childisheness")
        twitterCard.setOnClickListener {
            webView.loadUrl("https://twitter.com/childisheness")
        }
        linkedinCard.setOnClickListener {
            webView.loadUrl("https://www.linkedin.com/in/nsi-cyber/")
        }
        instagramCard.setOnClickListener {
            webView.loadUrl("https://www.instagram.com/childisheness/")
        }
        githubCard.setOnClickListener {
            webView.loadUrl("https://github.com/nsi-cyber")
        }

    }

}