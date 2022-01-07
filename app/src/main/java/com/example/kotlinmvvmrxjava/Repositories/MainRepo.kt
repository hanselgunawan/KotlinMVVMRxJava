package com.example.kotlinmvvmrxjava.Repositories

import androidx.lifecycle.MutableLiveData
import com.example.kotlinmvvmrxjava.Common.Common
import com.example.kotlinmvvmrxjava.Model.PostModel
import com.example.kotlinmvvmrxjava.Network.APIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainRepo {
    private val apiService: APIService
    private val compositeDisposable = CompositeDisposable()

    init {
        apiService = Common.getAPIService
    }

    val getPostModelLiveData: MutableLiveData<MutableList<PostModel>>
    get() {
        val data: MutableLiveData<MutableList<PostModel>> = MutableLiveData<MutableList<PostModel>>()
        compositeDisposable.add(apiService.getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{ postModels ->
                if (postModels != null) {
                    data.value = postModels
                }
            })
        return data
    }
}