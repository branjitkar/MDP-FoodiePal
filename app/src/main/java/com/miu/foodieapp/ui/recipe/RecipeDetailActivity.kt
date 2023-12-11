package com.miu.foodieapp.ui.recipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.miu.foodieapp.databinding.ActivityRecipieDetailBinding
import com.miu.foodieapp.model.Recipe

class RecipeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecipieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recipe = intent.getSerializableExtra("recipe") as Recipe;

        binding.recipeDetailName.text = recipe.name
        binding.recipeDetailDescription.text = recipe.description
        binding.recipeDetailIngredients.text = recipe.ingredients
        binding.recipeDetailInstructions.text = recipe.instructions
        binding.recipeDetailCookTime.text = recipe.cookingTime

    }
}