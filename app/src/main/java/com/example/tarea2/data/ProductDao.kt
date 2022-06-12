package com.example.tarea2.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tarea2.model.Product

@Dao
interface ProductDao {

    @Query("SELECT * FROM Product")
    fun getAll(): LiveData<List<Product>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addProduct(product: Product)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateProduct(product: Product)

    @Delete
    suspend fun deleteProduct(product: Product)
}