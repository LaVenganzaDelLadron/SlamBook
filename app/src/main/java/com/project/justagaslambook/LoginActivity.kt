
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
        }

    }
}