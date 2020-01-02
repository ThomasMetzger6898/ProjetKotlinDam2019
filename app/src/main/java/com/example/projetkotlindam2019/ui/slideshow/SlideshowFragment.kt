package com.example.projetkotlindam2019.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.example.projetkotlindam2019.R
import com.example.projetkotlindam2019.classes.Car
import com.example.projetkotlindam2019.classes.CarList
import com.example.projetkotlindam2019.classes.MercedesCardAdapter

import org.json.JSONArray
import java.io.InputStream

class SlideshowFragment : Fragment() {
    var arr = arrayListOf<String>()

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


        var json : String? = null


        val inputStream : InputStream = mView.context.assets.open("bdd_json.json")
        json = inputStream.bufferedReader().use { it.readText()}

        var jsonarr = JSONArray(json)
        val array : ArrayList<Car> = ArrayList<Car>()

        for (i in 0..jsonarr.length()-1){
            var jsonobj = jsonarr.getJSONObject(i)
            val car = Car( (jsonobj.getString("Nom")),(jsonobj.getString("Origine")),(jsonobj.getInt("Chevaux")))
            array.add(car)
        }

        adapter = MercedesCardAdapter(array)
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