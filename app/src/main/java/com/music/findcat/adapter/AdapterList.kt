package com.music.findcat.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.music.findcat.UserList
import com.music.findcat.databinding.ItemListBinding
import com.squareup.picasso.Picasso

class AdapterList(
    private val list: ArrayList<UserList>,
    private var listenner: OnClickListener
) : RecyclerView.Adapter<AdapterList.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(list[position])
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(var itemListBinding: ItemListBinding) :
        RecyclerView.ViewHolder(itemListBinding.root) {
        private val view = itemListBinding

        fun bindView(user: UserList) {
            view.login.text = user.login
            Picasso.get().load(user.avatarUrl).into(view.avatar)

            itemView.setOnClickListener {
                listenner.onClick(user.login)
            }
        }


    }
    interface OnClickListener{
        fun onClick(login:String)
    }

}