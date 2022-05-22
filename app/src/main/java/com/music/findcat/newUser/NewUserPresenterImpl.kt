package com.music.findcat.newUser

import com.music.findcat.NewUserList
import com.music.findcat.api.Api
import com.music.findcat.api.ServicesGenerator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewUserPresenterImpl : NewUserContact.Presenter {
    private var api = ServicesGenerator.createService(Api::class.java)
    private var mvpView: NewUserContact.View? = null


    override fun responseNewUser(login: String) {
        mvpView?.let { view ->
            view.progressBar(true)
            api.getNewUser(login).enqueue(object : Callback<ArrayList<NewUserList>> {
                override fun onResponse(
                    call: Call<ArrayList<NewUserList>>,
                    response: Response<ArrayList<NewUserList>>
                ) {
                    if (response.isSuccessful) {
                        view.progressBar(false)
                        response.body()?.let { it ->
                            view.loadNewUserGitHub(it)
                        }
                    }
                }

                override fun onFailure(call: Call<ArrayList<NewUserList>>, t: Throwable) {
                    view.progressBar(false)
                    view.error()

                }


            })
        }
    }

    override fun attachView(view: NewUserContact.View) {
        mvpView = view
    }

    override fun detachView() {
        mvpView = null
    }


}