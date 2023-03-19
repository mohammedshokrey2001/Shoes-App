package com.example.shoesapp.model.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ShoeDao {

 @Insert
 fun insert(shoe: Shoe)

 @Query("SELECT * FROM shoe_details_table ORDER BY shoe_id")
  fun getAllShoes():LiveData<List<Shoe>>

 @Query("SELECT * FROM shoe_details_table WHERE shoe_id=:shoeId")
 fun get(shoeId:Int):Shoe

 @Query( "DELETE FROM shoe_details_table")
 fun deleteTable()

 @Update
 fun updateRow(shoe: Shoe)

 @Query("SELECT * FROM shoe_details_table ORDER BY shoe_id DESC LIMIT 1")
 fun getLastAddedShoes():Shoe?


}