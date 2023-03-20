package com.example.retrofitapp.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.retrofitapp.Popular_Movies
import com.example.retrofitapp.Toprated_Movie
import com.example.retrofitapp.Upcoming_Movies
import com.example.retrofitapp.R
import com.example.retrofitapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Popular_Movies())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.popularMenu -> replaceFragment(Popular_Movies())
                R.id.topratedMenu -> replaceFragment(Toprated_Movie())
                R.id.upcomingMenu -> replaceFragment(Upcoming_Movies())
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