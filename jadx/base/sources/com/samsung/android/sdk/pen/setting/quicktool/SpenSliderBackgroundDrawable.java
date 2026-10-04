package com.samsung.android.sdk.pen.setting.quicktool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import com.revenuecat.purchases.p036ui.revenuecatui.components.SensibleDefaults;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAdaptiveColor;
import com.samsung.android.spen.C8357R;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpenSliderBackgroundDrawable.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u0000 52\u00020\u0001:\u000256BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0013J\u0010\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0005H\u0016J\u0012\u0010(\u001a\u00020 2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u0005H\u0017J\u000e\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020\u0017J\u000e\u0010.\u001a\u00020 2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010/\u001a\u00020 2\u0006\u0010-\u001a\u00020\u0017J\u0016\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\bJ\u0010\u00103\u001a\u00020 2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u00104\u001a\u00020 2\u0006\u0010\f\u001a\u00020\u0005H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSliderBackgroundDrawable;", "Landroid/graphics/drawable/Drawable;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "width", "", "height", "radius", "", "strokeWidth", "startAngle", "sweepAngle", "color", "", "<init>", "(Landroid/content/Context;IIFFFF[I)V", "mPaint", "Landroid/graphics/Paint;", "mDrawArcInfo", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSliderBackgroundDrawable$DrawArcInfo;", "mCenterX", "mCenterY", "mIsOutlineEnabled", "", "mIsNeedOutline", "mOutlineColor", "mOutlineWidth", "mGradientShader", "Landroid/graphics/SweepGradient;", "mCheckerboardShader", "Landroid/graphics/BitmapShader;", "close", "", "setDrawInfo", "drawArcInfo", "draw", "canvas", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "getOpacity", "setCheckerboardDrawableEnable", "enable", "setGradientColor", "setOutlineEnable", "isPointInPath", "x", "y", "updatePaint", "updateOutline", "Companion", "DrawArcInfo", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SpenSliderBackgroundDrawable extends Drawable {
    private static final String TAG = "SliderBackgroundDrawable";
    private final Context context;
    private float mCenterX;
    private float mCenterY;
    private BitmapShader mCheckerboardShader;
    private DrawArcInfo mDrawArcInfo;
    private SweepGradient mGradientShader;
    private boolean mIsNeedOutline;
    private boolean mIsOutlineEnabled;
    private int mOutlineColor;
    private float mOutlineWidth;
    private Paint mPaint;
    private final float startAngle;
    private final float sweepAngle;

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java", replaceWith = @ReplaceWith(expression = "PixelFormat.TRANSLUCENT", imports = {"android.graphics.PixelFormat"}))
    public int getOpacity() {
        return -3;
    }

    public SpenSliderBackgroundDrawable(Context context, int i, int i2, float f, float f2, float f3, float f4, int[] iArr) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.startAngle = f3;
        this.sweepAngle = f4;
        DrawArcInfo drawArcInfo = new DrawArcInfo(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 127, null);
        this.mDrawArcInfo = drawArcInfo;
        float f5 = i;
        float f6 = i2;
        drawArcInfo.setInfo(f5, f6, f, f2, f3, f4, 0.0f);
        this.mCenterX = f5 / 2.0f;
        this.mCenterY = f6 / 2.0f;
        this.mOutlineColor = context.getResources().getColor(C8357R.color.setting_qt_curved_slider_adaptive_outline_color);
        this.mOutlineWidth = context.getResources().getDimensionPixelSize(C8357R.dimen.qt_thickness_bg_outline_width);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f2);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setAntiAlias(true);
        this.mPaint = paint;
        if (iArr != null) {
            updatePaint(iArr);
        }
    }

    /* JADX INFO: compiled from: SpenSliderBackgroundDrawable.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ>\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006 "}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSliderBackgroundDrawable$DrawArcInfo;", "", "width", "", "height", "radius", "strokeWidth", "startAngle", "sweepAngle", "extendedAngle", "<init>", "(FFFFFFF)V", "getWidth", "()F", "setWidth", "(F)V", "getHeight", "setHeight", "getRadius", "setRadius", "getStrokeWidth", "setStrokeWidth", "getStartAngle", "setStartAngle", "getSweepAngle", "setSweepAngle", "getExtendedAngle", "setExtendedAngle", "setInfo", "", "toString", "", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public static final class DrawArcInfo {
        private float extendedAngle;
        private float height;
        private float radius;
        private float startAngle;
        private float strokeWidth;
        private float sweepAngle;
        private float width;

        public DrawArcInfo() {
            this(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 127, null);
        }

        public DrawArcInfo(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
            this.width = f;
            this.height = f2;
            this.radius = f3;
            this.strokeWidth = f4;
            this.startAngle = f5;
            this.sweepAngle = f6;
            this.extendedAngle = f7;
        }

        public /* synthetic */ DrawArcInfo(float f, float f2, float f3, float f4, float f5, float f6, float f7, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? 0.0f : f2, (i & 4) != 0 ? 0.0f : f3, (i & 8) != 0 ? 0.0f : f4, (i & 16) != 0 ? 0.0f : f5, (i & 32) != 0 ? 0.0f : f6, (i & 64) != 0 ? 0.0f : f7);
        }

        public final float getWidth() {
            return this.width;
        }

        public final void setWidth(float f) {
            this.width = f;
        }

        public final float getHeight() {
            return this.height;
        }

        public final void setHeight(float f) {
            this.height = f;
        }

        public final float getRadius() {
            return this.radius;
        }

        public final void setRadius(float f) {
            this.radius = f;
        }

        public final float getStrokeWidth() {
            return this.strokeWidth;
        }

        public final void setStrokeWidth(float f) {
            this.strokeWidth = f;
        }

        public final float getStartAngle() {
            return this.startAngle;
        }

        public final void setStartAngle(float f) {
            this.startAngle = f;
        }

        public final float getSweepAngle() {
            return this.sweepAngle;
        }

        public final void setSweepAngle(float f) {
            this.sweepAngle = f;
        }

        public final float getExtendedAngle() {
            return this.extendedAngle;
        }

        public final void setExtendedAngle(float f) {
            this.extendedAngle = f;
        }

        public final void setInfo(float width, float height, float radius, float strokeWidth, float startAngle, float sweepAngle, float extendedAngle) {
            this.width = width;
            this.height = height;
            this.radius = radius;
            this.strokeWidth = strokeWidth;
            this.startAngle = startAngle;
            this.sweepAngle = sweepAngle;
            this.extendedAngle = extendedAngle;
        }

        public String toString() {
            return "(width=" + this.width + " height=" + this.height + " radius=" + this.radius + " strokeWidth=" + this.strokeWidth + " startAngle=" + this.startAngle + " sweepAngle=" + this.sweepAngle + " extendedAngle=" + this.extendedAngle + ")";
        }
    }

    public final void close() {
        this.mPaint = null;
        this.mGradientShader = null;
        this.mCheckerboardShader = null;
    }

    public final void setDrawInfo(DrawArcInfo drawArcInfo) {
        Intrinsics.checkNotNullParameter(drawArcInfo, "drawArcInfo");
        this.mDrawArcInfo.setInfo(drawArcInfo.getWidth(), drawArcInfo.getHeight(), drawArcInfo.getRadius(), drawArcInfo.getStrokeWidth(), drawArcInfo.getStartAngle(), drawArcInfo.getSweepAngle(), drawArcInfo.getExtendedAngle());
        this.mCenterX = drawArcInfo.getWidth() / 2.0f;
        this.mCenterY = drawArcInfo.getHeight() / 2.0f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Canvas canvas2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        RectF rectF = new RectF(this.mCenterX - this.mDrawArcInfo.getRadius(), this.mCenterY - this.mDrawArcInfo.getRadius(), this.mCenterX + this.mDrawArcInfo.getRadius(), this.mCenterY + this.mDrawArcInfo.getRadius());
        if (this.mIsOutlineEnabled && this.mIsNeedOutline) {
            Paint paint = this.mPaint;
            if (paint != null) {
                paint.setShader(null);
            }
            Paint paint2 = this.mPaint;
            if (paint2 != null) {
                paint2.setStrokeWidth(this.mDrawArcInfo.getStrokeWidth() + this.mOutlineWidth);
            }
            Paint paint3 = this.mPaint;
            if (paint3 != null) {
                paint3.setColor(this.mOutlineColor);
            }
            float startAngle = this.mDrawArcInfo.getStartAngle();
            float sweepAngle = this.mDrawArcInfo.getSweepAngle();
            Paint paint4 = this.mPaint;
            Intrinsics.checkNotNull(paint4);
            canvas2 = canvas;
            canvas2.drawArc(rectF, startAngle, sweepAngle, false, paint4);
        } else {
            canvas2 = canvas;
        }
        Paint paint5 = this.mPaint;
        if (paint5 != null) {
            paint5.setStrokeWidth(this.mDrawArcInfo.getStrokeWidth());
        }
        BitmapShader bitmapShader = this.mCheckerboardShader;
        if (bitmapShader != null) {
            Paint paint6 = this.mPaint;
            if (paint6 != null) {
                paint6.setShader(bitmapShader);
            }
            float startAngle2 = this.mDrawArcInfo.getStartAngle();
            float sweepAngle2 = this.mDrawArcInfo.getSweepAngle();
            Paint paint7 = this.mPaint;
            Intrinsics.checkNotNull(paint7);
            canvas2.drawArc(rectF, startAngle2, sweepAngle2, false, paint7);
        }
        SweepGradient sweepGradient = this.mGradientShader;
        if (sweepGradient != null) {
            Paint paint8 = this.mPaint;
            if (paint8 != null) {
                paint8.setShader(sweepGradient);
            }
            float startAngle3 = this.mDrawArcInfo.getStartAngle();
            float sweepAngle3 = this.mDrawArcInfo.getSweepAngle();
            Paint paint9 = this.mPaint;
            Intrinsics.checkNotNull(paint9);
            canvas2.drawArc(rectF, startAngle3, sweepAngle3, false, paint9);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setAlpha(alpha);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setColorFilter(colorFilter);
        }
    }

    public final void setCheckerboardDrawableEnable(boolean enable) {
        if (enable) {
            if (this.mCheckerboardShader != null) {
                return;
            }
            Drawable drawable = this.context.getResources().getDrawable(C8357R.drawable.checkerboard_pattern);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            drawable.draw(new Canvas(bitmapCreateBitmap));
            this.mCheckerboardShader = new BitmapShader(bitmapCreateBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        } else {
            this.mCheckerboardShader = null;
        }
        invalidateSelf();
    }

    public final void setGradientColor(int[] color) {
        Intrinsics.checkNotNullParameter(color, "color");
        updatePaint(color);
        updateOutline(color[1]);
    }

    public final void setOutlineEnable(boolean enable) {
        this.mIsOutlineEnabled = enable;
    }

    public final boolean isPointInPath(float x, float y) {
        float f = x - this.mCenterX;
        float f2 = y - this.mCenterY;
        float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2));
        float radius = this.mDrawArcInfo.getRadius();
        Paint paint = this.mPaint;
        Intrinsics.checkNotNull(paint);
        float strokeWidth = radius + (paint.getStrokeWidth() / 2.0f);
        Paint paint2 = this.mPaint;
        Intrinsics.checkNotNull(paint2);
        if (fSqrt < strokeWidth - paint2.getStrokeWidth() || fSqrt > strokeWidth) {
            return false;
        }
        float degrees = (float) Math.toDegrees(Math.atan2(f2, f));
        Paint paint3 = this.mPaint;
        Intrinsics.checkNotNull(paint3);
        double strokeWidth2 = (((double) paint3.getStrokeWidth()) / (((double) this.mDrawArcInfo.getRadius()) * 3.141592653589793d)) * ((double) SensibleDefaults.X_OFFSET);
        if (degrees < 0.0f) {
            degrees += 360.0f;
        }
        float f3 = 360;
        double startAngle = ((double) (((this.mDrawArcInfo.getStartAngle() % f3) + f3) % f3)) - (strokeWidth2 / ((double) 2));
        double sweepAngle = ((((double) this.mDrawArcInfo.getSweepAngle()) + startAngle) % ((double) 360)) + strokeWidth2;
        if (this.mDrawArcInfo.getSweepAngle() >= 0.0f) {
            if (startAngle < sweepAngle) {
                double d = degrees;
                return startAngle <= d && d <= sweepAngle;
            }
            double d2 = degrees;
            return d2 >= startAngle || d2 <= sweepAngle;
        }
        if (sweepAngle < startAngle) {
            double d3 = degrees;
            return sweepAngle <= d3 && d3 <= startAngle;
        }
        double d4 = degrees;
        return d4 >= sweepAngle || d4 <= startAngle;
    }

    private final void updatePaint(int[] color) {
        float fCeil = (float) Math.ceil(this.mDrawArcInfo.getExtendedAngle());
        float f = (this.startAngle + this.sweepAngle) % 360.0f;
        float f2 = 2;
        float width = this.mDrawArcInfo.getWidth() / 2.0f;
        float height = this.mDrawArcInfo.getHeight() / 2.0f;
        SweepGradient sweepGradient = new SweepGradient(width, height, color, new float[]{0.0f, ((f * f2) + (f2 * fCeil)) / 360.0f});
        Matrix matrix = new Matrix();
        matrix.setRotate(-(f + fCeil), width, height);
        sweepGradient.setLocalMatrix(matrix);
        this.mGradientShader = sweepGradient;
        invalidateSelf();
    }

    private final void updateOutline(int color) {
        if (this.mIsOutlineEnabled) {
            this.mIsNeedOutline = SpenSettingUtilAdaptiveColor.isAdaptiveColor(this.context, color, SpenSettingUtilAdaptiveColor.UseType.DECISION_TRANSPARENCY_OUTLINE);
        }
    }
}
