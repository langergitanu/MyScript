package com.myscript.nebo.editing.impl.p027ui;

import android.graphics.PointF;
import android.view.ScaleGestureDetector;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.myscript.nebo.editing.impl.p027ui.DocumentTouchController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScaleGestureDetectorListener.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u0019\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, m1599d2 = {"Lcom/myscript/nebo/editing/impl/ui/ScaleGestureDetectorListener;", "Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;", "canvasContextInfo", "Lcom/myscript/nebo/editing/impl/ui/ScaleGestureDetectorListener$CanvasContextInfo;", "<init>", "(Lcom/myscript/nebo/editing/impl/ui/ScaleGestureDetectorListener$CanvasContextInfo;)V", "mScaleListeners", "", "Lcom/myscript/nebo/editing/impl/ui/DocumentTouchController$ZoomListener;", "viewportFocus", "Landroid/graphics/PointF;", "lastSpanX", "", "lastSpanY", "intermediate", "", "onScaleBegin", "scaleGestureDetector", "Landroid/view/ScaleGestureDetector;", "onScale", "onScaleEnd", "", "detector", "addZoomListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "cleanUpZoomListener", "zoomListeners", "", "getZoomListeners", "()Ljava/util/List;", "CanvasContextInfo", "editing_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ScaleGestureDetectorListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
    private final CanvasContextInfo canvasContextInfo;
    private boolean intermediate;
    private float lastSpanX;
    private float lastSpanY;
    private final List<DocumentTouchController.ZoomListener> mScaleListeners;
    private final PointF viewportFocus;

    /* JADX INFO: compiled from: ScaleGestureDetectorListener.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\fÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/editing/impl/ui/ScaleGestureDetectorListener$CanvasContextInfo;", "", "screenWidth", "", "getScreenWidth", "()I", "screenHeight", "getScreenHeight", "getViewportTopLeft", "Landroid/graphics/PointF;", "getHorizontalScrollLimit", "getVerticalScrollLimit", "editing_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface CanvasContextInfo {
        int getHorizontalScrollLimit();

        int getScreenHeight();

        int getScreenWidth();

        int getVerticalScrollLimit();

        PointF getViewportTopLeft();
    }

    private static final float onScale$weights(float f, float f2) {
        if (f == 0.0f) {
            return 0.0f;
        }
        float f3 = 1;
        return ((f - f3) * (f2 + ((1.0f - f2) / 2))) + f3;
    }

    public ScaleGestureDetectorListener(CanvasContextInfo canvasContextInfo) {
        Intrinsics.checkNotNullParameter(canvasContextInfo, "canvasContextInfo");
        this.canvasContextInfo = canvasContextInfo;
        this.mScaleListeners = new ArrayList();
        this.viewportFocus = new PointF();
    }

    @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        Intrinsics.checkNotNullParameter(scaleGestureDetector, "scaleGestureDetector");
        this.lastSpanX = scaleGestureDetector.getCurrentSpanX();
        this.lastSpanY = scaleGestureDetector.getCurrentSpanY();
        this.intermediate = true;
        Iterator<DocumentTouchController.ZoomListener> it = getZoomListeners().iterator();
        while (it.hasNext()) {
            it.next().onZoomStarted();
        }
        return true;
    }

    @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        Intrinsics.checkNotNullParameter(scaleGestureDetector, "scaleGestureDetector");
        float currentSpanX = scaleGestureDetector.getCurrentSpanX();
        float currentSpanY = scaleGestureDetector.getCurrentSpanY();
        float screenWidth = currentSpanX / this.canvasContextInfo.getScreenWidth();
        float screenHeight = currentSpanY / this.canvasContextInfo.getScreenHeight();
        float f = screenWidth + screenHeight;
        float fOnScale$weights = f > 0.0f ? ((onScale$weights(currentSpanX == 0.0f ? 0.0f : this.lastSpanX / currentSpanX, screenWidth) * screenWidth) + (onScale$weights(currentSpanY == 0.0f ? 0.0f : this.lastSpanY / currentSpanY, screenHeight) * screenHeight)) / f : 1.0f;
        float focusX = scaleGestureDetector.getFocusX();
        float focusY = scaleGestureDetector.getFocusY();
        PointF viewportTopLeft = this.canvasContextInfo.getViewportTopLeft();
        this.viewportFocus.set(viewportTopLeft.x + focusX, viewportTopLeft.y + focusY);
        Iterator<DocumentTouchController.ZoomListener> it = getZoomListeners().iterator();
        while (it.hasNext()) {
            it.next().onZoom(1.0f / (Math.round(fOnScale$weights * 100.0f) / 100.0f), this.viewportFocus.x, this.viewportFocus.y, this.intermediate);
        }
        this.lastSpanX = currentSpanX;
        this.lastSpanY = currentSpanY;
        return true;
    }

    @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector detector) {
        Intrinsics.checkNotNullParameter(detector, "detector");
        this.intermediate = false;
        onScale(detector);
        Iterator<DocumentTouchController.ZoomListener> it = getZoomListeners().iterator();
        while (it.hasNext()) {
            it.next().onZoomEnded();
        }
    }

    public final synchronized void addZoomListener(DocumentTouchController.ZoomListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mScaleListeners.add(listener);
    }

    public final synchronized void cleanUpZoomListener() {
        this.mScaleListeners.clear();
    }

    public final synchronized List<DocumentTouchController.ZoomListener> getZoomListeners() {
        return this.mScaleListeners;
    }
}
