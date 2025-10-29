package com.project.justagaslambook.model

import android.os.Parcel
import android.os.Parcelable

class VibeInformation (
    var favoriteColor: String? = null,
    var favoriteFood: String? = null,
    var favoriteSong: String? = null,
    var favoriteMovie: String? = null,
    var favoriteGame: String? = null,
    var favoriteSubject: String? = null,
    var mottoInLife: String? = null,
    var dreamJob: String? = null,
    var biggestFear: String? = null,
    var hiddenTalent: String? = null,
    var luckyNumber: String? = null
): Parcelable {
    constructor(parcel: Parcel): this (
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
        parcel.writeString(favoriteColor)
        parcel.writeString(favoriteFood)
        parcel.writeString(favoriteSong)
        parcel.writeString(favoriteMovie)
        parcel.writeString(favoriteGame)
        parcel.writeString(favoriteSubject)
        parcel.writeString(mottoInLife)
        parcel.writeString(dreamJob)
        parcel.writeString(biggestFear)
        parcel.writeString(hiddenTalent)
        parcel.writeString(luckyNumber)
    }

    override fun toString(): String {
        return "Favorite Color: " + favoriteColor + "\nFavorite Food: " + favoriteFood + "\nFavorite Song: " + favoriteSong + "\nFavorite Movie: " + favoriteMovie + "\nFavorite Game: " + favoriteGame + "\nFavorite Subject: " + favoriteSubject + "\nMotto in Life: " + mottoInLife + "\nDream Job: " + dreamJob + "\nBiggest Fear: " + biggestFear + "\nHidden Talent: " + hiddenTalent + "\nLucky Number: " + luckyNumber
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<VibeInformation> {
        override fun createFromParcel(parcel: Parcel): VibeInformation {
            return VibeInformation(parcel)
        }

        override fun newArray(size: Int): Array<out VibeInformation?>? {
            return arrayOfNulls(size)
        }
    }

}