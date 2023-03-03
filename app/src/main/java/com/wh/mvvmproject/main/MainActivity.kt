package com.wh.mvvmproject.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.wh.mvvmproject.R
import com.wh.mvvmproject.base.BaseActivity
import com.wh.mvvmproject.databinding.ActivityMainBinding
import com.wh.mvvmproject.mvvmtemplate.MvvmTemplateActivity
import com.wh.mvvmproject.proxy.ProxyActivity


class MainActivity : BaseActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) { ActivityMainBinding.inflate(layoutInflater) }
//    private val viewModel: MainViewModel by viewModels()

    private val mAdapter by lazy(LazyThreadSafetyMode.NONE) { MainFunctionAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = mAdapter
        mAdapter.setList(MainViewModel.LIST)
        Log.d("-------","${MainViewModel.LIST.size}")

        mAdapter.setOnItemClickListener{ adapter, _, position ->
            val item = adapter.getItem(position) ?: return@setOnItemClickListener
            when(item){
                "动态代理"->{
                    startActivity(Intent(this, ProxyActivity::class.java))
                }
                "MVVM"->{
                    startActivity(Intent(this, MvvmTemplateActivity::class.java))
                }
            }

        }
    }
}