package com.myscript.nebo.editing.impl.p027ui;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.myscript.atk.core.Extent;
import com.myscript.atk.core.Point;
import com.myscript.atk.core.Renderer;
import com.myscript.atk.core.ViewTransform;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocToScreenConverter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\tJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0002J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0002J\u0016\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m1599d2 = {"Lcom/myscript/nebo/editing/impl/ui/DocToScreenConverter;", "", "renderer", "Lcom/myscript/atk/core/Renderer;", "viewTransform", "Lcom/myscript/atk/core/ViewTransform;", "<init>", "(Lcom/myscript/atk/core/Renderer;Lcom/myscript/atk/core/ViewTransform;)V", "tempMatrix", "Landroid/graphics/Matrix;", "zoomMatrixInverted", "cachedOffsetX", "", "cachedOffsetY", "cachedScaleX", "cachedScaleY", "release", "", "computeZoomMatrixInverted", "xMmToPx", "", "mm", "yMmToPx", "extentToRect", TtmlNode.ATTR_TTS_EXTENT, "Lcom/myscript/atk/core/Extent;", "rectPixels", "Landroid/graphics/Rect;", "editing_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DocToScreenConverter {
    private float cachedOffsetX;
    private float cachedOffsetY;
    private float cachedScaleX;
    private float cachedScaleY;
    private Renderer renderer;
    private final Matrix tempMatrix;
    private ViewTransform viewTransform;
    private final Matrix zoomMatrixInverted;

    public DocToScreenConverter(Renderer renderer, ViewTransform viewTransform) {
        Intrinsics.checkNotNullParameter(viewTransform, "viewTransform");
        this.tempMatrix = new Matrix();
        this.zoomMatrixInverted = new Matrix();
        this.cachedOffsetX = Float.NaN;
        this.cachedOffsetY = Float.NaN;
        this.cachedScaleX = Float.NaN;
        this.cachedScaleY = Float.NaN;
        this.renderer = Renderer.newRef(renderer);
        this.viewTransform = ViewTransform.newRef(viewTransform);
        if (viewTransform.scaleX() == 0.0f || viewTransform.scaleY() == 0.0f) {
            throw new IllegalArgumentException("Invalid ViewTransform aspect ratio".toString());
        }
    }

    public final void release() {
        Renderer renderer = this.renderer;
        if (renderer != null) {
            renderer.delete();
        }
        this.renderer = null;
        ViewTransform viewTransform = this.viewTransform;
        if (viewTransform != null) {
            viewTransform.delete();
        }
        this.viewTransform = null;
    }

    public final Matrix computeZoomMatrixInverted() {
        ViewTransform viewTransform = this.viewTransform;
        Point pointZoomOffset = viewTransform != null ? viewTransform.zoomOffset() : null;
        float x = pointZoomOffset != null ? pointZoomOffset.getX() : 0.0f;
        float y = pointZoomOffset != null ? pointZoomOffset.getY() : 0.0f;
        ViewTransform viewTransform2 = this.viewTransform;
        float fScaleX = viewTransform2 != null ? viewTransform2.scaleX() : 0.0f;
        ViewTransform viewTransform3 = this.viewTransform;
        float fScaleY = viewTransform3 != null ? viewTransform3.scaleY() : 0.0f;
        if (x == this.cachedOffsetX && y == this.cachedOffsetY && fScaleX == this.cachedScaleX && fScaleY == this.cachedScaleY) {
            return this.zoomMatrixInverted;
        }
        this.tempMatrix.reset();
        this.tempMatrix.postTranslate(x, y);
        this.tempMatrix.postScale(fScaleX, fScaleY);
        this.zoomMatrixInverted.reset();
        this.tempMatrix.invert(this.zoomMatrixInverted);
        this.cachedOffsetX = x;
        this.cachedOffsetY = y;
        this.cachedScaleX = fScaleX;
        this.cachedScaleY = fScaleY;
        return this.zoomMatrixInverted;
    }

    private final int xMmToPx(float mm) {
        ViewTransform viewTransform = this.viewTransform;
        if (viewTransform != null) {
            return (int) Math.floor(((double) (mm / viewTransform.scaleX())) + 0.5d);
        }
        return 0;
    }

    private final int yMmToPx(float mm) {
        ViewTransform viewTransform = this.viewTransform;
        if (viewTransform != null) {
            return (int) Math.floor(((double) (mm / viewTransform.scaleY())) + 0.5d);
        }
        return 0;
    }

    public final void extentToRect(Extent extent, Rect rectPixels) {
        Intrinsics.checkNotNullParameter(extent, "extent");
        Intrinsics.checkNotNullParameter(rectPixels, "rectPixels");
        rectPixels.set(xMmToPx(extent.getXMin()), yMmToPx(extent.getYMin()), xMmToPx(extent.getXMax()) - 1, yMmToPx(extent.getYMax()) - 1);
    }
}
