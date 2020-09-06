package com.wya.movieapp.ui.Play

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wya.movieapp.ui.api.ApiClient
import com.wya.movieapp.ui.model.Play
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlayViewModel : ViewModel() {
    private var result: MutableLiveData<Play> = MutableLiveData()

    fun getResultPlay(): LiveData<Play> = result

    fun getLoadingPlay() {
        var apiClient = ApiClient()
        var call = apiClient.getPlayClient(
            ApiClient.API_KEY, "en", "1"
        )
        call.enqueue(object : Callback<Play> {
            override fun onFailure(call: Call<Play>, t: Throwable) {
                Log.d("Error>>>", t.toString())
            }

            override fun onResponse(call: Call<Play>, response: Response<Play>) {
                result.value = response.body()
            }

        })
    }
}