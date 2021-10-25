package com.marcelo.filmekotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.marcelo.filmecoroutineskoin.R
import com.marcelo.filmekotlincoroutines.ui.fragment.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            replaceFragment(MainFragment())
        }
    }
}

fun AppCompatActivity.replaceFragment(fragment: Fragment){
    val fragmentManager = supportFragmentManager
    val transaction = fragmentManager.beginTransaction()
    transaction.replace(R.id.container,fragment)
    transaction.commit()
}