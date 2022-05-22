package com.music.findcat.main

import com.music.findcat.UserList
import com.music.findcat.mvp.BaseContract

interface UserContract {

    interface View:BaseContract.View{
        fun loadUserGitHub(userList: ArrayList<UserList>)
        fun progressBar(show:Boolean)
        fun error()
    }

    interface Presenter:BaseContract.Presenter<View>{
        fun response()
    }
}