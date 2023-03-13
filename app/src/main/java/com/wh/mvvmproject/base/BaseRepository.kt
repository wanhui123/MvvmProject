package com.wh.mvvmproject.base

import com.wh.mvvmproject.model.bean.BaseData
import com.wh.mvvmproject.model.bean.ReqState

/**
 * Created by WanHui on 2023/1/31
 */
open class BaseRepository {
    suspend fun <T : Any> executeRequest(block: suspend () -> BaseData<T>): BaseData<T> {
        val baseData = block.invoke()
        if (baseData.code == 0) {
            //正确
            baseData.state = ReqState.Success
        } else {
            baseData.state = ReqState.Error
        }
        return baseData
    }
}