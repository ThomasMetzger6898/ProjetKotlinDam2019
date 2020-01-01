package com.example.projetkotlindam2019.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetkotlindam2019.R
import com.example.projetkotlindam2019.classes.MercedesCardAdapter

class SlideshowFragment : Fragment() {

    private lateinit var mView: View
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<MercedesCardAdapter.ViewHolder>? = null
    private lateinit var slideshowViewModel: SlideshowViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mView = inflater.inflate(R.layout.fragment_slideshow, container, false)
        val rvMercedes = mView.findViewById(R.id.my_recycler_view) as RecyclerView


        slideshowViewModel =
            ViewModelProviders.of(this).get(SlideshowViewModel::class.java)
        /*slideshowViewModel.list.observe(this, Observer {
            print(it)
            adapter = MercedesCardAdapter(it)
            rvMercedes.layoutManager = LinearLayoutManager(mView.context)
            rvMercedes.adapter = adapter
        })*/

        adapter = MercedesCardAdapter(slideshowViewModel.getList())
        rvMercedes.layoutManager = LinearLayoutManager(mView.context)
        rvMercedes.adapter = adapter


        return mView


        /*val root = inflater.inflate(R.layout.fragment_slideshow, container, false)
        val textView: TextView = root.findViewById(R.id.text_slideshow)
        slideshowViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root*/
    }
}