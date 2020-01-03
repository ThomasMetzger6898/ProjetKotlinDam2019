package com.example.projetkotlindam2019.classes

import android.os.Parcel
import android.os.Parcelable
import kotlinx.serialization.Serializable

@Serializable
class Car ( val nom:String,val marque: String, val image: Int,val annee:String, val conso:String,val vitesse_maximum:String,val cv:String,val poid:String,val zeroAcent:String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nom)
        parcel.writeString(marque)
        parcel.writeInt(image)
        parcel.writeString(annee)
        parcel.writeString(conso)
        parcel.writeString(vitesse_maximum)
        parcel.writeString(cv)
        parcel.writeString(poid)
        parcel.writeString(zeroAcent)
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


/*class Car ( val nom:String,val marque: String, val image: Int,val consomation:String,val vitesseMax :Int,val cheveaux:Int,val poid:Int,val zeroAcent:String,val annee:Int ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nom)
        parcel.writeString(marque)
        parcel.writeInt(image)
        parcel.writeString(consomation)
        parcel.writeInt(vitesseMax)
        parcel.writeInt(cheveaux)
        parcel.writeInt(poid)
        parcel.writeString(zeroAcent)
        parcel.writeInt(annee)
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
}*/