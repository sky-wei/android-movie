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

package com.sky.tv.movie.ui.activity

import android.content.Intent
import com.sky.tv.movie.R
import com.sky.tv.movie.ui.base.BaseActivity
import com.sky.tv.movie.ui.fragment.HomeFragment

/**
 * Created by sky on 2020-02-25.
 */
class HomeActivity : BaseActivity() {

    override fun getLayoutId()= R.layout.activity_home

    override fun initView(intent: Intent) {

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.home_frame, HomeFragment())
            .commit()
    }
}