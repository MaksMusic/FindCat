package com.music.findcat.followers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.music.findcat.FollowersList
import com.music.findcat.adapter.AdapterFollowersList

import com.music.findcat.databinding.ActivityFolloversBinding


class FolloversActivity : AppCompatActivity(),FollowersContact.View {
    private lateinit var binding: ActivityFolloversBinding
    private var login:String = ""
    private lateinit var presenterImplFollowers: FollowersPresnterlmpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFolloversBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intentString = intent.extras
        login = intentString?.get("LOGIN").toString()

        presenterImplFollowers = FollowersPresnterlmpl()
        presenterImplFollowers.attachView(this)
        presenterImplFollowers.response(login)

   binding.exit.setOnClickListener{
       finish()
   }
    }


    override fun loadUserGitHub(folloresList: ArrayList<FollowersList>) {
        val adapterListFollowersList = AdapterFollowersList(folloresList)
        binding.RRFollowings.adapter = adapterListFollowersList
    }

    override fun progressBar(show: Boolean) {
        if (show) binding.progressBarFollowers.visibility = View.VISIBLE
       else binding.progressBarFollowers.visibility = View.GONE
    }

    override fun error() {
        Toast.makeText(this, "not connection internet", Toast.LENGTH_SHORT).show()
    }


}