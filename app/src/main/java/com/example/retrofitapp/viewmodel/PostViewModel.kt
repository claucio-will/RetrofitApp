package com.example.myapplicationroom.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitapp.model.Post
import com.example.retrofitapp.repositories.PostRepository

import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel : ViewModel() {

    private val repository = PostRepository()

    val posts = MutableLiveData<List<Post>>()
    val errorMessage = MutableLiveData<String>()


    fun getPosts() {
        //launch: usado para criar um thread assincrona e não travar a thread principal
        viewModelScope.launch {
            val response = repository.getPost()

            //enquere não bloqueia a thread principal
            response.enqueue(object : Callback<List<Post>> {
                override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                    if (response.isSuccessful) {
                        // TODO Coloar um progressDialog antes que os dados apareca
                        Log.d("PostViewModel", "successfully")
                        posts.postValue(response.body())
                    } else {
                        Log.e("PostViewModel", "Error: ${response.code()}")
                        errorMessage.postValue("Error: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                    errorMessage.postValue(t.message)
                }

            })
        }
    }


}