package com.sky.tv.movie.data.cache

import android.content.Context
import com.google.gson.Gson
import com.jakewharton.disklrucache.DiskLruCache
import com.sky.android.common.util.Alog
import com.sky.android.common.util.FileUtil
import java.io.File
import java.io.IOException

/**
 * Created by sky on 2020-02-26.
 */
class CacheManager(context: Context) : ICacheManager {

    companion object {

        private const val MAX_SIZE = 1024 * 1024 * 100.toLong()
    }

    private val mGson: Gson = Gson()
    private var mDiskLruCache: DiskLruCache? = null

    init {
        val cacheDir = File(context.cacheDir, "data")
        try {
            mDiskLruCache = DiskLruCache
                .open(cacheDir, 1, 1, MAX_SIZE)
        } catch (e: IOException) {
            Alog.e("异常了", e)
        }
    }

    override fun buildKey(value: String): String {
        return value.toLowerCase()
    }

    @Synchronized
    override fun <T> get(key: String, tClass: Class<T>): T? {

        var snapshot: DiskLruCache.Snapshot? = null

        try {
            snapshot = mDiskLruCache?.get(key)
            if (snapshot != null) {
                val temp = snapshot.getString(0)
                return mGson.fromJson(temp, tClass)
            }
        } catch (tr: Throwable) {
            Alog.e("get异常", tr)
        } finally {
            FileUtil.closeQuietly(snapshot)
        }
        return null
    }

    @Synchronized
    override fun <T> put(key: String, value: T?) {

        var editor : DiskLruCache.Editor? = null

        try {
            editor = mDiskLruCache?.edit(key)
            if (editor != null) {
                editor[0] = mGson.toJson(value)
                editor.commit()
            }
            mDiskLruCache?.flush()
        } catch (tr: Throwable) {
            abortQuietly(editor)
            Alog.e("put异常", tr)
        }
    }

    @Synchronized
    override fun remove(key: String) {
        try {
            mDiskLruCache?.remove(key)
            mDiskLruCache?.flush()
        } catch (tr: Throwable) {
            Alog.e("remove异常", tr)
        }
    }

    override fun clear() {
        try {
            mDiskLruCache?.delete()
        } catch (e: IOException) {
            Alog.e("删除异常", e)
        }
    }

    override fun close() {
        FileUtil.closeQuietly(mDiskLruCache)
    }

    /**
     * 保存失败
     * @param editor
     */
    private fun abortQuietly(editor: DiskLruCache.Editor?) {
        try {
            editor?.abort()
        } catch (tr: Throwable) {
            Alog.e("abort异常", tr)
        }
    }
}