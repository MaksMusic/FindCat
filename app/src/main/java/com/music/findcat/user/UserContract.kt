package com.music.findcat.user

import com.music.findcat.User
import com.music.findcat.mvp.BaseContract

interface UserContract {

    interface View:BaseContract.View{
        fun loadUser(user: User)
        fun progressBar(show:Boolean)
        fun error()
    }

    interface Presenter:BaseContract.Presenter<View>{
        fun response(login:String)
    }
}