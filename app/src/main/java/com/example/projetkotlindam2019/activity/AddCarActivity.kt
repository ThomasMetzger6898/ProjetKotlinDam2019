package com.example.projetkotlindam2019.activity


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.projetkotlindam2019.R
import com.example.projetkotlindam2019.classes.Car
import com.example.projetkotlindam2019.ui.home.HomeFragment
import com.example.projetkotlindam2019.ui.slideshow.SlideshowFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.serialization.json.Json
import kotlinx.serialization.list
import org.json.JSONObject
import java.io.InputStream


class AddCarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_car)

        var list: ArrayList<Car> = ArrayList<Car>()
        val intent = intent
        if (intent != null) {
            if (intent.hasExtra("pos")) {
                list = intent.getParcelableArrayListExtra("list")
            }

            var myCar: Car

            val nomEdit: EditText = findViewById(R.id.et_nom)
            val nomCar: String = nomEdit.text.toString()

            val anneeEdit: EditText = findViewById(R.id.et_annee)
            val anneeCar: String = anneeEdit.text.toString()

            val consoEdit: EditText = findViewById(R.id.et_conso)
            val consoCar: String = consoEdit.text.toString()

            val cvEdit: EditText = findViewById(R.id.et_cv)
            val cvCar: String = cvEdit.text.toString()

            val origineEdit: EditText = findViewById(R.id.et_origine)
            val origineCar: String = origineEdit.text.toString()

            val poidEdit: EditText = findViewById(R.id.et_poid)
            val poidCar: String = poidEdit.text.toString()

            val vitmaxEdit: EditText = findViewById(R.id.et_vitmax)
            val vitmaxCar: String = vitmaxEdit.text.toString()

            val zeroAcentEdit: EditText = findViewById(R.id.et_zeroAcent)
            val zeroAcentCar: String = zeroAcentEdit.text.toString()

            myCar = Car(nomCar, origineCar, R.drawable.ic_img2, anneeCar, consoCar, vitmaxCar, cvCar, poidCar, zeroAcentCar)
            list.add(myCar)


            val btnAjoute: Button = findViewById(R.id.btn_ajouter)
            btnAjoute.setOnClickListener {
                /*val intent = Intent(this,SlideshowFragment::class.java)
            intent.putExtra("car",myCar )
            startActivity(intent)*/


                /*val fragobj = SlideshowFragment()
                val bundle = Bundle()
                bundle.putParcelable("car", myCar)
                fragobj.arguments = bundle
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.nav_host_fragment, fragobj)
                transaction.commit()*/



                var json: String? = null


                val inputStream: InputStream = this.assets.open("bdd_json.json")
                json = inputStream.bufferedReader().use { it.readText() }

                var carListSerialised = Json.stringify(Car.serializer().list,list)
                val obj = JSONObject()
                var jsonObject = JSONObject(obj.get("bdd_json.json").toString())
                jsonObject.remove("bdd_json.json")
                jsonObject.put("bdd_json.json",carListSerialised)

                startActivity(Intent(this,HomeFragment::class.java))

            }


        }
    }
}
