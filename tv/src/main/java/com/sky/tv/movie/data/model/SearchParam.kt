package com.sky.tv.movie.data.model

/**
 * Created by sky on 2020-02-26.
 */
data class SearchParam(
    var sort: String = "",
    var tags: String = "",
    var type: String = "",
    var tag: String,
    var limit: Int = 20,
    var start: Int = 0
)