package com.example.shoesapp.model.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.android.material.internal.ManufacturerUtils

@Entity(tableName ="shoe_details_table")
data class Shoe (
    @PrimaryKey(autoGenerate = true )
    @ColumnInfo(name = "shoe_id")
    val id:Int,

    @ColumnInfo(name = "shoe_name")
    val name:String ,

    @ColumnInfo(name="shoe_manufacturer")
    val manufacturer:String,

    @ColumnInfo(name="shoe_size")
    val size:Double,

    @ColumnInfo(name="shoe_description")
    val description:String)


