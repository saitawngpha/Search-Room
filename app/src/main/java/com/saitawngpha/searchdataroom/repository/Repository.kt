package com.saitawngpha.searchdataroom.repository

/**
 * @Author: ၸၢႆးတွင်ႉၾႃႉ
 * @Date: 1/12/23
 */
import com.saitawngpha.searchdataroom.data.Person
import com.saitawngpha.searchdataroom.data.PersonDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val personDao: PersonDao
) {

    fun readData(): Flow<List<Person>> {
        return personDao.readData()
    }

    suspend fun insertData(person: Person) {
        personDao.insertData(person)
    }

    fun searchDatabase(searchQuery: String): Flow<List<Person>> {
        return personDao.searchDatabase(searchQuery)
    }

}