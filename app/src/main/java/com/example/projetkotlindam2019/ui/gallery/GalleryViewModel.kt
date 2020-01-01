package com.example.projetkotlindam2019.ui.gallery

import android.content.Context
import androidx.cardview.widget.CardView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is galery Fragment"
    }
    val text: LiveData<String> = _text
}