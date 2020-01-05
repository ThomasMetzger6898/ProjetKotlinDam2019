package com.example.projetkotlindam2019.activity


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.projetkotlindam2019.R
import com.example.projetkotlindam2019.classes.Car


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


                startActivity(Intent(this, MainPageActivity::class.java))
                finish()


            }


        }
    }
}
