package com.saitawngpha.searchdataroom.viewmodel

/**
 * @Author: ၸၢႆးတွင်ႉၾႃႉ
 * @Date: 1/12/23
 */
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.saitawngpha.searchdataroom.data.Person
import com.saitawngpha.searchdataroom.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val readData = repository.readData().asLiveData()

    fun insertData(person: Person){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertData(person)
        }
    }

    fun searchDatabase(searchQuery: String): LiveData<List<Person>> {
        return repository.searchDatabase(searchQuery).asLiveData()
    }

}