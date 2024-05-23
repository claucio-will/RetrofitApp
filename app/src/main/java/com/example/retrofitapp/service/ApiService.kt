package com.example.retrofitapp.service


import com.example.retrofitapp.model.Post
import retrofit2.Call
import retrofit2.http.GET


/**
 * Aqui deve ser colocado todas Metodos
 */
interface ApiService {

    //Call facilita a execucao de requisição http, com ela usamo o metodo enquere que
    // faz a requisição, aonde tem o response
    @GET("posts")
    fun getPosts(): Call<List<Post>>
}