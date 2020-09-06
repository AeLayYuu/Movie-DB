package com.wya.movieapp.ui.popular

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wya.movieapp.ui.api.ApiClient
import com.wya.movieapp.ui.model.Popular
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularViewModel: ViewModel() {
    private var result: MutableLiveData<Popular> = MutableLiveData()

    fun getResultPopular(): LiveData<Popular> =result

    fun getLoadingPopular(){
        var apiClient=ApiClient()
        var call= apiClient.getPopularClient(
            ApiClient.API_KEY,"en","1"
        )
        call.enqueue(object : Callback<Popular>{
            override fun onFailure(call: Call<Popular>, t: Throwable) {
                Log.d("Error >>>",t.toString())
            }

            override fun onResponse(call: Call<Popular>, response: Response<Popular>) {
                result.value=response.body()
            }

        })
    }
}