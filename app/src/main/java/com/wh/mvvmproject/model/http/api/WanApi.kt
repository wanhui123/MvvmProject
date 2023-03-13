package com.wh.mvvmproject.model.http.api

import com.wh.mvvmproject.model.bean.Article
import com.wh.mvvmproject.model.bean.Banner
import com.wh.mvvmproject.model.bean.BaseData
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by WanHui on 2023/1/31
 */
interface WanApi {
    @GET("banner/json")
    suspend fun getBanner(): BaseData<List<Banner>>

    //页码从0开始
    @GET("article/list/{page}/json")
    suspend fun getArticle(@Path("page") page: Int): BaseData<Article>
}