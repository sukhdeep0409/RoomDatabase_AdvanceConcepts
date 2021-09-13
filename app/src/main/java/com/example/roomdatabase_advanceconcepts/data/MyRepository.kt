package com.example.roomdatabase_advanceconcepts.data

import androidx.lifecycle.LiveData

class MyRepository
constructor(private val myDao: MyDao) {
    val readPerson: LiveData<List<Person>> = myDao.readPerson()

    suspend fun insertPerson(person: Person) {
        myDao.insertPerson(person)
    }
}