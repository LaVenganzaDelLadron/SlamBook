package com.project.justagaslambook.controllers

import com.project.justagaslambook.model.User

class Authentication {
    companion object {
        val users = ArrayList<User>()
        var currentUser: User? = null
    }

    fun signup(username: String, password: String): Boolean {
        if (users.any { it.username == username }) return false
        users.add(User(username, password, arrayListOf())) // Initialize their slambook
        return true
    }

    fun login(username: String, password: String): Boolean {
        val user = users.find { it.username == username && it.password == password }
        return if (user != null) {
            currentUser = user
            true
        } else false
    }


}