package com.example.pruebadevartis.view.register

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.pruebadevartis.R
import com.example.pruebadevartis.application.MyApplication
import com.example.pruebadevartis.util.ViewModelFactory
import com.example.pruebadevartis.viewmodel.RegisterActivityViewModel
import javax.inject.Inject

class RegisterActivity : AppCompatActivity() {

    var viewModelFactory: ViewModelFactory? = null
        @Inject set
    var registerActivityViewModel: RegisterActivityViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        (applicationContext as MyApplication).getComponent()?.inject(this)

        registerActivityViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(RegisterActivityViewModel::class.java)
    }
}