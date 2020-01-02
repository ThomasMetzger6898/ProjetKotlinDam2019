package com.example.projetkotlindam2019.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.projetkotlindam2019.R
import com.example.projetkotlindam2019.classes.CustomView

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)*/
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        var customView: CustomView = root.findViewById(R.id.customView)
        /*homeViewModel.value.observe(this, Observer {
            val res = it
            customView.array = it.array
        })*/

        return root
    }
}