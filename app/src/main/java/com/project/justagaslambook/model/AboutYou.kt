package com.project.justagaslambook.model

import android.os.Parcel
import android.os.Parcelable

class AboutYou (
    var crushName: String? = null,
    var idealType: String? = null,
    var defineLove: String? = null,
    var defineLife: String? = null,
    var firstLoveStory: String? = null,
    var futureSelf: String? = null
): Parcelable{

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(crushName)
        parcel.writeString(idealType)
        parcel.writeString(defineLove)
        parcel.writeString(defineLife)
        parcel.writeString(firstLoveStory)
        parcel.writeString(futureSelf)
    }

    override fun toString(): String {
        return "Crush Name: " + crushName + "\nIdeal Type: " + idealType + "\nDefine Love: " + defineLove + "\nDefine Life: " + defineLife + "\nFirst Love Story: " + firstLoveStory + "\nFuture Self: " + futureSelf
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<AboutYou> {
        override fun createFromParcel(parcel: Parcel): AboutYou? {
            return AboutYou(parcel)
        }

        override fun newArray(size: Int): Array<out AboutYou?>? {
            return arrayOfNulls(size)
        }
    }

}