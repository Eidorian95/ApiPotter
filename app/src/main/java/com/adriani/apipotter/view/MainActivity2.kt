package com.adriani.apipotter.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.adriani.apipotter.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment()

        navigationBar.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_charactaers -> {
                    val fragment = CharactersFragmet2.newInstance()
                    openFragment(fragment)
                    true
                }
                R.id.action_house -> {
                    val fragment = HousesFragment2.newInstance()
                    openFragment(fragment)
                    true
                }
                R.id.action_spells -> {
                    val fragment = SpellsFragment2.newInstance()
                    openFragment(fragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_fragment, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun setFragment(){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_fragment, CharactersFragmet2.newInstance())
        transaction.addToBackStack(null)
        transaction.commit()

        navigationBar.selectedItemId =  R.id.action_charactaers
    }
}
