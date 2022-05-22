package com.music.findcat.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.music.findcat.newUser.NewUserActivity
import com.music.findcat.User
import com.music.findcat.databinding.ActivityUserBinding
import com.music.findcat.followers.FolloversActivity
import com.squareup.picasso.Picasso

class UserActivity : AppCompatActivity(),UserContract.View {
    private lateinit var binding: ActivityUserBinding
    private lateinit var presenterImpl: UserPresenterImpl
    private var login:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val args = intent.extras
        login = args?.get("LOGIN").toString()

        presenterImpl = UserPresenterImpl()
        presenterImpl.attachView(this)
        presenterImpl.response(login)

        binding.exit.setOnClickListener{
            finish()
        }
        binding.user.setOnClickListener {
            val intent = Intent(this, NewUserActivity::class.java)
            intent.putExtra("LOGIN", login)
            startActivity(intent)
        }

    }

    fun dataUser(user: User){
        binding.NameUser.text = user.login
        Picasso.get().load(user.avatarUrl).into(binding.avatarUser)
        binding.idUser.text = "id: ${user.id.toString()}"
        binding.SurnameUser.text = "Anonim"
        binding.AdminUser.text = administration(user.site_admin)

        binding.FollowersUser.setOnClickListener {
            val intent = Intent (this, FolloversActivity::class.java)
            intent.putExtra("LOGIN", user.login)
            startActivity(intent)
        }
    }




    fun administration (admin:Boolean) :String{
        if (admin==true){
            return "администратор"
        }else{
            return "пользователь"
        }
    }

    override fun loadUser(user: User) {
        dataUser(user)
    }

    override fun progressBar(show: Boolean) {
        if (show) binding.progressBar.visibility = View.VISIBLE
        else binding.progressBar.visibility = View.GONE
    }

    override fun error() {
        Toast.makeText(
            this,
            "Проверьте подключение к интернету и повторите попытку",
            Toast.LENGTH_SHORT
        ).show()

    }
}