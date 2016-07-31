package com.example.allen.customcanvas

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import com.example.allen.customcanvas.util.dp2px
import kotlinx.android.synthetic.main.activity_scrolling.*

class ScrollingActivity : AppCompatActivity() {

    val ARC_HEIGHT = 50f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show() }

        initView()
    }

    fun initView() {
        app_bar.addOnOffsetChangedListener { appBarLayout, i ->
            val originH = appBarLayout.totalScrollRange
            var arcH = (originH + i) * 1.0f / originH * dp2px(this, ARC_HEIGHT)
            Log.e("ScrollingActivity", "height:$originH, i = $i, arcH: $arcH")
            arcIv.updateArcHeight(arcH)
            arcIv.requestLayout()
        }
    }
}
