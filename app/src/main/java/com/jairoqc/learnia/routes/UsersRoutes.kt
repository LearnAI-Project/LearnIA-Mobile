package com.jairoqc.learnia.routes
import com.jairoqc.learnia.models.ResponseHttp
import com.jairoqc.learnia.models.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

//Rutas, cambiarla por SpringBoot, uso actual Nodejs
interface UsersRoutes {
    @POST("users/create")
    fun register(@Body user: User): Call<ResponseHttp>
}