package com.adriani.apipotter.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.adriani.apipotter.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity2 : AppCompatActivity() {

    private var fragment1:HousesFragment2? = null
    private var fragment2:CharactersFragmet2? = null
    private var fragment3:SpellsFragment2? = null
    private var fm:FragmentManager = supportFragmentManager
    private var active:Fragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setDefaultFragment()

        navigationBar.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_house -> {
                    if(fragment1 == null){
                        fragment1 = HousesFragment2.newInstance()
                        fm.beginTransaction().add(R.id.main_fragment, fragment1!!, "1").hide(active!!).commit()
                    }
                    fm.beginTransaction().hide(active!!).show(fragment1!!).commit()
                    active = fragment1!!
                    true
                }
                R.id.action_charactaers -> {
                    fm.beginTransaction().hide(active!!).show(fragment2!!).commit()
                    active = fragment2!!
                    true
                }
                R.id.action_spells -> {
                    if(fragment3 == null){
                        fragment3 = SpellsFragment2.newInstance()
                        fm.beginTransaction().add(R.id.main_fragment, fragment3!!, "3").hide(active!!).commit()
                    }
                    fm.beginTransaction().hide(active!!).show(fragment3!!).commit()
                    active = fragment3!!
                    true
                }
                else -> false
            }
        }
    }

    private fun setDefaultFragment(){
        fragment2 = CharactersFragmet2.newInstance()
        fm.beginTransaction().replace(R.id.main_fragment, fragment2!!).commit()
        active = fragment2
        navigationBar.selectedItemId =  R.id.action_charactaers
    }
}
