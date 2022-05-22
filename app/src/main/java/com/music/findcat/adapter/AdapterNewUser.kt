package com.music.findcat.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.music.findcat.FollowersList
import com.music.findcat.NewUserList
import com.music.findcat.databinding.ItemListNewUserBinding
import com.squareup.picasso.Picasso

class AdapterNewUser(private var newUserList: ArrayList<NewUserList>)
    :RecyclerView.Adapter<AdapterNewUser.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterNewUser.ViewHolder {
        return ViewHolder(ItemListNewUserBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        )
    }

    override fun onBindViewHolder(holder: AdapterNewUser.ViewHolder, position: Int) {
        holder.bindView(newUserList[position])
    }

    override fun getItemCount(): Int {
        return newUserList.size
    }


    inner class ViewHolder(var itemNewUserBinding: ItemListNewUserBinding)
        :RecyclerView.ViewHolder(itemNewUserBinding.root) {

        fun bindView(user: NewUserList) {
            itemNewUserBinding.login.text = user.name
            itemNewUserBinding.textInfo.setText(user.textInfo)
            Picasso.get().load(user.owner.avatarUrl).into(itemNewUserBinding.AvatarUser)

        }


    }
}