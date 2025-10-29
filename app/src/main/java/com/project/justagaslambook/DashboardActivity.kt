package com.project.justagaslambook

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.project.hadeseye.dialog.ShowDialog
import com.project.justagaslambook.databinding.ActivityDashboardBinding
import com.project.justagaslambook.fragments.AddFragment
import com.project.justagaslambook.fragments.ListFragment

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private lateinit var dialog: ShowDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dialog = ShowDialog(this)

        replaceFragment(AddFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.home -> replaceFragment(AddFragment())
                R.id.report -> replaceFragment(ListFragment())
                R.id.settingIcon -> {
                    dialog.exitDialog("Logout", "Are you sure you want to logout?", "Cancel", "Logout") {
                        val intent = Intent(this@DashboardActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }
            true
        }



    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}