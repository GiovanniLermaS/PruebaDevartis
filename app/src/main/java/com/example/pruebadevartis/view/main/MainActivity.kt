package com.example.pruebadevartis.view.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.pruebadevartis.R
import com.example.pruebadevartis.application.MyApplication
import com.example.pruebadevartis.db.model.LoginRegister
import com.example.pruebadevartis.util.ViewModelFactory
import com.example.pruebadevartis.util.showProgress
import com.example.pruebadevartis.viewmodel.MainActivityViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var viewModelFactory: ViewModelFactory? = null
        @Inject set
    var mainActivityViewModel: MainActivityViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (applicationContext as MyApplication).getComponent()?.inject(this)

        mainActivityViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(MainActivityViewModel::class.java)

        //mainActivityViewModel?.registerUser("example", "example")
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btLogin -> {
                loginRegisterUser(true)
            }
            R.id.btRegister -> {
                loginRegisterUser(false)
            }
        }
    }

    private fun loginRegisterUser(isLogin: Boolean) {
        if (etUser.text.toString().isNotEmpty() && etPassword.text.toString()
                .isNotEmpty()
        ) {
            showProgress(this, isAlertInit = true)
            val register = LoginRegister()
            register.user = etUser.text.toString()
            register.password = etPassword.text.toString()
            mainActivityViewModel?.loginRegisterUser(register, isLogin)
            mainActivityViewModel?.getSuccessMain()?.observe(this) { registerResponse ->
                if (registerResponse.access_token != null) {
                    Snackbar.make(
                        clPrincipalView,
                        "UserId: ${registerResponse.user_id}, Token: ${registerResponse.access_token}",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
                if (registerResponse.message != null) {
                    Snackbar.make(
                        clPrincipalView,
                        registerResponse.message!!,
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
                showProgress(this, isAlertInit = false)
            }
        } else {
            Snackbar.make(clPrincipalView, "Campos vacíos", Snackbar.LENGTH_SHORT).show()
        }
    }
}