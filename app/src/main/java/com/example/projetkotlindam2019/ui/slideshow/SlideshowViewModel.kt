package com.example.projetkotlindam2019.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projetkotlindam2019.R
import com.example.projetkotlindam2019.classes.Car

class SlideshowViewModel : ViewModel() {

    /*private val _mercedesList = MutableLiveData<ArrayList<Car>>().apply {
        value?.add(Car("Amg","Mercedes", R.drawable.ic_img1))
        value?.add(Car("Amg","Mercedes", R.drawable.ic_img2))
    }
    val list: LiveData<ArrayList<Car>> = _mercedesList

    fun getList() : ArrayList<Car>?{
        return _mercedesList.value;
    }*/

    val _mercedesList = ArrayList<Car>()

    fun getList() : ArrayList<Car>{
        _mercedesList.add(Car("Amg","Mercedes", R.drawable.ic_img1))
        _mercedesList.add(Car("Cls","Mercedes", R.drawable.ic_img2))
        return _mercedesList;

    }
}