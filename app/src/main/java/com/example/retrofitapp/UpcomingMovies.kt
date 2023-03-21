package com.example.retrofitapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapp.View.MovieAdapter
import com.example.retrofitapp.ViewModel.MovieViewModel

class UpcomingMovies : Fragment() {

    lateinit var movieViewModel : MovieViewModel
    var movieAdapter = MovieAdapter(arrayListOf())
    lateinit var recView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        movieViewModel.getUpcomingMovies()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upcoming__movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recView = view.findViewById(R.id.recView)
        recView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = movieAdapter
        }
        recView.hasFixedSize()
        movieViewModel.movieUpcomingResponse.observe(viewLifecycleOwner, Observer { item ->

           item?.let {
               movieAdapter.setMovies(it)
           }
        })




    }
}