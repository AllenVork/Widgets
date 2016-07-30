package com.example.allen.customcanvas.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.allen.customcanvas.R;

/**
 * Created by Allen on 2016/7/30 0030.
 *  图片叠加
 *     http://www.cnblogs.com/DonkeyTomy/articles/3215137.html
 */
public class Layer extends View {
    private Paint circlePaint;
    private Paint srcPaint;

    private int winW;
    private int winH;

    public Layer(Context context) {
        super(context);
        init();
    }

    public Layer(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Layer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        drawBitmap(canvas);
        drawArcRec(canvas, 100);
    }

    private void init() {
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        winH = wm.getDefaultDisplay().getHeight();
        winW = wm.getDefaultDisplay().getWidth();

        circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setColor(Color.YELLOW);
    }

    private void drawArcRec(Canvas canvas, float h) {

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.GREEN);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(3);

        float r = h / 2 + winW * winW / (8 * h);
        RectF f = new RectF(0, 0, winW, 500);

        //首先创建画布
        canvas.saveLayer(f, paint);
        //画dst
        canvas.drawRect(f, paint);
        //设置模式
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        //画src
        paint.setColor(Color.RED);
        canvas.drawCircle(winW/ 2f, 500 - r, r, paint);

        paint.setXfermode(null);
        canvas.restore();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        int height = this.getHeight();
        Log.e("Layer", "height:" + height);
    }

    private void drawBitmap(Canvas canvas) {
        Bitmap dst = BitmapFactory.decodeResource(getContext().getResources(), R.mipmap.a);
        Bitmap src = BitmapFactory.decodeResource(getContext().getResources(), R.mipmap.b);

        canvas.drawColor(Color.GREEN);

        canvas.saveLayer(0, 0, 1000, 1000, null, Canvas.ALL_SAVE_FLAG);

        //首先保存画布，然后画dst,再设置模式，然后画src，最后restore.
        canvas.drawBitmap(dst, 0, 0, circlePaint);
        circlePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        canvas.drawBitmap(src, 100, 100, circlePaint);

        circlePaint.setXfermode(null);
        canvas.restore();
    }
}
