package com.example.projetkotlindam2019.classes

import android.os.Parcel
import android.os.Parcelable



class Car ( val nom:String,val marque: String, val image: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nom)
        parcel.writeString(marque)
        parcel.writeInt(image)
    }

    override fun toString(): String {
        return nom
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Car> {
        override fun createFromParcel(parcel: Parcel): Car {
            return Car(parcel)
        }

        override fun newArray(size: Int): Array<Car?> {
            return arrayOfNulls(size)
        }
    }
}


//class Car ( val nom:String,val marque: String, val image: Int,val consomation:Double,val vitesseMax :Int,val cheveaux:Int,val poid:Int,val zeroAcent:Double,val annee:Int ) : Parcelable