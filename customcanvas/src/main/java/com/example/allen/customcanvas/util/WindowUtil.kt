package com.example.allen.customcanvas.util

import android.content.Context

/**
 * Created by Allen on 2016/7/31 0031.
 */
fun dp2px(context: Context, dp: Float): Float {
    val scale = context.resources.displayMetrics.density
    return dp * scale + 0.5f
}
