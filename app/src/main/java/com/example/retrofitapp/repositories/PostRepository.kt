package com.example.retrofitapp.repositories

import com.example.retrofitapp.RetrofitInstance


//Essa classe usa o objeto RetrofitInstance, que usa a ApiService para buscas os dados
class PostRepository {

    /**
     * Essa função busca os dados da api, dentro do objeto RetrofitInstance tem
     * uma propriedade do tipo ApiSevice, e ela que tem o metodo GET que busca os dados,
     * essa propriedade que está no objeto RetrofitInstance ela que configura o acesso
     * a API
     */
    fun getPost() = RetrofitInstance.api.getPosts()
}