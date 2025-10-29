package com.project.justagaslambook.model

import android.os.Parcel
import android.os.Parcelable
import com.project.justagaslambook.model.VibeInformation

class SlamBook constructor(
    var basicInformation: ArrayList<BasicInformation>? = arrayListOf(),
    var vibeInformation: ArrayList<VibeInformation>? = arrayListOf(),
    var aboutYou: ArrayList<AboutYou>? = arrayListOf(),
    var randomFun: ArrayList<RandomFun>? = arrayListOf()
    )


