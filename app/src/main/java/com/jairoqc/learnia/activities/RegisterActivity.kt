package com.jairoqc.learnia.activities

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jairoqc.learnia.R

class RegisterActivity : AppCompatActivity() {
    var textViewToLogin: TextView? = null
    var inputEmailRegister: EditText? = null
    var inputPasswordRegister: EditText?= null
    var inputPasswordReplitRegister: EditText? = null
    var buttonRegister: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        textViewToLogin= findViewById(R.id.goToTheLogin)
        inputEmailRegister= findViewById(R.id.registerInputEmail)
        inputPasswordRegister= findViewById(R.id.registerInputPassword)
        inputPasswordReplitRegister= findViewById(R.id.registerInputPasswordReplit)
        buttonRegister= findViewById(R.id.btnRegister)

        textViewToLogin?.setOnClickListener{goToTheLogin()}
        buttonRegister?.setOnClickListener{register()}

    }
    fun String.isEmailValid(): Boolean {
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }
    private fun validateForm(email:String,password:String,replit:String): Boolean {
        if(email.isNullOrBlank()){
            Toast.makeText(this,"Correo Inválido",Toast.LENGTH_LONG).show()
            return false
        }
        if(password.isNullOrBlank()|| password.length < 8){
            Toast.makeText(this,"La contraseña debe tener como mínimo 8 carácteres",Toast.LENGTH_LONG).show()
            return false
        }
        if(replit.isNullOrBlank()){
            Toast.makeText(this,"Las contraseñas no coinciden",Toast.LENGTH_LONG).show()
            return false
        }
        if(password!=replit){
            Toast.makeText(this,"Las contraseñas no coinciden",Toast.LENGTH_LONG).show()
            return false
        }
        if(!email.isEmailValid()){
            Toast.makeText(this,"Correo Inválido",Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }
    private fun goToTheLogin() {
        val i = Intent(this, LoginActivity::class.java)
        startActivity(i)
    }
    private fun register(){
        val email = inputEmailRegister?.text.toString()
        val password= inputPasswordRegister?.text.toString()
        val passwordReplit= inputPasswordReplitRegister?.text.toString()

        if(validateForm(email,password,passwordReplit)){
            Log.d("LoginActivity","El formulario es valido")
            Toast.makeText(this,"El formulario es valido",Toast.LENGTH_LONG).show()
            Toast.makeText(this,"El email es ${email}",Toast.LENGTH_LONG).show()
            Toast.makeText(this,"La contraseña es ${password}",Toast.LENGTH_LONG).show()

            Log.d("LoginActivity","El email es: $email")
            Log.d("LoginActivity","El email es: $password")
        }
        else{
            Log.d("LoginActivity","El formulario es invalido")
            Toast.makeText(this,"El formulario es invalido",Toast.LENGTH_LONG).show()
        }
    }
}