package com.sungbin.dagger.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sungbin.dagger.example.di.DaggerFileComponent
import com.sungbin.dagger.example.model.FileDataModel
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity() {

    @Inject
    @field:Named("name")
    lateinit var filesData: ArrayList<FileDataModel>

    @Inject
    @field:Named("random")
    lateinit var fileData2: ArrayList<FileDataModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerFileComponent.builder()
                .build()
                .inject(this)

        for(i in 0 until filesData.size){
            Log.d(filesData[i].data, "random id: ${fileData2[i].data}")
        }
    }
}