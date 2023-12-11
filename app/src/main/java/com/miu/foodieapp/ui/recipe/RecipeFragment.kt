package com.miu.foodieapp.ui.recipe

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.miu.foodieapp.R
import com.miu.foodieapp.adapter.RecipeAdapter
import com.miu.foodieapp.databinding.FragmentRecipeBinding
import com.miu.foodieapp.model.Recipe

class RecipeFragment : Fragment() {

    private lateinit var binding: FragmentRecipeBinding

    private val recipeList = ArrayList<Recipe>(listOf(
        Recipe(
            "Classic Cheese Pizza",
            "Simple Classic Cheese Pizza recipe perfect for every occasion.",
            """1 ball Artisan Pizza Dough
                |All-purpose flour, for dusting
                |Semolina flour, for dusting
                |¼ cup Basic Pizza Sauce (recipe follows)
                |3 ounces shredded low-moisture mozzarella
                |Fresh basil or oregano leaves, for garnishing""".trimMargin(),
            """Step1: Remove the artisan pizza dough from the refrigerator and let it stand at room temperature for 1 to 2 hours, or until it's cool but not cold. Press the dough on a heavily floured surface, leaving a 1/2-inch border.
                |Step2: Preheat your home oven to 500°F with a baking steel or large round cast-iron pizza pan on the middle rack. Let the pan preheat in the oven for about 30 minutes. For an outdoor pizza oven, follow the manufacturer's instructions to preheat the oven and pizza stone on high for 20 minutes.
                |Step3: Create a 1/2-inch wide ring around the edge of the dough by pressing firmly with the outer edge of your hand. Gently stretch the dough into a 10-inch circle, maintaining a slightly thicker outer ring. Place the shaped dough on a semolina-dusted pizza peel.
                |Step4: Spread a layer of Basic Pizza Sauce over the dough and evenly distribute shredded low-moisture mozzarella on top.
                |Step5: Carefully transfer the pizza to the preheated pan in your home oven or onto the stone in the outdoor pizza oven. If using a home oven, bake at 500°F for about 3 minutes until the crust edges puff slightly. Rotate the pan, increase the oven temperature to broil, and broil for an additional 3 to 6 minutes until the pizza is cooked through and the crust is browned.
                |Step6: For an outdoor pizza oven, use the peel to rotate the pizza 90 degrees every 20 to 30 seconds until the pizza is cooked through with a risen and charred crust in spots, typically 2 to 4 minutes.
                |Step7: Transfer the cooked pizza to a cutting board using the peel. Garnish with fresh basil or oregano if desired, then cut into wedges.
                |Step8: Serve your delicious classic cheese pizza and enjoy!""".trimMargin(),
            R.drawable.pizza,
            "30 min"
        ),
        Recipe(
            "Creamy Alfredo Pasta",
            "Indulge in the rich and satisfying flavors of creamy Alfredo pasta.",
            """1 tablespoon olive oil
                |2 cloves garlic, minced
                |1 can (7.6 fluid ounces) NESTLÉ® Media Crema
                |1/2 cup whole milk
                |3/4 cup (3 ounces) grated Parmesan cheese
                |1/2 pound fettuccini pasta or pasta of your choice
                |Freshly ground black pepper, to taste
                |Chopped parsley for garnish""".trimMargin(),
            """Step1: Cook the pasta according to the package instructions. Drain and set aside.
                |Step2: In a medium saucepan, heat olive oil over medium-low heat. Add minced garlic and sauté for about 1 minute until fragrant.
                |Step3: Reduce the heat to low. Stir in NESTLÉ Media Crema and milk. Season with a pinch of salt and freshly ground black pepper.
                |Step4: Bring the sauce to a gentle boil, then add the grated Parmesan cheese. Stir occasionally and cook for 2 minutes or until the sauce thickens.
                |Step5: Serve the creamy Alfredo sauce over hot cooked pasta. Garnish with chopped parsley.
                |Step6: Enjoy your delicious and creamy Alfredo pasta!""".trimMargin(),
            R.drawable.pasta,
        "25 min"
        ),
        Recipe(
            "Classic Beef Burger",
            "A delicious and juicy classic beef burger recipe that everyone will love.",
            """1 pound ground beef
                |1 teaspoon salt
                |1/2 teaspoon black pepper
                |4 hamburger buns
                |4 slices cheddar cheese
                |Lettuce, tomato, onion, and pickles for garnish
                |Ketchup and mustard for condiments""".trimMargin(),
            """Step1: Preheat your grill or stovetop griddle over medium-high heat.
                |Step2: Divide the ground beef into 4 equal portions and shape them into burger patties. Season each patty with salt and pepper.
                |Step3: Place the burger patties on the hot grill or griddle. Cook for about 4-5 minutes per side for medium doneness, adjusting the time based on your preference.
                |Step4: In the last minute of cooking, add a slice of cheddar cheese on top of each patty and cover to melt the cheese.
                |Step5: Toast the hamburger buns on the grill for a minute or until they are golden brown.
                |Step6: Assemble the burgers by placing each patty on a bun. Add lettuce, tomato, onion, and pickles as desired. Spread ketchup and mustard on the top bun.
                |Step7: Serve the burgers hot and enjoy!""".trimMargin(),
            R.drawable.burger,
            "20 min"
        ),
        Recipe(
            "Crispy Homemade French Fries",
        "Make perfectly crispy and golden homemade French fries with this easy recipe.",
                """4 large potatoes, peeled and cut into matchsticks
                    |Vegetable oil for frying
                    |Salt to taste
                    |Optional: Ketchup or mayonnaise for dipping""".trimMargin(),
                """Step1: Rinse the cut potatoes in cold water to remove excess starch. Pat them dry with a clean kitchen towel or paper towels.
                    |Step2: In a large, deep pan or deep fryer, heat vegetable oil to 350°F (175°C).
                    |Step3: Carefully add the potato matchsticks to the hot oil in batches, ensuring not to overcrowd the pan. Fry until they are golden brown and crispy, about 3-4 minutes per batch.
                    |Step4: Using a slotted spoon or tongs, remove the fries from the oil and place them on a plate lined with paper towels to absorb excess oil.
                    |Step5: Season the hot fries with salt immediately after removing them from the oil. Toss them to ensure even coating.
                    |Step6: Repeat the frying process with the remaining batches of potatoes.
                    |Step7: Serve the crispy French fries hot as is or with ketchup or mayonnaise for dipping.
                    |Step8: Enjoy your homemade French fries!""".trimMargin(),
                R.drawable.french_fries,
                "25 min"
        )
    ))

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipeBinding.inflate(inflater, container, false)

        val recipeRecyclerView = binding.recipeRecyclerView
        recipeRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val recipeAdapter = RecipeAdapter(requireContext(), recipeList)
        recipeRecyclerView.adapter = recipeAdapter

        binding.btnAddNewRecipe.setOnClickListener { addNewRecipeClicked(recipeAdapter) }

        return binding.root
    }

    private fun addNewRecipeClicked(recipeAdapter: RecipeAdapter) {
        val addRecipeFormBuilder = AlertDialog.Builder(requireContext())
        addRecipeFormBuilder.setTitle("Add new recipe")
        val addRecipeFormView = layoutInflater.inflate(R.layout.add_recipe_form, null)
        addRecipeFormBuilder.setView(addRecipeFormView)

        addRecipeFormBuilder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }

        addRecipeFormBuilder.setPositiveButton("Save") { dialog, _ ->
            val newRecipeName = addRecipeFormView.findViewById<EditText>(R.id.newRecipeName).text.toString()
            val newRecipeDescription = addRecipeFormView.findViewById<EditText>(R.id.newRecipeDescription).text.toString()
            val newRecipeIngredients = addRecipeFormView.findViewById<EditText>(R.id.newRecipeIngredients).text.toString()
            val newRecipeInstructions = addRecipeFormView.findViewById<EditText>(R.id.newRecipeInstructions).text.toString()
            val newRecipeCookTime = addRecipeFormView.findViewById<EditText>(R.id.newRecipeCookTime).text.toString()
            recipeList.add(
                Recipe(
                    newRecipeName,
                    newRecipeDescription,
                    newRecipeIngredients,
                    newRecipeInstructions,
                    R.drawable.no_image,
                    newRecipeCookTime
                )
            )
            dialog.dismiss()
            recipeAdapter.notifyDataSetChanged()
            Toast.makeText(
                requireContext(),
                "Recipe for $newRecipeName added successfully",
                Toast.LENGTH_SHORT
            ).show()
        }

        val recipeDialog = addRecipeFormBuilder.create()
        recipeDialog.show()
    }
}