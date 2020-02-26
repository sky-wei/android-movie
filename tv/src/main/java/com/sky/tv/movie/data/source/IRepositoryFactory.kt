package com.sky.tv.movie.data.source

/**
 * Created by sky on 2020-02-26.
 */
interface IRepositoryFactory {

    /**
     * 创建源
     * @return
     */
    fun createMovieSource(): IMovieSource
}