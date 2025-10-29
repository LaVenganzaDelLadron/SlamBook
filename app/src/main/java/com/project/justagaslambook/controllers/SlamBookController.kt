package com.project.justagaslambook.controllers

import android.content.Context
import android.util.Log
import com.project.justagaslambook.model.VibeInformation
import com.project.justagaslambook.model.AboutYou
import com.project.justagaslambook.model.BasicInformation
import com.project.justagaslambook.model.RandomFun
import com.project.justagaslambook.model.SlamBook

class SlamBookController(private val requireContext: Context) {

    companion object {
        private const val TAG = "SlamBookController"
    }

    fun addBasicInformation(
        nickname: String?, age: String?, likeTOCallMeAs: String?,
        month: String?, day: String?, year: String?,
        gender: String?, status: String?, email: String?,
        phone: String?, address: String?
    ) {
        val currentUser = Authentication.currentUser ?: run {
            Log.e(TAG, "❌ Failed to add BasicInformation — no user logged in.")
            return
        }

        val basicInformation = BasicInformation(
            nickname, age, likeTOCallMeAs, month, day, year,
            gender, status, email, phone, address
        )

        if (currentUser.slambook.isNullOrEmpty()) {
            currentUser.slambook = arrayListOf(SlamBook(basicInformation = arrayListOf(basicInformation)))
            Log.d(TAG, "✅ Created new SlamBook and added BasicInformation: $basicInformation")
        } else {
            currentUser.slambook?.first()?.basicInformation?.add(basicInformation)
            Log.d(TAG, "✅ Added BasicInformation to existing SlamBook: $basicInformation")
        }
    }

    fun addVibeInformation(
        favoriteColor: String?, favoriteFood: String?, favoriteSong: String?,
        favoriteMovie: String?, favoriteGame: String?, favoriteSubject: String?,
        mottoInLife: String?, dreamJob: String?, biggestFear: String?,
        hiddenTalent: String?, luckyNumber: String?
    ) {
        val currentUser = Authentication.currentUser ?: run {
            Log.e(TAG, "❌ Failed to add VibeInformation — no user logged in.")
            return
        }

        val vibeInformation = VibeInformation(
            favoriteColor, favoriteFood, favoriteSong, favoriteMovie,
            favoriteGame, favoriteSubject, mottoInLife, dreamJob,
            biggestFear, hiddenTalent, luckyNumber
        )

        if (currentUser.slambook.isNullOrEmpty()) {
            currentUser.slambook = arrayListOf(SlamBook(vibeInformation = arrayListOf(vibeInformation)))
            Log.d(TAG, "✅ Created new SlamBook and added VibeInformation: $vibeInformation")
        } else {
            currentUser.slambook?.first()?.vibeInformation?.add(vibeInformation)
            Log.d(TAG, "✅ Added VibeInformation to existing SlamBook: $vibeInformation")
        }
    }

    fun addAboutYou(
        crushName: String?, idealType: String?, defineLove: String?,
        defineLife: String?, firstLoveStory: String?, futureSelf: String?
    ) {
        val currentUser = Authentication.currentUser ?: run {
            Log.e(TAG, "❌ Failed to add AboutYou — no user logged in.")
            return
        }

        val aboutYou = AboutYou(crushName, idealType, defineLove, defineLife, firstLoveStory, futureSelf)

        if (currentUser.slambook.isNullOrEmpty()) {
            currentUser.slambook = arrayListOf(SlamBook(aboutYou = arrayListOf(aboutYou)))
            Log.d(TAG, "✅ Created new SlamBook and added AboutYou: $aboutYou")
        } else {
            currentUser.slambook?.first()?.aboutYou?.add(aboutYou)
            Log.d(TAG, "✅ Added AboutYou to existing SlamBook: $aboutYou")
        }
    }

    fun addRandomFun(
        animalAnswer: String?, superPower: String?, cantLiveAnswer: String?,
        neverForgetAnswer: String?, guiltyPleasureAnswer: String?
    ) {
        val currentUser = Authentication.currentUser ?: run {
            Log.e(TAG, "❌ Failed to add RandomFun — no user logged in.")
            return
        }

        val randomFun = RandomFun(animalAnswer, superPower, cantLiveAnswer, neverForgetAnswer, guiltyPleasureAnswer)

        if (currentUser.slambook.isNullOrEmpty()) {
            currentUser.slambook = arrayListOf(SlamBook(randomFun = arrayListOf(randomFun)))
            Log.d(TAG, "✅ Created new SlamBook and added RandomFun: $randomFun")
        } else {
            currentUser.slambook?.first()?.randomFun?.add(randomFun)
            Log.d(TAG, "✅ Added RandomFun to existing SlamBook: $randomFun")
        }
    }
    fun getUserBasicInformation(): ArrayList<BasicInformation>? {
        val data = Authentication.currentUser?.slambook?.first()?.basicInformation
        Log.d(TAG, "📘 Retrieved BasicInformation: $data")
        return data
    }

    fun getUserVibeInformation(): ArrayList<VibeInformation>? {
        val data = Authentication.currentUser?.slambook?.first()?.vibeInformation
        Log.d(TAG, "🎵 Retrieved VibeInformation: $data")
        return data
    }

    fun getUserAboutYou(): ArrayList<AboutYou>? {
        val data = Authentication.currentUser?.slambook?.first()?.aboutYou
        Log.d(TAG, "💖 Retrieved AboutYou: $data")
        return data
    }

    fun getUserRandomFun(): ArrayList<RandomFun>? {
        val data = Authentication.currentUser?.slambook?.first()?.randomFun
        Log.d(TAG, "🎲 Retrieved RandomFun: $data")
        return data
    }
}
