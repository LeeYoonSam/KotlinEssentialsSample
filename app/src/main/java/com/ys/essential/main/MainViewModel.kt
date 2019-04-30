package com.ys.essential.main

import com.ys.essential.BaseViewModel
import com.ys.essential.network.ApiService
import com.ys.essential.storage.SharedPreferenceStorage
import javax.inject.Inject

class MainViewModel @Inject constructor(private val sharedPreferenceStorage: SharedPreferenceStorage, val apiService: ApiService) : BaseViewModel() {
    fun getTestPrint() = println("call test print")

    fun testSavePreference() {
        sharedPreferenceStorage.put("key", "test")
        println("success test save")
    }

    fun testGetPreference() {
        println(sharedPreferenceStorage.getString("key"))
    }

    fun testApiService() {
        apiService.getTest()
    }
}