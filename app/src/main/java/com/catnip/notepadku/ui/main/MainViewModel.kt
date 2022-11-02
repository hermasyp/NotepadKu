package com.catnip.notepadku.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class MainViewModel : ViewModel() {

    val someValue : MutableLiveData<String> = MutableLiveData()

    fun doSomeWork(){
        viewModelScope.launch {
            someValue.postValue("First")
            delay(1000)
            someValue.postValue("Second")
            delay(2000)
            someValue.postValue("Third")
        }
    }

}