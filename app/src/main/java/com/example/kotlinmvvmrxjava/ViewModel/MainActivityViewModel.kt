package com.example.kotlinmvvmrxjava.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinmvvmrxjava.Model.PostModel
import com.example.kotlinmvvmrxjava.Repositories.MainRepo

class MainActivityViewModel: ViewModel() {

    private val mainRepo: MainRepo

    init {
        mainRepo = MainRepo()
    }

    val getPostList : LiveData<MutableList<PostModel>>
        get() = mainRepo.getPostModelLiveData
}