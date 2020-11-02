package com.tottus.ui.register

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.tottus.databinding.ActivityRegisterBinding
import com.tottus.ui.showLongMessage
import com.tottus.ui.validateInputs
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
            val repeatPassword = binding.repeatPasswordText.text.toString()
            val termsCheck = binding.termsCheckBox

            if (validateInputs(names, lastNames, email, password, repeatPassword)) {
                if (validateRepeatPass(password, repeatPassword)) {
                    if (termsCheck.isChecked) {
                        viewModel.registerUser(names, lastNames, email, password)
                    } else {
                        showLongMessage("Acepte los terminos y condiciones")
                    }
                } else {
                    showLongMessage("Contraseñas no coinciden")
                }
            } else {
                showLongMessage("Existe Campos Vacios")
            }
        }
    }

    private fun initViewModel() {
        viewModel.apply {
            showMessage.observe(this@RegisterActivity, observerMessage())
            isSuccessful.observe(this@RegisterActivity, observerSuccessful())
        }
    }

    private fun observerMessage() = Observer<String> {
        Toast.makeText(this@RegisterActivity, it, Toast.LENGTH_LONG).show()
    }

    private fun observerSuccessful() = Observer<Boolean> {
        if (it) finish()
    }

    private fun validateRepeatPass(password: String, repeatPassword: String): Boolean {
        return password == repeatPassword
    }

}