package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class Extent {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public Extent(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(Extent extent) {
        if (extent == null) {
            return 0L;
        }
        return extent.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_Extent(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public Extent() {
        this(ATKCoreJNI.new_Extent__SWIG_0(), true);
    }

    public Extent(Extent extent) {
        this(ATKCoreJNI.new_Extent__SWIG_1(getCPtr(extent)), true);
    }

    public Extent(float f, float f2, float f3, float f4) {
        this(ATKCoreJNI.new_Extent__SWIG_2(f, f2, f3, f4), true);
    }

    public void set(Extent extent) {
        ATKCoreJNI.Extent_set__SWIG_0(this.swigCPtr, this, getCPtr(extent));
    }

    public void set(float f, float f2, float f3, float f4) {
        ATKCoreJNI.Extent_set__SWIG_1(this.swigCPtr, this, f, f2, f3, f4);
    }

    public float getWidth() {
        return ATKCoreJNI.Extent_getWidth(this.swigCPtr, this);
    }

    public float getHeight() {
        return ATKCoreJNI.Extent_getHeight(this.swigCPtr, this);
    }

    public float getXMin() {
        return ATKCoreJNI.Extent_getXMin(this.swigCPtr, this);
    }

    public float getYMin() {
        return ATKCoreJNI.Extent_getYMin(this.swigCPtr, this);
    }

    public float getXMax() {
        return ATKCoreJNI.Extent_getXMax(this.swigCPtr, this);
    }

    public float getYMax() {
        return ATKCoreJNI.Extent_getYMax(this.swigCPtr, this);
    }

    public boolean contains(Extent extent) {
        return ATKCoreJNI.Extent_contains__SWIG_0(this.swigCPtr, this, getCPtr(extent), extent);
    }

    public boolean contains(float f, float f2) {
        return ATKCoreJNI.Extent_contains__SWIG_1(this.swigCPtr, this, f, f2);
    }

    public boolean contains(Point point) {
        return ATKCoreJNI.Extent_contains__SWIG_2(this.swigCPtr, this, Point.getCPtr(point), point);
    }

    public boolean isWorld() {
        return ATKCoreJNI.Extent_isWorld(this.swigCPtr, this);
    }

    public boolean empty() {
        return ATKCoreJNI.Extent_empty(this.swigCPtr, this);
    }

    public boolean valid() {
        return ATKCoreJNI.Extent_valid(this.swigCPtr, this);
    }

    public Extent intersection(Extent extent) {
        return new Extent(ATKCoreJNI.Extent_intersection(this.swigCPtr, this, getCPtr(extent), extent), true);
    }

    public boolean intersectsStrict(Extent extent) {
        return ATKCoreJNI.Extent_intersectsStrict(this.swigCPtr, this, getCPtr(extent), extent);
    }

    public boolean intersects(Extent extent) {
        return ATKCoreJNI.Extent_intersects(this.swigCPtr, this, getCPtr(extent), extent);
    }

    public void add(Extent extent) {
        ATKCoreJNI.Extent_add__SWIG_0(this.swigCPtr, this, getCPtr(extent), extent);
    }

    public void add(float f, float f2) {
        ATKCoreJNI.Extent_add__SWIG_1(this.swigCPtr, this, f, f2);
    }

    public Extent translate(float f, float f2) {
        return new Extent(ATKCoreJNI.Extent_translate(this.swigCPtr, this, f, f2), false);
    }

    public Extent inset(float f, float f2) {
        return new Extent(ATKCoreJNI.Extent_inset(this.swigCPtr, this, f, f2), false);
    }

    public Extent scale(float f, float f2) {
        return new Extent(ATKCoreJNI.Extent_scale__SWIG_0(this.swigCPtr, this, f, f2), false);
    }

    public Extent scale(float f) {
        return new Extent(ATKCoreJNI.Extent_scale__SWIG_1(this.swigCPtr, this, f), false);
    }

    public boolean strictlyEquals(Extent extent) {
        return ATKCoreJNI.Extent_strictlyEquals(this.swigCPtr, this, getCPtr(extent), extent);
    }

    public boolean almostEquals(Extent extent, float f) {
        return ATKCoreJNI.Extent_almostEquals__SWIG_0(this.swigCPtr, this, getCPtr(extent), extent, f);
    }

    public boolean almostEquals(Extent extent) {
        return ATKCoreJNI.Extent_almostEquals__SWIG_1(this.swigCPtr, this, getCPtr(extent), extent);
    }

    public float diagonalLength() {
        return ATKCoreJNI.Extent_diagonalLength(this.swigCPtr, this);
    }

    public Extent mapped(Transform transform) {
        return new Extent(ATKCoreJNI.Extent_mapped(this.swigCPtr, this, Transform.getCPtr(transform), transform), true);
    }

    public Point topLeft() {
        return new Point(ATKCoreJNI.Extent_topLeft(this.swigCPtr, this), true);
    }

    public Point topRight() {
        return new Point(ATKCoreJNI.Extent_topRight(this.swigCPtr, this), true);
    }

    public Point bottomLeft() {
        return new Point(ATKCoreJNI.Extent_bottomLeft(this.swigCPtr, this), true);
    }

    public Point bottomRight() {
        return new Point(ATKCoreJNI.Extent_bottomRight(this.swigCPtr, this), true);
    }

    public Point midTop() {
        return new Point(ATKCoreJNI.Extent_midTop(this.swigCPtr, this), true);
    }

    public Point midRight() {
        return new Point(ATKCoreJNI.Extent_midRight(this.swigCPtr, this), true);
    }

    public Point midBottom() {
        return new Point(ATKCoreJNI.Extent_midBottom(this.swigCPtr, this), true);
    }

    public Point midLeft() {
        return new Point(ATKCoreJNI.Extent_midLeft(this.swigCPtr, this), true);
    }

    public Point centroid() {
        return new Point(ATKCoreJNI.Extent_centroid(this.swigCPtr, this), true);
    }

    public SWIGTYPE_p_std__arrayT_atk__core__Extent_4_t subtract(Extent extent) {
        return new SWIGTYPE_p_std__arrayT_atk__core__Extent_4_t(ATKCoreJNI.Extent_subtract(this.swigCPtr, this, getCPtr(extent), extent), true);
    }
}
