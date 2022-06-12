package com.example.tarea2.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tarea2.model.Product

@Database(entities = [Product::class], version=1, exportSchema = false)
abstract class ProductDatabase: RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {
        @Volatile
        private var INSTANCE: ProductDatabase? = null

        fun getDatabase(context: android.content.Context): ProductDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductDatabase::class.java,
                    "product_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }
    }
}