package com.myscript.nebo.editing.impl.p027ui;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import com.myscript.atk.core.Extent;
import com.myscript.atk.core.InvalidateType;
import com.myscript.atk.core.Renderer;
import com.myscript.atk.core.ViewTransform;
import com.myscript.atk.core.p020ui.CustomContext;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class RendererWrapperImpl implements RendererWrapper {
    private static final boolean DBG = false;
    private static final String TAG = "RenderingThread";
    private final CustomContext mCanvasContext;
    private final RectF mCaptureDirtyRect;
    private final CustomRenderedItemsConfiguration mCustomRenderedItemsConfiguration;
    private final Object mCustomerRenderedItemsMutex;
    private DocToScreenConverter mDocToScreenConverter;
    private final RectF mDocumentDirtyRect;
    private volatile boolean mHasPageBounds;
    private volatile boolean mHasSearchExtents;
    private final Extent mPageBounds;
    private final Paint mPageBoundsBorderPaint;
    private final Paint mPageBoundsFillPaint;
    private Renderer mRenderer;
    private final List<Extent> mSearchExtents;
    private Extent mSearchHitExtent;
    private final Paint mSearchHitsPaint;
    private final RectF mTransformedPageBounds;
    private final List<RectF> mTransformedSearchExtents;
    private ViewTransform mViewTransform;
    private final RectF mViewportRectMm;
    private final Rect mViewportRectPx;

    public RendererWrapperImpl(int i, int i2, CustomRenderedItemsConfiguration customRenderedItemsConfiguration) {
        CustomContext customContext = new CustomContext();
        this.mCanvasContext = customContext;
        RectF rectF = new RectF();
        this.mDocumentDirtyRect = rectF;
        RectF rectF2 = new RectF();
        this.mCaptureDirtyRect = rectF2;
        this.mViewportRectPx = new Rect(0, 0, 0, 0);
        this.mViewportRectMm = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.mCustomerRenderedItemsMutex = new Object();
        this.mPageBounds = new Extent();
        this.mTransformedPageBounds = new RectF();
        Paint paint = new Paint();
        this.mPageBoundsFillPaint = paint;
        Paint paint2 = new Paint();
        this.mPageBoundsBorderPaint = paint2;
        this.mSearchExtents = new ArrayList();
        this.mTransformedSearchExtents = new ArrayList();
        this.mHasPageBounds = false;
        this.mHasSearchExtents = false;
        Paint paint3 = new Paint();
        this.mSearchHitsPaint = paint3;
        rectF.setEmpty();
        rectF2.setEmpty();
        customContext.extent = new Extent();
        this.mCustomRenderedItemsConfiguration = customRenderedItemsConfiguration;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(0);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(customRenderedItemsConfiguration.getPageBoundsBorderColor());
        paint2.setStrokeWidth(customRenderedItemsConfiguration.getPageBoundsBorderWidthPx());
        paint3.setStyle(Paint.Style.FILL);
        paint3.setColor(customRenderedItemsConfiguration.getSearchHitColor());
        paint3.setStrokeWidth(1.0f);
        setSize(i, i2);
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.RendererWrapper
    public void handleRenderingRequest(Canvas canvas, int i) {
        boolean z;
        RectF rectF = this.mViewportRectMm;
        if ((InvalidateType.DOCUMENT.swigValue() & i) != 0) {
            this.mDocumentDirtyRect.set(rectF);
        }
        if ((i & InvalidateType.CAPTURE.swigValue()) != 0) {
            this.mCaptureDirtyRect.set(rectF);
            z = true;
        } else {
            z = false;
        }
        Renderer renderer = this.mRenderer;
        Renderer rendererNewRef = renderer != null ? Renderer.newRef(renderer) : null;
        if (rendererNewRef != null) {
            try {
                drawPageBounds(canvas);
                if (!this.mDocumentDirtyRect.isEmpty()) {
                    prepareCanvas(canvas, this.mDocumentDirtyRect);
                    this.mCanvasContext.invalidateType = InvalidateType.DOCUMENT;
                    rendererNewRef.draw(this.mCanvasContext.extent, InvalidateType.DOCUMENT, this.mCanvasContext);
                    if (z) {
                        this.mCanvasContext.invalidateType = InvalidateType.CAPTURE;
                        rendererNewRef.drawCapture(this.mCanvasContext.extent, this.mCanvasContext);
                    }
                    restoreCanvas();
                }
                drawSearchView(canvas);
            } catch (Throwable th) {
                if (rendererNewRef != null) {
                    try {
                        rendererNewRef.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (rendererNewRef != null) {
            rendererNewRef.close();
        }
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.RendererWrapper
    public void bind(Renderer renderer, ViewTransform viewTransform) {
        this.mDocumentDirtyRect.setEmpty();
        this.mCaptureDirtyRect.setEmpty();
        synchronized (this) {
            this.mRenderer = Renderer.newRef(renderer);
            this.mViewTransform = ViewTransform.newRef(viewTransform);
            this.mDocToScreenConverter = new DocToScreenConverter(renderer, viewTransform);
        }
        setViewportPx(this.mViewportRectPx.left, 0, this.mViewportRectPx.right, this.mViewportRectPx.height());
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.RendererWrapper
    public void unbind() {
        this.mDocumentDirtyRect.setEmpty();
        this.mCaptureDirtyRect.setEmpty();
        synchronized (this) {
            Renderer renderer = this.mRenderer;
            if (renderer != null) {
                renderer.delete();
                this.mRenderer = null;
            }
            ViewTransform viewTransform = this.mViewTransform;
            if (viewTransform != null) {
                viewTransform.delete();
                this.mViewTransform = null;
            }
            DocToScreenConverter docToScreenConverter = this.mDocToScreenConverter;
            if (docToScreenConverter != null) {
                docToScreenConverter.release();
                this.mDocToScreenConverter = null;
            }
        }
        setViewportPx(this.mViewportRectPx.left, 0, this.mViewportRectPx.right, this.mViewportRectPx.height());
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.RendererWrapper
    public void setSize(int i, int i2) {
        setViewportPx(this.mViewportRectPx.left, this.mViewportRectPx.top, this.mViewportRectPx.left + i, this.mViewportRectPx.top + i2);
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.RendererWrapper
    public void scrollAt(int i, int i2) {
        setViewportPx(i, i2, this.mViewportRectPx.width() + i, this.mViewportRectPx.height() + i2);
    }

    private void setViewportPx(int i, int i2, int i3, int i4) {
        synchronized (this) {
            this.mViewportRectPx.set(i, i2, i3, i4);
            ViewTransform viewTransform = this.mViewTransform;
            if (viewTransform != null) {
                float fScaleX = viewTransform.scaleX();
                float fScaleY = this.mViewTransform.scaleY();
                this.mViewportRectMm.set(i * fScaleX, i2 * fScaleY, i3 * fScaleX, i4 * fScaleY);
            }
        }
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.RendererWrapper
    public boolean extentToViewRect(Extent extent, Rect rect) {
        synchronized (this) {
            DocToScreenConverter docToScreenConverter = this.mDocToScreenConverter;
            if (docToScreenConverter == null) {
                return false;
            }
            docToScreenConverter.extentToRect(extent, rect);
            rect.offset(-this.mViewportRectPx.left, -this.mViewportRectPx.top);
            return true;
        }
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.RendererWrapper
    public void release() {
        if (this.mCanvasContext.extent != null) {
            this.mCanvasContext.extent.delete();
            this.mCanvasContext.extent = null;
        }
        unbind();
    }

    private void prepareCanvas(Canvas canvas, RectF rectF) {
        Matrix matrixComputeZoomMatrixInverted;
        canvas.save();
        this.mCanvasContext.canvas = canvas;
        this.mCanvasContext.extent.set(rectF.left, rectF.top, rectF.right, rectF.bottom);
        this.mCanvasContext.scale = 1.0f;
        synchronized (this) {
            DocToScreenConverter docToScreenConverter = this.mDocToScreenConverter;
            matrixComputeZoomMatrixInverted = docToScreenConverter != null ? docToScreenConverter.computeZoomMatrixInverted() : null;
        }
        if (matrixComputeZoomMatrixInverted != null) {
            this.mCanvasContext.setDocToScreenMatrix(matrixComputeZoomMatrixInverted, -rectF.left, -rectF.top);
        }
        this.mCanvasContext.needCanvasRestore = false;
    }

    private void restoreCanvas() {
        if (this.mCanvasContext.needCanvasRestore) {
            this.mCanvasContext.canvas.restore();
            this.mCanvasContext.needCanvasRestore = false;
        }
        try {
            this.mCanvasContext.canvas.restore();
        } catch (IllegalStateException e) {
            Log.e(TAG, "Rendering error", e);
        }
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.RendererWrapper
    public void setExtentsForSearch(List<? extends Extent> list) {
        synchronized (this.mCustomerRenderedItemsMutex) {
            this.mSearchExtents.clear();
            this.mSearchExtents.addAll(list);
            refreshCustomRenderedItems();
        }
    }

    private void drawPageBounds(Canvas canvas) {
        RectF rectF;
        if (this.mHasPageBounds) {
            synchronized (this.mCustomerRenderedItemsMutex) {
                rectF = new RectF(this.mTransformedPageBounds);
            }
            if (rectF.isEmpty()) {
                return;
            }
            canvas.save();
            canvas.translate(-this.mViewportRectPx.left, -this.mViewportRectPx.top);
            float pageBoundsBorderWidthPx = this.mCustomRenderedItemsConfiguration.getPageBoundsBorderWidthPx();
            ViewTransform viewTransform = this.mViewTransform;
            float fZoomScale = pageBoundsBorderWidthPx / (viewTransform != null ? viewTransform.zoomScale() : 1.0f);
            this.mPageBoundsBorderPaint.setStrokeWidth(fZoomScale);
            canvas.drawRect(rectF, this.mPageBoundsFillPaint);
            RectF rectF2 = new RectF(rectF);
            float f = (-fZoomScale) / 2.0f;
            rectF2.inset(f, f);
            canvas.drawRect(rectF2, this.mPageBoundsBorderPaint);
            canvas.restore();
        }
    }

    private void drawSearchView(Canvas canvas) {
        ArrayList arrayList;
        int searchHitColor;
        if (this.mHasSearchExtents) {
            synchronized (this.mCustomerRenderedItemsMutex) {
                arrayList = new ArrayList(this.mTransformedSearchExtents);
            }
            if (arrayList.isEmpty()) {
                return;
            }
            canvas.save();
            canvas.translate(-this.mViewportRectPx.left, -this.mViewportRectPx.top);
            RectF transformedSearchExtent = getTransformedSearchExtent(this.mSearchHitExtent);
            for (int i = 0; i < arrayList.size(); i++) {
                if (transformedSearchExtent != null && transformedSearchExtent.equals(arrayList.get(i))) {
                    searchHitColor = this.mCustomRenderedItemsConfiguration.getSearchSelectedHitColor();
                } else {
                    searchHitColor = this.mCustomRenderedItemsConfiguration.getSearchHitColor();
                }
                this.mSearchHitsPaint.setColor(searchHitColor);
                float searchHitPaddingPx = this.mCustomRenderedItemsConfiguration.getSearchHitPaddingPx();
                canvas.drawRect(((RectF) arrayList.get(i)).left - searchHitPaddingPx, ((RectF) arrayList.get(i)).top - searchHitPaddingPx, ((RectF) arrayList.get(i)).right + searchHitPaddingPx, ((RectF) arrayList.get(i)).bottom + searchHitPaddingPx, this.mSearchHitsPaint);
            }
            canvas.restore();
        }
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.RendererWrapper
    public void setSelectedHitExtent(Extent extent) {
        synchronized (this.mCustomerRenderedItemsMutex) {
            if (extent == null) {
                this.mSearchHitExtent = null;
                return;
            }
            for (Extent extent2 : this.mSearchExtents) {
                if (extent2.almostEquals(extent)) {
                    this.mSearchHitExtent = extent2;
                    return;
                }
            }
        }
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.RendererWrapper
    public void setPageBounds(Extent extent, int i) {
        this.mPageBoundsFillPaint.setColor(i);
        if (extent != null && extent.valid()) {
            this.mPageBounds.set(extent);
        } else {
            this.mPageBounds.set(Float.MAX_VALUE, Float.MAX_VALUE, Float.MIN_VALUE, Float.MIN_VALUE);
        }
        refreshCustomRenderedItems();
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.RendererWrapper
    public void refreshCustomRenderedItems() {
        ViewTransform viewTransform = this.mViewTransform;
        ViewTransform viewTransformNewRef = viewTransform != null ? ViewTransform.newRef(viewTransform) : null;
        if (viewTransformNewRef != null) {
            try {
                synchronized (this.mCustomerRenderedItemsMutex) {
                    this.mTransformedSearchExtents.clear();
                    for (Extent extent : this.mSearchExtents) {
                        this.mTransformedSearchExtents.add(new RectF(viewTransformNewRef.mapX(extent.getXMin()), viewTransformNewRef.mapY(extent.getYMin()), viewTransformNewRef.mapX(extent.getXMax()), viewTransformNewRef.mapY(extent.getYMax())));
                    }
                    this.mTransformedPageBounds.set(viewTransformNewRef.mapX(this.mPageBounds.getXMin()), viewTransformNewRef.mapY(this.mPageBounds.getYMin()), viewTransformNewRef.mapX(this.mPageBounds.getXMax()), viewTransformNewRef.mapY(this.mPageBounds.getYMax()));
                    this.mHasSearchExtents = !this.mTransformedSearchExtents.isEmpty();
                    this.mHasPageBounds = !this.mTransformedPageBounds.isEmpty();
                }
            } catch (Throwable th) {
                if (viewTransformNewRef != null) {
                    try {
                        viewTransformNewRef.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (viewTransformNewRef != null) {
            viewTransformNewRef.close();
        }
    }

    private RectF getTransformedSearchExtent(Extent extent) {
        if (extent == null) {
            return null;
        }
        ViewTransform viewTransform = this.mViewTransform;
        ViewTransform viewTransformNewRef = viewTransform != null ? ViewTransform.newRef(viewTransform) : null;
        if (viewTransformNewRef == null) {
            if (viewTransformNewRef != null) {
                viewTransformNewRef.close();
            }
            return null;
        }
        try {
            RectF rectF = new RectF(viewTransformNewRef.mapX(extent.getXMin()), viewTransformNewRef.mapY(extent.getYMin()), viewTransformNewRef.mapX(extent.getXMax()), viewTransformNewRef.mapY(extent.getYMax()));
            if (viewTransformNewRef != null) {
                viewTransformNewRef.close();
            }
            return rectF;
        } catch (Throwable th) {
            if (viewTransformNewRef != null) {
                try {
                    viewTransformNewRef.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
