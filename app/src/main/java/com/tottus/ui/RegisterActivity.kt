package com.tottus.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.tottus.R
import com.tottus.databinding.ActivityRegisterBinding
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel


class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    private val viewModel: RegisterViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.materialToolbar)

        initViewModel()
        intiOnClick()
    }

    private fun intiOnClick() {
        binding.registerButton.setOnClickListener {
            val names = binding.namesText.text.toString()
            val lastNames = binding.lastNameText.text.toString()
            val email = binding.emailText.text.toString()
            val password = binding.passwordText.text.toString()
            viewModel.registerUser(names, lastNames, email, password)
        }
    }

    /** ViewModel **/
    private fun initViewModel() {
        viewModel.apply {
            showMessage.observe(this@RegisterActivity, observerMessage())
        }
    }

    /** Observer **/
    private fun observerMessage() = Observer<String> {
        Toast.makeText(this@RegisterActivity, it, Toast.LENGTH_LONG).show()
    }
}