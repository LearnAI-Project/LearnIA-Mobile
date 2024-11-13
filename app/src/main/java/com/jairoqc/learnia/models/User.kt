package com.jairoqc.learnia.models

import com.google.gson.annotations.SerializedName

class User (
    @SerializedName("id") val id: String? = null,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("session_token") val sessionToken: String? = null

){
    override fun toString(): String {
        return "User(id='$id', email='$email', password='$password', sessionToken='$sessionToken')"
    }
}