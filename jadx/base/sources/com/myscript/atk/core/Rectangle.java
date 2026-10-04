package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class Rectangle {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public Rectangle(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(Rectangle rectangle) {
        if (rectangle == null) {
            return 0L;
        }
        return rectangle.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_Rectangle(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public Rectangle() {
        this(ATKCoreJNI.new_Rectangle__SWIG_0(), true);
    }

    public Rectangle(float f, float f2, float f3, float f4) {
        this(ATKCoreJNI.new_Rectangle__SWIG_1(f, f2, f3, f4), true);
    }

    public Rectangle(Point point, Point point2) {
        this(ATKCoreJNI.new_Rectangle__SWIG_2(Point.getCPtr(point), point, Point.getCPtr(point2), point2), true);
    }

    public Point getTopLeft() {
        return new Point(ATKCoreJNI.Rectangle_getTopLeft(this.swigCPtr, this), true);
    }

    public Point getTopRight() {
        return new Point(ATKCoreJNI.Rectangle_getTopRight(this.swigCPtr, this), true);
    }

    public Point getBottomLeft() {
        return new Point(ATKCoreJNI.Rectangle_getBottomLeft(this.swigCPtr, this), true);
    }

    public Point getBottomRight() {
        return new Point(ATKCoreJNI.Rectangle_getBottomRight(this.swigCPtr, this), true);
    }

    public Point midTop() {
        return new Point(ATKCoreJNI.Rectangle_midTop(this.swigCPtr, this), true);
    }

    public Point midRight() {
        return new Point(ATKCoreJNI.Rectangle_midRight(this.swigCPtr, this), true);
    }

    public Point midBottom() {
        return new Point(ATKCoreJNI.Rectangle_midBottom(this.swigCPtr, this), true);
    }

    public Point midLeft() {
        return new Point(ATKCoreJNI.Rectangle_midLeft(this.swigCPtr, this), true);
    }

    public Point getCenter() {
        return new Point(ATKCoreJNI.Rectangle_getCenter(this.swigCPtr, this), true);
    }

    public Rectangle united(Rectangle rectangle) {
        return new Rectangle(ATKCoreJNI.Rectangle_united__SWIG_0(this.swigCPtr, this, getCPtr(rectangle), rectangle), true);
    }

    public Rectangle unitedEx(Rectangle rectangle) {
        return new Rectangle(ATKCoreJNI.Rectangle_unitedEx(this.swigCPtr, this, getCPtr(rectangle), rectangle), true);
    }

    public Rectangle united(Point point) {
        return new Rectangle(ATKCoreJNI.Rectangle_united__SWIG_1(this.swigCPtr, this, Point.getCPtr(point), point), true);
    }

    public boolean contains(Point point) {
        return ATKCoreJNI.Rectangle_contains__SWIG_0(this.swigCPtr, this, Point.getCPtr(point), point);
    }

    public boolean contains(float f, float f2) {
        return ATKCoreJNI.Rectangle_contains__SWIG_1(this.swigCPtr, this, f, f2);
    }

    public boolean contains(Rectangle rectangle) {
        return ATKCoreJNI.Rectangle_contains__SWIG_2(this.swigCPtr, this, getCPtr(rectangle), rectangle);
    }

    public boolean intersects(Rectangle rectangle) {
        return ATKCoreJNI.Rectangle_intersects(this.swigCPtr, this, getCPtr(rectangle), rectangle);
    }

    public Rectangle intersected(Rectangle rectangle) {
        return new Rectangle(ATKCoreJNI.Rectangle_intersected(this.swigCPtr, this, getCPtr(rectangle), rectangle), true);
    }

    public void translate(float f, float f2) {
        ATKCoreJNI.Rectangle_translate__SWIG_0(this.swigCPtr, this, f, f2);
    }

    public Rectangle translated(float f, float f2) {
        return new Rectangle(ATKCoreJNI.Rectangle_translated__SWIG_0(this.swigCPtr, this, f, f2), true);
    }

    public void translate(Point point) {
        ATKCoreJNI.Rectangle_translate__SWIG_1(this.swigCPtr, this, Point.getCPtr(point), point);
    }

    public Rectangle translated(Point point) {
        return new Rectangle(ATKCoreJNI.Rectangle_translated__SWIG_1(this.swigCPtr, this, Point.getCPtr(point), point), true);
    }

    public void inset(float f, float f2) {
        ATKCoreJNI.Rectangle_inset(this.swigCPtr, this, f, f2);
    }

    public void adjust(float f, float f2, float f3, float f4) {
        ATKCoreJNI.Rectangle_adjust(this.swigCPtr, this, f, f2, f3, f4);
    }

    public Rectangle adjusted(float f, float f2, float f3, float f4) {
        return new Rectangle(ATKCoreJNI.Rectangle_adjusted(this.swigCPtr, this, f, f2, f3, f4), true);
    }

    public void clip(SemiAxis semiAxis) {
        ATKCoreJNI.Rectangle_clip(this.swigCPtr, this, SemiAxis.getCPtr(semiAxis), semiAxis);
    }

    public Rectangle clipped(SemiAxis semiAxis) {
        return new Rectangle(ATKCoreJNI.Rectangle_clipped(this.swigCPtr, this, SemiAxis.getCPtr(semiAxis), semiAxis), true);
    }

    public float getLeft() {
        return ATKCoreJNI.Rectangle_getLeft(this.swigCPtr, this);
    }

    public float getTop() {
        return ATKCoreJNI.Rectangle_getTop(this.swigCPtr, this);
    }

    public float getRight() {
        return ATKCoreJNI.Rectangle_getRight(this.swigCPtr, this);
    }

    public float getBottom() {
        return ATKCoreJNI.Rectangle_getBottom(this.swigCPtr, this);
    }

    public float aspectRatio() {
        return ATKCoreJNI.Rectangle_aspectRatio(this.swigCPtr, this);
    }

    public void add(Rectangle rectangle) {
        ATKCoreJNI.Rectangle_add__SWIG_0(this.swigCPtr, this, getCPtr(rectangle), rectangle);
    }

    public void add(List<Rectangle> list) {
        SWIGRectangleList sWIGRectangleList = new SWIGRectangleList(list);
        ATKCoreJNI.Rectangle_add__SWIG_1(this.swigCPtr, this, SWIGRectangleList.getCPtr(sWIGRectangleList), sWIGRectangleList);
    }

    public static Rectangle getUndefined() {
        long jRectangle_Undefined_get = ATKCoreJNI.Rectangle_Undefined_get();
        if (jRectangle_Undefined_get == 0) {
            return null;
        }
        return new Rectangle(jRectangle_Undefined_get, false);
    }

    public boolean isUndefined() {
        return ATKCoreJNI.Rectangle_isUndefined(this.swigCPtr, this);
    }

    public boolean isDefined() {
        return ATKCoreJNI.Rectangle_isDefined(this.swigCPtr, this);
    }

    public boolean isEmpty() {
        return ATKCoreJNI.Rectangle_isEmpty(this.swigCPtr, this);
    }

    public boolean isPoint() {
        return ATKCoreJNI.Rectangle_isPoint(this.swigCPtr, this);
    }

    public boolean strictlyEquals(Rectangle rectangle) {
        return ATKCoreJNI.Rectangle_strictlyEquals(this.swigCPtr, this, getCPtr(rectangle), rectangle);
    }

    public boolean almostEquals(Rectangle rectangle, float f) {
        return ATKCoreJNI.Rectangle_almostEquals__SWIG_0(this.swigCPtr, this, getCPtr(rectangle), rectangle, f);
    }

    public boolean almostEquals(Rectangle rectangle) {
        return ATKCoreJNI.Rectangle_almostEquals__SWIG_1(this.swigCPtr, this, getCPtr(rectangle), rectangle);
    }

    public static Rectangle fromExtentEx(Extent extent) {
        return new Rectangle(ATKCoreJNI.Rectangle_fromExtentEx(Extent.getCPtr(extent), extent), true);
    }

    public static Rectangle fromPoints(List<Point> list) {
        SWIGVectorPoint sWIGVectorPoint = new SWIGVectorPoint(list);
        return new Rectangle(ATKCoreJNI.Rectangle_fromPoints(SWIGVectorPoint.getCPtr(sWIGVectorPoint), sWIGVectorPoint), true);
    }

    public Point forceInside(Point point) {
        return new Point(ATKCoreJNI.Rectangle_forceInside__SWIG_0(this.swigCPtr, this, Point.getCPtr(point), point), true);
    }

    public Rectangle forceInside(Rectangle rectangle) {
        return new Rectangle(ATKCoreJNI.Rectangle_forceInside__SWIG_1(this.swigCPtr, this, getCPtr(rectangle), rectangle), true);
    }

    public boolean fitTo(Rectangle rectangle, FitOption fitOption) {
        return ATKCoreJNI.Rectangle_fitTo(this.swigCPtr, this, getCPtr(rectangle), rectangle, fitOption.swigValue());
    }

    public int hashCode() {
        return ATKCoreJNI.Rectangle_hashCode(this.swigCPtr, this);
    }

    public boolean nativeEquals(Rectangle rectangle) {
        return ATKCoreJNI.Rectangle_nativeEquals(this.swigCPtr, this, getCPtr(rectangle), rectangle);
    }

    public String toString() {
        return new String(ATKCoreJNI.Rectangle_toString(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public float getWidth() {
        return ATKCoreJNI.Rectangle_getWidth(this.swigCPtr, this);
    }

    public float getHeight() {
        return ATKCoreJNI.Rectangle_getHeight(this.swigCPtr, this);
    }

    public enum FitOption {
        FILL,
        COVER,
        CONTAIN,
        WIDTH_ONLY,
        HEIGHT_ONLY;

        private final int swigValue;

        public final int swigValue() {
            return this.swigValue;
        }

        public static FitOption swigToEnum(int i) {
            FitOption[] fitOptionArr = (FitOption[]) FitOption.class.getEnumConstants();
            if (i < fitOptionArr.length && i >= 0) {
                FitOption fitOption = fitOptionArr[i];
                if (fitOption.swigValue == i) {
                    return fitOption;
                }
            }
            for (FitOption fitOption2 : fitOptionArr) {
                if (fitOption2.swigValue == i) {
                    return fitOption2;
                }
            }
            throw new IllegalArgumentException("No enum " + FitOption.class + " with value " + i);
        }

        FitOption() {
            int i = SwigNext.next;
            SwigNext.next = i + 1;
            this.swigValue = i;
        }

        FitOption(int i) {
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        FitOption(FitOption fitOption) {
            int i = fitOption.swigValue;
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        private static class SwigNext {
            private static int next;

            private SwigNext() {
            }
        }
    }
}
