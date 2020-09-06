package com.wya.movieapp.ui.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wya.movieapp.ui.api.ApiClient
import com.wya.movieapp.ui.model.Detail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel: ViewModel() {
    private var topratedDetail: MutableLiveData<Detail> = MutableLiveData()

    fun getDetail(): LiveData<Detail> = topratedDetail

    fun getLoading(id :Int) {
        var apiClient = ApiClient()
        var apiCall = apiClient.getDetailClient(
            id,ApiClient.API_KEY,"en-US"
        )
        apiCall.enqueue(object : Callback<Detail>{
            override fun onFailure(call: Call<Detail>, t: Throwable) {
                Log.d("Error >>>>",t.toString())
            }

            override fun onResponse(call: Call<Detail>, response: Response<Detail>) {
                topratedDetail.value=response.body()
            }

        })
    }
}