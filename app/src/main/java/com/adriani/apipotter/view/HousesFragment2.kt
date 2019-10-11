package com.adriani.apipotter.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.adriani.apipotter.R



/**
 * A simple [Fragment] subclass.
 *
 */
class HousesFragment2 : Fragment() {

    companion object{
        fun newInstance():HousesFragment2 = HousesFragment2()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_houses, container, false)
    }


}
