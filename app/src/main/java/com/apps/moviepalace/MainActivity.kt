package com.apps.moviepalace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.apps.moviepalace.adapter.RecyclerViewAdapter
import com.apps.moviepalace.model.Movie
import com.apps.moviepalace.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewAdapter: RecyclerViewAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViewModel()
        initViewModel()

    }
    private fun initializeViewModel(){
        recyclerView.apply{
             layoutManager = LinearLayoutManager(this@MainActivity)

            recyclerViewAdapter = RecyclerViewAdapter()
            adapter = recyclerViewAdapter

        }

    }
    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getMoviesList().observe(this, Observer<List<Movie>>{
            recyclerViewAdapter.setMovies(it)
            recyclerViewAdapter.notifyDataSetChanged()
        })

        viewModel.apiCall()
    }
}