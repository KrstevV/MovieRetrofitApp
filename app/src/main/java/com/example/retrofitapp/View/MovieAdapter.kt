package com.example.retrofitapp.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitapp.Model.MoviesData
import com.example.retrofitapp.R


class MovieAdapter (var list : List<MoviesData>) : RecyclerView.Adapter<MovieAdapter.ViewHolder> () {

    private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        var titleMoive = view.findViewById<TextView>(R.id.titleMovie)
        var dateMovie = view.findViewById<TextView>(R.id.dateMovie)
        var imgMovie = view.findViewById<ImageView>(R.id.imageMovie)

    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var moviesPosition = list[position]
        holder.titleMoive.text = moviesPosition.title
        holder.dateMovie.text = moviesPosition.date
        Glide.with(holder.itemView).load(IMAGE_BASE + moviesPosition.img).into(holder.imgMovie)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setMovies(movie : List<MoviesData>) {
        this.list = movie
        notifyDataSetChanged()
    }


}