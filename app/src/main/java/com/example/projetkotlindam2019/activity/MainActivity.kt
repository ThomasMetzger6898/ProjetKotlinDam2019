package com.example.projetkotlindam2019.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import com.example.projetkotlindam2019.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.tv_password
import kotlinx.android.synthetic.main.activity_main.tv_username
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()

        btn_redirect.setOnClickListener{
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }

        btn_sign_in.setOnClickListener{
            doLogin()
        }


    }

    private fun doLogin() {
        if (tv_username.text.toString().isEmpty()) {
            tv_username.error = "please enter email!"
            tv_username.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(tv_username.text.toString()).matches()) {
            tv_username.error = "please enter a valid email!"
            tv_username.requestFocus()
            return
        }
        if (tv_password.text.toString().isEmpty()) {
            tv_username.error = "please enter password!"
            tv_username.requestFocus()
            return
        }

        auth.signInWithEmailAndPassword(tv_username.text.toString(), tv_password.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    updateUI(null)
                }
            }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        //val currentUser = auth.currentUser
        //updateUI(currentUser)
    }



    private fun updateUI(currentUser: FirebaseUser?){
        if (currentUser != null){
            //email verification bug
            /*if (currentUser.isEmailVerified){
                startActivity(Intent(this,MainPageActivity::class.java))
                finish()
            }
            else{
                toast("Please verify your email adress")
            }*/

            startActivity(Intent(this, MainPageActivity::class.java))
            finish()

        }
        else{
            toast("Sign In failed. Try again after some time")
        }

    }

}
