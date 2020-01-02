package com.example.projetkotlindam2019.activity

import android.content.Intent
import android.os.Bundle
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

        val intent = intent
        if(intent != null){
            var pos : Int = 0
            var list : ArrayList<Car> = ArrayList<Car>()
            if(intent.hasExtra("pos")){
                pos = intent.getIntExtra("pos",0)
                list = intent.getParcelableArrayListExtra("list")
            }
            val image : ImageView = findViewById(R.id.imageCar)
            image.setImageResource(list[pos].image)
            val textName : TextView = findViewById(R.id.tv_name)
            textName.text = list[pos].nom
            val textMarque : TextView = findViewById(R.id.tv_Marque)
            textMarque.text = list[pos].marque

            val textConso : TextView = findViewById(R.id.tv_conso)

        }




    }

}