package com.project.justagaslambook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.justagaslambook.DataActivity
import com.project.justagaslambook.R
import com.project.justagaslambook.model.AboutYou
import com.project.justagaslambook.model.BasicInformation
import com.project.justagaslambook.model.RandomFun
import com.project.justagaslambook.model.VibeInformation

class SlamBookAdapter(
    private val basicInfoList: MutableList<BasicInformation>,
    private val viberInfoList: MutableList<VibeInformation>,
    private val aboutYouList: MutableList<AboutYou>,
    private val randomFunList: MutableList<RandomFun>,
    private val onDeleteClick: (position: Int, item: BasicInformation) -> Unit
) : RecyclerView.Adapter<SlamBookAdapter.SlamBookViewHolder>() {

    class SlamBookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNickName: TextView = itemView.findViewById(R.id.tvNickName)
        val tvAge: TextView = itemView.findViewById(R.id.tvAge)
        val tvEmail: TextView = itemView.findViewById(R.id.tvEmail)
        val tvFavoriteColor: TextView = itemView.findViewById(R.id.tvFavoriteColor)
        val btnDelete: ImageView = itemView.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlamBookViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_slambook_card, parent, false)
        return SlamBookViewHolder(view)
    }

    override fun onBindViewHolder(holder: SlamBookViewHolder, position: Int) {
        val basicInfo = basicInfoList.getOrNull(position) ?: return
        val vibeInfo = viberInfoList.getOrNull(position)
        val aboutYou = aboutYouList.getOrNull(position)


        holder.tvNickName.text = basicInfo.nickname ?: "N/A"
        holder.tvAge.text = "Age: ${basicInfo.age ?: "Unknown"}"
        holder.tvEmail.text = "Email: ${basicInfo.email ?: "N/A"}"
        holder.tvFavoriteColor.text = "Favorite Color: ${basicInfo.gender ?: "N/A"}"



        holder.itemView.setOnClickListener { view ->
            val context = view.context
            val intent = android.content.Intent(context, DataActivity::class.java).apply {
                putExtra("nickname", basicInfo.nickname)
                putExtra("age", basicInfo.age)
                putExtra("email", basicInfo.email)
                putExtra("phone", basicInfo.phone)
                putExtra("gender", basicInfo.gender)
                putExtra("favoriteColor", vibeInfo?.favoriteColor)
                putExtra("favoriteFood", vibeInfo?.favoriteFood)
                putExtra("mottoInLife", vibeInfo?.mottoInLife)
                putExtra("crushName", aboutYou?.crushName)
                putExtra("idealType", aboutYou?.idealType)
            }
            context.startActivity(intent)
        }


        holder.btnDelete.setOnClickListener {
            onDeleteClick(position, basicInfo)
        }
    }

    override fun getItemCount(): Int = basicInfoList.size

    fun removeItem(position: Int) {
        basicInfoList.removeAt(position)
        notifyItemRemoved(position)
    }
}
