package com.example.projetkotlindam2019.activity

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.example.projetkotlindam2019.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.jetbrains.anko.toast


class SignUpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        auth = FirebaseAuth.getInstance()

        btn_sign_up.setOnClickListener {
            toast("Bonjour !!")
            signUpUser()
        }
    }

    private fun signUpUser(){
            if(tv_username.text.toString().isEmpty()){
                tv_username.error = "please enter email!"
                tv_username.requestFocus()
                return
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(tv_username.text.toString()).matches()){
                tv_username.error = "please enter a valid email!"
                tv_username.requestFocus()
                return
            }
            if(tv_password.text.toString().isEmpty()){
                tv_username.error = "please enter password!"
                tv_username.requestFocus()
                return
            }

        auth.createUserWithEmailAndPassword(tv_username.text.toString(), tv_password.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser

                    user?.sendEmailVerification()
                        ?.addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                startActivity(Intent(this, MainActivity::class.java))
                                finish()
                            }
                        }

                } else {
                    toast("Sign Up failed. Try again after some time")
                }
            }
    }

}

