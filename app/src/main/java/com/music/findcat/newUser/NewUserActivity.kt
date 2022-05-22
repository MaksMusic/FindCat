package com.music.findcat.newUser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.music.findcat.NewUserList
import com.music.findcat.adapter.AdapterList
import com.music.findcat.adapter.AdapterNewUser
import com.music.findcat.databinding.ActivityNewUserBinding

class NewUserActivity : AppCompatActivity(),NewUserContact.View {
    private lateinit var binding: ActivityNewUserBinding
    private var login: String = ""
    private lateinit  var presenterImpl:NewUserPresenterImpl


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val args = intent.extras
         login = args?.get("LOGIN").toString()

        presenterImpl = NewUserPresenterImpl()
        presenterImpl.attachView(this)
        presenterImpl.responseNewUser(login)
        binding.exit.setOnClickListener{
            finish()
        }

    }

    override fun loadNewUserGitHub(newUserList: ArrayList<NewUserList>) {
     val adapterNewUser = AdapterNewUser(newUserList)
        binding.rrNewUser.adapter = adapterNewUser
    }

    override fun progressBar(show: Boolean) {
        if (show) binding.progresBar.visibility  = View.VISIBLE
        else binding.progresBar.visibility  = View.GONE

    }

    override fun error() {
        Toast.makeText(this, "not connection internet", Toast.LENGTH_SHORT).show()
    }
}




