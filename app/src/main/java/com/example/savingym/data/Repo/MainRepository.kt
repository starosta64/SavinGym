package com.example.savingym.data.Repo

import com.example.savingym.data.network.ApiClient
import com.example.savingym.data.network.MainApi

class MainRepository :IMainRepository{
    private var service: MainApi = ApiClient.instance.mainApi
}