package com.miu.foodieapp.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.miu.foodieapp.R
import com.miu.foodieapp.adapter.ViewPager2Adapter
import com.miu.foodieapp.databinding.ActivityMainBinding
import com.miu.foodieapp.ui.aboutme.AboutMeFragment
import com.miu.foodieapp.ui.blog.BlogFragment
import com.miu.foodieapp.ui.contact.ContactFragment
import com.miu.foodieapp.ui.mealplanner.MealPlannerFragment
import com.miu.foodieapp.ui.recipe.RecipeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentList: List<Fragment>
    private lateinit var correspondingTabList: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fragmentList = listOf(
            RecipeFragment(),
            MealPlannerFragment(),
            BlogFragment(),
            ContactFragment(),
            AboutMeFragment()
        )
        correspondingTabList = listOf(
            "Recipe",
            "Meal Planner",
            "Blogs",
            "Contact",
            "About Me"
        )
        bindViewPagerAndTabLayout()
        setupBottomNavigation()
    }

    private fun bindViewPagerAndTabLayout() {
        val viewPager2 = binding.viewPager2
        val tabLayout = binding.tabLayout

        val adapter = ViewPager2Adapter(fragmentList, this)
        viewPager2.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager2) {tab, position ->
            tab.text = correspondingTabList[position]
        }.attach()
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigationView2.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_recipe -> binding.viewPager2.currentItem = 0
                R.id.navigation_meal_planner -> binding.viewPager2.currentItem = 1
                R.id.navigation_blogs -> binding.viewPager2.currentItem = 2
            }
            true
        }

        //bind tabLayout and bottomNav selection
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                if(tab.position<3){
                    binding.viewPager2.currentItem = tab.position
                    binding.bottomNavigationView2.selectedItemId = binding.bottomNavigationView2.menu.getItem(tab.position).itemId
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
}