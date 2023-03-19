package com.example.shoesapp.model.room

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.shoesapp.model.ShoeModel

class ShoeViewModelFactory (
    private val dataSource:ShoeDao
    ,private val application: Application
        ):ViewModelProvider.Factory {

@Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShoeModel::class.java)){
            return ShoeViewModel(dataSource,application) as T
        }
        throw IllegalArgumentException("unKnown ViewModel class")
    }
    }


