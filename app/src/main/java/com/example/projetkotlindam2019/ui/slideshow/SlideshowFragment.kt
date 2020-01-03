package com.example.projetkotlindam2019.ui.slideshow

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
import com.example.projetkotlindam2019.R
import com.example.projetkotlindam2019.classes.Car
import com.example.projetkotlindam2019.classes.MercedesCardAdapter

import org.json.JSONArray
import java.io.InputStream

class SlideshowFragment : Fragment() {
    var arr = arrayListOf<String>()

    private lateinit var mView: View
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<MercedesCardAdapter.ViewHolder>? = null
    private lateinit var slideshowViewModel: SlideshowViewModel
    private lateinit var array : ArrayList<Car>

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
        //val array : ArrayList<Car> = ArrayList<Car>()
        array = ArrayList<Car>()
        val imageArray = listOf(R.drawable.ic_img1,R.drawable.ic_image10,R.drawable.ic_image11,R.drawable.ic_image3,R.drawable.ic_image4,R.drawable.ic_image5,R.drawable.ic_image6,R.drawable.ic_image7,R.drawable.ic_image8,R.drawable.ic_image9)

        for (i in 0..jsonarr.length()-1){
            var jsonobj = jsonarr.getJSONObject(i)
            //val car = Car( (jsonobj.getString("Nom")),(jsonobj.getString("Origine")), imageArray[i],(jsonobj.getString("Consomation")),(jsonobj.getInt("Vitesse_maximum")),(jsonobj.getInt("Chevaux")),(jsonobj.getInt("Poids")),(jsonobj.getString("0_a_100")),(jsonobj.getInt("Année")))
            val car = Car( (jsonobj.getString("Nom")),(jsonobj.getString("Origine")), imageArray[i],(jsonobj.getString("Année")),(jsonobj.getString("Consomation")),(jsonobj.getString("Vitesse_maximum")),(jsonobj.getString("Chevaux")),(jsonobj.getString("Poids")),(jsonobj.getString("0_a_100")))

            array.add(car)
        }

        if(arguments != null){
            val myCar : Car = arguments!!.getParcelable("car")
            //Log.d("",myCar)
            array.add(myCar)
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

    fun addItem(car : Car){
        array.add(car)
    }
}