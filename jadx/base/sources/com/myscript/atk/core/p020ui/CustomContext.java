package com.myscript.atk.core.p020ui;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import com.myscript.atk.core.Extent;
import com.myscript.atk.core.InkStyle;
import com.myscript.atk.core.InvalidateType;
import com.myscript.atk.core.Transform;

/* JADX INFO: loaded from: classes4.dex */
public class CustomContext {
    protected static final float DEFAULT_LINE_WIDTH_SCALE = 1.0f;
    public static final float DEFAULT_SCALE = 1.0f;
    public Canvas canvas;
    public Extent extent;
    public InvalidateType invalidateType;
    private Path mAndroidPath;
    private AndroidStroker mAndroidStroker;
    private Transform mArcTransformCenterTmp;
    private Matrix mArcTransformMatrix;
    private Paint mBitmapPaint;
    private Paint mBrushPaint;
    public float mDashDimension;
    public float mDashGapDimension;
    private Paint mDecorationPaint;
    public boolean mDoSmooth;
    public float[] mDocToScreenArray;
    private PathEffect mDocToScreenDashPathEffect;
    public Matrix mDocToScreenMatrix;
    private final float[] mDocToScreenPoints;
    public float mDocToScreenScaling;
    public int mFillColor;
    private Paint mGlyphPaint;
    public boolean mHasShadow;
    public int mInkColor;
    public InkStyle mInkStyle;
    public float mInkWidth;
    public boolean mIsDash;
    public boolean mIsFillStyle;
    public boolean mIsRounded;
    private Rect mOffscreenSourceRect;
    private Matrix mPathMatrix;
    private RectF mRectF;
    public boolean mStretchedFontRendering;
    private TextPaint mStringPaint;
    public int mStroking;
    private final float[] mTemporaryMatrixFloatArray;
    public boolean needCanvasRestore;
    public float scale = 1.0f;
    public float mLineWidthScale = 1.0f;
    public float mPixelSize = 0.0f;

    public CustomContext() {
        Matrix matrix = new Matrix();
        this.mDocToScreenMatrix = matrix;
        float[] fArr = new float[9];
        this.mDocToScreenArray = fArr;
        this.mTemporaryMatrixFloatArray = new float[9];
        this.mDocToScreenPoints = new float[4];
        matrix.getValues(fArr);
        computeScreenScaling();
    }

    public void setDocToScreenMatrix(Matrix matrix, float f, float f2) {
        this.mDocToScreenMatrix.set(matrix);
        this.mDocToScreenMatrix.preTranslate(f, f2);
        this.mDocToScreenMatrix.getValues(this.mDocToScreenArray);
        computeScreenScaling();
    }

    public void setDocToScreenMatrix(Transform transform, float f, float f2) {
        if (transform.getXShear() != 0.0f || transform.getYShear() != 0.0f) {
            throw new RuntimeException("Invalid Matrix: the transform matrix applies a rotation");
        }
        float[] fArr = this.mDocToScreenArray;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
        fArr[0] = transform.getXScale();
        this.mDocToScreenArray[1] = transform.getXShear();
        float[] fArr2 = this.mDocToScreenArray;
        float xTranslate = transform.getXTranslate();
        float[] fArr3 = this.mDocToScreenArray;
        fArr2[2] = xTranslate + (fArr3[0] * f);
        fArr3[3] = transform.getYShear();
        this.mDocToScreenArray[4] = transform.getYScale();
        float[] fArr4 = this.mDocToScreenArray;
        float yTranslate = transform.getYTranslate();
        float[] fArr5 = this.mDocToScreenArray;
        fArr4[5] = yTranslate + (fArr5[4] * f2);
        this.mDocToScreenMatrix.setValues(fArr5);
        computeScreenScaling();
    }

    private void computeScreenScaling() {
        float[] fArr = this.mDocToScreenArray;
        float f = fArr[0];
        float f2 = fArr[3];
        this.mDocToScreenScaling = (float) Math.sqrt((f * f) + (f2 * f2));
    }

    public float[] mapToScreen(float f, float f2, float f3, float f4) {
        float[] fArr = this.mDocToScreenPoints;
        float[] fArr2 = this.mDocToScreenArray;
        float f5 = f * fArr2[0];
        float f6 = fArr2[2];
        fArr[0] = f5 + f6;
        float f7 = fArr2[4];
        float f8 = fArr2[5];
        fArr[1] = (f2 * f7) + f8;
        fArr[2] = (f3 * fArr2[0]) + f6;
        fArr[3] = (f4 * f7) + f8;
        return fArr;
    }

    public float[] mapToScreen(float f, float f2) {
        float[] fArr = this.mDocToScreenPoints;
        float[] fArr2 = this.mDocToScreenArray;
        fArr[0] = (f * fArr2[0]) + fArr2[2];
        fArr[1] = (f2 * fArr2[4]) + fArr2[5];
        return fArr;
    }

    public PathEffect getDashPathEffect() {
        if (this.mDocToScreenDashPathEffect == null) {
            float f = this.mDashDimension;
            float f2 = this.mDocToScreenScaling;
            this.mDocToScreenDashPathEffect = new DashPathEffect(new float[]{f * f2, this.mDashGapDimension * f2}, 0.0f);
        }
        return this.mDocToScreenDashPathEffect;
    }

    public void resetDashPathEffect() {
        this.mDocToScreenDashPathEffect = null;
    }

    public Paint getBrushPaint() {
        if (this.mBrushPaint == null) {
            Paint paint = new Paint(1);
            this.mBrushPaint = paint;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            configureBrushPaint();
        }
        return this.mBrushPaint;
    }

    public void configureBrushPaint() {
        Paint paint = this.mBrushPaint;
        if (paint != null) {
            paint.setStrokeWidth(this.mInkWidth * this.mLineWidthScale * this.scale * this.mDocToScreenScaling);
            this.mBrushPaint.setStyle(AndroidStroker.isFill(this.mStroking) ? Paint.Style.FILL : Paint.Style.STROKE);
            this.mBrushPaint.setColor(this.mInkColor);
            this.mBrushPaint.setStrokeCap(this.mIsRounded ? Paint.Cap.ROUND : Paint.Cap.SQUARE);
        }
    }

    public Paint getDecorationPaint() {
        if (this.mDecorationPaint == null) {
            this.mDecorationPaint = new Paint(1);
        }
        return this.mDecorationPaint;
    }

    public AndroidStroker getAndroidStroker() {
        if (this.mAndroidStroker == null) {
            this.mAndroidStroker = new AndroidStroker(0.0f, 0);
            configureAndroidStroker();
        }
        return this.mAndroidStroker;
    }

    public void configureAndroidStroker() {
        AndroidStroker androidStroker = this.mAndroidStroker;
        if (androidStroker != null) {
            float f = this.mInkWidth;
            if (f > 0.0f) {
                androidStroker.setWidth(f * this.scale);
            }
            this.mAndroidStroker.setStroking(this.mStroking);
            this.mAndroidStroker.setSmooth(this.mDoSmooth);
            this.mAndroidStroker.setPixelSize(this.mPixelSize);
        }
    }

    public TextPaint getStringPaint() {
        if (this.mStringPaint == null) {
            this.mStringPaint = new TextPaint(193);
        }
        return this.mStringPaint;
    }

    public Paint getGlyphPaint() {
        if (this.mGlyphPaint == null) {
            this.mGlyphPaint = new Paint(193);
        }
        return this.mGlyphPaint;
    }

    public Matrix getPathMatrix() {
        if (this.mPathMatrix == null) {
            this.mPathMatrix = new Matrix();
        }
        return this.mPathMatrix;
    }

    public Paint getBitmapPaint() {
        if (this.mBitmapPaint == null) {
            this.mBitmapPaint = new Paint(2);
        }
        return this.mBitmapPaint;
    }

    public Rect getOffscreenSourceRect() {
        if (this.mOffscreenSourceRect == null) {
            this.mOffscreenSourceRect = new Rect();
        }
        return this.mOffscreenSourceRect;
    }

    public Matrix getArcTransformMatrix() {
        if (this.mArcTransformMatrix == null) {
            this.mArcTransformMatrix = new Matrix();
        }
        return this.mArcTransformMatrix;
    }

    public Transform getArcTransformCenterTmp() {
        if (this.mArcTransformCenterTmp == null) {
            this.mArcTransformCenterTmp = new Transform();
        }
        return this.mArcTransformCenterTmp;
    }

    public Path getAndroidPath() {
        if (this.mAndroidPath == null) {
            this.mAndroidPath = new Path();
        }
        return this.mAndroidPath;
    }

    public RectF getRectF() {
        if (this.mRectF == null) {
            this.mRectF = new RectF();
        }
        return this.mRectF;
    }

    public float[] getTemporaryMatrixFloatArray() {
        return this.mTemporaryMatrixFloatArray;
    }
}
