package com.sungbin.dagger.example.di

import com.sungbin.dagger.example.MainActivity
import com.sungbin.dagger.example.module.FileModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [FileModule::class])
interface FileComponent {

    fun inject(activity: MainActivity)

    /*@Component.Builder
    interface Builder {
        fun build() : FileComponent
        fun fileModule(fileModule: FileModule) : Builder
    }*/
}