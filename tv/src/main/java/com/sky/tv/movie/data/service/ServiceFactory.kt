package com.sky.tv.movie.data.service

import com.sky.tv.movie.Constant
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by sky on 2020-02-26.
 */
class ServiceFactory : IServiceFactory {

    override fun <T> createService(tClass: Class<T>): T {
        return createRetrofit(createHttpClient(), Constant.BASE_URL).create(tClass)
    }

    /**
     * 创建OkHttpClient
     */
    private fun createHttpClient(): OkHttpClient {
        return OkHttpClient()
            .newBuilder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    /**
     * 创建Retrofit
     */
    private fun createRetrofit(client: OkHttpClient, baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}