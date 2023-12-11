package com.miu.foodieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.miu.foodieapp.R
import com.miu.foodieapp.model.MealPlan
import java.time.format.DateTimeFormatter

class MealPlanAdapter(private val mealPlanList: List<MealPlan>) :
    RecyclerView.Adapter<MealPlanAdapter.MealPlanViewHolder>() {

    class MealPlanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mealPlanItemDate: TextView = itemView.findViewById(R.id.mealPlanItemDate)
        val mealPlanItemBreakfast: TextView = itemView.findViewById(R.id.mealPlanItemBreakfast)
        val mealPlanItemLunch: TextView = itemView.findViewById(R.id.mealPlanItemLunch)
        val mealPlanItemDinner: TextView = itemView.findViewById(R.id.mealPlanItemDinner)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealPlanViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.meal_plan_list_item, parent, false)
        return MealPlanViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealPlanViewHolder, position: Int) {
        val mealPlan = mealPlanList[position]

        val formattedDate = mealPlan.mealDateTime.format(DateTimeFormatter.ofPattern("E\nMM/dd"))

        holder.mealPlanItemDate.text = formattedDate
        holder.mealPlanItemBreakfast.text = "Breakfast: ${mealPlan.breakfast}"
        holder.mealPlanItemLunch.text = "Lunch: ${mealPlan.lunch}"
        holder.mealPlanItemDinner.text = "Dinner: ${mealPlan.dinner}"
    }

    override fun getItemCount(): Int {
        return mealPlanList.size
    }
}
