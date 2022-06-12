package com.example.tarea2.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Product")
data class Product (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name="name")
    val nombre: String,
    @ColumnInfo(name="brand")
    val brand: String,
    @ColumnInfo(name = "price")
    val price: Double,
    @ColumnInfo(name = "location")
    val location: String,
    @ColumnInfo(name = "size")
    val size: String
): Parcelable