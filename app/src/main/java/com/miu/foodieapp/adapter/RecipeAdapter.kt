package com.miu.foodieapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.miu.foodieapp.R
import com.miu.foodieapp.model.Recipe
import com.miu.foodieapp.ui.recipe.RecipeDetailActivity

class RecipeAdapter(private var context: Context,
                    private val recipeList: List<Recipe>)
    : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>(){

    class RecipeViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val recipeListItemCardView = itemView.findViewById<CardView>(R.id.recipeListItemCardView)
        val recipeListItemImage = itemView.findViewById<ImageView>(R.id.recipeListItemImage)
        val recipeListItemName = itemView.findViewById<TextView>(R.id.recipeListItemName)
        val recipeListItemDescription = itemView.findViewById<TextView>(R.id.recipeListItemDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_list_item, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeAdapter.RecipeViewHolder, position: Int) {
        val recipe = recipeList[position]
        holder.recipeListItemName.text = recipe.name
        holder.recipeListItemDescription.text = recipe.description
        holder.recipeListItemImage.setImageResource(recipe.image)
        holder.recipeListItemCardView.setOnClickListener {
            openRecipeActivity(recipe)
        }
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    private fun openRecipeActivity(recipe: Recipe) {
        val rIntent = Intent(context, RecipeDetailActivity::class.java)
        rIntent.putExtra("recipe", recipe)
        startActivity(context, rIntent, null)
    }
}