package com.project.justagaslambook.model

import android.os.Parcel
import android.os.Parcelable

class BasicInformation (
    var nickname: String? = null,
    var age: String? = null,
    var likeTOCallMeAs: String? = null,
    var month: String? = null,
    var day: String? = null,
    var year: String? = null,
    var gender: String? = null,
    var status: String? = null,
    var email: String? = null,
    var phone: String? = null,
    var address: String? = null
): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nickname)
        parcel.writeString(age)
        parcel.writeString(likeTOCallMeAs)
        parcel.writeString(month)
        parcel.writeString(day)
        parcel.writeString(year)
        parcel.writeString(gender)
        parcel.writeString(status)
        parcel.writeString(email)
        parcel.writeString(phone)
        parcel.writeString(address)
    }

    override fun toString(): String {
        return "Name: " + nickname + "\nAge: " + age + "\nLike to call me as: " + likeTOCallMeAs + "\nBirthday: " + month + "/" + day + "/" + year + "\nGender: " + gender + "\nStatus: " + status + "\nEmail: " + email + "\nPhone: " + phone + "\nAddress: " + address
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<BasicInformation> {
        override fun createFromParcel(parcel: Parcel): BasicInformation {
            return BasicInformation(parcel)
        }

        override fun newArray(size: Int): Array<out BasicInformation?>? {
            return  arrayOfNulls(size)
        }


    }





}