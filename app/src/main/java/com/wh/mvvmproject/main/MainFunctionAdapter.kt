package com.wh.mvvmproject.main

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.wh.mvvmproject.R

/**
 * Created by WanHui on 2023/3/3
 */
class MainFunctionAdapter : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_function_for_main) {
    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(R.id.text, item)
    }
}