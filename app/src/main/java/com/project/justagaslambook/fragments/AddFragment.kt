package com.project.justagaslambook.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import android.widget.ViewFlipper
import com.google.android.material.textfield.TextInputEditText
import com.project.hadeseye.dialog.ShowDialog
import com.project.justagaslambook.R
import com.project.justagaslambook.controllers.SlamBookController
import com.project.justagaslambook.databinding.FragmentAddBinding

class AddFragment : Fragment() {
    private val VIEW_BASIC = 0
    private val VIEW_PERSONAL = 1
    private val VIEW_ABOUT = 2
    private val VIEW_RANDOM = 3


    private lateinit var nickName: TextInputEditText
    private lateinit var age: TextInputEditText
    private lateinit var likeTOCallMeAs: TextInputEditText
    private lateinit var month: Spinner
    private lateinit var day: Spinner
    private lateinit var year: TextInputEditText
    private lateinit var gender: Spinner
    private lateinit var status: Spinner
    private lateinit var email: TextInputEditText
    private lateinit var phone: TextInputEditText
    private lateinit var address: TextInputEditText

    private lateinit var favoriteColor: TextInputEditText
    private lateinit var favoriteFood: TextInputEditText
    private lateinit var favoriteSong: TextInputEditText
    private lateinit var favoriteMovie: TextInputEditText
    private lateinit var favoriteGame: TextInputEditText
    private lateinit var favoriteSubject: TextInputEditText
    private lateinit var mottoInLife: TextInputEditText
    private lateinit var dreamJob: TextInputEditText
    private lateinit var biggestFear: TextInputEditText
    private lateinit var hiddenTalent: TextInputEditText
    private lateinit var luckyNumber: TextInputEditText

    private lateinit var crushName: TextInputEditText
    private lateinit var idealType: TextInputEditText
    private lateinit var defineLove: TextInputEditText
    private lateinit var defineLife: TextInputEditText
    private lateinit var firstLoveStory: TextInputEditText
    private lateinit var messageToYourSelf: TextInputEditText

    private lateinit var animalAnswer: TextInputEditText
    private lateinit var superPowerAnswer: TextInputEditText
    private lateinit var cantLiveAnswer: TextInputEditText
    private lateinit var neverForgetAnswer: TextInputEditText
    private lateinit var guiltyPleasureAnswer: TextInputEditText


    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    private lateinit var controller: SlamBookController
    private var dialog: ShowDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        val view = binding.root

        dialog = ShowDialog(requireContext())
        controller = SlamBookController(requireContext())


        val viewFlipper = view.findViewById<ViewFlipper>(R.id.viewFlipper)

        nickName = view.findViewById(R.id.etNickName)
        age = view.findViewById(R.id.etAge)
        likeTOCallMeAs = view.findViewById(R.id.likeToCall)
        month = view.findViewById(R.id.dateMonth)
        day = view.findViewById(R.id.dateDay)
        year = view.findViewById(R.id.dateYear)
        gender = view.findViewById(R.id.gender)
        status = view.findViewById(R.id.status)
        email = view.findViewById(R.id.etEmail)
        phone = view.findViewById(R.id.etContactNo)
        address = view.findViewById(R.id.etAddress)

        favoriteColor = view.findViewById(R.id.etFavcolor)
        favoriteFood = view.findViewById(R.id.etFavfood)
        favoriteSong = view.findViewById(R.id.etFavsong)
        favoriteMovie = view.findViewById(R.id.etFavmovie)
        favoriteGame = view.findViewById(R.id.etFavgame)
        favoriteSubject = view.findViewById(R.id.etFavsubject)
        mottoInLife = view.findViewById(R.id.etFavmotto)
        dreamJob = view.findViewById(R.id.etDreamjob)
        biggestFear = view.findViewById(R.id.etBiggestfear)
        hiddenTalent = view.findViewById(R.id.etHiddenTalent)
        luckyNumber = view.findViewById(R.id.etLuckyNumber)

        crushName = view.findViewById(R.id.etCrushName)
        idealType = view.findViewById(R.id.etIdealType)
        defineLove = view.findViewById(R.id.etDefineLove)
        defineLife = view.findViewById(R.id.etDefineLife)
        firstLoveStory = view.findViewById(R.id.etLoveStory)
        messageToYourSelf = view.findViewById(R.id.etFutureSelf)

        animalAnswer = view.findViewById(R.id.etAnimal)
        superPowerAnswer = view.findViewById(R.id.etSuperpower)
        cantLiveAnswer = view.findViewById(R.id.etLiveWithout)
        neverForgetAnswer = view.findViewById(R.id.etNeverForget)
        guiltyPleasureAnswer = view.findViewById(R.id.etGuiltyPleasure)









        with(binding) {
            tvBasicInformation.setOnClickListener {
                if (viewFlipper.displayedChild != VIEW_BASIC) {
                    viewFlipper.displayedChild = VIEW_BASIC
                }
            }

            tvPersonalVibesInformation.setOnClickListener {
                if (viewFlipper.displayedChild != VIEW_PERSONAL) {
                    viewFlipper.displayedChild = VIEW_PERSONAL
                }
            }

            tvAboutYou.setOnClickListener {
                if (viewFlipper.displayedChild != VIEW_ABOUT) {
                    viewFlipper.displayedChild = VIEW_ABOUT
                }
            }

            tvRandomFun.setOnClickListener {
                if (viewFlipper.displayedChild != VIEW_RANDOM) {
                    viewFlipper.displayedChild = VIEW_RANDOM
                }
            }

            btnSubmit.setOnClickListener {
                val emptyFields = mutableListOf<String>()

                if (nickName.text.isNullOrEmpty()) emptyFields.add("Nickname")
                if (age.text.isNullOrEmpty()) emptyFields.add("Age")
                if (likeTOCallMeAs.text.isNullOrEmpty()) emptyFields.add("Like to call me as")
                if (year.text.isNullOrEmpty()) emptyFields.add("Year")
                if (email.text.isNullOrEmpty()) emptyFields.add("Email")
                if (phone.text.isNullOrEmpty()) emptyFields.add("Phone")
                if (address.text.isNullOrEmpty()) emptyFields.add("Address")

                if (favoriteColor.text.isNullOrEmpty()) emptyFields.add("Favorite Color")
                if (favoriteFood.text.isNullOrEmpty()) emptyFields.add("Favorite Food")
                if (favoriteSong.text.isNullOrEmpty()) emptyFields.add("Favorite Song")
                if (favoriteMovie.text.isNullOrEmpty()) emptyFields.add("Favorite Movie")
                if (favoriteGame.text.isNullOrEmpty()) emptyFields.add("Favorite Game")
                if (favoriteSubject.text.isNullOrEmpty()) emptyFields.add("Favorite Subject")
                if (mottoInLife.text.isNullOrEmpty()) emptyFields.add("Motto in Life")
                if (dreamJob.text.isNullOrEmpty()) emptyFields.add("Dream Job")
                if (biggestFear.text.isNullOrEmpty()) emptyFields.add("Biggest Fear")
                if (hiddenTalent.text.isNullOrEmpty()) emptyFields.add("Hidden Talent")
                if (luckyNumber.text.isNullOrEmpty()) emptyFields.add("Lucky Number")

                if (crushName.text.isNullOrEmpty()) emptyFields.add("Crush Name")
                if (idealType.text.isNullOrEmpty()) emptyFields.add("Ideal Type")
                if (defineLove.text.isNullOrEmpty()) emptyFields.add("Define Love")
                if (defineLife.text.isNullOrEmpty()) emptyFields.add("Define Life")
                if (firstLoveStory.text.isNullOrEmpty()) emptyFields.add("First Love Story")
                if (messageToYourSelf.text.isNullOrEmpty()) emptyFields.add("Message to Yourself")

                if (animalAnswer.text.isNullOrEmpty()) emptyFields.add("Animal Answer")
                if (superPowerAnswer.text.isNullOrEmpty()) emptyFields.add("Super Power Answer")
                if (cantLiveAnswer.text.isNullOrEmpty()) emptyFields.add("Can't Live Without")
                if (neverForgetAnswer.text.isNullOrEmpty()) emptyFields.add("Never Forget")
                if (guiltyPleasureAnswer.text.isNullOrEmpty()) emptyFields.add("Guilty Pleasure")

                if (phone.text?.length != 11) {
                    emptyFields.add("Phone number must be 11 digits")
                }

                if (emptyFields.isNotEmpty()) {
                    android.util.Log.d("AddFragment", "Empty fields: $emptyFields")

                    dialog?.invalidDialog(
                        "Invalid",
                        "Please fill the following fields:\n${emptyFields.joinToString(", ")}"
                    )
                } else {
                    val nickname = nickName.text.toString()
                    val age = age.text.toString()
                    val likeTOCallMeAs = likeTOCallMeAs.text.toString()
                    val months = month.selectedItem.toString()
                    val days = day.selectedItem.toString()
                    val year = year.text.toString()
                    val gender = gender.selectedItem.toString()
                    val status = status.selectedItem.toString()
                    val email = email.text.toString()
                    val phone = phone.text.toString()
                    val address = address.text.toString()

                    val favoriteColor = favoriteColor.text.toString()
                    val favoriteFood = favoriteFood.text.toString()
                    val favoriteSong = favoriteSong.text.toString()
                    val favoriteMovie = favoriteMovie.text.toString()
                    val favoriteGame = favoriteGame.text.toString()
                    val favoriteSubject = favoriteSubject.text.toString()
                    val mottoInLife = mottoInLife.text.toString()
                    val dreamJob = dreamJob.text.toString()
                    val biggestFear = biggestFear.text.toString()
                    val hiddenTalent = hiddenTalent.text.toString()
                    val luckyNumber = luckyNumber.text.toString()

                    val crushName = crushName.text.toString()
                    val idealType = idealType.text.toString()
                    val defineLove = defineLove.text.toString()
                    val defineLife = defineLife.text.toString()
                    val firstLoveStory = firstLoveStory.text.toString()
                    val messageToYourSelf = messageToYourSelf.text.toString()

                    val animalAnswer = animalAnswer.text.toString()
                    val superPowerAnswer = superPowerAnswer.text.toString()
                    val cantLiveAnswer = cantLiveAnswer.text.toString()
                    val neverForgetAnswer = neverForgetAnswer.text.toString()
                    val guiltyPleasureAnswer = guiltyPleasureAnswer.text.toString()

                    controller.addBasicInformation(nickname, age, likeTOCallMeAs, months, days, year, gender, status, email, phone, address)
                    controller.addVibeInformation(favoriteColor, favoriteFood, favoriteSong, favoriteMovie, favoriteGame, favoriteSubject, mottoInLife, dreamJob, biggestFear, hiddenTalent, luckyNumber)
                    controller.addAboutYou(crushName, idealType, defineLove, defineLife, firstLoveStory, messageToYourSelf)
                    controller.addRandomFun(animalAnswer, superPowerAnswer, cantLiveAnswer, neverForgetAnswer, guiltyPleasureAnswer)

                    dialog?.successDialog("Success", "Successfully Added")
                }
            }


            btnCancel.setOnClickListener {
                clearAll()
            }

        }




        return view
    }

    private fun clearAll() {
        listOf(
            nickName, age, likeTOCallMeAs, year, email, phone, address,
            favoriteColor, favoriteFood, favoriteSong, favoriteMovie, favoriteGame,
            favoriteSubject, mottoInLife, dreamJob, biggestFear, hiddenTalent, luckyNumber,
            crushName, idealType, defineLove, defineLife, firstLoveStory, messageToYourSelf,
            animalAnswer, superPowerAnswer, cantLiveAnswer, neverForgetAnswer, guiltyPleasureAnswer
        ).forEach { it.text?.clear() }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
