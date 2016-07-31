package com.example.allen.customcanvas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    fun initView() {
        scrollBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, ScrollingActivity::class.java)
            startActivity(intent)
        }
    }
}
