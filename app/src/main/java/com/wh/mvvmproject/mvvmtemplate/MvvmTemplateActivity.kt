package com.wh.mvvmproject.mvvmtemplate

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.wh.mvvmproject.base.BaseActivity
import kotlinx.coroutines.launch

/**
 * Created by WanHui on 2023/3/3
 * 应用架构指南
 * https://developer.android.google.cn/topic/architecture?hl=zh-cn
 * https://github.com/android/nowinandroid
 */
class MvvmTemplateActivity : BaseActivity() {
    // 在系统第一次调用活动的 onCreate() 方法时创建一个 ViewModel。
    // 重新创建的活动接收由第一个活动创建的相同 MainViewModel 实例。
    // 使用 'by viewModels()' Kotlin 属性委托
    // 来自 activity-ktx 神器
    private val viewModel: MvvmTemplateViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    // 更新 UI 元素
                }
            }
        }
    }
}