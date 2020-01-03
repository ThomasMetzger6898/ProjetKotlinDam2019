package com.example.projetkotlindam2019.ui.gallery

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.projetkotlindam2019.R
import com.example.projetkotlindam2019.classes.Car
import kotlinx.android.synthetic.main.fragment_gallery.*
import org.json.JSONArray
import java.io.InputStream

import kotlinx.android.synthetic.main.activity_main.*
import android.widget.AdapterView
import android.widget.ArrayAdapter


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

        galleryViewModel.text.observe(this, Observer {

        })

        var json : String? = null


        val inputStream : InputStream = root.context.assets.open("bdd_json.json")
        json = inputStream.bufferedReader().use { it.readText()}

        var jsonarr = JSONArray(json)
        val array : ArrayList<Car> = ArrayList<Car>()
        val imageArray = listOf(R.drawable.ic_img1,R.drawable.ic_image10,R.drawable.ic_image11,R.drawable.ic_image3,R.drawable.ic_image4,R.drawable.ic_image5,R.drawable.ic_image6,R.drawable.ic_image7,R.drawable.ic_image8,R.drawable.ic_image9)

        for (i in 0..jsonarr.length()-1){
            var jsonobj = jsonarr.getJSONObject(i)
            //val car = Car( (jsonobj.getString("Nom")),(jsonobj.getString("Origine")), imageArray[i],(jsonobj.getDouble("Consomation")),(jsonobj.getInt("Vitesse_maximum")),(jsonobj.getInt("Chevaux")),(jsonobj.getInt("Poids")),(jsonobj.getDouble("0_a_100")),(jsonobj.getInt("Année")))
            val car = Car( (jsonobj.getString("Nom")),(jsonobj.getString("Origine")), imageArray[i],(jsonobj.getString("Année")),(jsonobj.getString("Consomation")),(jsonobj.getString("Vitesse_maximum")),(jsonobj.getString("Chevaux")),(jsonobj.getString("Poids")),(jsonobj.getString("0_a_100")))
            array.add(car)
        }
        /*Find the id of spinner*/
        val spinner1 = root.findViewById<Spinner>(R.id.spinner1)
        val spinner2 = root.findViewById<Spinner>(R.id.spinner2)

        /*set an adapter with strings array*/
        spinner1.adapter = ArrayAdapter(context, R.layout.support_simple_spinner_dropdown_item,array ) as SpinnerAdapter?
        spinner2.adapter = ArrayAdapter(context, R.layout.support_simple_spinner_dropdown_item,array ) as SpinnerAdapter?



        // Set an on item selected listener for spinner object
        spinner1.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent:AdapterView<*>, view: View, position: Int, id: Long){
                // Display the selected item text on text view
             //   text_view.text = "Spinner selected : ${parent.getItemAtPosition(position).toString()}"
                nomv1.text = array[position].nom
                cv1.text = array[position].nom
            }
            override fun onNothingSelected(parent: AdapterView<*>){
                // Another interface callback
            }
        }

        spinner2.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent:AdapterView<*>, view: View, position: Int, id: Long){
                // Display the selected item text on text view
                //   text_view.text = "Spinner selected : ${parent.getItemAtPosition(position).toString()}"
                nomv2.text = array[position].nom
                cv2.text = array[position].nom
            }
            override fun onNothingSelected(parent: AdapterView<*>){
                // Another interface callback
            }
        }

            return root
    }
}
