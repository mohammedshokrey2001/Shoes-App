package com.example.shoesapp.model
import android.os.Parcel
import android.os.Parcelable

data class ShoeModel(var name: String?, var size: Double, var company: String?, var description: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readDouble(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeDouble(size)
        parcel.writeString(company)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ShoeModel> {
        override fun createFromParcel(parcel: Parcel): ShoeModel {
            return ShoeModel(parcel)
        }

        override fun newArray(size: Int): Array<ShoeModel?> {
            return arrayOfNulls(size)
        }
    }
}