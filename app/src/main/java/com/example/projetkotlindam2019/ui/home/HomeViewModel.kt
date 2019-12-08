package com.example.projetkotlindam2019.ui.home

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private lateinit var customView: CustomView
    private lateinit var context : Context

    private val _view = MutableLiveData<CustomView>().apply {
        customView = CustomView(context)
        value = customView
    }
    val value : LiveData<CustomView> = _view
}