package com.saitawngpha.searchdataroom.data

/**
 * @Author: ၸၢႆးတွင်ႉၾႃႉ
 * @Date: 1/12/23
 */
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Person::class],
    version = 1,
    exportSchema = false
)
abstract class PersonDatabase: RoomDatabase() {

    abstract fun personDao(): PersonDao

}