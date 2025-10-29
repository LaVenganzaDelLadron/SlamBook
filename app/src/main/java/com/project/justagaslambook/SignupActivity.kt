package com.project.justagaslambook

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.project.hadeseye.dialog.ShowDialog
import com.project.justagaslambook.controllers.Authentication
import com.project.justagaslambook.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    var isPasswordVisible = false
    private lateinit var binding: ActivitySignupBinding
    private val auth = Authentication()
    private val dialog = ShowDialog(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding) {
            btnSignup.setOnClickListener {
                val username = etUsername.text.toString().trim()
                val password = etPassword.text.toString().trim()

                val success = auth.signup(username, password)

                if (success) {
                    dialog.successDialog("Signup","Signup Successfully","Ok", {
                        val intent = Intent(this@SignupActivity, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    })
                }else {
                    dialog.invalidDialog("Error","Username already exists")
                }
            }
            tvLogin.setOnClickListener {
                val intent = Intent(this@SignupActivity, LoginActivity::class.java)
                startActivity(intent)
            }

            binding.ivTogglePassword.setOnClickListener {
                isPasswordVisible = !isPasswordVisible

                if (isPasswordVisible) {
                    // Show password
                    binding.etPassword.inputType =
                        android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                    binding.ivTogglePassword.setImageResource(R.drawable.clown)
                } else {
                    binding.etPassword.inputType =
                        android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
                    binding.ivTogglePassword.setImageResource(R.drawable.clown)
                }

                binding.etPassword.setSelection(binding.etPassword.text?.length ?: 0)
            }
        }
    }
}