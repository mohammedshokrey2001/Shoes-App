package com.example.shoesapp.model.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class ShoeViewModel (
    val database :ShoeDao,
    application :Application
):AndroidViewModel(application){

}