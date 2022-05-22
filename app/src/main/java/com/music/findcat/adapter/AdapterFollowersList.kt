package com.music.findcat.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.music.findcat.FollowersList
import com.music.findcat.databinding.ItemListFollowersBinding
import com.squareup.picasso.Picasso

class AdapterFollowersList(
    private val listFollowers: ArrayList<FollowersList>)
    : RecyclerView.Adapter<AdapterFollowersList.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemListFollowersBinding.inflate(LayoutInflater.from(parent.context),
                    parent,
                    false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(listFollowers[position])
    }

    override fun getItemCount() = listFollowers.size

    inner class ViewHolder(var itemListBinding: ItemListFollowersBinding) :
        RecyclerView.ViewHolder(itemListBinding.root) {
        private val view = itemListBinding

        fun bindView(followers: FollowersList) {
            view.loginFollowings.text = followers.login
            Picasso.get().load(followers.avatarUrl).into(view.avatarFollowers)
        }
    }

}