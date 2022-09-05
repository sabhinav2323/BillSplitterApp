package com.abhinavsharma.billsplitterapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProviders
import com.abhinavsharma.billsplitterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel : MainViewModel by viewModels ()
    private var binding : ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.isLoading.value
            }
        }
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnLogin?.setOnClickListener {
            loginBtnOnClick()
        }

        binding?.btnSignUp?.setOnClickListener {
            signUpBtnOnclick()
        }
    }

    private fun loginBtnOnClick(){
        val intent = Intent(this, HomeScreenActivity::class.java)
        startActivity(intent)
    }

    private fun signUpBtnOnclick(){
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }
}