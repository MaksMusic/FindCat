package com.music.findcat.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.music.findcat.user.UserActivity
import com.music.findcat.UserList
import com.music.findcat.adapter.AdapterList
import com.music.findcat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AdapterList.OnClickListener,UserContract.View {

    lateinit var binding: ActivityMainBinding
    private lateinit var presenterImpl: UserPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenterImpl = UserPresenterImpl()
        presenterImpl.attachView(this)
        presenterImpl.response()

        binding
    }





    override fun onClick(login: String) {
        val intent = Intent (this, UserActivity::class.java)
        intent.putExtra("LOGIN", login)
        startActivity(intent)
    }

    //MVP Retrofit
    override fun loadUserGitHub(userList: ArrayList<UserList>) {
        val adapterList = AdapterList(userList,this)
        binding.recyclerView.adapter = adapterList
    }

    override fun progressBar(show: Boolean) {
        if (show) binding.progressBar.visibility = View.VISIBLE
        else binding.progressBar.visibility = View.GONE
    }

    override fun error() {
        Toast.makeText(this, "not connection internet", Toast.LENGTH_SHORT).show()
    }
}