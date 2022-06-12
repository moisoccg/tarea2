package com.example.tarea2.repository

import androidx.lifecycle.LiveData
import com.example.tarea2.data.ProductDao
import com.example.tarea2.model.Product

class ProductRepository(private val productDao: ProductDao) {

    val getAllProducts: LiveData<List<Product>>  = productDao.getAll()
    suspend fun addProduct(product: Product){
        productDao.addProduct(product)
    }

    suspend fun updateProduct(product: Product){
        productDao.updateProduct(product)
    }

    suspend fun deleteProduct(product: Product){
        productDao.deleteProduct(product)
    }
}