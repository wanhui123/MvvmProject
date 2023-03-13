package com.wh.mvvmproject.model.repository

import com.wh.mvvmproject.model.bean.Article
import com.wh.mvvmproject.model.bean.Banner
import com.wh.mvvmproject.model.http.WanRetrofitClient
import com.wh.mvvmproject.base.BaseRepository
import com.wh.mvvmproject.model.bean.BaseData

/**
 * Created by WanHui on 2023/1/31
 */
class HomeRepository : BaseRepository() {
    private val service = WanRetrofitClient.service

    suspend fun requestWanData(): BaseData<List<Banner>> {
        return executeRequest { service.getBanner() }
    }

    suspend fun requestRankData(page: Int): BaseData<Article> {
        return executeRequest { service.getArticle(page) }
    }
}