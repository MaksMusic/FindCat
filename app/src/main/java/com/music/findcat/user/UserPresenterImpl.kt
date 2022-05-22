package com.music.findcat.user

import com.music.findcat.User
import com.music.findcat.api.Api
import com.music.findcat.api.ServicesGenerator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserPresenterImpl:UserContract.Presenter {

    private val api = ServicesGenerator.createService(Api::class.java)
    private var mvpView:UserContract.View? = null

    override fun response(login: String) {
        mvpView?.let { view ->
            view.progressBar(true)
            api.getUser(login).enqueue(object :Callback<User>{
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.isSuccessful){
                        view.progressBar(false)
                        response.body()?.let { res->
                            view.loadUser(res)
                        }
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    view.progressBar(false)
                    view.error()
                }
            })
        }
    }

    override fun attachView(view: UserContract.View) {
        mvpView = view
    }

    override fun detachView() {
        mvpView = null
    }
}