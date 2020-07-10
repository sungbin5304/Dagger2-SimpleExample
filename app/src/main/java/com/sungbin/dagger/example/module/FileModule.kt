package com.sungbin.dagger.example.module

import android.annotation.SuppressLint
import com.sungbin.dagger.example.model.FileDataModel
import dagger.Module
import dagger.Provides
import java.io.File
import javax.inject.Named
import kotlin.random.Random

@SuppressLint("SdCardPath")
@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

@Module
class FileModule {

    @Module
    companion object {
        @Provides
        @Named("name")
        @JvmStatic
        fun provideFileName(): ArrayList<FileDataModel> {
            val array = ArrayList<FileDataModel>()
            val files = File("/sdcard").list().map {
                val file = File(it)
                array.add(FileDataModel(file.name))
            }
            return array
        }

        @Provides
        @Named("random")
        @JvmStatic
        fun provideFilePath(): ArrayList<FileDataModel> {
            val array = ArrayList<FileDataModel>()
            val files = File("/sdcard").list().map {
                val file = File(it)
                array.add(FileDataModel(Random.nextInt(0, 10000).toString()))
            }
            return array
        }
    }
}