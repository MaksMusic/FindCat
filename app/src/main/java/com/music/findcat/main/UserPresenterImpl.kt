package com.music.findcat.main

import android.util.Log
import com.music.findcat.UserList
import com.music.findcat.api.Api
import com.music.findcat.api.ServicesGenerator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserPresenterImpl:UserContract.Presenter {

    private var api = Api.create()
    private var mvpView: UserContract.View? = null

    override fun response() {
        mvpView?.let { view ->
            view.progressBar(true)
            api.getUserList().enqueue(object :Callback<ArrayList<UserList>>{
                override fun onResponse(
                    call: Call<ArrayList<UserList>>,
                    response: Response<ArrayList<UserList>>
                ) {
                    if (response.isSuccessful){
                        view.progressBar(false)
                        response.body()?.let { res->
                            view.loadUserGitHub(res)
                            Log.e("TAGS", res.toString())
                        }
                    }
                }

                override fun onFailure(call: Call<ArrayList<UserList>>, t: Throwable) {
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