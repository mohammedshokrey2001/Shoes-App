package com.example.shoesapp.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Shoe::class], version = 1, exportSchema = false)
abstract class  ShoeDatabase : RoomDatabase(){
    abstract val shoeDao :ShoeDao

     companion object{
         private var INSTANCE :ShoeDatabase? = null

         fun getInstance(context: Context):ShoeDatabase{
             synchronized(this){
                 var instance: ShoeDatabase? = INSTANCE

                 if (instance==null){
                     instance = Room.databaseBuilder(
                         context.applicationContext,
                         ShoeDatabase::class.java,
                         "shoe_app_database"

                     ).fallbackToDestructiveMigration()

                       .build()
                     INSTANCE = instance

                 }
                 return instance

             }

         }
     }
}

