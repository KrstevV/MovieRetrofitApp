package com.example.retrofitapp.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.retrofitapp.PopularMovies
import com.example.retrofitapp.TopratedMovie
import com.example.retrofitapp.UpcomingMovies
import com.example.retrofitapp.R
import com.example.retrofitapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(PopularMovies())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.popularMenu -> replaceFragment(PopularMovies())
                R.id.topratedMenu -> replaceFragment(TopratedMovie())
                R.id.upcomingMenu -> replaceFragment(UpcomingMovies())
            }
           true

        }
    }
    private fun replaceFragment(fragment : Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layour, fragment)
        fragmentTransaction.commit()

    }

}