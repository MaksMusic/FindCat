package com.music.findcat.mvp

class BaseContract {
    interface Presenter<in T>{
        fun attachView(view:T)
        fun detachView()
    }

    interface View{

    }
}