package com.example.projetkotlindam2019.ui.gallery

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.projetkotlindam2019.R
import com.example.projetkotlindam2019.activity.AddCarActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
            ViewModelProviders.of(this).get(GalleryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        val text: TextView = root.findViewById(R.id.text_galery)
        galleryViewModel.text.observe(this, Observer {
            text.text = it
        })

        /*val fab: FloatingActionButton = root.findViewById(R.id.fab)
        fab.hide()*/

        return root
    }
}