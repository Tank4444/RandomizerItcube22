package ru.chuikov.randomizeritcube22

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.chuikov.randomizeritcube22.dao.Audience
import ru.chuikov.randomizeritcube22.dao.Station

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val _audiences:MutableLiveData<MutableList<Audience>> = MutableLiveData(mutableListOf())
    val audiences:LiveData<MutableList<Audience>> = _audiences

    fun addAudience(name:String, count:Int){
        val audience = Audience(name, MutableList<Station>(count, init = {
            Station(it,true)
        }))
        _audiences.value?.add(audience)
        _audiences.notifyObserver()
    }
    fun removeLastAudience(){
        _audiences.value?.removeLast()
        _audiences.notifyObserver()
    }

    fun setList(list: MutableList<Audience>){
        _audiences.value = mutableListOf()
        _audiences.value?.addAll(list)
        _audiences.notifyObserver()
    }
}

fun <T> MutableLiveData<T>.notifyObserver() {
    this.value = this.value
}