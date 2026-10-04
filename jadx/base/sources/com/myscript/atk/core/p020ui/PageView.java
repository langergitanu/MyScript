package com.myscript.atk.core.p020ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.Log;
import com.myscript.atk.core.CenterEllipticArc;
import com.myscript.atk.core.DecorationType;
import com.myscript.atk.core.Extent;
import com.myscript.atk.core.Glyph;
import com.myscript.atk.core.IColorInversionPolicy;
import com.myscript.atk.core.IPageView;
import com.myscript.atk.core.InkDecorationType;
import com.myscript.atk.core.InkStroke;
import com.myscript.atk.core.InkStyle;
import com.myscript.atk.core.InvalidateType;
import com.myscript.atk.core.LayoutGroup;
import com.myscript.atk.core.LayoutItemArc;
import com.myscript.atk.core.LayoutItemDecoration;
import com.myscript.atk.core.LayoutItemObject;
import com.myscript.atk.core.LayoutItemPoint;
import com.myscript.atk.core.LayoutItemString;
import com.myscript.atk.core.LayoutItemStroke;
import com.myscript.atk.core.MotionEvent;
import com.myscript.atk.core.Point;
import com.myscript.atk.core.PointerInfo;
import com.myscript.atk.core.Rectangle;
import com.myscript.atk.core.SWIGVectorMotionEvent;
import com.myscript.atk.core.Sprite;
import com.myscript.atk.core.TextImpl;
import com.myscript.atk.core.Transform;
import com.myscript.atk.core.TransformUtils;
import com.myscript.atk.core.p020ui.utils.BestFontSelector;
import com.myscript.atk.core.p020ui.utils.FontManager;
import com.myscript.atk.core.p020ui.utils.InkStyleCacheData;
import com.myscript.atk.core.p020ui.utils.SquareRootPathBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes4.dex */
public class PageView implements IPageView<CustomContext, Path> {
    private static final float ARROW_HEAD_RATIO = 0.75f;
    private static boolean DBG = false;
    protected static final float DEFAULT_LINE_WIDTH_SCALE = 1.0f;
    protected static final int PT1_X = 0;
    protected static final int PT1_Y = 1;
    protected static final int PT2_X = 2;
    protected static final int PT2_Y = 3;
    private static final String TAG = "PageView";
    private volatile BitmapCache mBitmapCache;
    private IColorInversionPolicy mColorInversionPolicy;
    private boolean mDrawImageSynchronously;
    protected boolean mIsCachingStroke;
    private float mLineWidthScale;
    private final OfflineSurfaceManager mOffscreenSurfaceManager;
    protected float mPixelSize;
    protected float mScaledDensity;
    private IUpdatableRendering mUpdatableRendering;
    private static final int SHADOW_COLOR = Color.argb(77, 0, 0, 0);
    private static final List<String> mStrechCharacters = new ArrayList(Arrays.asList("{", "}", "[", "]", "(", ")"));

    @Override // com.myscript.atk.core.IPageView
    public boolean supportsMotionPrediction() {
        return false;
    }

    public PageView(DisplayMetrics displayMetrics, OfflineSurfaceManager offlineSurfaceManager) {
        this(displayMetrics, false, offlineSurfaceManager);
    }

    public PageView(DisplayMetrics displayMetrics, boolean z, OfflineSurfaceManager offlineSurfaceManager) {
        this.mLineWidthScale = 1.0f;
        this.mPixelSize = 0.0f;
        this.mDrawImageSynchronously = true;
        this.mIsCachingStroke = z;
        this.mOffscreenSurfaceManager = offlineSurfaceManager == null ? new OfflineSurfaceManager() : offlineSurfaceManager;
        this.mScaledDensity = displayMetrics.scaledDensity;
    }

    public static void toggleTypesetBoxesDisplay() {
        DBG = !DBG;
    }

    public void setUpdatableRendering(IUpdatableRendering iUpdatableRendering) {
        this.mUpdatableRendering = iUpdatableRendering;
    }

    public void setBitmapCache(BitmapCache bitmapCache) {
        BitmapCache bitmapCache2 = this.mBitmapCache;
        if (bitmapCache2 != null) {
            synchronized (bitmapCache2) {
                bitmapCache2.clear();
            }
        }
        this.mBitmapCache = bitmapCache;
    }

    public void setPixelSize(float f) {
        this.mPixelSize = f;
    }

    public void setLineWidthScale(float f) {
        this.mLineWidthScale = f;
    }

    private void configureSelectionShadow(Paint paint, float f) {
        paint.setShadowLayer(0.09f * f, 0.0f, f * 0.3f, SHADOW_COLOR);
    }

    private void resetSelectionShadow(Paint paint) {
        paint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
    }

    @Override // com.myscript.atk.core.IPageView
    public void draw(int i, CustomContext customContext) {
        if (Color.alpha(i) == 0) {
            return;
        }
        customContext.canvas.drawColor(resolveColor(i));
    }

    @Override // com.myscript.atk.core.IPageView
    public void drawLine(Point point, Point point2, CustomContext customContext, boolean z, boolean z2) {
        PathEffect pathEffect;
        PageView pageView = this;
        if (Color.alpha(customContext.mInkColor) == 0) {
            return;
        }
        Paint brushPaint = customContext.getBrushPaint();
        Paint.Style style = brushPaint.getStyle();
        int color = brushPaint.getColor();
        brushPaint.setPathEffect(customContext.mIsDash ? customContext.getDashPathEffect() : null);
        brushPaint.setStyle(Paint.Style.STROKE);
        brushPaint.setColor(customContext.mInkColor);
        if (customContext.mHasShadow) {
            pageView.configureSelectionShadow(brushPaint, customContext.mDocToScreenScaling);
        }
        if (customContext.mIsDash && customContext.mHasShadow) {
            throw new UnsupportedOperationException("Dash style with shadow is not supported");
        }
        float[] fArrMapToScreen = customContext.mapToScreen(point.getX(), point.getY(), point2.getX(), point2.getY());
        float beginArrowSize = customContext.mInkStyle.getBeginArrowSize() * customContext.scale * customContext.mDocToScreenScaling;
        float f = beginArrowSize * 0.75f;
        float fAtan2 = (float) Math.atan2(fArrMapToScreen[3] - fArrMapToScreen[1], fArrMapToScreen[2] - fArrMapToScreen[0]);
        if (customContext.mIsDash && !z && !z2 && Build.VERSION.SDK_INT >= 28) {
            customContext.canvas.drawLine(fArrMapToScreen[0], fArrMapToScreen[1], fArrMapToScreen[2], fArrMapToScreen[3], brushPaint);
            pathEffect = null;
        } else {
            Path androidPath = customContext.getAndroidPath();
            androidPath.reset();
            androidPath.moveTo(fArrMapToScreen[0], fArrMapToScreen[1]);
            androidPath.lineTo(fArrMapToScreen[2], fArrMapToScreen[3]);
            if (z) {
                pathEffect = null;
                pageView.drawArrow(androidPath, fArrMapToScreen[0], fArrMapToScreen[1], 3.1415927f + fAtan2, f, beginArrowSize);
            } else {
                pathEffect = null;
            }
            if (z2) {
                pageView = this;
                pageView.drawArrow(androidPath, fArrMapToScreen[2], fArrMapToScreen[3], fAtan2, f, beginArrowSize);
            } else {
                pageView = this;
            }
            customContext.canvas.drawPath(androidPath, brushPaint);
        }
        brushPaint.setPathEffect(pathEffect);
        brushPaint.setStyle(style);
        brushPaint.setColor(color);
        if (customContext.mHasShadow) {
            pageView.resetSelectionShadow(brushPaint);
        }
    }

    private Path draw(InkStroke inkStroke, CustomContext customContext, Transform transform) {
        Path path = new Path();
        customContext.getAndroidStroker().stroke(inkStroke, transform, path);
        Path path2 = new Path(path);
        path2.transform(customContext.mDocToScreenMatrix);
        Paint brushPaint = customContext.getBrushPaint();
        if (customContext.mIsFillStyle) {
            Paint.Style style = brushPaint.getStyle();
            int color = brushPaint.getColor();
            brushPaint.setStyle(Paint.Style.FILL);
            brushPaint.setColor(customContext.mFillColor);
            customContext.canvas.drawPath(path2, brushPaint);
            brushPaint.setStyle(style);
            brushPaint.setColor(color);
        }
        if (customContext.mHasShadow) {
            configureSelectionShadow(brushPaint, customContext.mDocToScreenScaling);
        }
        brushPaint.setPathEffect(customContext.mIsDash ? customContext.getDashPathEffect() : null);
        customContext.canvas.drawPath(path2, brushPaint);
        brushPaint.setPathEffect(null);
        if (customContext.mHasShadow) {
            resetSelectionShadow(brushPaint);
        }
        return path;
    }

    private Path draw(com.myscript.atk.core.Path path, CustomContext customContext, Transform transform) {
        if (Float.compare(0.0f, customContext.mInkWidth) >= 0 && !customContext.mIsFillStyle) {
            return null;
        }
        if (transform != null) {
            path = TransformUtils.mapped(path, transform);
        }
        Path path2 = new Path();
        customContext.getAndroidStroker().stroke(path, path2);
        Path path3 = new Path(path2);
        path3.transform(customContext.mDocToScreenMatrix);
        Paint brushPaint = customContext.getBrushPaint();
        if (customContext.mIsFillStyle) {
            Paint.Style style = brushPaint.getStyle();
            int color = brushPaint.getColor();
            brushPaint.setStyle(Paint.Style.FILL);
            brushPaint.setColor(customContext.mFillColor);
            customContext.canvas.drawPath(path3, brushPaint);
            brushPaint.setStyle(style);
            brushPaint.setColor(color);
        }
        if (customContext.mHasShadow) {
            configureSelectionShadow(brushPaint, customContext.mDocToScreenScaling);
        }
        brushPaint.setPathEffect(customContext.mIsDash ? customContext.getDashPathEffect() : null);
        customContext.canvas.drawPath(path3, brushPaint);
        brushPaint.setPathEffect(null);
        if (customContext.mHasShadow) {
            resetSelectionShadow(brushPaint);
        }
        return path2;
    }

    @Override // com.myscript.atk.core.IPageView
    public void draw(Path path, CustomContext customContext) {
        Path path2 = new Path(path);
        path2.transform(customContext.mDocToScreenMatrix);
        Paint brushPaint = customContext.getBrushPaint();
        if (customContext.mIsFillStyle) {
            Paint.Style style = brushPaint.getStyle();
            int color = brushPaint.getColor();
            brushPaint.setStyle(Paint.Style.FILL);
            brushPaint.setColor(customContext.mFillColor);
            customContext.canvas.drawPath(path2, brushPaint);
            brushPaint.setStyle(style);
            brushPaint.setColor(color);
        }
        customContext.canvas.drawPath(path2, brushPaint);
    }

    @Override // com.myscript.atk.core.IPageView
    public void draw(long j, InkStroke inkStroke, CustomContext customContext, Transform transform) {
        try {
            draw(inkStroke, customContext, transform);
        } finally {
            inkStroke.delete();
        }
    }

    @Override // com.myscript.atk.core.IPageView
    public Path draw(LayoutItemStroke layoutItemStroke, CustomContext customContext, Transform transform) {
        try {
            return draw(layoutItemStroke.getInkStroke(), customContext, transform);
        } finally {
            layoutItemStroke.delete();
        }
    }

    @Override // com.myscript.atk.core.IPageView
    public void drawWithPrediction(long j, InkStroke inkStroke, CustomContext customContext, Transform transform, SWIGVectorMotionEvent sWIGVectorMotionEvent, boolean z) {
        com.myscript.atk.core.Path path = inkStroke.getPath();
        if (!sWIGVectorMotionEvent.isEmpty()) {
            PointerInfo back = inkStroke.getPath().getBack();
            for (MotionEvent motionEvent : sWIGVectorMotionEvent) {
                back.setX((float) motionEvent.getX());
                back.setY((float) motionEvent.getY());
                back.setT(motionEvent.getT());
                path.lineTo(back);
            }
        }
        draw(path, customContext, transform);
    }

    @Override // com.myscript.atk.core.IPageView
    public void drawPath(String str, com.myscript.atk.core.Path path, InkStyle inkStyle, boolean z, CustomContext customContext) {
        styleChanged(inkStyle, customContext);
        draw(path, customContext, (Transform) null);
    }

    protected float ellipsePointX_SVG(float f, float f2, float f3) {
        return (float) (((double) f) * Math.cos(f3));
    }

    protected float ellipsePointY_SVG(float f, float f2, float f3) {
        return (float) (((double) f2) * Math.sin(f3));
    }

    @Override // com.myscript.atk.core.IPageView
    public void draw(LayoutItemArc layoutItemArc, CustomContext customContext, Transform transform) throws Throwable {
        Paint paint;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        InkDecorationType inkDecorationType;
        int i;
        Paint.Style style;
        PageView pageView = this;
        try {
            CenterEllipticArc centerParametrization = layoutItemArc.getCenterParametrization();
            if (transform != null && !transform.isIdentity()) {
                Point map = transform.map(centerParametrization.getCx(), centerParametrization.getCy());
                centerParametrization.setCx(map.getX());
                centerParametrization.setCy(map.getY());
                Transform arcTransformCenterTmp = customContext.getArcTransformCenterTmp();
                arcTransformCenterTmp.setIdentity();
                arcTransformCenterTmp.rotate2(centerParametrization.getPhi());
                Point map2 = transform.map(0.0f, 0.0f);
                Point map3 = arcTransformCenterTmp.map(centerParametrization.getRx(), 0.0f);
                Point map4 = arcTransformCenterTmp.map(0.0f, centerParametrization.getRy());
                Point map5 = transform.map(map3.getX(), map3.getY());
                Point map6 = transform.map(map4.getX(), map4.getY());
                map5.set(map5.getX() - map2.getX(), map5.getY() - map2.getY());
                map6.set(map6.getX() - map2.getX(), map6.getY() - map2.getY());
                centerParametrization.setPhi((float) Math.atan2(map5.getY(), map5.getX()));
                centerParametrization.setRx(map5.length());
                centerParametrization.setRy(map6.length());
            }
            float ry = centerParametrization.getRy();
            float rx = centerParametrization.getRx();
            float phi = centerParametrization.getPhi();
            float startAngle = centerParametrization.getStartAngle();
            float sweepAngle = centerParametrization.getSweepAngle();
            float degrees = (float) Math.toDegrees(startAngle);
            double d = sweepAngle;
            float degrees2 = (float) Math.toDegrees(d);
            boolean z = d >= 6.282185307179586d || d <= -6.282185307179586d;
            Matrix arcTransformMatrix = customContext.getArcTransformMatrix();
            arcTransformMatrix.reset();
            arcTransformMatrix.setTranslate(centerParametrization.getCx(), centerParametrization.getCy());
            if (Float.compare(phi, 0.0f) != 0) {
                arcTransformMatrix.preRotate((float) Math.toDegrees(phi));
            }
            arcTransformMatrix.setConcat(customContext.mDocToScreenMatrix, arcTransformMatrix);
            Paint brushPaint = customContext.getBrushPaint();
            float strokeWidth = brushPaint.getStrokeWidth();
            brushPaint.setStrokeWidth(strokeWidth);
            if (customContext.mIsDash) {
                throw new UnsupportedOperationException("Dash style is not supported with arcs and ovals");
            }
            if (customContext.mIsDash && customContext.mHasShadow) {
                throw new UnsupportedOperationException("Dash style with shadow is not supported");
            }
            int i2 = customContext.mFillColor;
            if (!customContext.mIsFillStyle || Color.alpha(i2) == 0) {
                paint = brushPaint;
                f = degrees;
                f2 = sweepAngle;
                f3 = degrees2;
                f4 = strokeWidth;
            } else {
                Paint.Style style2 = brushPaint.getStyle();
                int color = brushPaint.getColor();
                brushPaint.setStyle(Paint.Style.FILL);
                brushPaint.setColor(i2);
                customContext.canvas.save();
                customContext.canvas.concat(arcTransformMatrix);
                if (z) {
                    i = color;
                    customContext.canvas.drawOval(-rx, -ry, rx, ry, brushPaint);
                    f2 = sweepAngle;
                    style = style2;
                    paint = brushPaint;
                    f = degrees;
                    f3 = degrees2;
                    f4 = strokeWidth;
                } else {
                    i = color;
                    f2 = sweepAngle;
                    style = style2;
                    paint = brushPaint;
                    f = degrees;
                    f3 = degrees2;
                    f4 = strokeWidth;
                    customContext.canvas.drawArc(-rx, -ry, rx, ry, f, f3, false, paint);
                }
                customContext.canvas.restore();
                paint.setStyle(style);
                paint.setColor(i);
            }
            if (Color.alpha(customContext.mInkColor) != 0) {
                Paint.Style style3 = paint.getStyle();
                int color2 = paint.getColor();
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(customContext.mInkColor);
                if (customContext.mHasShadow) {
                    pageView.configureSelectionShadow(paint, customContext.mDocToScreenScaling);
                }
                Path androidPath = customContext.getAndroidPath();
                androidPath.reset();
                if (z) {
                    androidPath.addOval(-rx, -ry, rx, ry, Path.Direction.CCW);
                    f5 = rx;
                    f6 = ry;
                } else {
                    androidPath.addArc(-rx, -ry, rx, ry, f, f3);
                    f5 = rx;
                    f6 = ry;
                }
                InkDecorationType firstDecoration = layoutItemArc.getFirstDecoration();
                InkDecorationType lastDecoration = layoutItemArc.getLastDecoration();
                if (firstDecoration == InkDecorationType.ARROW_HEAD || lastDecoration == InkDecorationType.ARROW_HEAD) {
                    float beginArrowSize = customContext.mInkStyle.getBeginArrowSize() * customContext.scale;
                    float f8 = beginArrowSize * 0.75f;
                    float f9 = f2 / 100.0f;
                    if (firstDecoration == InkDecorationType.ARROW_HEAD) {
                        float fEllipsePointX_SVG = pageView.ellipsePointX_SVG(f5, f6, startAngle);
                        float fEllipsePointY_SVG = pageView.ellipsePointY_SVG(f5, f6, startAngle);
                        float f10 = startAngle + f9;
                        try {
                            float fAtan2 = (float) Math.atan2(fEllipsePointY_SVG - pageView.ellipsePointY_SVG(f5, f6, f10), fEllipsePointX_SVG - pageView.ellipsePointX_SVG(f5, f6, f10));
                            f7 = startAngle;
                            androidPath = androidPath;
                            inkDecorationType = lastDecoration;
                            pageView = this;
                            pageView.drawArrow(androidPath, fEllipsePointX_SVG, fEllipsePointY_SVG, fAtan2, f8, beginArrowSize);
                        } catch (Throwable th) {
                            th = th;
                            layoutItemArc.delete();
                            throw th;
                        }
                    } else {
                        f7 = startAngle;
                        inkDecorationType = lastDecoration;
                    }
                    if (inkDecorationType == InkDecorationType.ARROW_HEAD) {
                        float f11 = f7 + f2;
                        float fEllipsePointX_SVG2 = pageView.ellipsePointX_SVG(f5, f6, f11);
                        float fEllipsePointY_SVG2 = pageView.ellipsePointY_SVG(f5, f6, f11);
                        float f12 = f11 - f9;
                        Path path = androidPath;
                        float fAtan22 = (float) Math.atan2(fEllipsePointY_SVG2 - pageView.ellipsePointY_SVG(f5, f6, f12), fEllipsePointX_SVG2 - pageView.ellipsePointX_SVG(f5, f6, f12));
                        pageView = this;
                        androidPath = path;
                        pageView.drawArrow(androidPath, fEllipsePointX_SVG2, fEllipsePointY_SVG2, fAtan22, f8, beginArrowSize);
                    }
                }
                androidPath.transform(arcTransformMatrix);
                customContext.canvas.drawPath(androidPath, paint);
                paint.setStrokeWidth(f4);
                paint.setStyle(style3);
                paint.setColor(color2);
                if (customContext.mHasShadow) {
                    pageView.resetSelectionShadow(paint);
                }
            }
            layoutItemArc.delete();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.myscript.atk.core.IPageView
    public void draw(LayoutItemPoint layoutItemPoint, CustomContext customContext, Transform transform) {
        layoutItemPoint.delete();
    }

    /* JADX WARN: Finally extract failed */
    @Override // com.myscript.atk.core.IPageView
    public void draw(LayoutItemString layoutItemString, CustomContext customContext, Transform transform) {
        float xTranslate;
        float yTranslate;
        float xScale;
        float yScale;
        SpannableString spannableString;
        float f;
        float f2;
        if (transform != null) {
            try {
                xTranslate = transform.getXTranslate();
                yTranslate = transform.getYTranslate();
                xScale = transform.getXScale();
                yScale = transform.getYScale();
            } finally {
                layoutItemString.delete();
            }
        } else {
            xTranslate = 0.0f;
            yTranslate = 0.0f;
            xScale = 1.0f;
            yScale = 1.0f;
        }
        TextPaint stringPaint = customContext.getStringPaint();
        int i = 255;
        if (DBG) {
            int i2 = 0;
            while (i2 < layoutItemString.getGlyphCount()) {
                Glyph glyphAt = layoutItemString.getGlyphAt(i2);
                float parallelogramX = glyphAt.getParallelogramX() + xTranslate;
                float parallelogramY = glyphAt.getParallelogramY() + yTranslate;
                float parallelogramUX = parallelogramX + (glyphAt.getParallelogramUX() * xScale);
                float parallelogramVY = parallelogramY + (glyphAt.getParallelogramVY() * yScale);
                stringPaint.setColor(Color.argb(100, new Random().nextInt(i), new Random().nextInt(255), new Random().nextInt(255)));
                float[] fArrMapToScreen = customContext.mapToScreen(parallelogramX, parallelogramY, parallelogramUX, parallelogramVY);
                stringPaint.setStyle(Paint.Style.FILL);
                customContext.canvas.drawRect(fArrMapToScreen[0], fArrMapToScreen[1], fArrMapToScreen[2], fArrMapToScreen[3], stringPaint);
                stringPaint.setStyle(Paint.Style.STROKE);
                glyphAt.delete();
                i2++;
                i = 255;
                xTranslate = xTranslate;
                yTranslate = yTranslate;
            }
        }
        float f3 = xTranslate;
        float f4 = yTranslate;
        boolean zContains = customContext.mStretchedFontRendering;
        if (!zContains && layoutItemString.getStyleCount() > 0) {
            zContains = layoutItemString.getStyleAt(0).getFontFamily().contains("STIX");
        }
        if (!zContains) {
            if (customContext.mHasShadow) {
                configureSelectionShadow(stringPaint, customContext.mDocToScreenScaling);
            }
            Glyph glyphAt2 = layoutItemString.getGlyphAt(0);
            float parallelogramVY2 = glyphAt2.getParallelogramVY();
            float parallelogramY2 = glyphAt2.getParallelogramY() + (yScale * parallelogramVY2);
            float linesBaseLine = glyphAt2.hasLines() ? (1.0f - glyphAt2.getLinesBaseLine()) * parallelogramVY2 : parallelogramY2;
            float parallelogramX2 = glyphAt2.getParallelogramX();
            boolean zHasSlices = glyphAt2.hasSlices();
            if (zHasSlices) {
                parallelogramX2 += glyphAt2.getSlicesLeft() * glyphAt2.getParallelogramUX();
            }
            glyphAt2.delete();
            float f5 = parallelogramX2 + f3;
            float f6 = (parallelogramY2 + f4) - linesBaseLine;
            int styleCount = layoutItemString.getStyleCount();
            char c = 4;
            if (styleCount == 1) {
                InkStyleCacheData data = InkStyleCacheData.getData(layoutItemString.getStyleAt(0), InkStyleCacheData.COLOR | InkStyleCacheData.FONT_PROPERTIES);
                int iRound = Math.round(data.fontSize * customContext.scale * customContext.mDocToScreenArray[4]);
                stringPaint.setStyle(Paint.Style.FILL);
                stringPaint.setColor(resolveColor(data.color));
                stringPaint.setTypeface(FontManager.getTypeface(data));
                float f7 = iRound;
                stringPaint.setTextSize(f7);
                stringPaint.setLetterSpacing(FontManager.computeLetterSpacing(data.isDefaultFont, f7 / this.mScaledDensity));
                String label = layoutItemString.getLabel();
                if (zHasSlices) {
                    f2 = 0.0f;
                } else {
                    Path path = new Path();
                    stringPaint.getTextPath(label, 0, 1, 0.0f, 0.0f, path);
                    stringPaint = stringPaint;
                    RectF rectF = new RectF();
                    path.computeBounds(rectF, true);
                    f2 = rectF.left;
                }
                float[] fArrMapToScreen2 = customContext.mapToScreen(f5, f6);
                customContext.canvas.drawText(label, fArrMapToScreen2[0] - f2, fArrMapToScreen2[1], stringPaint);
            } else {
                String label2 = layoutItemString.getLabel();
                SpannableString spannableString2 = new SpannableString(label2);
                TextImpl textImpl = new TextImpl(label2);
                InkStyleCacheData inkStyleCacheData = null;
                int i3 = 0;
                while (i3 < styleCount) {
                    char c2 = c;
                    int styleRangeAt_fromGlyph = layoutItemString.getStyleRangeAt_fromGlyph(i3);
                    int styleRangeAt_toGlyph = layoutItemString.getStyleRangeAt_toGlyph(i3);
                    int glyphUtf16BeginAt = textImpl.getGlyphUtf16BeginAt(styleRangeAt_fromGlyph);
                    int glyphUtf16EndAt = textImpl.getGlyphUtf16EndAt(styleRangeAt_toGlyph);
                    InkStyleCacheData data2 = InkStyleCacheData.getData(layoutItemString.getStyleAt(i3), InkStyleCacheData.COLOR | InkStyleCacheData.FONT_PROPERTIES);
                    if (i3 == 0) {
                        inkStyleCacheData = data2;
                    }
                    int i4 = styleCount;
                    int iRound2 = Math.round(data2.fontSize * customContext.scale * customContext.mDocToScreenArray[c2]);
                    int i5 = data2.color;
                    boolean z = zHasSlices;
                    spannableString2.setSpan(new CustomTextSpan(FontManager.getTypeface(data2), FontManager.getFontStyle(data2), iRound2, FontManager.computeLetterSpacing(data2.isDefaultFont, iRound2 / this.mScaledDensity), resolveColor(data2.color)), glyphUtf16BeginAt, glyphUtf16EndAt, 33);
                    i3++;
                    c = c2;
                    styleCount = i4;
                    zHasSlices = z;
                }
                char c3 = c;
                boolean z2 = zHasSlices;
                if (inkStyleCacheData == null) {
                    return;
                }
                stringPaint.setColor(resolveColor(inkStyleCacheData.color));
                Typeface typeface = FontManager.getTypeface(inkStyleCacheData);
                stringPaint.setTypeface(typeface);
                float fRound = Math.round(inkStyleCacheData.fontSize * customContext.scale * customContext.mDocToScreenArray[c3]);
                stringPaint.setTextSize(fRound);
                stringPaint.setLetterSpacing(FontManager.computeLetterSpacing(inkStyleCacheData.isDefaultFont, fRound / this.mScaledDensity));
                if (z2) {
                    spannableString = spannableString2;
                    f = 0.0f;
                } else {
                    Path path2 = new Path();
                    spannableString = spannableString2;
                    stringPaint.getTextPath(spannableString2.toString(), 0, 1, 0.0f, 0.0f, path2);
                    stringPaint = stringPaint;
                    RectF rectF2 = new RectF();
                    path2.computeBounds(rectF2, true);
                    f = rectF2.left;
                }
                int iCeil = (int) Math.ceil(stringPaint.measureText(spannableString.toString()));
                stringPaint.setTypeface(Typeface.create(typeface, 0));
                TextPaint textPaint = stringPaint;
                StaticLayout staticLayout = new StaticLayout(spannableString, textPaint, iCeil * 2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                stringPaint = textPaint;
                if (staticLayout.getLineCount() != 1) {
                    throw new RuntimeException();
                }
                int lineBaseline = staticLayout.getLineBaseline(0);
                customContext.canvas.save();
                float[] fArrMapToScreen3 = customContext.mapToScreen(f5, f6);
                customContext.canvas.translate(fArrMapToScreen3[0] - f, fArrMapToScreen3[1] - lineBaseline);
                stringPaint.setStyle(Paint.Style.FILL);
                staticLayout.draw(customContext.canvas);
                stringPaint.setStyle(Paint.Style.STROKE);
                customContext.canvas.restore();
                if (DBG) {
                    stringPaint.setColor(Color.argb(50, 0, 255, 0));
                    float[] fArrMapToScreen4 = customContext.mapToScreen(0.0f, f6, 1000.0f, f6);
                    customContext.canvas.drawLine(fArrMapToScreen4[0], fArrMapToScreen4[1], fArrMapToScreen4[2], fArrMapToScreen4[3], stringPaint);
                    stringPaint.setColor(Color.argb(30, 255, 0, 0));
                    float lineAscent = staticLayout.getLineAscent(0) + f6;
                    float[] fArrMapToScreen5 = customContext.mapToScreen(0.0f, lineAscent, 1000.0f, lineAscent);
                    customContext.canvas.drawLine(fArrMapToScreen5[0], fArrMapToScreen5[1], fArrMapToScreen5[2], fArrMapToScreen5[3], stringPaint);
                    stringPaint.setColor(Color.argb(30, 255, 0, 0));
                    float lineDescent = f6 + staticLayout.getLineDescent(0);
                    float[] fArrMapToScreen6 = customContext.mapToScreen(0.0f, lineDescent, 1000.0f, lineDescent);
                    customContext.canvas.drawLine(fArrMapToScreen6[0], fArrMapToScreen6[1], fArrMapToScreen6[2], fArrMapToScreen6[3], stringPaint);
                }
            }
            if (customContext.mHasShadow) {
                resetSelectionShadow(stringPaint);
            }
        } else {
            Paint glyphPaint = customContext.getGlyphPaint();
            if (customContext.mHasShadow) {
                configureSelectionShadow(glyphPaint, customContext.mDocToScreenScaling);
            }
            int styleCount2 = layoutItemString.getStyleCount();
            for (int i6 = 0; i6 < styleCount2; i6++) {
                int styleRangeAt_toGlyph2 = layoutItemString.getStyleRangeAt_toGlyph(i6);
                InkStyle styleAt = layoutItemString.getStyleAt(i6);
                for (int styleRangeAt_fromGlyph2 = layoutItemString.getStyleRangeAt_fromGlyph(i6); styleRangeAt_fromGlyph2 <= styleRangeAt_toGlyph2; styleRangeAt_fromGlyph2++) {
                    Glyph glyphAt3 = layoutItemString.getGlyphAt(styleRangeAt_fromGlyph2);
                    try {
                        draw(glyphAt3, styleAt, customContext, transform);
                        glyphAt3.delete();
                    } catch (Throwable th) {
                        glyphAt3.delete();
                        throw th;
                    }
                }
            }
            if (customContext.mHasShadow) {
                resetSelectionShadow(glyphPaint);
            }
        }
    }

    private void draw(Glyph glyph, InkStyle inkStyle, CustomContext customContext, Transform transform) {
        boolean z;
        float parallelogramX = glyph.getParallelogramX();
        float parallelogramY = glyph.getParallelogramY();
        float parallelogramUX = glyph.getParallelogramUX() + parallelogramX;
        float parallelogramVY = glyph.getParallelogramVY() + parallelogramY;
        if (transform != null) {
            Point map = transform.map(parallelogramX, parallelogramY);
            float x = map.getX();
            float y = map.getY();
            Point map2 = transform.map(parallelogramUX, parallelogramVY);
            float x2 = map2.getX();
            parallelogramY = y;
            parallelogramX = x;
            parallelogramVY = map2.getY();
            parallelogramUX = x2;
        }
        RectF rectF = new RectF(parallelogramX, parallelogramY, parallelogramUX, parallelogramVY);
        String label = glyph.getLabel();
        Paint glyphPaint = customContext.getGlyphPaint();
        InkStyleCacheData data = InkStyleCacheData.getData(inkStyle, InkStyleCacheData.FONT_PROPERTIES);
        if (data.isSTIXFont && mStrechCharacters.contains(label)) {
            glyphPaint.setTypeface(BestFontSelector.getBestFontFor(label, glyphPaint, rectF, inkStyle));
            z = false;
        } else {
            glyphPaint.setTypeface(FontManager.getTypeface(data));
            z = data.isDefaultFont;
        }
        glyphPaint.setColor(resolveColor(inkStyle.getColor()));
        float fontSize = inkStyle.getFontSize();
        glyphPaint.setTextSize(fontSize);
        glyphPaint.setLetterSpacing(FontManager.computeLetterSpacing(z, fontSize / this.mScaledDensity));
        if (SquareRootPathBuilder.SQUARE_ROOT_STRING.equals(glyph.getLabel())) {
            drawSquareRoot(glyph, rectF, inkStyle, customContext);
        } else {
            drawStandardGlyph(glyph, rectF, transform, customContext);
        }
    }

    private void drawSquareRoot(Glyph glyph, RectF rectF, InkStyle inkStyle, CustomContext customContext) {
        Path squareRootPath = SquareRootPathBuilder.getSquareRootPath(rectF, glyph.getSlicesLeft(), inkStyle);
        squareRootPath.transform(customContext.mDocToScreenMatrix);
        customContext.canvas.drawPath(squareRootPath, customContext.getGlyphPaint());
    }

    private void drawStandardGlyph(Glyph glyph, RectF rectF, Transform transform, CustomContext customContext) {
        String label = glyph.getLabel();
        Paint glyphPaint = customContext.getGlyphPaint();
        Path androidPath = customContext.getAndroidPath();
        androidPath.reset();
        glyphPaint.getTextPath(label, 0, label.length(), 0.0f, 0.0f, androidPath);
        if (!androidPath.isEmpty()) {
            RectF rectF2 = customContext.getRectF();
            androidPath.computeBounds(rectF2, true);
            Matrix pathMatrix = customContext.getPathMatrix();
            pathMatrix.reset();
            pathMatrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.FILL);
            androidPath.transform(pathMatrix);
            androidPath.transform(customContext.mDocToScreenMatrix);
            customContext.canvas.drawPath(androidPath, glyphPaint);
            return;
        }
        drawStandardGlyphFallback(glyph, rectF, transform, customContext);
    }

    private void drawStandardGlyphFallback(Glyph glyph, RectF rectF, Transform transform, CustomContext customContext) {
        float linesBaseLine;
        Paint glyphPaint = customContext.getGlyphPaint();
        InkStyleCacheData data = InkStyleCacheData.getData(customContext.mInkStyle, InkStyleCacheData.FONT_PROPERTIES);
        float fRound = Math.round(data.fontSize * customContext.scale * (transform != null ? transform.getYScale() : 1.0f) * customContext.mDocToScreenArray[4]);
        glyphPaint.setTextSize(fRound);
        glyphPaint.setTypeface(FontManager.getTypeface(data));
        glyphPaint.setLetterSpacing(FontManager.computeLetterSpacing(data.isDefaultFont, fRound / this.mScaledDensity));
        customContext.mDocToScreenMatrix.mapRect(customContext.getRectF(), rectF);
        if (glyph.hasLines()) {
            linesBaseLine = (1.0f - glyph.getLinesBaseLine()) * rectF.height();
        } else {
            linesBaseLine = rectF.bottom;
        }
        float slicesLeft = rectF.left;
        float f = rectF.bottom;
        if (glyph.hasSlices()) {
            slicesLeft += glyph.getSlicesLeft() * rectF.width();
        }
        float[] fArrMapToScreen = customContext.mapToScreen(slicesLeft, f - linesBaseLine);
        customContext.canvas.drawText(glyph.getLabel(), fArrMapToScreen[0], fArrMapToScreen[1], glyphPaint);
    }

    @Override // com.myscript.atk.core.IPageView
    public void draw(LayoutItemObject layoutItemObject, final String str, final String str2, Rectangle rectangle, Transform transform, CustomContext customContext) {
        final BitmapCache bitmapCache;
        try {
            if (str2.startsWith("image/") && (bitmapCache = this.mBitmapCache) != null) {
                synchronized (bitmapCache) {
                    Bitmap bitmapLoad = bitmapCache.get(str);
                    if (bitmapLoad == null) {
                        if (DBG) {
                            Log.d(TAG, "No image available for " + str + " " + str2);
                        }
                        Rectangle rectangleMapped = TransformUtils.mapped(rectangle, transform);
                        final float left = rectangleMapped.getLeft();
                        final float right = rectangleMapped.getRight();
                        final float top = rectangleMapped.getTop();
                        final float bottom = rectangleMapped.getBottom();
                        if (this.mDrawImageSynchronously) {
                            bitmapLoad = bitmapCache.load(str, str2, -1, -1);
                        } else {
                            AsyncTask.execute(new Runnable() { // from class: com.myscript.atk.core.ui.PageView$$ExternalSyntheticLambda0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$draw$0(bitmapCache, str, str2, left, top, right, bottom);
                                }
                            });
                        }
                    }
                    if (bitmapLoad != null && !bitmapLoad.isRecycled()) {
                        Rect offscreenSourceRect = customContext.getOffscreenSourceRect();
                        offscreenSourceRect.set(0, 0, bitmapLoad.getWidth(), bitmapLoad.getHeight());
                        RectF rectF = customContext.getRectF();
                        rectF.set(rectangle.getLeft(), rectangle.getTop(), rectangle.getRight(), rectangle.getBottom());
                        Matrix pathMatrix = customContext.getPathMatrix();
                        pathMatrix.reset();
                        float[] temporaryMatrixFloatArray = customContext.getTemporaryMatrixFloatArray();
                        temporaryMatrixFloatArray[6] = 0.0f;
                        temporaryMatrixFloatArray[7] = 0.0f;
                        temporaryMatrixFloatArray[8] = 1.0f;
                        temporaryMatrixFloatArray[0] = transform.getXScale();
                        temporaryMatrixFloatArray[1] = transform.getXShear();
                        temporaryMatrixFloatArray[2] = transform.getXTranslate();
                        temporaryMatrixFloatArray[3] = transform.getYShear();
                        temporaryMatrixFloatArray[4] = transform.getYScale();
                        temporaryMatrixFloatArray[5] = transform.getYTranslate();
                        pathMatrix.setValues(temporaryMatrixFloatArray);
                        customContext.canvas.save();
                        customContext.canvas.concat(customContext.mDocToScreenMatrix);
                        customContext.canvas.concat(pathMatrix);
                        customContext.canvas.drawBitmap(bitmapLoad, offscreenSourceRect, rectF, customContext.getBitmapPaint());
                        customContext.canvas.restore();
                    }
                }
            }
        } catch (RuntimeException e) {
            Log.e(TAG, "LayoutObject can't be drawn", e);
        } finally {
            layoutItemObject.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$draw$0(BitmapCache bitmapCache, String str, String str2, float f, float f2, float f3, float f4) {
        synchronized (bitmapCache) {
            if (bitmapCache.load(str, str2, -1, -1) != null) {
                invalidate(new Extent(f, f2, f3, f4), InvalidateType.DOCUMENT.swigValue());
            }
        }
    }

    @Override // com.myscript.atk.core.IPageView
    public void draw(Rectangle rectangle, CustomContext customContext) {
        float[] fArrMapToScreen = customContext.mapToScreen(rectangle.getLeft(), rectangle.getTop(), rectangle.getRight(), rectangle.getBottom());
        Paint brushPaint = customContext.getBrushPaint();
        if (customContext.mIsFillStyle) {
            Paint.Style style = brushPaint.getStyle();
            int color = brushPaint.getColor();
            brushPaint.setStyle(Paint.Style.FILL);
            brushPaint.setColor(customContext.mFillColor);
            customContext.canvas.drawRect(fArrMapToScreen[0], fArrMapToScreen[1], fArrMapToScreen[2], fArrMapToScreen[3], brushPaint);
            brushPaint.setStyle(style);
            brushPaint.setColor(color);
        }
        if (customContext.mHasShadow) {
            configureSelectionShadow(brushPaint, customContext.mDocToScreenScaling);
        }
        customContext.canvas.drawRect(fArrMapToScreen[0], fArrMapToScreen[1], fArrMapToScreen[2], fArrMapToScreen[3], brushPaint);
        if (customContext.mHasShadow) {
            resetSelectionShadow(brushPaint);
        }
    }

    @Override // com.myscript.atk.core.IPageView
    public void draw(LayoutItemDecoration layoutItemDecoration, CustomContext customContext, Transform transform) {
        try {
            com.myscript.atk.core.Path pathMapped = transform != null ? TransformUtils.mapped(layoutItemDecoration.getPath(), transform) : layoutItemDecoration.getPath();
            AndroidStroker androidStroker = customContext.getAndroidStroker();
            boolean smooth = androidStroker.getSmooth();
            androidStroker.setSmooth(false);
            Paint decorationPaint = customContext.getDecorationPaint();
            Path androidPath = customContext.getAndroidPath();
            if (customContext.mIsFillStyle && layoutItemDecoration.getDecorationType() == DecorationType.FILL_AREA_DECORATION) {
                int i = customContext.mFillColor;
                if (Color.alpha(i) > 0) {
                    decorationPaint.setColor(i);
                    decorationPaint.setStyle(Paint.Style.FILL);
                    int stroking = androidStroker.getStroking();
                    androidStroker.setStroking(11);
                    androidStroker.stroke(pathMapped, androidPath);
                    androidStroker.setStroking(stroking);
                    androidPath.transform(customContext.mDocToScreenMatrix);
                    customContext.canvas.drawPath(androidPath, decorationPaint);
                }
            } else {
                int iResolveColor = resolveColor(customContext.mInkStyle.getTextDecorationColor());
                if (Color.alpha(iResolveColor) > 0) {
                    decorationPaint.setColor(iResolveColor);
                    if (!NativeStroker.isFill(customContext.mStroking)) {
                        decorationPaint.setStyle(Paint.Style.STROKE);
                        decorationPaint.setStrokeWidth(customContext.mInkWidth * this.mLineWidthScale * customContext.scale * customContext.mDocToScreenScaling);
                    } else {
                        decorationPaint.setStyle(Paint.Style.FILL);
                    }
                    androidStroker.stroke(pathMapped, androidPath);
                    androidPath.transform(customContext.mDocToScreenMatrix);
                    customContext.canvas.drawPath(androidPath, decorationPaint);
                }
                int iResolveColor2 = resolveColor(customContext.mInkStyle.getTextDecorationBackgroundColor());
                if (Color.alpha(iResolveColor2) > 0) {
                    decorationPaint.setColor(iResolveColor2);
                    decorationPaint.setStyle(Paint.Style.FILL);
                    int stroking2 = androidStroker.getStroking();
                    androidStroker.setStroking(11);
                    androidStroker.stroke(pathMapped, androidPath);
                    androidStroker.setStroking(stroking2);
                    androidPath.transform(customContext.mDocToScreenMatrix);
                    customContext.canvas.drawPath(androidPath, decorationPaint);
                }
            }
            androidStroker.setSmooth(smooth);
        } finally {
            layoutItemDecoration.delete();
        }
    }

    @Override // com.myscript.atk.core.IPageView
    public void drawSelection(com.myscript.atk.core.Path path, CustomContext customContext) {
        throw new UnsupportedOperationException();
    }

    private void drawArrow(Path path, float f, float f2, float f3, float f4, float f5) {
        double d = f3;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        float f6 = -fSin;
        float f7 = (f - (fCos * f4)) - ((f6 * 0.5f) * f5);
        float f8 = (f2 - (fSin * f4)) - ((0.5f * fCos) * f5);
        path.moveTo(f7, f8);
        path.lineTo(f, f2);
        path.moveTo(f7 + (f6 * f5), f8 + (fCos * f5));
        path.lineTo(f, f2);
    }

    @Override // com.myscript.atk.core.IPageView
    public void groupChanged(LayoutGroup layoutGroup, CustomContext customContext) {
        if (layoutGroup != null) {
            layoutGroup.delete();
        }
    }

    @Override // com.myscript.atk.core.IPageView
    public void styleChanged(InkStyle inkStyle, CustomContext customContext) {
        customContext.mInkStyle = inkStyle;
        InkStyleCacheData data = InkStyleCacheData.getData(inkStyle, InkStyleCacheData.WIDTH | InkStyleCacheData.COLOR | InkStyleCacheData.FILL_COLOR | InkStyleCacheData.FILL_STYLE | InkStyleCacheData.BRUSH | InkStyleCacheData.SMOOTHING);
        customContext.mInkWidth = data.width;
        customContext.mInkColor = resolveColor(data.color);
        customContext.mFillColor = resolveColor(data.fillColor);
        customContext.mIsFillStyle = data.fillStyleIsSolid;
        customContext.resetDashPathEffect();
        customContext.mIsDash = data.brushIsDash;
        if (customContext.mIsDash) {
            customContext.mDashDimension = data.brushDashDimension;
            customContext.mDashGapDimension = data.brushDashGapDimension;
        }
        customContext.mIsRounded = data.brushIsRounded;
        customContext.mHasShadow = data.brushHasShadow;
        customContext.mStroking = NativeStroker.getStroking(data.brush);
        customContext.mDoSmooth = true;
        customContext.mLineWidthScale = this.mLineWidthScale;
        customContext.mPixelSize = this.mPixelSize;
        customContext.configureBrushPaint();
        customContext.configureAndroidStroker();
    }

    @Override // com.myscript.atk.core.IPageView
    public void stylesheetChanged(com.myscript.atk.core.Layout layout) {
        if (layout != null) {
            layout.delete();
        }
    }

    @Override // com.myscript.atk.core.IPageView
    public boolean isCachingStroke() {
        return this.mIsCachingStroke;
    }

    @Override // com.myscript.atk.core.IPageView
    public void pushClip(Extent extent, CustomContext customContext) {
        customContext.canvas.save();
        float[] fArrMapToScreen = customContext.mapToScreen(extent.getXMin(), extent.getYMin(), extent.getXMax(), extent.getYMax());
        customContext.canvas.clipRect(fArrMapToScreen[0], fArrMapToScreen[1], fArrMapToScreen[2], fArrMapToScreen[3]);
    }

    @Override // com.myscript.atk.core.IPageView
    public void popClip(CustomContext customContext) {
        customContext.canvas.restore();
    }

    @Override // com.myscript.atk.core.IPageView
    public void invalidate(int i) {
        IUpdatableRendering iUpdatableRendering = this.mUpdatableRendering;
        if (iUpdatableRendering != null) {
            iUpdatableRendering.invalidate(i);
        }
    }

    @Override // com.myscript.atk.core.IPageView
    public void invalidate(Extent extent, int i) {
        IUpdatableRendering iUpdatableRendering = this.mUpdatableRendering;
        if (iUpdatableRendering != null) {
            iUpdatableRendering.invalidate(extent, i);
        }
    }

    @Override // com.myscript.atk.core.IPageView
    public void draw(Sprite sprite, Transform transform, float f, CustomContext customContext) {
        try {
            Bitmap bitmap = this.mOffscreenSurfaceManager.getBitmap((int) sprite.getBatchID());
            if (bitmap != null) {
                if (transform != null) {
                    transform.multiply2(sprite.getDeltaTransform());
                } else {
                    transform = sprite.getDeltaTransform();
                }
                Rectangle srcRectangle = sprite.getSrcRectangle();
                Transform initTransform = sprite.getInitTransform();
                float xScale = initTransform.getXScale();
                float yScale = initTransform.getYScale();
                Rect offscreenSourceRect = customContext.getOffscreenSourceRect();
                offscreenSourceRect.set(Math.round(srcRectangle.getLeft() * xScale), Math.round(srcRectangle.getTop() * yScale), Math.round(srcRectangle.getRight() * xScale), Math.round(srcRectangle.getBottom() * yScale));
                Paint bitmapPaint = customContext.getBitmapPaint();
                bitmapPaint.setAlpha((int) (f * 255.0f));
                Extent destExtent = sprite.getDestExtent();
                RectF rectF = customContext.getRectF();
                rectF.set(destExtent.getXMin(), destExtent.getYMin(), destExtent.getXMax(), destExtent.getYMax());
                Matrix pathMatrix = customContext.getPathMatrix();
                pathMatrix.reset();
                float[] temporaryMatrixFloatArray = customContext.getTemporaryMatrixFloatArray();
                temporaryMatrixFloatArray[6] = 0.0f;
                temporaryMatrixFloatArray[7] = 0.0f;
                temporaryMatrixFloatArray[8] = 1.0f;
                temporaryMatrixFloatArray[0] = transform.getXScale();
                temporaryMatrixFloatArray[1] = transform.getXShear();
                temporaryMatrixFloatArray[2] = transform.getXTranslate();
                temporaryMatrixFloatArray[3] = transform.getYShear();
                temporaryMatrixFloatArray[4] = transform.getYScale();
                temporaryMatrixFloatArray[5] = transform.getYTranslate();
                pathMatrix.setValues(temporaryMatrixFloatArray);
                customContext.canvas.save();
                customContext.canvas.concat(customContext.mDocToScreenMatrix);
                customContext.canvas.concat(pathMatrix);
                customContext.canvas.drawBitmap(bitmap, offscreenSourceRect, rectF, bitmapPaint);
                customContext.canvas.restore();
            }
        } finally {
            sprite.delete();
        }
    }

    @Override // com.myscript.atk.core.IPageView
    public Sprite createOffscreenRender(Extent extent, boolean z, Transform transform) {
        Point map = transform.map(extent.getWidth(), extent.getHeight());
        int iCreate = this.mOffscreenSurfaceManager.create(extent, Math.max(1, Math.round(map.getX())), Math.max(1, Math.round(map.getY())), z);
        if (iCreate < 0) {
            return null;
        }
        Sprite sprite = new Sprite(iCreate);
        sprite.setSrcRectangle(new Rectangle(0.0f, 0.0f, extent.getWidth(), extent.getHeight()));
        sprite.setDestExtent(new Extent(extent.getXMin(), extent.getYMin(), extent.getXMax(), extent.getYMax()));
        sprite.setInitTransform(transform);
        return sprite;
    }

    @Override // com.myscript.atk.core.IPageView
    public void releaseOffscreenRender(Sprite sprite) {
        this.mOffscreenSurfaceManager.release((int) sprite.getBatchID());
    }

    public void releaseOffscreenManager() {
        this.mOffscreenSurfaceManager.release();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.myscript.atk.core.IPageView
    public CustomContext createDrawingContext(Sprite sprite, Extent extent, Transform transform, int i) {
        if (sprite == null || sprite.getBatchID() < 0) {
            return null;
        }
        Extent destExtent = sprite.getDestExtent();
        Bitmap bitmap = this.mOffscreenSurfaceManager.getBitmap((int) sprite.getBatchID());
        if (bitmap == null) {
            return null;
        }
        CustomContext customContext = new CustomContext();
        customContext.setDocToScreenMatrix(transform, -destExtent.getXMin(), -destExtent.getYMin());
        customContext.canvas = new Canvas(bitmap);
        customContext.extent = extent;
        float[] fArrMapToScreen = customContext.mapToScreen(extent.getXMin(), extent.getYMin(), extent.getXMax(), extent.getYMax());
        customContext.canvas.clipRect(fArrMapToScreen[0], fArrMapToScreen[1], fArrMapToScreen[2], fArrMapToScreen[3]);
        customContext.canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        customContext.canvas.save();
        customContext.invalidateType = InvalidateType.TEMPORARY;
        customContext.scale = 1.0f;
        return customContext;
    }

    @Override // com.myscript.atk.core.IPageView
    public void releaseDrawingContext(Sprite sprite, CustomContext customContext) {
        customContext.canvas.restore();
        customContext.canvas = null;
    }

    @Override // com.myscript.atk.core.IPageView
    public void setStretchedFontRenderingMode(boolean z, CustomContext customContext) {
        customContext.mStretchedFontRendering = z;
    }

    public void setSynchronousImageRendering(boolean z) {
        this.mDrawImageSynchronously = z;
    }

    protected int resolveColor(int i) {
        IColorInversionPolicy iColorInversionPolicy = this.mColorInversionPolicy;
        return iColorInversionPolicy != null ? iColorInversionPolicy.invertColor2(i) : i;
    }

    @Override // com.myscript.atk.core.IPageView
    public void colorInversionPolicyChanged(IColorInversionPolicy iColorInversionPolicy) {
        this.mColorInversionPolicy = iColorInversionPolicy;
    }
}
