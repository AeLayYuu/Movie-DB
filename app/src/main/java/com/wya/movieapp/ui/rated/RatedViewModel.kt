package com.wya.movieapp.ui.rated

import android.provider.Telephony
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wya.movieapp.ui.api.ApiClient
import com.wya.movieapp.ui.model.Rated
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RatedViewModel: ViewModel() {
    private var result: MutableLiveData<Rated> = MutableLiveData()

    fun getResultRated() :LiveData<Rated> =result

    fun getLoading(){
        var apiClient=ApiClient()
        var call = apiClient.getRatedClient(
            ApiClient.API_KEY,"en","1"
        )
        call.enqueue( object : Callback<Rated>{
            override fun onFailure(call: Call<Rated>, t: Throwable) {
                Log.d("Error>>..",t.toString())
            }

            override fun onResponse(call: Call<Rated>, response: Response<Rated>) {
                result.value=response.body()
            }

        })
    }
}