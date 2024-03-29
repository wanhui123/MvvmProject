package com.wh.mvvmproject.mvvmtemplate

import com.wh.mvvmproject.base.BaseViewModel
import com.wh.mvvmproject.model.bean.Banner
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random

/**
 * Created by WanHui on 2023/3/3
 */
class MvvmTemplateViewModel : BaseViewModel() {
    // 公开屏幕 UI 状态
    private val _uiState = MutableStateFlow(DiceUiState())
    val uiState: StateFlow<DiceUiState> = _uiState.asStateFlow()

    private val _bannerUiState = MutableStateFlow(BannerUiState())
    val bannerUiState = _bannerUiState.asStateFlow()

    // Handle business logic
    fun rollDice() {
        _uiState.update { currentState ->
            currentState.copy(
                firstDieValue = Random.nextInt(from = 1, until = 7),
                secondDieValue = Random.nextInt(from = 1, until = 7),
                numberOfRolls = currentState.numberOfRolls + 1,
            )
        }
    }

    fun getBanner(){

    }
}

data class DiceUiState(
    val firstDieValue: Int? = null,
    val secondDieValue: Int? = null,
    val numberOfRolls: Int = 0,
)

data class BannerUiState(
    val bannerList: List<Banner> ? = null
)