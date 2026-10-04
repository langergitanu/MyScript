package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class Layout {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public Layout(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(Layout layout) {
        if (layout == null) {
            return 0L;
        }
        return layout.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_Layout(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public static String getBACKGROUND_LAYER_NAME() {
        return new String(ATKCoreJNI.Layout_BACKGROUND_LAYER_NAME_get(), StandardCharsets.UTF_8);
    }

    public static String getBACKGROUND_OBJECT_LAYER_NAME() {
        return new String(ATKCoreJNI.Layout_BACKGROUND_OBJECT_LAYER_NAME_get(), StandardCharsets.UTF_8);
    }

    public static String getDOCUMENT_LAYER_NAME() {
        return new String(ATKCoreJNI.Layout_DOCUMENT_LAYER_NAME_get(), StandardCharsets.UTF_8);
    }

    public Layout() {
        this(ATKCoreJNI.new_Layout__SWIG_0(), true);
    }

    public boolean hasTag(long j) {
        return ATKCoreJNI.Layout_hasTag(this.swigCPtr, this, j);
    }

    public List<Long> tags(String str) {
        return new SWIGVectorTagId(ATKCoreJNI.Layout_tags(this.swigCPtr, this, str.getBytes()), true);
    }

    public long addTag(Selection selection, String str, Json json) {
        return ATKCoreJNI.Layout_addTag__SWIG_0(this.swigCPtr, this, Selection.getCPtr(selection), selection, str.getBytes(), Json.getCPtr(json), json);
    }

    public long addTag(Selection selection, String str) {
        return ATKCoreJNI.Layout_addTag__SWIG_1(this.swigCPtr, this, Selection.getCPtr(selection), selection, str.getBytes());
    }

    public long addTag(Selection selection) {
        return ATKCoreJNI.Layout_addTag__SWIG_2(this.swigCPtr, this, Selection.getCPtr(selection), selection);
    }

    public long addTag(SWIGTYPE_p_myscript__ink__InkSelection sWIGTYPE_p_myscript__ink__InkSelection, String str, Json json) {
        return ATKCoreJNI.Layout_addTag__SWIG_3(this.swigCPtr, this, SWIGTYPE_p_myscript__ink__InkSelection.getCPtr(sWIGTYPE_p_myscript__ink__InkSelection), str.getBytes(), Json.getCPtr(json), json);
    }

    public long addTag(SWIGTYPE_p_myscript__ink__InkSelection sWIGTYPE_p_myscript__ink__InkSelection, String str) {
        return ATKCoreJNI.Layout_addTag__SWIG_4(this.swigCPtr, this, SWIGTYPE_p_myscript__ink__InkSelection.getCPtr(sWIGTYPE_p_myscript__ink__InkSelection), str.getBytes());
    }

    public long addTag(SWIGTYPE_p_myscript__ink__InkSelection sWIGTYPE_p_myscript__ink__InkSelection) {
        return ATKCoreJNI.Layout_addTag__SWIG_5(this.swigCPtr, this, SWIGTYPE_p_myscript__ink__InkSelection.getCPtr(sWIGTYPE_p_myscript__ink__InkSelection));
    }

    public void updateTag(long j, Selection selection, Json json) {
        ATKCoreJNI.Layout_updateTag__SWIG_0(this.swigCPtr, this, j, Selection.getCPtr(selection), selection, Json.getCPtr(json), json);
    }

    public void updateTag(long j, Selection selection) {
        ATKCoreJNI.Layout_updateTag__SWIG_1(this.swigCPtr, this, j, Selection.getCPtr(selection), selection);
    }

    public void updateTag(long j, SWIGTYPE_p_myscript__ink__InkSelection sWIGTYPE_p_myscript__ink__InkSelection, Json json) {
        ATKCoreJNI.Layout_updateTag__SWIG_2(this.swigCPtr, this, j, SWIGTYPE_p_myscript__ink__InkSelection.getCPtr(sWIGTYPE_p_myscript__ink__InkSelection), Json.getCPtr(json), json);
    }

    public void updateTag(long j, SWIGTYPE_p_myscript__ink__InkSelection sWIGTYPE_p_myscript__ink__InkSelection) {
        ATKCoreJNI.Layout_updateTag__SWIG_3(this.swigCPtr, this, j, SWIGTYPE_p_myscript__ink__InkSelection.getCPtr(sWIGTYPE_p_myscript__ink__InkSelection));
    }

    public void removeTag(long j) {
        ATKCoreJNI.Layout_removeTag(this.swigCPtr, this, j);
    }

    public void removeTags(List<Long> list) {
        SWIGVectorTagId sWIGVectorTagId = new SWIGVectorTagId(list);
        ATKCoreJNI.Layout_removeTags(this.swigCPtr, this, SWIGVectorTagId.getCPtr(sWIGVectorTagId), sWIGVectorTagId);
    }

    public Rectangle getViewPort() {
        return new Rectangle(ATKCoreJNI.Layout_getViewPort(this.swigCPtr, this), true);
    }

    public void setViewPort(Rectangle rectangle) {
        ATKCoreJNI.Layout_setViewPort(this.swigCPtr, this, Rectangle.getCPtr(rectangle), rectangle);
    }

    public InkStyle resolveStyle(int i, String str, String str2) {
        return new InkStyle(ATKCoreJNI.Layout_resolveStyle__SWIG_0(this.swigCPtr, this, i, str.getBytes(), str2.getBytes()), true);
    }

    public InkStyle resolveStyle(int i, String str) {
        return new InkStyle(ATKCoreJNI.Layout_resolveStyle__SWIG_1(this.swigCPtr, this, i, str.getBytes()), true);
    }

    public void applyStyle(Selection selection, String str, String str2) {
        ATKCoreJNI.Layout_applyStyle__SWIG_0(this.swigCPtr, this, Selection.getCPtr(selection), selection, str.getBytes(), str2.getBytes());
    }

    public void applyStyle(Selection selection, String str) {
        ATKCoreJNI.Layout_applyStyle__SWIG_1(this.swigCPtr, this, Selection.getCPtr(selection), selection, str.getBytes());
    }

    public void removeStyle(Selection selection, String str) {
        ATKCoreJNI.Layout_removeStyle(this.swigCPtr, this, Selection.getCPtr(selection), selection, str.getBytes());
    }

    public boolean hasFontSpaceWidth(String str, float f) {
        return ATKCoreJNI.Layout_hasFontSpaceWidth(this.swigCPtr, this, str.getBytes(), f);
    }

    public float getFontSpaceWidth(String str, float f) {
        return ATKCoreJNI.Layout_getFontSpaceWidth(this.swigCPtr, this, str.getBytes(), f);
    }

    public void setFontSpaceWidth(String str, float f, float f2) {
        ATKCoreJNI.Layout_setFontSpaceWidth(this.swigCPtr, this, str.getBytes(), f, f2);
    }

    public SWIGTYPE_p_std__vectorT_myscript__document__LayoutItemObject_t layoutItemObjectsFromMimeType(String str) {
        return new SWIGTYPE_p_std__vectorT_myscript__document__LayoutItemObject_t(ATKCoreJNI.Layout_layoutItemObjectsFromMimeType(this.swigCPtr, this, str.getBytes()), true);
    }

    public SWIGTYPE_p_std__vectorT_myscript__document__LayoutItemObject_t layoutItemObjectsFromUrl(String str) {
        return new SWIGTYPE_p_std__vectorT_myscript__document__LayoutItemObject_t(ATKCoreJNI.Layout_layoutItemObjectsFromUrl(this.swigCPtr, this, str.getBytes()), true);
    }

    public SWIGTYPE_p_std__vectorT_myscript__document__LayoutItemObject_t layoutItemObjectsFromCustomAttribute(String str, String str2, Selection selection) {
        return new SWIGTYPE_p_std__vectorT_myscript__document__LayoutItemObject_t(ATKCoreJNI.Layout_layoutItemObjectsFromCustomAttribute(this.swigCPtr, this, str.getBytes(), str2.getBytes(), Selection.getCPtr(selection), selection), true);
    }

    public LayoutItemObject layoutItemObjectFromCustomAttribute(String str, String str2, String str3, SWIGTYPE_p_std__functionT_bool_fstd__string_const_RF_t sWIGTYPE_p_std__functionT_bool_fstd__string_const_RF_t) {
        return new LayoutItemObject(ATKCoreJNI.Layout_layoutItemObjectFromCustomAttribute__SWIG_0(this.swigCPtr, this, str.getBytes(), str2.getBytes(), str3.getBytes(), SWIGTYPE_p_std__functionT_bool_fstd__string_const_RF_t.getCPtr(sWIGTYPE_p_std__functionT_bool_fstd__string_const_RF_t)), true);
    }

    public LayoutItemObject layoutItemObjectFromCustomAttribute(String str, String str2, String str3) {
        return new LayoutItemObject(ATKCoreJNI.Layout_layoutItemObjectFromCustomAttribute__SWIG_1(this.swigCPtr, this, str.getBytes(), str2.getBytes(), str3.getBytes()), true);
    }

    public int countLayoutItemObjects(String str, String str2, String str3) {
        return ATKCoreJNI.Layout_countLayoutItemObjects(this.swigCPtr, this, str.getBytes(), str2.getBytes(), str3.getBytes());
    }

    public Selection addLayoutItem(LayoutItem layoutItem, String str, SWIGTYPE_p_myscript__ink__InkStrokeId sWIGTYPE_p_myscript__ink__InkStrokeId) {
        return new Selection(ATKCoreJNI.Layout_addLayoutItem__SWIG_0(this.swigCPtr, this, LayoutItem.getCPtr(layoutItem), layoutItem, str.getBytes(), SWIGTYPE_p_myscript__ink__InkStrokeId.getCPtr(sWIGTYPE_p_myscript__ink__InkStrokeId)), true);
    }

    public Selection addLayoutItem(LayoutItem layoutItem, String str) {
        return new Selection(ATKCoreJNI.Layout_addLayoutItem__SWIG_1(this.swigCPtr, this, LayoutItem.getCPtr(layoutItem), layoutItem, str.getBytes()), true);
    }

    public Selection addLayoutItem(LayoutItem layoutItem) {
        return new Selection(ATKCoreJNI.Layout_addLayoutItem__SWIG_2(this.swigCPtr, this, LayoutItem.getCPtr(layoutItem), layoutItem), true);
    }

    public Selection addStroke(InkStroke inkStroke, String str, String str2) {
        return new Selection(ATKCoreJNI.Layout_addStroke__SWIG_0(this.swigCPtr, this, InkStroke.getCPtr(inkStroke), inkStroke, str.getBytes(), str2.getBytes()), true);
    }

    public Selection addStroke(InkStroke inkStroke, String str) {
        return new Selection(ATKCoreJNI.Layout_addStroke__SWIG_1(this.swigCPtr, this, InkStroke.getCPtr(inkStroke), inkStroke, str.getBytes()), true);
    }

    public Selection addStrokeToGroup(LayoutGroup layoutGroup, InkStroke inkStroke, String str, String str2) {
        return new Selection(ATKCoreJNI.Layout_addStrokeToGroup__SWIG_0(this.swigCPtr, this, LayoutGroup.getCPtr(layoutGroup), layoutGroup, InkStroke.getCPtr(inkStroke), inkStroke, str.getBytes(), str2.getBytes()), true);
    }

    public Selection addStrokeToGroup(LayoutGroup layoutGroup, InkStroke inkStroke, String str) {
        return new Selection(ATKCoreJNI.Layout_addStrokeToGroup__SWIG_1(this.swigCPtr, this, LayoutGroup.getCPtr(layoutGroup), layoutGroup, InkStroke.getCPtr(inkStroke), inkStroke, str.getBytes()), true);
    }

    public Selection addStrokeToGroup(LayoutGroup layoutGroup, InkStroke inkStroke) {
        return new Selection(ATKCoreJNI.Layout_addStrokeToGroup__SWIG_2(this.swigCPtr, this, LayoutGroup.getCPtr(layoutGroup), layoutGroup, InkStroke.getCPtr(inkStroke), inkStroke), true);
    }

    public Selection addObject(String str, String str2, Rectangle rectangle, String str3, String str4, boolean z) {
        return new Selection(ATKCoreJNI.Layout_addObject__SWIG_0(this.swigCPtr, this, str.getBytes(), str2.getBytes(), Rectangle.getCPtr(rectangle), rectangle, str3.getBytes(), str4.getBytes(), z), true);
    }

    public Selection addObject(String str, String str2, Rectangle rectangle, String str3, String str4) {
        return new Selection(ATKCoreJNI.Layout_addObject__SWIG_1(this.swigCPtr, this, str.getBytes(), str2.getBytes(), Rectangle.getCPtr(rectangle), rectangle, str3.getBytes(), str4.getBytes()), true);
    }

    public Selection addObject(String str, String str2, Rectangle rectangle, String str3) {
        return new Selection(ATKCoreJNI.Layout_addObject__SWIG_2(this.swigCPtr, this, str.getBytes(), str2.getBytes(), Rectangle.getCPtr(rectangle), rectangle, str3.getBytes()), true);
    }

    public void removeObject(String str) {
        ATKCoreJNI.Layout_removeObject(this.swigCPtr, this, str.getBytes());
    }

    public Selection addGuide(String str, String str2, String str3, String str4) {
        return new Selection(ATKCoreJNI.Layout_addGuide__SWIG_0(this.swigCPtr, this, str.getBytes(), str2.getBytes(), str3.getBytes(), str4.getBytes()), true);
    }

    public Selection addGuide(String str, String str2, String str3) {
        return new Selection(ATKCoreJNI.Layout_addGuide__SWIG_1(this.swigCPtr, this, str.getBytes(), str2.getBytes(), str3.getBytes()), true);
    }

    public boolean hasMetadata(long j) {
        return ATKCoreJNI.Layout_hasMetadata(this.swigCPtr, this, j);
    }

    public Json metadata(long j) {
        return new Json(ATKCoreJNI.Layout_metadata(this.swigCPtr, this, j), true);
    }

    public void setMetadata(long j, Json json) {
        ATKCoreJNI.Layout_setMetadata(this.swigCPtr, this, j, Json.getCPtr(json), json);
    }

    public void addLayer(String str) {
        ATKCoreJNI.Layout_addLayer(this.swigCPtr, this, str.getBytes());
    }

    public void removeLayer(String str) {
        ATKCoreJNI.Layout_removeLayer(this.swigCPtr, this, str.getBytes());
    }

    public void setLayerColor(String str, int i) {
        ATKCoreJNI.Layout_setLayerColor(this.swigCPtr, this, str.getBytes(), i);
    }

    public void moveSelectionToLayer(Selection selection, String str) {
        ATKCoreJNI.Layout_moveSelectionToLayer(this.swigCPtr, this, Selection.getCPtr(selection), selection, str.getBytes());
    }

    public void bringToFront(Selection selection) {
        ATKCoreJNI.Layout_bringToFront(this.swigCPtr, this, Selection.getCPtr(selection), selection);
    }

    public void pushToBack(Selection selection) {
        ATKCoreJNI.Layout_pushToBack(this.swigCPtr, this, Selection.getCPtr(selection), selection);
    }

    public void stackUnder(Selection selection, Selection selection2) {
        ATKCoreJNI.Layout_stackUnder(this.swigCPtr, this, Selection.getCPtr(selection), selection, Selection.getCPtr(selection2), selection2);
    }

    public void stackAbove(Selection selection, Selection selection2) {
        ATKCoreJNI.Layout_stackAbove(this.swigCPtr, this, Selection.getCPtr(selection), selection, Selection.getCPtr(selection2), selection2);
    }

    public boolean isAbove(Selection selection, Selection selection2) {
        return ATKCoreJNI.Layout_isAbove(this.swigCPtr, this, Selection.getCPtr(selection), selection, Selection.getCPtr(selection2), selection2);
    }

    public void clear() {
        ATKCoreJNI.Layout_clear(this.swigCPtr, this);
    }

    public Selection getAllSelection() {
        return new Selection(ATKCoreJNI.Layout_getAllSelection(this.swigCPtr, this), true);
    }

    public void erase(Selection selection) {
        ATKCoreJNI.Layout_erase(this.swigCPtr, this, Selection.getCPtr(selection), selection);
    }

    public void transform(Selection selection, Transform transform) {
        ATKCoreJNI.Layout_transform__SWIG_0(this.swigCPtr, this, Selection.getCPtr(selection), selection, Transform.getCPtr(transform), transform);
    }

    public Transform transform(String str) {
        return new Transform(ATKCoreJNI.Layout_transform__SWIG_1(this.swigCPtr, this, str.getBytes()), true);
    }

    public List<Glyph> createGlyphsFromLabel(List<Parallelogram> list, String str) {
        SWIGVectorParallelogram sWIGVectorParallelogram = new SWIGVectorParallelogram(list);
        return new SWIGVectorGlyph(ATKCoreJNI.Layout_createGlyphsFromLabel__SWIG_0(this.swigCPtr, this, SWIGVectorParallelogram.getCPtr(sWIGVectorParallelogram), sWIGVectorParallelogram, str.getBytes()), true);
    }

    public List<Glyph> createGlyphsFromLabel(List<GlyphLines> list, List<Parallelogram> list2, String str) {
        SWIGVectorGlyphLines sWIGVectorGlyphLines = new SWIGVectorGlyphLines(list);
        SWIGVectorParallelogram sWIGVectorParallelogram = new SWIGVectorParallelogram(list2);
        return new SWIGVectorGlyph(ATKCoreJNI.Layout_createGlyphsFromLabel__SWIG_1(this.swigCPtr, this, SWIGVectorGlyphLines.getCPtr(sWIGVectorGlyphLines), sWIGVectorGlyphLines, SWIGVectorParallelogram.getCPtr(sWIGVectorParallelogram), sWIGVectorParallelogram, str.getBytes()), true);
    }

    public List<Glyph> createGlyphsFromLabel(List<Parallelogram> list, SWIGTYPE_p_std__vectorT_myscript__ink__GlyphSlices_t sWIGTYPE_p_std__vectorT_myscript__ink__GlyphSlices_t, String str) {
        SWIGVectorParallelogram sWIGVectorParallelogram = new SWIGVectorParallelogram(list);
        return new SWIGVectorGlyph(ATKCoreJNI.Layout_createGlyphsFromLabel__SWIG_2(this.swigCPtr, this, SWIGVectorParallelogram.getCPtr(sWIGVectorParallelogram), sWIGVectorParallelogram, SWIGTYPE_p_std__vectorT_myscript__ink__GlyphSlices_t.getCPtr(sWIGTYPE_p_std__vectorT_myscript__ink__GlyphSlices_t), str.getBytes()), true);
    }

    public List<Glyph> createGlyphsFromLabel(List<GlyphLines> list, List<Parallelogram> list2, SWIGTYPE_p_std__vectorT_myscript__ink__GlyphSlices_t sWIGTYPE_p_std__vectorT_myscript__ink__GlyphSlices_t, String str) {
        SWIGVectorGlyphLines sWIGVectorGlyphLines = new SWIGVectorGlyphLines(list);
        SWIGVectorParallelogram sWIGVectorParallelogram = new SWIGVectorParallelogram(list2);
        return new SWIGVectorGlyph(ATKCoreJNI.Layout_createGlyphsFromLabel__SWIG_3(this.swigCPtr, this, SWIGVectorGlyphLines.getCPtr(sWIGVectorGlyphLines), sWIGVectorGlyphLines, SWIGVectorParallelogram.getCPtr(sWIGVectorParallelogram), sWIGVectorParallelogram, SWIGTYPE_p_std__vectorT_myscript__ink__GlyphSlices_t.getCPtr(sWIGTYPE_p_std__vectorT_myscript__ink__GlyphSlices_t), str.getBytes()), true);
    }

    public LayoutGroup findGroupUsingCustomAttribute(String str, String str2, String str3) {
        return new LayoutGroup(ATKCoreJNI.Layout_findGroupUsingCustomAttribute(this.swigCPtr, this, str.getBytes(), str2.getBytes(), str3.getBytes()), true);
    }

    public static boolean itemCanBeDetached(LayoutItem layoutItem) {
        return ATKCoreJNI.Layout_itemCanBeDetached(LayoutItem.getCPtr(layoutItem), layoutItem);
    }

    public LayoutItemStroke makeStroke(InkStroke inkStroke, String str, String str2) {
        return new LayoutItemStroke(ATKCoreJNI.Layout_makeStroke__SWIG_0(this.swigCPtr, this, InkStroke.getCPtr(inkStroke), inkStroke, str.getBytes(), str2.getBytes()), true);
    }

    public LayoutItemStroke makeStroke(InkStroke inkStroke, String str) {
        return new LayoutItemStroke(ATKCoreJNI.Layout_makeStroke__SWIG_1(this.swigCPtr, this, InkStroke.getCPtr(inkStroke), inkStroke, str.getBytes()), true);
    }

    public LayoutItemStroke makeStroke(Path path, String str, String str2) {
        return new LayoutItemStroke(ATKCoreJNI.Layout_makeStroke__SWIG_2(this.swigCPtr, this, Path.getCPtr(path), path, str.getBytes(), str2.getBytes()), true);
    }

    public LayoutItemStroke makeStroke(Path path, String str) {
        return new LayoutItemStroke(ATKCoreJNI.Layout_makeStroke__SWIG_3(this.swigCPtr, this, Path.getCPtr(path), path, str.getBytes()), true);
    }

    public LayoutItemLine makeLine(Point point, Point point2, String str, String str2, boolean z, boolean z2) {
        return new LayoutItemLine(ATKCoreJNI.Layout_makeLine__SWIG_0(this.swigCPtr, this, Point.getCPtr(point), point, Point.getCPtr(point2), point2, str.getBytes(), str2.getBytes(), z, z2), true);
    }

    public LayoutItemLine makeLine(Point point, Point point2, String str, String str2, boolean z) {
        return new LayoutItemLine(ATKCoreJNI.Layout_makeLine__SWIG_1(this.swigCPtr, this, Point.getCPtr(point), point, Point.getCPtr(point2), point2, str.getBytes(), str2.getBytes(), z), true);
    }

    public LayoutItemLine makeLine(Point point, Point point2, String str, String str2) {
        return new LayoutItemLine(ATKCoreJNI.Layout_makeLine__SWIG_2(this.swigCPtr, this, Point.getCPtr(point), point, Point.getCPtr(point2), point2, str.getBytes(), str2.getBytes()), true);
    }

    public LayoutItemLine makeLine(Point point, Point point2, String str) {
        return new LayoutItemLine(ATKCoreJNI.Layout_makeLine__SWIG_3(this.swigCPtr, this, Point.getCPtr(point), point, Point.getCPtr(point2), point2, str.getBytes()), true);
    }

    public LayoutItemPoint makePoint(Point point, String str, String str2) {
        return new LayoutItemPoint(ATKCoreJNI.Layout_makePoint__SWIG_0(this.swigCPtr, this, Point.getCPtr(point), point, str.getBytes(), str2.getBytes()), true);
    }

    public LayoutItemPoint makePoint(Point point, String str) {
        return new LayoutItemPoint(ATKCoreJNI.Layout_makePoint__SWIG_1(this.swigCPtr, this, Point.getCPtr(point), point, str.getBytes()), true);
    }

    public LayoutItemArc makeArc(Point point, float f, float f2, float f3, float f4, float f5, String str, String str2, boolean z, boolean z2) {
        return new LayoutItemArc(ATKCoreJNI.Layout_makeArc__SWIG_0(this.swigCPtr, this, Point.getCPtr(point), point, f, f2, f3, f4, f5, str.getBytes(), str2.getBytes(), z, z2), true);
    }

    public LayoutItemArc makeArc(Point point, float f, float f2, float f3, float f4, float f5, String str, String str2, boolean z) {
        return new LayoutItemArc(ATKCoreJNI.Layout_makeArc__SWIG_1(this.swigCPtr, this, Point.getCPtr(point), point, f, f2, f3, f4, f5, str.getBytes(), str2.getBytes(), z), true);
    }

    public LayoutItemArc makeArc(Point point, float f, float f2, float f3, float f4, float f5, String str, String str2) {
        return new LayoutItemArc(ATKCoreJNI.Layout_makeArc__SWIG_2(this.swigCPtr, this, Point.getCPtr(point), point, f, f2, f3, f4, f5, str.getBytes(), str2.getBytes()), true);
    }

    public LayoutItemArc makeArc(Point point, float f, float f2, float f3, float f4, float f5, String str) {
        return new LayoutItemArc(ATKCoreJNI.Layout_makeArc__SWIG_3(this.swigCPtr, this, Point.getCPtr(point), point, f, f2, f3, f4, f5, str.getBytes()), true);
    }

    public LayoutItemArc makeArc(CenterEllipticArc centerEllipticArc, String str, String str2, boolean z, boolean z2) {
        return new LayoutItemArc(ATKCoreJNI.Layout_makeArc__SWIG_4(this.swigCPtr, this, CenterEllipticArc.getCPtr(centerEllipticArc), centerEllipticArc, str.getBytes(), str2.getBytes(), z, z2), true);
    }

    public LayoutItemArc makeArc(CenterEllipticArc centerEllipticArc, String str, String str2, boolean z) {
        return new LayoutItemArc(ATKCoreJNI.Layout_makeArc__SWIG_5(this.swigCPtr, this, CenterEllipticArc.getCPtr(centerEllipticArc), centerEllipticArc, str.getBytes(), str2.getBytes(), z), true);
    }

    public LayoutItemArc makeArc(CenterEllipticArc centerEllipticArc, String str, String str2) {
        return new LayoutItemArc(ATKCoreJNI.Layout_makeArc__SWIG_6(this.swigCPtr, this, CenterEllipticArc.getCPtr(centerEllipticArc), centerEllipticArc, str.getBytes(), str2.getBytes()), true);
    }

    public LayoutItemArc makeArc(CenterEllipticArc centerEllipticArc, String str) {
        return new LayoutItemArc(ATKCoreJNI.Layout_makeArc__SWIG_7(this.swigCPtr, this, CenterEllipticArc.getCPtr(centerEllipticArc), centerEllipticArc, str.getBytes()), true);
    }

    public LayoutItemString makeString(Glyph glyph, String str, String str2) {
        return new LayoutItemString(ATKCoreJNI.Layout_makeString__SWIG_0(this.swigCPtr, this, Glyph.getCPtr(glyph), glyph, str.getBytes(), str2.getBytes()), true);
    }

    public LayoutItemString makeString(Glyph glyph, String str) {
        return new LayoutItemString(ATKCoreJNI.Layout_makeString__SWIG_1(this.swigCPtr, this, Glyph.getCPtr(glyph), glyph, str.getBytes()), true);
    }

    public LayoutItemGuide makeGuide(String str, GuideData guideData, String str2, String str3) {
        return new LayoutItemGuide(ATKCoreJNI.Layout_makeGuide__SWIG_0(this.swigCPtr, this, str.getBytes(), GuideData.getCPtr(guideData), guideData, str2.getBytes(), str3.getBytes()), true);
    }

    public LayoutItemGuide makeGuide(String str, GuideData guideData, String str2) {
        return new LayoutItemGuide(ATKCoreJNI.Layout_makeGuide__SWIG_1(this.swigCPtr, this, str.getBytes(), GuideData.getCPtr(guideData), guideData, str2.getBytes()), true);
    }

    public LayoutItemGuide makeGuide(String str, GuideData guideData, GuidePositioning guidePositioning, String str2, String str3) {
        return new LayoutItemGuide(ATKCoreJNI.Layout_makeGuide__SWIG_2(this.swigCPtr, this, str.getBytes(), GuideData.getCPtr(guideData), guideData, GuidePositioning.getCPtr(guidePositioning), guidePositioning, str2.getBytes(), str3.getBytes()), true);
    }

    public LayoutItemGuide makeGuide(String str, GuideData guideData, GuidePositioning guidePositioning, String str2) {
        return new LayoutItemGuide(ATKCoreJNI.Layout_makeGuide__SWIG_3(this.swigCPtr, this, str.getBytes(), GuideData.getCPtr(guideData), guideData, GuidePositioning.getCPtr(guidePositioning), guidePositioning, str2.getBytes()), true);
    }

    public Layout(Layout layout) {
        this(ATKCoreJNI.new_Layout__SWIG_1(getCPtr(layout), layout), true);
    }

    public LayerIterator getLayoutGroup(String str) {
        return new LayerIterator(ATKCoreJNI.Layout_getLayoutGroup(this.swigCPtr, this, str.getBytes()), true);
    }

    public Page getPage() {
        return new Page(ATKCoreJNI.Layout_getPage(this.swigCPtr, this), true);
    }

    public boolean valid() {
        return ATKCoreJNI.Layout_valid(this.swigCPtr, this);
    }
}
