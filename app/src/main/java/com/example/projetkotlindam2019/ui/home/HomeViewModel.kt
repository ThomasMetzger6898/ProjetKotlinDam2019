package com.example.projetkotlindam2019.ui.home

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projetkotlindam2019.classes.CustomView

class HomeViewModel : ViewModel() {

    private lateinit var customView: CustomView
    private lateinit var context : Context

    private val _view = MutableLiveData<CustomView>().apply {
        //customView = CustomView(context)
        //value = customView
    }
    //val value : LiveData<CustomView> = _view

}