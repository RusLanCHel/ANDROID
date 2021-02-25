package com.example.watchfilmapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.watchfilmapp.Model.Film
import java.util.*
import kotlin.collections.ArrayList

class MainViewModel(private val recyclerViewDataFilm: MutableLiveData<ArrayList<Film>> = MutableLiveData()) : ViewModel() {
    private lateinit var filmArrayList: ArrayList<Film>

    fun getData(): LiveData<ArrayList<Film>>{
        getDataFromLocalSource()
        return recyclerViewDataFilm
    }

    fun getDataFromLocalSource(){
        val first = Film("a", 1)
        val second = Film("b", 2)
        filmArrayList = ArrayList(listOf(first, second, Film("c", 3)))
        recyclerViewDataFilm.postValue(filmArrayList)
    }

}