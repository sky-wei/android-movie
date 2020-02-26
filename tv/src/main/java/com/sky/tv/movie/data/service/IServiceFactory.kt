package com.sky.tv.movie.data.service

/**
 * Created by sky on 2020-02-26.
 */
interface IServiceFactory {

    /**
     * 创建服务
     * @param tClass
     * @param <T>
     * @return
    </T> */
    fun <T> createService(tClass: Class<T>): T
}