package com.music.findcat.newUser

import com.music.findcat.NewUserList
import com.music.findcat.mvp.BaseContract

interface NewUserContact {

    interface View : BaseContract.View {
        fun loadNewUserGitHub(newUserList: ArrayList<NewUserList>)
        fun progressBar(show: Boolean)
        fun error()
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun responseNewUser(login: String)
    }
}