package com.myscript.nebo.editing.impl.p027ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.util.Log;
import com.myscript.atk.core.InkStroke;
import com.myscript.atk.core.InkStyle;
import com.myscript.atk.core.Layout;
import com.myscript.atk.core.LayoutGroup;
import com.myscript.atk.core.LayoutItemObject;
import com.myscript.atk.core.ModelLock;
import com.myscript.atk.core.Rectangle;
import com.myscript.atk.core.SWIGVectorMotionEvent;
import com.myscript.atk.core.Transform;
import com.myscript.atk.core.TransformUtils;
import com.myscript.atk.core.VO_DOCUMENT_PRIVATE_T;
import com.myscript.atk.core.p020ui.CustomContext;
import com.myscript.atk.core.p020ui.OfflineSurfaceManager;
import com.myscript.atk.core.p020ui.PageView;
import com.myscript.snt.core.StyleUtils;

/* JADX INFO: loaded from: classes7.dex */
public class NeboPageView extends PageView {
    private static final String TAG = "NeboPageView";
    private Paint mBorderPaint;
    private boolean mDrawBlockOutlines;

    @Override // com.myscript.atk.core.p020ui.PageView, com.myscript.atk.core.IPageView
    public boolean supportsMotionPrediction() {
        return true;
    }

    public NeboPageView(DisplayMetrics displayMetrics, boolean z) {
        this(displayMetrics, z, null);
    }

    public NeboPageView(DisplayMetrics displayMetrics, boolean z, OfflineSurfaceManager offlineSurfaceManager) {
        super(displayMetrics, z, offlineSurfaceManager);
        this.mDrawBlockOutlines = true;
        this.mBorderPaint = null;
        setLineWidthScale(0.5f);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.myscript.atk.core.p020ui.PageView, com.myscript.atk.core.IPageView
    public void draw(LayoutItemObject layoutItemObject, String str, String str2, Rectangle rectangle, Transform transform, CustomContext customContext) {
        if (this.mBorderPaint != null && this.mDrawBlockOutlines) {
            Rectangle rectangleMapped = TransformUtils.mapped(rectangle, transform);
            float strokeWidth = this.mBorderPaint.getStrokeWidth() * customContext.mLineWidthScale;
            Paint paint = new Paint(this.mBorderPaint);
            paint.setColor(resolveColor(this.mBorderPaint.getColor()));
            paint.setStrokeWidth(this.mBorderPaint.getStrokeWidth() * customContext.mDocToScreenScaling);
            rectangleMapped.inset(strokeWidth, strokeWidth);
            float[] fArrMapToScreen = customContext.mapToScreen(rectangleMapped.getLeft(), rectangleMapped.getTop(), rectangleMapped.getRight(), rectangleMapped.getBottom());
            if ("application/vnd.myscript.shape".equals(str2)) {
                customContext.canvas.drawRect(fArrMapToScreen[0], fArrMapToScreen[1], fArrMapToScreen[2], fArrMapToScreen[3], paint);
                return;
            }
            if ("application/vnd.myscript.section-borders".equals(str2)) {
                Canvas canvas = customContext.canvas;
                float f = fArrMapToScreen[0];
                float f2 = fArrMapToScreen[1];
                canvas.drawLine(f, f2, fArrMapToScreen[2], f2, paint);
                Canvas canvas2 = customContext.canvas;
                float f3 = fArrMapToScreen[0];
                float f4 = fArrMapToScreen[3];
                canvas2.drawLine(f3, f4, fArrMapToScreen[2], f4, paint);
                return;
            }
        }
        super.draw(layoutItemObject, str, str2, rectangle, transform, customContext);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.myscript.atk.core.p020ui.PageView, com.myscript.atk.core.IPageView
    public void groupChanged(LayoutGroup layoutGroup, CustomContext customContext) {
        try {
            if (customContext.needCanvasRestore) {
                customContext.canvas.restore();
                customContext.needCanvasRestore = false;
            }
            if (layoutGroup != null) {
                Rectangle box = layoutGroup.getBox();
                float width = box.getWidth();
                float height = box.getHeight();
                try {
                    boolean zEquals = "ActiveBlock".equals(layoutGroup.getCustomAttribute("type"));
                    String customAttribute = layoutGroup.getCustomAttribute("ActiveBlock_subType");
                    setStretchedFontRenderingMode("com.myscript.math".equals(customAttribute) || "com.myscript.diagram".equals(customAttribute), customContext);
                    if (width > 0.0f && height > 0.0f && zEquals) {
                        customContext.canvas.save();
                        float[] fArrMapToScreen = customContext.mapToScreen(box.getLeft(), box.getTop(), box.getRight(), box.getBottom());
                        customContext.canvas.clipRect(fArrMapToScreen[0], fArrMapToScreen[1], fArrMapToScreen[2], fArrMapToScreen[3]);
                        customContext.needCanvasRestore = true;
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Invalid LayoutGroup", e);
                }
                customContext.scale = layoutGroup.getCustomAttributeAsFloat("scale", 1.0f);
            }
        } finally {
            super.groupChanged(layoutGroup, customContext);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.myscript.atk.core.p020ui.PageView, com.myscript.atk.core.IPageView
    public void drawWithPrediction(long j, InkStroke inkStroke, CustomContext customContext, Transform transform, SWIGVectorMotionEvent sWIGVectorMotionEvent, boolean z) {
        super.drawWithPrediction(j, inkStroke, customContext, transform, sWIGVectorMotionEvent, z);
    }

    @Override // com.myscript.atk.core.p020ui.PageView, com.myscript.atk.core.IPageView
    public void stylesheetChanged(Layout layout) {
        try {
            ModelLock modelLock = new ModelLock(layout);
            try {
                InkStyle inkStyleResolveStyle = layout.resolveStyle(VO_DOCUMENT_PRIVATE_T.LayoutItemGuide.swigValue(), StyleUtils.getGUIDE_STYLE_NAME());
                modelLock.delete();
                if (this.mBorderPaint == null) {
                    Paint paint = new Paint();
                    this.mBorderPaint = paint;
                    paint.setStyle(Paint.Style.STROKE);
                }
                this.mBorderPaint.setColor(inkStyleResolveStyle.getColor());
                this.mBorderPaint.setStrokeWidth(inkStyleResolveStyle.getWidth());
            } catch (Throwable th) {
                modelLock.delete();
                throw th;
            }
        } catch (Exception e) {
            Log.e(TAG, "Error during stylesheet changed", e);
        } finally {
            super.stylesheetChanged(layout);
        }
    }

    public void drawOutlines(boolean z) {
        this.mDrawBlockOutlines = z;
    }
}
