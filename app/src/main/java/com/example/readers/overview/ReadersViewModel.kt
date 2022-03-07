package com.example.readers.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.readers.data.ItemsItem
import com.example.readers.netwoek.BooksApi
import kotlinx.coroutines.launch

enum class MoviesApiStatus { LOADING, ERROR, DONE }

class ReadersViewModel : ViewModel(){


    var result = MutableLiveData<List<ItemsItem?>>()
    var  _thieresult = MutableLiveData<List<ItemsItem?>>()
    val thieresult: MutableLiveData<List<ItemsItem?>> = _thieresult



    private val _status = MutableLiveData<MoviesApiStatus>()
    val status: LiveData<MoviesApiStatus> = _status



    var title = MutableLiveData<String?>()
    var image = MutableLiveData<String?>()


    init {
        getBook()
    }


    private fun getBook(){

        viewModelScope.launch {
            result.value = BooksApi.retrofitService.getBook( "fantasy").items
        }
    }
}