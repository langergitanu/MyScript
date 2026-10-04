package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class ViewTransform implements AutoCloseable {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ViewTransform(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ViewTransform viewTransform) {
        if (viewTransform == null) {
            return 0L;
        }
        return viewTransform.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_ViewTransform(j);
            }
            this.swigCPtr = 0L;
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        delete();
    }

    public ViewTransform(float f, float f2) {
        this(ATKCoreJNI.new_ViewTransform(f, f2), true);
    }

    public boolean setDPI(float f, float f2) {
        return ATKCoreJNI.ViewTransform_setDPI(this.swigCPtr, this, f, f2);
    }

    public Transform transform(boolean z) {
        return new Transform(ATKCoreJNI.ViewTransform_transform__SWIG_0(this.swigCPtr, this, z), true);
    }

    public Transform transform() {
        return new Transform(ATKCoreJNI.ViewTransform_transform__SWIG_1(this.swigCPtr, this), true);
    }

    public Transform itransform(boolean z) {
        return new Transform(ATKCoreJNI.ViewTransform_itransform__SWIG_0(this.swigCPtr, this, z), true);
    }

    public Transform itransform() {
        return new Transform(ATKCoreJNI.ViewTransform_itransform__SWIG_1(this.swigCPtr, this), true);
    }

    public static ViewTransform fitToWidth(Extent extent, float f, float f2, float f3, float f4, int i, int i2) {
        return new ViewTransform(ATKCoreJNI.ViewTransform_fitToWidth(Extent.getCPtr(extent), extent, f, f2, f3, f4, i, i2), true);
    }

    public float imapX(float f) {
        return ATKCoreJNI.ViewTransform_imapX(this.swigCPtr, this, f);
    }

    public float imapY(float f) {
        return ATKCoreJNI.ViewTransform_imapY(this.swigCPtr, this, f);
    }

    public float mapX(float f) {
        return ATKCoreJNI.ViewTransform_mapX(this.swigCPtr, this, f);
    }

    public float mapY(float f) {
        return ATKCoreJNI.ViewTransform_mapY(this.swigCPtr, this, f);
    }

    public Point imap(float f, float f2) {
        return new Point(ATKCoreJNI.ViewTransform_imap__SWIG_0(this.swigCPtr, this, f, f2), true);
    }

    public Point map(float f, float f2) {
        return new Point(ATKCoreJNI.ViewTransform_map__SWIG_0(this.swigCPtr, this, f, f2), true);
    }

    public Point imap(Point point) {
        return new Point(ATKCoreJNI.ViewTransform_imap__SWIG_1(this.swigCPtr, this, Point.getCPtr(point), point), true);
    }

    public Point map(Point point) {
        return new Point(ATKCoreJNI.ViewTransform_map__SWIG_1(this.swigCPtr, this, Point.getCPtr(point), point), true);
    }

    public PointerInfo imap(PointerInfo pointerInfo) {
        return new PointerInfo(ATKCoreJNI.ViewTransform_imap__SWIG_2(this.swigCPtr, this, PointerInfo.getCPtr(pointerInfo), pointerInfo), true);
    }

    public PointerInfo map(PointerInfo pointerInfo) {
        return new PointerInfo(ATKCoreJNI.ViewTransform_map__SWIG_2(this.swigCPtr, this, PointerInfo.getCPtr(pointerInfo), pointerInfo), true);
    }

    public Extent imap(Extent extent) {
        return new Extent(ATKCoreJNI.ViewTransform_imap__SWIG_3(this.swigCPtr, this, Extent.getCPtr(extent), extent), true);
    }

    public Extent map(Extent extent) {
        return new Extent(ATKCoreJNI.ViewTransform_map__SWIG_3(this.swigCPtr, this, Extent.getCPtr(extent), extent), true);
    }

    public void zoomAt(Point point, float f) {
        ATKCoreJNI.ViewTransform_zoomAt(this.swigCPtr, this, Point.getCPtr(point), point, f);
    }

    public void fitTo(Extent extent, int i, int i2, int i3, int i4) {
        ATKCoreJNI.ViewTransform_fitTo__SWIG_0(this.swigCPtr, this, Extent.getCPtr(extent), extent, i, i2, i3, i4);
    }

    public void fitTo(Extent extent, int i, int i2, int i3) {
        ATKCoreJNI.ViewTransform_fitTo__SWIG_1(this.swigCPtr, this, Extent.getCPtr(extent), extent, i, i2, i3);
    }

    public void fitTo(Extent extent, int i, int i2) {
        ATKCoreJNI.ViewTransform_fitTo__SWIG_2(this.swigCPtr, this, Extent.getCPtr(extent), extent, i, i2);
    }

    public void verticalScrollTo(Extent extent, int i, int i2) {
        ATKCoreJNI.ViewTransform_verticalScrollTo(this.swigCPtr, this, Extent.getCPtr(extent), extent, i, i2);
    }

    public void pan(Point point) {
        ATKCoreJNI.ViewTransform_pan(this.swigCPtr, this, Point.getCPtr(point), point);
    }

    public float scaleX() {
        return ATKCoreJNI.ViewTransform_scaleX(this.swigCPtr, this);
    }

    public float scaleY() {
        return ATKCoreJNI.ViewTransform_scaleY(this.swigCPtr, this);
    }

    public float zoomScale() {
        return ATKCoreJNI.ViewTransform_zoomScale(this.swigCPtr, this);
    }

    public void setZoomScale(float f) {
        ATKCoreJNI.ViewTransform_setZoomScale(this.swigCPtr, this, f);
    }

    public boolean hasZoomOffset() {
        return ATKCoreJNI.ViewTransform_hasZoomOffset(this.swigCPtr, this);
    }

    public Point zoomOffset() {
        return new Point(ATKCoreJNI.ViewTransform_zoomOffset(this.swigCPtr, this), true);
    }

    public void setZoomOffset(Point point) {
        ATKCoreJNI.ViewTransform_setZoomOffset__SWIG_0(this.swigCPtr, this, Point.getCPtr(point), point);
    }

    public void setZoomOffset(float f, float f2) {
        ATKCoreJNI.ViewTransform_setZoomOffset__SWIG_1(this.swigCPtr, this, f, f2);
    }

    public void setTransform(Transform transform) {
        ATKCoreJNI.ViewTransform_setTransform(this.swigCPtr, this, Transform.getCPtr(transform), transform);
    }

    public float dpiX() {
        return ATKCoreJNI.ViewTransform_dpiX(this.swigCPtr, this);
    }

    public float dpiY() {
        return ATKCoreJNI.ViewTransform_dpiY(this.swigCPtr, this);
    }

    public static ViewTransform newRef(ViewTransform viewTransform) {
        long jViewTransform_newRef = ATKCoreJNI.ViewTransform_newRef(getCPtr(viewTransform), viewTransform);
        if (jViewTransform_newRef == 0) {
            return null;
        }
        return new ViewTransform(jViewTransform_newRef, true);
    }
}
