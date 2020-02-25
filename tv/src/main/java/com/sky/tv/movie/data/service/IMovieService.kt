/*
 * Copyright (c) 2020 The sky Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sky.tv.movie.data.service

import com.sky.tv.movie.data.model.SearchModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by sky on 2020-02-25.
 */
interface IMovieService {

    /**
     * 搜索分类
     */
    @GET("new_search_subjects?&sort={sort}&tags={tags}&start={start}")
    fun newSearchSubjects(
        @Path("sort") sort: String = "U",
        @Path("tags") tags: String = "",
        @Path("start") start: Int = 0
    ): Observable<SearchModel>


    /**
     * 搜索
     */
    @GET("search_subjects?&type={type}&sort={sort}&tag={tag}&page_limit={limit}&page_start={start}")
    fun searchSubjects(
        @Path("type") type: String,
        @Path("sort") sort: String,
        @Path("tag") tag: String,
        @Path("limit") limit: Int = 20,
        @Path("limit") start: Int = 0
    ): Observable<SearchModel>
}