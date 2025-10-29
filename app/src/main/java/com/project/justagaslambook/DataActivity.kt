package com.project.justagaslambook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.justagaslambook.databinding.ActivityDataBinding

class DataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nickname = intent.getStringExtra("nickname") ?: "N/A"
        val age = intent.getStringExtra("age") ?: "Unknown"
        val email = intent.getStringExtra("email") ?: "N/A"
        val phone = intent.getStringExtra("gender") ?: "N/A" // You used gender for phone?
        val favoriteColor = intent.getStringExtra("favoriteColor") ?: "N/A"
        val favoriteFood = intent.getStringExtra("favoriteFood") ?: "N/A"
        val mottoInLife = intent.getStringExtra("mottoInLife") ?: "N/A"
        val crushName = intent.getStringExtra("crushName") ?: "N/A"
        val idealType = intent.getStringExtra("idealType") ?: "N/A"

        binding.tvNickname.text = "Nickname: $nickname"
        binding.tvAge.text = "Age: $age"
        binding.tvEmail.text = "Email: $email"
        binding.tvPhone.text = "Phone: $phone"

        binding.tvFavoriteColor.text = "Favorite Color: $favoriteColor"
        binding.tvFavoriteFood.text = "Favorite Food: $favoriteFood"
        binding.tvMotto.text = "Motto in Life: $mottoInLife"

        binding.tvCrushName.text = "Crush Name: $crushName"
        binding.tvIdealType.text = "Ideal Type: $idealType"
    }
}
