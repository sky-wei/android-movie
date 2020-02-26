package com.sky.tv.movie.data.source.remote

import com.sky.tv.movie.data.model.MovieModel
import com.sky.tv.movie.data.model.SearchParam
import com.sky.tv.movie.data.source.IMovieSource
import io.reactivex.Observable

/**
 * Created by sky on 2020-02-26.
 */
class MovieRemoteSource : IMovieSource {


    override fun newSearchSubjects(param: SearchParam): Observable<List<MovieModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchSubjects(param: SearchParam): Observable<List<MovieModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}