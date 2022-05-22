package com.music.findcat.followers

import android.util.Log
import com.music.findcat.FollowersList

import com.music.findcat.api.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowersPresnterlmpl : FollowersContact.Presenter {

    private var api = Api.create()
    private var mvpViewFollowersList: FollowersContact.View? = null

    override fun response(login:String) {
        mvpViewFollowersList?.let { view ->
            view.progressBar(true)
            api.getFollowers(login).enqueue(object : Callback<ArrayList<FollowersList>> {
                override fun onResponse(
                    call: Call<ArrayList<FollowersList>>,
                    response: Response<ArrayList<FollowersList>>
                ) {
                    if (response.isSuccessful){
                        view.progressBar(false)
                        response.body()?.let { res->
                            view.loadUserGitHub(res)
                            Log.e("TAGS", res.toString())
                        }
                    }
                }

                override fun onFailure(call: Call<ArrayList<FollowersList>>, t: Throwable) {
                    view.progressBar(false)
                    view.error()
                }

            })
        }
    }

    override fun attachView(view: FollowersContact.View) {
      mvpViewFollowersList = view
    }

    override fun detachView() {
        mvpViewFollowersList = null
    }
}