package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class Selection implements Iterable<LayoutItem> {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public Selection(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(Selection selection) {
        if (selection == null) {
            return 0L;
        }
        return selection.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_Selection(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public Selection(Page page) {
        this(ATKCoreJNI.new_Selection__SWIG_0(Page.getCPtr(page), page), true);
    }

    public Selection(Layout layout) {
        this(ATKCoreJNI.new_Selection__SWIG_1(Layout.getCPtr(layout), layout), true);
    }

    public Selection(Content content) {
        this(ATKCoreJNI.new_Selection__SWIG_2(Content.getCPtr(content), content), true);
    }

    public Selection(Selection selection) {
        this(ATKCoreJNI.new_Selection__SWIG_3(getCPtr(selection), selection), true);
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Selection m12640clone() {
        return new Selection(ATKCoreJNI.Selection_clone(this.swigCPtr, this), true);
    }

    public Layout getLayout() {
        return new Layout(ATKCoreJNI.Selection_getLayout(this.swigCPtr, this), true);
    }

    public void reset() {
        ATKCoreJNI.Selection_reset__SWIG_0(this.swigCPtr, this);
    }

    public void reset(ModelLock modelLock) {
        ATKCoreJNI.Selection_reset__SWIG_1(this.swigCPtr, this, ModelLock.getCPtr(modelLock), modelLock);
    }

    public Selection selectNone() {
        return new Selection(ATKCoreJNI.Selection_selectNone(this.swigCPtr, this), false);
    }

    public Selection selectAll() {
        return new Selection(ATKCoreJNI.Selection_selectAll(this.swigCPtr, this), false);
    }

    public Selection selectLayer(String str, Mode mode) {
        return new Selection(ATKCoreJNI.Selection_selectLayer__SWIG_0(this.swigCPtr, this, str.getBytes(), mode.swigValue()), false);
    }

    public Selection selectLayer(String str) {
        return new Selection(ATKCoreJNI.Selection_selectLayer__SWIG_1(this.swigCPtr, this, str.getBytes()), false);
    }

    public Selection selectLayoutGroup(LayoutGroup layoutGroup, Mode mode) {
        return new Selection(ATKCoreJNI.Selection_selectLayoutGroup__SWIG_0(this.swigCPtr, this, LayoutGroup.getCPtr(layoutGroup), layoutGroup, mode.swigValue()), false);
    }

    public Selection selectLayoutGroup(LayoutGroup layoutGroup) {
        return new Selection(ATKCoreJNI.Selection_selectLayoutGroup__SWIG_1(this.swigCPtr, this, LayoutGroup.getCPtr(layoutGroup), layoutGroup), false);
    }

    public Selection selectTag(long j, Mode mode) {
        return new Selection(ATKCoreJNI.Selection_selectTag__SWIG_0(this.swigCPtr, this, j, mode.swigValue()), false);
    }

    public Selection selectTag(long j) {
        return new Selection(ATKCoreJNI.Selection_selectTag__SWIG_1(this.swigCPtr, this, j), false);
    }

    public Selection selectTags(List<Long> list, Mode mode) {
        SWIGVectorTagId sWIGVectorTagId = new SWIGVectorTagId(list);
        return new Selection(ATKCoreJNI.Selection_selectTags__SWIG_0(this.swigCPtr, this, SWIGVectorTagId.getCPtr(sWIGVectorTagId), sWIGVectorTagId, mode.swigValue()), false);
    }

    public Selection selectTags(List<Long> list) {
        SWIGVectorTagId sWIGVectorTagId = new SWIGVectorTagId(list);
        return new Selection(ATKCoreJNI.Selection_selectTags__SWIG_1(this.swigCPtr, this, SWIGVectorTagId.getCPtr(sWIGVectorTagId), sWIGVectorTagId), false);
    }

    public Selection selectLayoutItem(LayoutItem layoutItem, Mode mode) {
        return new Selection(ATKCoreJNI.Selection_selectLayoutItem__SWIG_0(this.swigCPtr, this, LayoutItem.getCPtr(layoutItem), layoutItem, mode.swigValue()), false);
    }

    public Selection selectLayoutItem(LayoutItem layoutItem) {
        return new Selection(ATKCoreJNI.Selection_selectLayoutItem__SWIG_1(this.swigCPtr, this, LayoutItem.getCPtr(layoutItem), layoutItem), false);
    }

    public Selection selectStrokeIds(boolean z, SWIGTYPE_p_std__vectorT_myscript__ink__InkStrokeId_t sWIGTYPE_p_std__vectorT_myscript__ink__InkStrokeId_t, Mode mode) {
        return new Selection(ATKCoreJNI.Selection_selectStrokeIds__SWIG_0(this.swigCPtr, this, z, SWIGTYPE_p_std__vectorT_myscript__ink__InkStrokeId_t.getCPtr(sWIGTYPE_p_std__vectorT_myscript__ink__InkStrokeId_t), mode.swigValue()), false);
    }

    public Selection selectStrokeIds(boolean z, SWIGTYPE_p_std__vectorT_myscript__ink__InkStrokeId_t sWIGTYPE_p_std__vectorT_myscript__ink__InkStrokeId_t) {
        return new Selection(ATKCoreJNI.Selection_selectStrokeIds__SWIG_1(this.swigCPtr, this, z, SWIGTYPE_p_std__vectorT_myscript__ink__InkStrokeId_t.getCPtr(sWIGTYPE_p_std__vectorT_myscript__ink__InkStrokeId_t)), false);
    }

    public Selection selectInkItemIfValid(SWIGTYPE_p_myscript__ink__InkStrokeId sWIGTYPE_p_myscript__ink__InkStrokeId, Mode mode) {
        return new Selection(ATKCoreJNI.Selection_selectInkItemIfValid__SWIG_0(this.swigCPtr, this, SWIGTYPE_p_myscript__ink__InkStrokeId.getCPtr(sWIGTYPE_p_myscript__ink__InkStrokeId), mode.swigValue()), false);
    }

    public Selection selectInkItemIfValid(SWIGTYPE_p_myscript__ink__InkStrokeId sWIGTYPE_p_myscript__ink__InkStrokeId) {
        return new Selection(ATKCoreJNI.Selection_selectInkItemIfValid__SWIG_1(this.swigCPtr, this, SWIGTYPE_p_myscript__ink__InkStrokeId.getCPtr(sWIGTYPE_p_myscript__ink__InkStrokeId)), false);
    }

    public Selection selectPolygon(Path path, Mode mode) {
        return new Selection(ATKCoreJNI.Selection_selectPolygon__SWIG_0(this.swigCPtr, this, Path.getCPtr(path), path, mode.swigValue()), false);
    }

    public Selection selectPolygon(Path path) {
        return new Selection(ATKCoreJNI.Selection_selectPolygon__SWIG_1(this.swigCPtr, this, Path.getCPtr(path), path), false);
    }

    public Selection selectPolygon(Point point, int i, Mode mode) {
        return new Selection(ATKCoreJNI.Selection_selectPolygon__SWIG_2(this.swigCPtr, this, Point.getCPtr(point), point, i, mode.swigValue()), false);
    }

    public Selection selectPolygon(Point point, int i) {
        return new Selection(ATKCoreJNI.Selection_selectPolygon__SWIG_3(this.swigCPtr, this, Point.getCPtr(point), point, i), false);
    }

    public Selection selectRectangle(Rectangle rectangle, Mode mode) {
        return new Selection(ATKCoreJNI.Selection_selectRectangle__SWIG_0(this.swigCPtr, this, Rectangle.getCPtr(rectangle), rectangle, mode.swigValue()), false);
    }

    public Selection selectRectangle(Rectangle rectangle) {
        return new Selection(ATKCoreJNI.Selection_selectRectangle__SWIG_1(this.swigCPtr, this, Rectangle.getCPtr(rectangle), rectangle), false);
    }

    public Selection selectByType(int i, Mode mode) {
        return new Selection(ATKCoreJNI.Selection_selectByType__SWIG_0(this.swigCPtr, this, i, mode.swigValue()), false);
    }

    public Selection selectByType(int i) {
        return new Selection(ATKCoreJNI.Selection_selectByType__SWIG_1(this.swigCPtr, this, i), false);
    }

    public void selectInkSegment(SWIGTYPE_p_myscript__ink__InkSegment sWIGTYPE_p_myscript__ink__InkSegment, Mode mode) {
        ATKCoreJNI.Selection_selectInkSegment__SWIG_0(this.swigCPtr, this, SWIGTYPE_p_myscript__ink__InkSegment.getCPtr(sWIGTYPE_p_myscript__ink__InkSegment), mode.swigValue());
    }

    public void selectInkSegment(SWIGTYPE_p_myscript__ink__InkSegment sWIGTYPE_p_myscript__ink__InkSegment) {
        ATKCoreJNI.Selection_selectInkSegment__SWIG_1(this.swigCPtr, this, SWIGTYPE_p_myscript__ink__InkSegment.getCPtr(sWIGTYPE_p_myscript__ink__InkSegment));
    }

    public SWIGTYPE_p_myscript__ink__InkSegment inkSegment() {
        return new SWIGTYPE_p_myscript__ink__InkSegment(ATKCoreJNI.Selection_inkSegment(this.swigCPtr, this), true);
    }

    public Selection adjustToStrokeBoundaries(float f) {
        return new Selection(ATKCoreJNI.Selection_adjustToStrokeBoundaries(this.swigCPtr, this, f), false);
    }

    public Selection combine(Selection selection, Mode mode) {
        return new Selection(ATKCoreJNI.Selection_combine__SWIG_0(this.swigCPtr, this, getCPtr(selection), selection, mode.swigValue()), false);
    }

    public Selection combine(Selection selection) {
        return new Selection(ATKCoreJNI.Selection_combine__SWIG_1(this.swigCPtr, this, getCPtr(selection), selection), false);
    }

    public List<Long> tags(String str) {
        return new SWIGVectorTagId(ATKCoreJNI.Selection_tags(this.swigCPtr, this, str.getBytes()), true);
    }

    public Extent getExtent(ExtentPolicy extentPolicy) {
        return new Extent(ATKCoreJNI.Selection_getExtent__SWIG_0(this.swigCPtr, this, extentPolicy.swigValue()), true);
    }

    public Extent getExtent() {
        return new Extent(ATKCoreJNI.Selection_getExtent__SWIG_1(this.swigCPtr, this), true);
    }

    public void transform(Transform transform) {
        ATKCoreJNI.Selection_transform(this.swigCPtr, this, Transform.getCPtr(transform), transform);
    }

    public void applyFontStyle(Transform transform) {
        ATKCoreJNI.Selection_applyFontStyle(this.swigCPtr, this, Transform.getCPtr(transform), transform);
    }

    public boolean isEmpty() {
        return ATKCoreJNI.Selection_isEmpty(this.swigCPtr, this);
    }

    public boolean hasGlyph() {
        return ATKCoreJNI.Selection_hasGlyph(this.swigCPtr, this);
    }

    public boolean hasStroke() {
        return ATKCoreJNI.Selection_hasStroke(this.swigCPtr, this);
    }

    public boolean hasPrimitive() {
        return ATKCoreJNI.Selection_hasPrimitive(this.swigCPtr, this);
    }

    public int getInkItemsCount() {
        return ATKCoreJNI.Selection_getInkItemsCount(this.swigCPtr, this);
    }

    public LayoutIterator iterator(boolean z) {
        return new LayoutIterator(ATKCoreJNI.Selection_iterator__SWIG_0(this.swigCPtr, this, z), true);
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public Iterator<LayoutItem> iterator2() {
        return new LayoutIterator(ATKCoreJNI.Selection_iterator__SWIG_1(this.swigCPtr, this), true);
    }

    public void setMode(GeometricMode geometricMode) {
        ATKCoreJNI.Selection_setMode(this.swigCPtr, this, geometricMode.swigValue());
    }

    public boolean intersects(Selection selection) {
        return ATKCoreJNI.Selection_intersects(this.swigCPtr, this, getCPtr(selection), selection);
    }

    public boolean contains(Selection selection) {
        return ATKCoreJNI.Selection_contains(this.swigCPtr, this, getCPtr(selection), selection);
    }

    public boolean isAbove(Selection selection, boolean z) {
        return ATKCoreJNI.Selection_isAbove(this.swigCPtr, this, getCPtr(selection), selection, z);
    }

    public SWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t layoutItems(boolean z) {
        return new SWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t(ATKCoreJNI.Selection_layoutItems__SWIG_0(this.swigCPtr, this, z), true);
    }

    public SWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t layoutItems() {
        return new SWIGTYPE_p_std__vectorT_myscript__document__LayoutItem_t(ATKCoreJNI.Selection_layoutItems__SWIG_1(this.swigCPtr, this), true);
    }

    public static float inkWidth(LayoutItem layoutItem) {
        return ATKCoreJNI.Selection_inkWidth(LayoutItem.getCPtr(layoutItem), layoutItem);
    }

    public boolean valid() {
        return ATKCoreJNI.Selection_valid(this.swigCPtr, this);
    }

    public float length() {
        return ATKCoreJNI.Selection_length(this.swigCPtr, this);
    }

    public String toString() {
        return new String(ATKCoreJNI.Selection_toString(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public enum GeometricMode {
        EXACT,
        INTERSECTING,
        SMART_GLYPH;

        private final int swigValue;

        public final int swigValue() {
            return this.swigValue;
        }

        public static GeometricMode swigToEnum(int i) {
            GeometricMode[] geometricModeArr = (GeometricMode[]) GeometricMode.class.getEnumConstants();
            if (i < geometricModeArr.length && i >= 0) {
                GeometricMode geometricMode = geometricModeArr[i];
                if (geometricMode.swigValue == i) {
                    return geometricMode;
                }
            }
            for (GeometricMode geometricMode2 : geometricModeArr) {
                if (geometricMode2.swigValue == i) {
                    return geometricMode2;
                }
            }
            throw new IllegalArgumentException("No enum " + GeometricMode.class + " with value " + i);
        }

        GeometricMode() {
            int i = SwigNext.next;
            SwigNext.next = i + 1;
            this.swigValue = i;
        }

        GeometricMode(int i) {
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        GeometricMode(GeometricMode geometricMode) {
            int i = geometricMode.swigValue;
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        private static class SwigNext {
            private static int next;

            private SwigNext() {
            }
        }
    }

    public enum Mode {
        SET(0),
        UNION(1),
        INTERSECTION(2),
        DIFFERENCE(3);

        private final int swigValue;

        public final int swigValue() {
            return this.swigValue;
        }

        public static Mode swigToEnum(int i) {
            Mode[] modeArr = (Mode[]) Mode.class.getEnumConstants();
            if (i < modeArr.length && i >= 0) {
                Mode mode = modeArr[i];
                if (mode.swigValue == i) {
                    return mode;
                }
            }
            for (Mode mode2 : modeArr) {
                if (mode2.swigValue == i) {
                    return mode2;
                }
            }
            throw new IllegalArgumentException("No enum " + Mode.class + " with value " + i);
        }

        Mode() {
            int i = SwigNext.next;
            SwigNext.next = i + 1;
            this.swigValue = i;
        }

        Mode(int i) {
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        Mode(Mode mode) {
            int i = mode.swigValue;
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        private static class SwigNext {
            private static int next;

            private SwigNext() {
            }
        }
    }

    public enum ExtentPolicy {
        NONE(0),
        CONSERVATIVE(1),
        ACCURATE(2);

        private final int swigValue;

        public final int swigValue() {
            return this.swigValue;
        }

        public static ExtentPolicy swigToEnum(int i) {
            ExtentPolicy[] extentPolicyArr = (ExtentPolicy[]) ExtentPolicy.class.getEnumConstants();
            if (i < extentPolicyArr.length && i >= 0) {
                ExtentPolicy extentPolicy = extentPolicyArr[i];
                if (extentPolicy.swigValue == i) {
                    return extentPolicy;
                }
            }
            for (ExtentPolicy extentPolicy2 : extentPolicyArr) {
                if (extentPolicy2.swigValue == i) {
                    return extentPolicy2;
                }
            }
            throw new IllegalArgumentException("No enum " + ExtentPolicy.class + " with value " + i);
        }

        ExtentPolicy() {
            int i = SwigNext.next;
            SwigNext.next = i + 1;
            this.swigValue = i;
        }

        ExtentPolicy(int i) {
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        ExtentPolicy(ExtentPolicy extentPolicy) {
            int i = extentPolicy.swigValue;
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
