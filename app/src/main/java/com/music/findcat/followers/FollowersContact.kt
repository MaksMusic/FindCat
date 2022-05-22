package com.music.findcat.followers

import com.music.findcat.FollowersList
import com.music.findcat.mvp.BaseContract


interface FollowersContact {
    interface View: BaseContract.View{
        fun loadUserGitHub(followersList: ArrayList<FollowersList>)
        fun progressBar(show:Boolean)
        fun error()
    }
    interface Presenter:BaseContract.Presenter<View>{
        fun response(login:String)
    }
}


