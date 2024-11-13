package com.jairoqc.learnia.providers

import com.jairoqc.learnia.api.ApiRoutes
import com.jairoqc.learnia.models.ResponseHttp
import com.jairoqc.learnia.models.User
import com.jairoqc.learnia.routes.UsersRoutes
import retrofit2.Call

class UsersProvider {
    private var usersRoutes: UsersRoutes? = null
    init {
        val api = ApiRoutes()
        usersRoutes= api.getUserRoutes()
    }
    fun register(user: User): Call<ResponseHttp>? {
        return usersRoutes?.register(user)
    }
}