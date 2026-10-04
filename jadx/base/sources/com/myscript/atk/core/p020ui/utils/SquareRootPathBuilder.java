package com.myscript.atk.core.p020ui.utils;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextPaint;
import com.myscript.atk.core.InkStyle;

/* JADX INFO: loaded from: classes4.dex */
public final class SquareRootPathBuilder {
    public static final String SQUARE_ROOT_STRING = "√";
    private static final TextPaint mTextPaint = new TextPaint(1);

    public static Path getSquareRootPath(RectF rectF, float f, InkStyle inkStyle) {
        float fSqrt = (float) (Math.sqrt(rectF.height() * rectF.width() * f) * 0.05999999865889549d);
        RectF rectF2 = new RectF();
        RectF rectF3 = new RectF();
        divide(rectF, rectF2, rectF3, f);
        Path leftSquareRootPath = getLeftSquareRootPath(mTextPaint, rectF2, inkStyle);
        leftSquareRootPath.addPath(getRightSquareRootPath(rectF3, fSqrt));
        return leftSquareRootPath;
    }

    private static void divide(RectF rectF, RectF rectF2, RectF rectF3, float f) {
        rectF2.set(rectF);
        rectF3.set(rectF);
        rectF2.right = rectF2.left + (rectF.width() * f);
        rectF3.left = rectF2.right;
    }

    private static Path getLeftSquareRootPath(Paint paint, RectF rectF, InkStyle inkStyle) {
        Path path = new Path();
        Matrix matrix = new Matrix();
        RectF rectF2 = new RectF();
        paint.setTypeface(BestFontSelector.getBestFontFor(SQUARE_ROOT_STRING, paint, rectF, inkStyle));
        paint.getTextPath(SQUARE_ROOT_STRING, 0, 1, 0.0f, 0.0f, path);
        path.computeBounds(rectF2, true);
        matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.FILL);
        path.transform(matrix);
        return path;
    }

    private static Path getRightSquareRootPath(RectF rectF, float f) {
        RectF rectF2 = new RectF(-(f / 2.0f), 0.0f, rectF.width(), f);
        rectF2.offset(rectF.left, rectF.top);
        Path path = new Path();
        path.addRect(rectF2, Path.Direction.CCW);
        return path;
    }
}
