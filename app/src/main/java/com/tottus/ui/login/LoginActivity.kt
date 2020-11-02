package com.tottus.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.tottus.databinding.ActivityLoginBinding
import com.tottus.domain.entity.UserDomain
import com.tottus.ui.*
import com.tottus.ui.register.RegisterActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initOnClick()
        initViewModel()
    }

    private fun initOnClick() {
        binding.registerHereText.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.loginButton.setOnClickListener {
            val email = binding.emailText.text.toString()
            val password = binding.passwordText.text.toString()
            if (validateInputs(email, password)) {
                viewModel.login(email, password)
            } else {
                showLongMessage("Existe Campos Vacios")
            }
        }
    }

    private fun initViewModel() {
        viewModel.apply {
            showResult.observe(this@LoginActivity, observerResult())
            isSuccessful.observe(this@LoginActivity, observerSuccessful())
        }
    }

    private fun observerResult() = Observer<Any> {
        when (it) {
            is String -> {
                showLongMessage(it)
            }
            is UserDomain -> {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("user", it)
                startActivity(intent)
            }
        }

    }

    private fun observerSuccessful() = Observer<Boolean> {
        if (it) finish()
    }
}