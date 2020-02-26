package com.example.savingym.data.network

import com.example.savingym.BuildConfig
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {

    private object Holder {

        val instance = ApiClient()

    }

    companion object {
        val instance: ApiClient by lazy { Holder.instance }
    }

    val authApi: AuthApi

    init {
        authApi = createRetrofit(
            "http://gym.areas.su/",
            initOkHttpClient()
        ).create(AuthApi::class.java)
    }

    //уровень подключения

    private fun initOkHttpClient(): OkHttpClient =
        OkHttpClient().newBuilder()
            .readTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(1, TimeUnit.MINUTES)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

    private fun createRetrofit(baseUrl: String, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}




