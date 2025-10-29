package com.project.justagaslambook.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.justagaslambook.R
import com.project.justagaslambook.adapter.SlamBookAdapter
import com.project.justagaslambook.controllers.SlamBookController
import com.project.justagaslambook.controllers.Authentication

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerSlamBook)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val controller = SlamBookController(requireContext())
        val userInfoList = controller.getUserBasicInformation()?.toMutableList() ?: mutableListOf()
        val vibeInfoList = controller.getUserVibeInformation()?.toMutableList() ?: mutableListOf()
        val aboutYouList = controller.getUserAboutYou()?.toMutableList() ?: mutableListOf()
        val randomFunList = controller.getUserRandomFun()?.toMutableList() ?: mutableListOf()


        if (userInfoList.isEmpty()) {
            Log.w("ListFragment", "⚠️ No data found in SlamBookController!")
            return view
        }

        lateinit var adapter: SlamBookAdapter

        adapter = SlamBookAdapter(userInfoList,vibeInfoList,aboutYouList,randomFunList) { position, item ->
            adapter.removeItem(position)

            Authentication.currentUser?.slambook?.first()?.basicInformation?.remove(item)

            Log.d("ListFragment", "🗑 Deleted item: ${item.nickname}")
        }

        recyclerView.adapter = adapter

        return view
    }
}
