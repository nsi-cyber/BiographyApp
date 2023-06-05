package com.nsicyber.biographyapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.google.android.material.tabs.TabLayoutMediator
import com.nsicyber.biographyapp.adapter.ViewPagerAdapter
import com.nsicyber.biographyapp.databinding.ActivityMainBinding
import com.nsicyber.biographyapp.fragments.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Tablar için adapter oluşturun ve ViewPager'a ayarlayın
        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        adapter.addFragment(HomeFragment())
        adapter.addFragment(GalleryFragment())
        adapter.addFragment(BlogFragment())
        adapter.addFragment(AboutMeFragment())
        adapter.addFragment(ContactFragment())
        binding.viewPager.adapter = adapter

        //TabLayout'a fragmentları ekleyerek tabların oluşturulması
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Home"
                1 -> tab.text = "Gallery"
                2 -> tab.text = "Blog"
                3 -> tab.text = "About Me"
                4 -> tab.text = "Contact"
            }
        }.attach()




    }


}