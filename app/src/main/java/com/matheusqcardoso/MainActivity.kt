package com.matheusqcardoso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.matheusqcardoso.fragments.ListsFragment
import com.matheusqcardoso.fragments.UserFragment

class MainActivity : AppCompatActivity() {
    //FRAGMENTS
    private val userFragment : Fragment = UserFragment()
    private val listsFragment : Fragment = ListsFragment()

    //BOTTOM_BAR
    private val bottomBar : BottomNavigationView = findViewById(R.id.bottom_bar)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //INIT
        changeFragment(userFragment)

        //BOTTOM_BAR: APPLY LISTENER FOR ITEM SELECTED
        bottomBar.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.bottom_bar_item_user -> changeFragment(userFragment)
                R.id.bottom_bar_item_lists -> changeFragment(listsFragment)
            }
            true
        }
    }

    //REPLACE THE CONTENT OF  FRAGMENT_VIEW FROM MAINACTIVITY FOR THE CURRENT FRAGMENT
    private fun changeFragment(f : Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_view, f)
            commit()
        }
    }
}