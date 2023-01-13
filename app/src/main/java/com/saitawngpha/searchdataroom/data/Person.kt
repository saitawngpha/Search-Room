package com.saitawngpha.searchdataroom.data

/**
 * @Author: ၸၢႆးတွင်ႉၾႃႉ
 * @Date: 1/12/23
 */
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person_table")
data class Person(
    var firstName: String,
    var lastName: String,
    var age: Int
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
