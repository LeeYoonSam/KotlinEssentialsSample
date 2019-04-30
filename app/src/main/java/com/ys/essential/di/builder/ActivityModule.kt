package com.ys.essential.di.builder

import com.ys.essential.di.module.MainActModule
import com.ys.essential.main.MainActivity
import com.ys.essential.di.socpe.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActModule::class])
    abstract fun mainActivity(): MainActivity
}