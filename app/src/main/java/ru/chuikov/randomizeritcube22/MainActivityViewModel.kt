package ru.chuikov.randomizeritcube22

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.GsonBuilder
import ru.chuikov.randomizeritcube22.dao.Audience
import ru.chuikov.randomizeritcube22.dao.Station
import ru.chuikov.randomizeritcube22.util.AudienceStorage
import ru.chuikov.randomizeritcube22.util.Storage

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val audienceStorage = AudienceStorage(application)
    
    private var audiences:MutableList<Audience> = audienceStorage.getAudience()?.toMutableList() ?: mutableListOf()

    fun getList()= audiences


    fun setList(list: MutableList<Audience>){
        audienceStorage.setAudience(list)
        audiences = audienceStorage.getAudience()?.toMutableList() ?: mutableListOf()
    }
}
