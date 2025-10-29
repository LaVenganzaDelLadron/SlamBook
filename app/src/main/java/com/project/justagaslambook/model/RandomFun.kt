package com.project.justagaslambook.model

import android.os.Parcel
import android.os.Parcelable

class RandomFun (
    var animalAnswer: String? = null,
    var superPower: String? = null,
    var cantLiveAnswer: String? = null,
    var neverForgetAnswer: String? = null,
    var guiltyPleasureAnswer: String? = null
): Parcelable {

    constructor(parcel: Parcel): this (
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(animalAnswer)
        parcel.writeString(superPower)
        parcel.writeString(cantLiveAnswer)
        parcel.writeString(neverForgetAnswer)
        parcel.writeString(guiltyPleasureAnswer)
    }

    override fun toString(): String {
        return "Animal Answer: " + animalAnswer + "\nSuper Power: " + superPower + "\nCan't Live Answer: " + cantLiveAnswer + "\nNever Forget Answer: " + neverForgetAnswer + "\nGuilty Pleasure Answer: " + guiltyPleasureAnswer
    }


    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<RandomFun> {
        override fun createFromParcel(parcel: Parcel): RandomFun? {
            return RandomFun(parcel)
        }

        override fun newArray(size: Int): Array<out RandomFun?>? {
            return arrayOfNulls(size)
        }

    }


}