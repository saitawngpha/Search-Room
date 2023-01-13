package com.saitawngpha.searchdataroom.di

/**
 * @Author: ၸၢႆးတွင်ႉၾႃႉ
 * @Date: 1/12/23
 */
import android.content.Context
import androidx.room.Room
import com.saitawngpha.searchdataroom.data.PersonDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        PersonDatabase::class.java,
        "person_database"
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: PersonDatabase) = database.personDao()

}