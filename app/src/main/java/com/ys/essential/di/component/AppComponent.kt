package com.ys.essential.di.component

import android.app.Application
import com.ys.essential.App
import com.ys.essential.di.AppModule
import com.ys.essential.di.NetworkModule
import com.ys.essential.di.builder.ActivityModule
import com.ys.essential.di.StorageModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton
import dagger.BindsInstance

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, ActivityModule::class, NetworkModule::class, StorageModule::class])
interface AppComponent: AndroidInjector<App> {
    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<App>() {
        @BindsInstance
        abstract fun application(application: Application): Builder

        abstract override fun build(): AppComponent
    }
}
