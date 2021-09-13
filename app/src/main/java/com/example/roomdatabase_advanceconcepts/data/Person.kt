package com.example.roomdatabase_advanceconcepts.data

import android.graphics.Bitmap
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_table")
data class Person
constructor(
    val firstName: String,
    val lastName: String,
    val age: Int,
    @Embedded
    val address: Address,
    val profilePhoto: Bitmap
) {
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
}

data class Address
constructor(
    val streetName: String,
    val streetNumber: Int
)
