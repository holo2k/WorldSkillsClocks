package com.example.madventure

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import com.example.madventure.databinding.ActivitySignInBinding
import java.util.regex.Pattern.compile

class SignInActivity : Activity() {

    private lateinit var binding: ActivitySignInBinding
    lateinit var email: EditText
    lateinit var password: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        email = findViewById(R.id.email)
        password=findViewById((R.id.password))

    }
    val pattern = ("[a-z0-9]{1,256}" +
            "\\@"+
            "[a-z0-9]{1,10}" +
            "\\."+
            "[a-z]{1,3}")


    fun EmailValid (email:String):Boolean{
        return compile (pattern).matcher(email).matches()}

    fun signin(view: android.view.View)
    {
        if(email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty())
        {
            if(EmailValid(email.text.toString())){
                val intent = Intent(this@SignInActivity,ResultActivity::class.java)
                startActivity(intent)
            }
            else{
                val alert = AlertDialog.Builder(this)
                    .setTitle("Ошибка")
                    .setMessage("Введите корректный E-mail")
                    .setPositiveButton("OK", null)
                    .create()
                    .show()
            }

        }
        else
        {
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Заполните все поля")
                .setPositiveButton("OK", null)
                .create()
                .show()
        }
    }
}