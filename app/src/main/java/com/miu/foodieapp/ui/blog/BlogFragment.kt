package com.miu.foodieapp.ui.blog

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.miu.foodieapp.R
import com.miu.foodieapp.adapter.BlogAdapter
import com.miu.foodieapp.databinding.FragmentBlogBinding
import com.miu.foodieapp.model.Blog
import java.util.prefs.AbstractPreferences

class BlogFragment : Fragment() {

    private lateinit var binding: FragmentBlogBinding

    private val blogList = ArrayList<Blog>(listOf(
        Blog(
            "Exciting Discoveries in Science",
            "Albert Einstein",
            "Recent breakthroughs in quantum physics have opened up new possibilities for understanding the nature of reality. Scientists are exploring the potential applications of these discoveries in various fields."
        ),
        Blog(
            "The Art of Cooking",
            "Julia Child",
            "Exploring the culinary world has always been a fascinating journey. In this blog, we'll dive into the intricacies of French cuisine and how to master the art of creating delicious and authentic dishes."
        ),
        Blog(
            "Traveling Through Time and Space",
            "Doctor Who",
            "Join me on an extraordinary journey through time and space. We'll explore different dimensions, encounter fascinating civilizations, and uncover the mysteries of the universe. Get ready for an adventure of a lifetime!"
        ),
        Blog(
            "The Future of Technology",
            "Elon Musk",
            "As technology continues to advance at an unprecedented pace, we'll discuss the potential impact on various industries. From space exploration to artificial intelligence, the future holds exciting possibilities."
        ),
        Blog(
            "A Glimpse into Nature's Wonders",
            "Jane Goodall",
            "Nature has always been a source of inspiration and awe. In this blog, we'll explore the wonders of the animal kingdom, conservation efforts, and the delicate balance that sustains life on our planet."
        )
    ))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlogBinding.inflate(layoutInflater)

        val recyclerView = binding.blogRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = BlogAdapter(blogList)
        recyclerView.adapter = adapter

        binding.btnAddNewBlogPost.setOnClickListener { addNewBlogPostClicked(adapter) }

        return binding.root
    }

    private fun addNewBlogPostClicked(blogAdapter: BlogAdapter) {
        val addBlogFormBuilder = AlertDialog.Builder(requireContext())
        addBlogFormBuilder.setTitle("Add new blog post")
        val addBlogFormView = layoutInflater.inflate(R.layout.add_blog_form, null)
        addBlogFormBuilder.setView(addBlogFormView)

        addBlogFormBuilder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }

        addBlogFormBuilder.setPositiveButton("Save") { dialog, _ ->
            val sharedPreferences = requireContext().getSharedPreferences("LoggedInUserPreferences", Context.MODE_PRIVATE)

            val authorName = sharedPreferences.getString("displayName", "Anonymous")
            val title = addBlogFormView.findViewById<EditText>(R.id.newBlogTitle).text.toString()
            val content = addBlogFormView.findViewById<EditText>(R.id.newBlogContent).text.toString()

            val newBlog = Blog(
                title,
                authorName,
                content
            )

            blogList.add(newBlog)
            blogAdapter.notifyDataSetChanged()
            dialog.dismiss()

            Toast.makeText(
                requireContext(),
                "Blog added successfully",
                Toast.LENGTH_SHORT
            ).show()
        }

        val blogDialog = addBlogFormBuilder.create()
        blogDialog.show()
    }

}