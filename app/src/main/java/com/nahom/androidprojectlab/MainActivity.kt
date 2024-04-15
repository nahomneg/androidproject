package com.nahom.androidprojectlab

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.nahom.androidprojectlab.ui.AboutFragment
import com.nahom.androidprojectlab.ui.AthletesFragment
import com.nahom.androidprojectlab.ui.Sports
import com.nahom.androidprojectlab.ui.dashboard.EventsFragment
import com.nahom.androidprojectlab.ui.home.NewsFragment
import com.nahom.androidprojectlab.ui.notifications.HistoricalFragment

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.view_pager)
        tabLayout = findViewById(R.id.tab_layout)

        setupViewPager(viewPager)
        tabLayout.setupWithViewPager(viewPager)

        // Set icons for bottom navigation
        val bottomNavMenu = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNavMenu.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_news -> {
                    viewPager.currentItem = 0
                    true
                }
                R.id.navigation_events -> {
                    viewPager.currentItem = 2
                    true
                }
                R.id.navigation_historical -> {
                    viewPager.currentItem = 3
                    true
                }
                else -> false
            }
        }
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(NewsFragment(), "News")
        adapter.addFragment(Sports(), "Sports")

        adapter.addFragment(EventsFragment(), "Events")
        adapter.addFragment(HistoricalFragment(), "Historical Archives")
        adapter.addFragment(AthletesFragment(), "Athletes")
        adapter.addFragment(AboutFragment(), "About")

        viewPager.adapter = adapter
    }
}

class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragmentList: MutableList<Fragment> = ArrayList()
    private val fragmentTitleList: MutableList<String> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitleList[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        fragmentTitleList.add(title)
    }
}
