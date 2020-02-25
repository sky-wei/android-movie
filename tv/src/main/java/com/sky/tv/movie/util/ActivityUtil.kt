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

package com.sky.tv.movie.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.sky.android.common.util.Alog

/**
 * Created by sky on 19-2-25.
 */
object ActivityUtil {

    /**
     * 启动Activity
     * @param context
     * @param activityClass 目标Activity
     */
    fun startActivity(context: Context, activityClass: Class<*>): Boolean {
        return startActivity(context, Intent(context, activityClass))
    }


    fun startActivity(context: Context, intent: Intent): Boolean {
        try { // 启动界面
            context.startActivity(intent)
            return true
        } catch (e: Exception) {
            Alog.e("启动Activity异常", e)
        }
        return false
    }

    fun startActivityForResult(activity: Activity, activityClass: Class<*>, requestCode: Int): Boolean {
        return startActivityForResult(activity, Intent(activity, activityClass), requestCode)
    }

    fun startActivityForResult(activity: Activity, intent: Intent, requestCode: Int): Boolean {
        try { // 启动指定的Activity
            activity.startActivityForResult(intent, requestCode)
            return true
        } catch (e: Exception) {
            Alog.e("启动Activity异常", e)
        }
        return false
    }

    fun startActivityForResult(fragment: Fragment, activityClass: Class<*>, requestCode: Int): Boolean {
        return startActivityForResult(fragment, Intent(fragment.context, activityClass), requestCode)
    }

    fun startActivityForResult(fragment: Fragment, intent: Intent, requestCode: Int): Boolean {
        try { // 启动指定的Activity
            fragment.startActivityForResult(intent, requestCode)
            return true
        } catch (e: Exception) {
            Alog.e("启动Activity异常", e)
        }
        return false
    }
}