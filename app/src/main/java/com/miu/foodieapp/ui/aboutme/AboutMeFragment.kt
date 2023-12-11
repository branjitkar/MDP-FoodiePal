package com.miu.foodieapp.ui.aboutme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.miu.foodieapp.R
import com.miu.foodieapp.databinding.FragmentAboutMeBinding

class AboutMeFragment : Fragment() {

    private lateinit var binding: FragmentAboutMeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutMeBinding.inflate(layoutInflater)

        val aboutMeContent = """👨‍🍳 Hey, I'm Bipul, your culinary buddy with a love for Nepali flavors. Raised on the aromas of spices, I bring a taste of Nepal to your table.

            |🍛 Imagine 'Himalayan Spice Bowl'—my take on a comforting meal. Packed with local spices, it's a warm hug on a plate, just like my mom used to make.
            
            |🌶️ I'm no fancy chef; I'm a home cook who loves experimenting. 'Kathmandu Curry Delight' is my go-to—a blend of local spices and rich flavors that takes me back to the streets of Nepal.
            
            |🏔️ Beyond the recipes, my kitchen is filled with laughter and the warmth of Nepali hospitality. For me, food is about sharing stories, creating connections, and celebrating our culture.
            
            |🍲 Let's keep it real and relatable. No complicated techniques—just the joy of authentic Nepali dishes. Join me on this flavorful journey, from 'Dal Bhat Power' to 'Mom's Momo Magic.'
            
            |🍛 Ready to dive into the world of Nepali delights? Let's cook up some memories together. 🍲✨""".trimMargin()

        binding.aboutMeContent.text = aboutMeContent

        return binding.root
    }
}