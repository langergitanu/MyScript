package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class Path {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public Path(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(Path path) {
        if (path == null) {
            return 0L;
        }
        return path.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_Path(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public Path() {
        this(ATKCoreJNI.new_Path__SWIG_0(), true);
    }

    private static long SwigConstructPath(List<PointerInfo> list) {
        SWIGVectorPointerInfo sWIGVectorPointerInfo = new SWIGVectorPointerInfo(list);
        return ATKCoreJNI.new_Path__SWIG_1(SWIGVectorPointerInfo.getCPtr(sWIGVectorPointerInfo), sWIGVectorPointerInfo);
    }

    public Path(List<PointerInfo> list) {
        this(SwigConstructPath(list), true);
    }

    public Path(Path path) {
        this(ATKCoreJNI.new_Path__SWIG_2(getCPtr(path), path), true);
    }

    public void clear() {
        ATKCoreJNI.Path_clear(this.swigCPtr, this);
    }

    public void reserve(int i) {
        ATKCoreJNI.Path_reserve(this.swigCPtr, this, i);
    }

    public void startAt(PointerInfo pointerInfo) {
        ATKCoreJNI.Path_startAt__SWIG_0(this.swigCPtr, this, PointerInfo.getCPtr(pointerInfo), pointerInfo);
    }

    public void moveTo(PointerInfo pointerInfo) {
        ATKCoreJNI.Path_moveTo(this.swigCPtr, this, PointerInfo.getCPtr(pointerInfo), pointerInfo);
    }

    public void startAt(Point point) {
        ATKCoreJNI.Path_startAt__SWIG_1(this.swigCPtr, this, Point.getCPtr(point), point);
    }

    public void startAt(float f, float f2) {
        ATKCoreJNI.Path_startAt__SWIG_2(this.swigCPtr, this, f, f2);
    }

    public void lineTo(PointerInfo pointerInfo) {
        ATKCoreJNI.Path_lineTo__SWIG_0(this.swigCPtr, this, PointerInfo.getCPtr(pointerInfo), pointerInfo);
    }

    public void linesTo(List<PointerInfo> list) {
        SWIGVectorPointerInfo sWIGVectorPointerInfo = new SWIGVectorPointerInfo(list);
        ATKCoreJNI.Path_linesTo(this.swigCPtr, this, SWIGVectorPointerInfo.getCPtr(sWIGVectorPointerInfo), sWIGVectorPointerInfo);
    }

    public void lineTo(Point point) {
        ATKCoreJNI.Path_lineTo__SWIG_1(this.swigCPtr, this, Point.getCPtr(point), point);
    }

    public void lineTo(float f, float f2) {
        ATKCoreJNI.Path_lineTo__SWIG_2(this.swigCPtr, this, f, f2);
    }

    public void endTo(PointerInfo pointerInfo) {
        ATKCoreJNI.Path_endTo__SWIG_0(this.swigCPtr, this, PointerInfo.getCPtr(pointerInfo), pointerInfo);
    }

    public void endTo(Point point) {
        ATKCoreJNI.Path_endTo__SWIG_1(this.swigCPtr, this, Point.getCPtr(point), point);
    }

    public void endTo(float f, float f2) {
        ATKCoreJNI.Path_endTo__SWIG_2(this.swigCPtr, this, f, f2);
    }

    public void makeGap() {
        ATKCoreJNI.Path_makeGap(this.swigCPtr, this);
    }

    public void close() {
        ATKCoreJNI.Path_close(this.swigCPtr, this);
    }

    public void chop() {
        ATKCoreJNI.Path_chop(this.swigCPtr, this);
    }

    public int getLength() {
        return ATKCoreJNI.Path_getLength(this.swigCPtr, this);
    }

    public Point pointAt(int i) {
        return new Point(ATKCoreJNI.Path_pointAt(this.swigCPtr, this, i), true);
    }

    public PointerInfo get(int i) {
        return new PointerInfo(ATKCoreJNI.Path_get(this.swigCPtr, this, i), false);
    }

    public PointerInfo getFront() {
        return new PointerInfo(ATKCoreJNI.Path_getFront(this.swigCPtr, this), false);
    }

    public PointerInfo getBack() {
        return new PointerInfo(ATKCoreJNI.Path_getBack(this.swigCPtr, this), false);
    }

    public boolean empty() {
        return ATKCoreJNI.Path_empty(this.swigCPtr, this);
    }

    public boolean hasGap() {
        return ATKCoreJNI.Path_hasGap(this.swigCPtr, this);
    }

    public boolean continuous() {
        return ATKCoreJNI.Path_continuous(this.swigCPtr, this);
    }

    public boolean hasTiltAndOrientation() {
        return ATKCoreJNI.Path_hasTiltAndOrientation(this.swigCPtr, this);
    }

    public static boolean compareFloat(float f, float f2) {
        return ATKCoreJNI.Path_compareFloat(f, f2);
    }

    public boolean closed() {
        return ATKCoreJNI.Path_closed(this.swigCPtr, this);
    }

    public float getDistance() {
        return ATKCoreJNI.Path_getDistance(this.swigCPtr, this);
    }

    public float getClosingDistance() {
        return ATKCoreJNI.Path_getClosingDistance(this.swigCPtr, this);
    }

    public Rectangle getBoundingRect() {
        return new Rectangle(ATKCoreJNI.Path_getBoundingRect(this.swigCPtr, this), true);
    }

    public float area() {
        return ATKCoreJNI.Path_area(this.swigCPtr, this);
    }

    public Path mapped(Transform transform) {
        return new Path(ATKCoreJNI.Path_mapped(this.swigCPtr, this, Transform.getCPtr(transform), transform), true);
    }

    public boolean surrounds(Point point) {
        return ATKCoreJNI.Path_surrounds(this.swigCPtr, this, Point.getCPtr(point), point);
    }

    public boolean hasPointsInside(Rectangle rectangle) {
        return ATKCoreJNI.Path_hasPointsInside(this.swigCPtr, this, Rectangle.getCPtr(rectangle), rectangle);
    }

    public float distanceTo(Point point) {
        return ATKCoreJNI.Path_distanceTo(this.swigCPtr, this, Point.getCPtr(point), point);
    }

    public Point centroid() {
        return new Point(ATKCoreJNI.Path_centroid(this.swigCPtr, this), true);
    }

    public Point closestPoint(Point point) {
        return new Point(ATKCoreJNI.Path_closestPoint(this.swigCPtr, this, Point.getCPtr(point), point), true);
    }

    public Path getConvexHull() {
        return new Path(ATKCoreJNI.Path_getConvexHull(this.swigCPtr, this), true);
    }

    public Path convexHullSpaced(float f) {
        return new Path(ATKCoreJNI.Path_convexHullSpaced__SWIG_0(this.swigCPtr, this, f), true);
    }

    public Path convexHullSpaced() {
        return new Path(ATKCoreJNI.Path_convexHullSpaced__SWIG_1(this.swigCPtr, this), true);
    }

    public Path resample(ResamplingMode resamplingMode, float f) {
        return new Path(ATKCoreJNI.Path_resample(this.swigCPtr, this, resamplingMode.swigValue(), f), true);
    }

    public boolean strokeFinished() {
        return ATKCoreJNI.Path_strokeFinished(this.swigCPtr, this);
    }

    public static Path fromLine(Line line) {
        return new Path(ATKCoreJNI.Path_fromLine(Line.getCPtr(line), line), true);
    }

    public static Path fromRectangle(Rectangle rectangle) {
        return new Path(ATKCoreJNI.Path_fromRectangle(Rectangle.getCPtr(rectangle), rectangle), true);
    }

    public static Path fromExtent(Extent extent) {
        return new Path(ATKCoreJNI.Path_fromExtent(Extent.getCPtr(extent), extent), true);
    }

    public static Path fromPointerInfos(List<PointerInfo> list) {
        SWIGVectorPointerInfo sWIGVectorPointerInfo = new SWIGVectorPointerInfo(list);
        return new Path(ATKCoreJNI.Path_fromPointerInfos(SWIGVectorPointerInfo.getCPtr(sWIGVectorPointerInfo), sWIGVectorPointerInfo), true);
    }

    public static Path fromPoints(List<Point> list) {
        SWIGVectorPoint sWIGVectorPoint = new SWIGVectorPoint(list);
        return new Path(ATKCoreJNI.Path_fromPoints(SWIGVectorPoint.getCPtr(sWIGVectorPoint), sWIGVectorPoint), true);
    }

    public List<PointerInfo> accessPoints() {
        return new SWIGVectorPointerInfo(ATKCoreJNI.Path_accessPoints(this.swigCPtr, this), false);
    }

    public List<PointerInfo> points() {
        return new SWIGVectorPointerInfo(ATKCoreJNI.Path_points(this.swigCPtr, this), false);
    }

    public List<Point> toPoints() {
        return new SWIGVectorPoint(ATKCoreJNI.Path_toPoints(this.swigCPtr, this), true);
    }

    public void toInkPoints(PathToStrokeOffsets pathToStrokeOffsets, SWIGTYPE_p_std__vectorT_float_t sWIGTYPE_p_std__vectorT_float_t, SWIGTYPE_p_std__vectorT_float_t sWIGTYPE_p_std__vectorT_float_t2, SWIGTYPE_p_std__vectorT_long_long_t sWIGTYPE_p_std__vectorT_long_long_t, SWIGTYPE_p_std__vectorT_float_t sWIGTYPE_p_std__vectorT_float_t3, SWIGTYPE_p_std__vectorT_float_t sWIGTYPE_p_std__vectorT_float_t4, SWIGTYPE_p_std__vectorT_float_t sWIGTYPE_p_std__vectorT_float_t5) {
        ATKCoreJNI.Path_toInkPoints(this.swigCPtr, this, PathToStrokeOffsets.getCPtr(pathToStrokeOffsets), pathToStrokeOffsets, SWIGTYPE_p_std__vectorT_float_t.getCPtr(sWIGTYPE_p_std__vectorT_float_t), SWIGTYPE_p_std__vectorT_float_t.getCPtr(sWIGTYPE_p_std__vectorT_float_t2), SWIGTYPE_p_std__vectorT_long_long_t.getCPtr(sWIGTYPE_p_std__vectorT_long_long_t), SWIGTYPE_p_std__vectorT_float_t.getCPtr(sWIGTYPE_p_std__vectorT_float_t3), SWIGTYPE_p_std__vectorT_float_t.getCPtr(sWIGTYPE_p_std__vectorT_float_t4), SWIGTYPE_p_std__vectorT_float_t.getCPtr(sWIGTYPE_p_std__vectorT_float_t5));
    }

    public static Path concat(SWIGTYPE_p_std__vectorT_atk__core__Path_t sWIGTYPE_p_std__vectorT_atk__core__Path_t) {
        return new Path(ATKCoreJNI.Path_concat(SWIGTYPE_p_std__vectorT_atk__core__Path_t.getCPtr(sWIGTYPE_p_std__vectorT_atk__core__Path_t)), true);
    }

    public boolean isGap(long j) {
        return ATKCoreJNI.Path_isGap(this.swigCPtr, this, j);
    }

    public SWIGTYPE_p_std__vectorT_atk__core__Path_t subPaths() {
        return new SWIGTYPE_p_std__vectorT_atk__core__Path_t(ATKCoreJNI.Path_subPaths(this.swigCPtr, this), true);
    }

    public boolean fitsInRectangles(List<Rectangle> list, boolean z) {
        SWIGRectangleList sWIGRectangleList = new SWIGRectangleList(list);
        return ATKCoreJNI.Path_fitsInRectangles__SWIG_0(this.swigCPtr, this, SWIGRectangleList.getCPtr(sWIGRectangleList), sWIGRectangleList, z);
    }

    public boolean fitsInRectangles(List<Rectangle> list) {
        SWIGRectangleList sWIGRectangleList = new SWIGRectangleList(list);
        return ATKCoreJNI.Path_fitsInRectangles__SWIG_1(this.swigCPtr, this, SWIGRectangleList.getCPtr(sWIGRectangleList), sWIGRectangleList);
    }

    public int hashCode() {
        return ATKCoreJNI.Path_hashCode(this.swigCPtr, this);
    }

    public boolean nativeEquals(Path path) {
        return ATKCoreJNI.Path_nativeEquals(this.swigCPtr, this, getCPtr(path), path);
    }

    public String toString() {
        return new String(ATKCoreJNI.Path_toString(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public enum ResamplingMode {
        ENSURE_MINIMUM,
        ENSURE_MAXIMUM,
        ENSURE_CONSTANT,
        ENSURE_PROPORTIONAL_TO_F;

        private final int swigValue;

        public final int swigValue() {
            return this.swigValue;
        }

        public static ResamplingMode swigToEnum(int i) {
            ResamplingMode[] resamplingModeArr = (ResamplingMode[]) ResamplingMode.class.getEnumConstants();
            if (i < resamplingModeArr.length && i >= 0) {
                ResamplingMode resamplingMode = resamplingModeArr[i];
                if (resamplingMode.swigValue == i) {
                    return resamplingMode;
                }
            }
            for (ResamplingMode resamplingMode2 : resamplingModeArr) {
                if (resamplingMode2.swigValue == i) {
                    return resamplingMode2;
                }
            }
            throw new IllegalArgumentException("No enum " + ResamplingMode.class + " with value " + i);
        }

        ResamplingMode() {
            int i = SwigNext.next;
            SwigNext.next = i + 1;
            this.swigValue = i;
        }

        ResamplingMode(int i) {
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        ResamplingMode(ResamplingMode resamplingMode) {
            int i = resamplingMode.swigValue;
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
