package com.example.a241221

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a241221.fragments.NewsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            //add -   что надо добавить и куда надо добавить
            .add(R.id.container, NewsFragment())
            // commit - то что закончили
            .commit()
    }
}