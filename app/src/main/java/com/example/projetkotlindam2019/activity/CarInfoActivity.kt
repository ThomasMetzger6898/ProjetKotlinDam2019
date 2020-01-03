package com.example.projetkotlindam2019.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.projetkotlindam2019.R
import com.example.projetkotlindam2019.classes.Car
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.jetbrains.anko.toast
import org.w3c.dom.Text


class CarInfoActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carinfo)
        var pos: Int = 0
        var list: ArrayList<Car> = ArrayList<Car>()
        val intent = intent
        if (intent != null) {


            if (intent.hasExtra("pos")) {
                pos = intent.getIntExtra("pos", 0)
                list = intent.getParcelableArrayListExtra("list")
            }
            val image: ImageView = findViewById(R.id.imageCar)
            image.setImageResource(list[pos].image)

            val textName: TextView = findViewById(R.id.tv_name)
            textName.text = list[pos].nom

            val textOrigine: TextView = findViewById(R.id.tv_origine)
            textOrigine.text = list[pos].marque

            val textAnnee: TextView = findViewById(R.id.tv_year)
            textAnnee.text = list[pos].annee.toString()

            val textConso: TextView = findViewById(R.id.tv_conso)
            textConso.text = list[pos].conso

            val textVitMax: TextView = findViewById(R.id.tv_vitmax)
            textVitMax.text = list[pos].vitesse_maximum.toString()

            val textCv: TextView = findViewById(R.id.tv_cv)
            textCv.text = list[pos].cv.toString()

            val textPoid: TextView = findViewById(R.id.tv_poid)
            textPoid.text = list[pos].poid.toString()

            val textZeroAcent: TextView = findViewById(R.id.tv_zeroAcent)
            textZeroAcent.text = list[pos].zeroAcent
        }

        val btnNext: Button = findViewById(R.id.btn_next)
        val btnLast: Button = findViewById(R.id.btn_last)
        var count: Int = 0

        btnLast.setOnClickListener{
            val image: ImageView = findViewById(R.id.imageCar)
            image.setImageResource(list[pos+count-1].image)

            val textName: TextView = findViewById(R.id.tv_name)
            textName.text = list[pos+count-1].nom

            val textOrigine: TextView = findViewById(R.id.tv_origine)
            textOrigine.text = list[pos+count-1].marque

            val textAnnee: TextView = findViewById(R.id.tv_year)
            textAnnee.text = list[pos+count-1].annee.toString()

            val textConso: TextView = findViewById(R.id.tv_conso)
            textConso.text = list[pos+count-1].conso

            val textVitMax: TextView = findViewById(R.id.tv_vitmax)
            textVitMax.text = list[pos+count-1].vitesse_maximum.toString()

            val textCv: TextView = findViewById(R.id.tv_cv)
            textCv.text = list[pos+count-1].cv.toString()

            val textPoid: TextView = findViewById(R.id.tv_poid)
            textPoid.text = list[pos+count-1].poid.toString()

            val textZeroAcent: TextView = findViewById(R.id.tv_zeroAcent)
            textZeroAcent.text = list[pos+count-1].zeroAcent

            count = count-1
    }
        btnNext.setOnClickListener{
            val image: ImageView = findViewById(R.id.imageCar)
            image.setImageResource(list[pos+count+1].image)

            val textName: TextView = findViewById(R.id.tv_name)
            textName.text = list[pos+count+1].nom

            val textOrigine: TextView = findViewById(R.id.tv_origine)
            textOrigine.text = list[pos+count+1].marque

            val textAnnee: TextView = findViewById(R.id.tv_year)
            textAnnee.text = list[pos+count+1].annee.toString()

            val textConso: TextView = findViewById(R.id.tv_conso)
            textConso.text = list[pos+count+1].conso

            val textVitMax: TextView = findViewById(R.id.tv_vitmax)
            textVitMax.text = list[pos+count+1].vitesse_maximum.toString()

            val textCv: TextView = findViewById(R.id.tv_cv)
            textCv.text = list[pos+count+1].cv.toString()

            val textPoid: TextView = findViewById(R.id.tv_poid)
            textPoid.text = list[pos+count+1].poid.toString()

            val textZeroAcent: TextView = findViewById(R.id.tv_zeroAcent)
            textZeroAcent.text = list[pos+count+1].zeroAcent

            count = count+1
        }




    }




}