
package com.project.justagaslambook

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.project.hadeseye.dialog.ShowDialog
import com.project.justagaslambook.controllers.Authentication
import com.project.justagaslambook.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val auth = Authentication()
    private val dialog = ShowDialog(this)
    var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            btnLogin.setOnClickListener {
                val username = etUsername.text.toString().trim()
                val password = etPassword.text.toString().trim()

                val success = auth.login(username, password)

                if (success) {
                    dialog.successDialog("Login","Login Successfully","Ok",  {
                        val intent = Intent(this@LoginActivity, DashboardActivity::class.java)
                        startActivity(intent)
                        finish()
                    })
                }else {
                    dialog.invalidDialog("Error","Invalid username or password")
                }

            }

            tvSignup.setOnClickListener {
                val intent = Intent(this@LoginActivity, SignupActivity::class.java)
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