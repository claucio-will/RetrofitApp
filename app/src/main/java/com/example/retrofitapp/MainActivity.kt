package com.example.retrofitapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationroom.viewmodel.PostViewModel
import com.example.retrofitapp.adapter.PostAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var postViewModel: PostViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter
    private lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = findViewById(R.id.text_error)

        postViewModel = ViewModelProvider(this)[PostViewModel::class.java]

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        postAdapter = PostAdapter()
        recyclerView.adapter = postAdapter

        postViewModel.posts.observe(this, Observer {
            postAdapter.setPosts(it)
        })

        postViewModel.errorMessage.observe(this, Observer {
            text.text = postViewModel.errorMessage.value
        })

        postViewModel.getPosts()
    }
}