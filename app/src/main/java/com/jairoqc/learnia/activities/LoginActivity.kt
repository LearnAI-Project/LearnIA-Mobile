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

class LoginActivity : AppCompatActivity() {
    //Instancias
    var textViewToRegister: TextView? = null
    var inputEmail: EditText? = null
    var inputPassword: EditText? = null
    var button: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets}
        //Search for ID
        textViewToRegister= findViewById(R.id.goToTheRegister)
        inputEmail= findViewById(R.id.loginEmailInput)
        inputPassword= findViewById(R.id.loginPasswordInput)
        button= findViewById(R.id.btnLogin)

        textViewToRegister?.setOnClickListener{goToRegister()}
        button?.setOnClickListener{login()} //Listening...
    }
    fun String.isEmailValid(): Boolean {
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }
    private fun validateForm(email:String,password:String): Boolean {
        if(email.isNullOrBlank()){
            Toast.makeText(this,"Correo inválido",Toast.LENGTH_LONG).show()
            return false
        }
        if(password.isNullOrBlank()|| password.length < 8){
            Toast.makeText(this,"La contraseña debe tener como mínimo 8 carácteres",Toast.LENGTH_LONG).show()
            return false
        }
        if(!email.isEmailValid()){
            Toast.makeText(this,"Correo inválido",Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }
    private fun goToRegister() {
        val i = Intent(this, RegisterActivity::class.java)
        startActivity(i)
    }

    //Speaking...
    private fun login(){
        val email= inputEmail?.text.toString()
        val password= inputPassword?.text.toString()
        if(validateForm(email,password)){
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
