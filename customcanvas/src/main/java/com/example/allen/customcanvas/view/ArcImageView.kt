package com.example.allen.customcanvas.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.WindowManager
import android.widget.ImageView
import com.example.allen.customcanvas.R
import com.example.allen.customcanvas.util.dp2px
import java.util.jar.Attributes

/**
 * Created by Allen on 2016/7/31 0031.
 */
class ArcImageView : ImageView {
    private var winW: Int = 0
    private var winH: Int = 0

    private var arcH: Float = 0f
    private var ARC_HEIGHT: Float = 50f
    private var recH: Float = 0f
    private var offset: Float = 0f

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attributes: AttributeSet) : super(context, attributes) {
        init()
    }

    private fun init() {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        winH = wm.defaultDisplay.height
        winW = wm.defaultDisplay.width
    }

    fun updateArcHeight(h: Float) {
        arcH = h
        invalidate()
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        recH = height.toFloat()
        Log.e("Layer", "height:" + recH)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        drawArcRect(canvas)
    }

    private fun drawArcRect(canvas: Canvas) {
        val dst = BitmapFactory.decodeResource(context.resources, R.mipmap.a)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = Color.RED
        paint.isAntiAlias = true
        val r = arcH / 2 + winW * winW / (8 * arcH)
        val f = RectF(0f, 0f, winW.toFloat(), recH)

        canvas.saveLayer(0f, 0f, winW.toFloat(), recH, paint, Canvas.ALL_SAVE_FLAG)
        canvas.drawCircle(winW / 2f, recH - r - (dp2px(context, ARC_HEIGHT)  - arcH), r, paint)

        paint.setXfermode(PorterDuffXfermode(PorterDuff.Mode.SRC_IN))
        paint.color = Color.YELLOW
        canvas.drawRect(f, paint)

        paint.setXfermode(null)
        canvas.restore()
    }
}