package com.ys.essential.di.module

import androidx.databinding.DataBindingUtil
import com.ys.essential.main.MainActivity
import com.ys.essential.databinding.ActivityMainBinding
import com.ys.essential.di.socpe.ActivityScope
import dagger.Module
import dagger.Provides
import androidx.lifecycle.ViewModelProviders
import com.ys.essential.BaseViewModelFactory
import com.ys.essential.R
import com.ys.essential.main.MainViewModel
import com.ys.essential.network.ApiService
import com.ys.essential.storage.SharedPreferenceStorage

@Module
class MainActModule {
    @Provides
    @ActivityScope
    fun provideMainActBinding(mainActivity: MainActivity) : ActivityMainBinding {
        return DataBindingUtil.setContentView(mainActivity, R.layout.activity_main)
    }

    @Provides
    @ActivityScope
    fun provideMainViewModel(mainActivity: MainActivity, storage: SharedPreferenceStorage, apiService: ApiService): MainViewModel {
        return ViewModelProviders
            .of(mainActivity, BaseViewModelFactory { MainViewModel(storage, apiService) } )
            .get(MainViewModel::class.java)
    }
}