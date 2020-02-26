package com.sky.tv.movie.data.cache

/**
 * Created by sky on 2020-02-26.
 */
interface ICacheManager {

    /**
     * 生成Key
     * @param value
     * @return
     */
    fun buildKey(value: String): String

    /**
     * 获取相应Key的信息
     * @param key
     * @param tClass
     * @param <T>
     * @return
    </T> */
    fun <T> get(key: String, tClass: Class<T>): T?

    /**
     * 保存相应的信息
     * @param key
     * @param value
     * @param <T>
    </T> */
    fun <T> put(key: String, value: T?)

    /**
     * 移除信息
     * @param key
     */
    fun remove(key: String)

    /**
     * 清除所有
     */
    fun clear()

    /**
     * 关闭
     */
    fun close()
}