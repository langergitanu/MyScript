package com.myscript.snt.core;

import com.myscript.atk.core.ActiveArea;
import com.myscript.atk.core.Extent;
import com.myscript.atk.core.LayoutGroup;
import com.myscript.atk.core.Point;
import com.myscript.atk.core.Rectangle;
import com.myscript.atk.core.Selection;
import com.myscript.atk.core.Transform;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class CompositeBox extends GridBox {
    private transient boolean swigCMemOwnDerived;
    private transient long swigCPtr;

    public CompositeBox(long j, boolean z) {
        super(NeboEngineJNI.CompositeBox_SWIGSmartPtrUpcast(j), true);
        this.swigCMemOwnDerived = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(CompositeBox compositeBox) {
        if (compositeBox == null) {
            return 0L;
        }
        return compositeBox.swigCPtr;
    }

    @Override // com.myscript.snt.core.GridBox, com.myscript.atk.core.Box
    protected void finalize() {
        delete();
    }

    @Override // com.myscript.snt.core.GridBox, com.myscript.atk.core.Box
    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwnDerived) {
                this.swigCMemOwnDerived = false;
                NeboEngineJNI.delete_CompositeBox(j);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public static String getActiveIDfromFieldName(String str) {
        return new String(NeboEngineJNI.CompositeBox_getActiveIDfromFieldName(str.getBytes()), StandardCharsets.UTF_8);
    }

    public static String getTYPE() {
        return new String(NeboEngineJNI.CompositeBox_TYPE_get(), StandardCharsets.UTF_8);
    }

    public String subtype() {
        return new String(NeboEngineJNI.CompositeBox_subtype(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    @Override // com.myscript.snt.core.GridBox
    public String getType() {
        return new String(NeboEngineJNI.CompositeBox_getType(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    @Override // com.myscript.atk.core.Box
    public boolean empty() {
        return NeboEngineJNI.CompositeBox_empty(this.swigCPtr, this);
    }

    @Override // com.myscript.atk.core.Box
    public Selection selection() {
        return new Selection(NeboEngineJNI.CompositeBox_selection__SWIG_0(this.swigCPtr, this), true);
    }

    public Selection selection(SWIGTYPE_p_atk__core__ActiveBackend__SelectionNature sWIGTYPE_p_atk__core__ActiveBackend__SelectionNature) {
        return new Selection(NeboEngineJNI.CompositeBox_selection__SWIG_1(this.swigCPtr, this, SWIGTYPE_p_atk__core__ActiveBackend__SelectionNature.getCPtr(sWIGTYPE_p_atk__core__ActiveBackend__SelectionNature)), true);
    }

    @Override // com.myscript.snt.core.GridBox, com.myscript.atk.core.Box
    public Extent extent() {
        return new Extent(NeboEngineJNI.CompositeBox_extent(this.swigCPtr, this), true);
    }

    @Override // com.myscript.snt.core.GridBox
    public int minNbLines(float f) {
        return NeboEngineJNI.CompositeBox_minNbLines(this.swigCPtr, this, f);
    }

    @Override // com.myscript.snt.core.GridBox
    public boolean fitTo(Extent extent, LayoutGrid layoutGrid, SWIGTYPE_p_snt__ReflowSettings sWIGTYPE_p_snt__ReflowSettings) {
        return NeboEngineJNI.CompositeBox_fitTo(this.swigCPtr, this, Extent.getCPtr(extent), extent, LayoutGrid.getCPtr(layoutGrid), layoutGrid, SWIGTYPE_p_snt__ReflowSettings.getCPtr(sWIGTYPE_p_snt__ReflowSettings));
    }

    public boolean needsTypeset() {
        return NeboEngineJNI.CompositeBox_needsTypeset(this.swigCPtr, this);
    }

    public boolean needsRefit(LayoutGrid layoutGrid) {
        return NeboEngineJNI.CompositeBox_needsRefit(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid);
    }

    @Override // com.myscript.snt.core.GridBox
    public SWIGTYPE_p_atk__core__ActiveBackend__TypesetSettings typesetSettings(SWIGTYPE_p_atk__core__ActiveBackend__TypesetRequest sWIGTYPE_p_atk__core__ActiveBackend__TypesetRequest) {
        return new SWIGTYPE_p_atk__core__ActiveBackend__TypesetSettings(NeboEngineJNI.CompositeBox_typesetSettings(this.swigCPtr, this, SWIGTYPE_p_atk__core__ActiveBackend__TypesetRequest.getCPtr(sWIGTYPE_p_atk__core__ActiveBackend__TypesetRequest)), true);
    }

    public void typeset(SWIGTYPE_p_atk__core__ActiveBackend__TypesetSettings sWIGTYPE_p_atk__core__ActiveBackend__TypesetSettings) {
        NeboEngineJNI.CompositeBox_typeset(this.swigCPtr, this, SWIGTYPE_p_atk__core__ActiveBackend__TypesetSettings.getCPtr(sWIGTYPE_p_atk__core__ActiveBackend__TypesetSettings));
    }

    @Override // com.myscript.atk.core.Box
    public void move(float f, float f2) {
        NeboEngineJNI.CompositeBox_move(this.swigCPtr, this, f, f2);
    }

    @Override // com.myscript.atk.core.Box
    public void remove() {
        NeboEngineJNI.CompositeBox_remove(this.swigCPtr, this);
    }

    @Override // com.myscript.snt.core.GridBox, com.myscript.atk.core.Box
    public boolean hasValidContent() {
        return NeboEngineJNI.CompositeBox_hasValidContent(this.swigCPtr, this);
    }

    public void transform(Transform transform, float f, float f2, float f3) {
        NeboEngineJNI.CompositeBox_transform(this.swigCPtr, this, Transform.getCPtr(transform), transform, f, f2, f3);
    }

    public String importObjectAt(LayoutGrid layoutGrid, String str, String str2, String str3, Point point, float f, Extent extent, boolean z, boolean z2) {
        return new String(NeboEngineJNI.CompositeBox_importObjectAt__SWIG_0(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid, str.getBytes(), str2.getBytes(), str3.getBytes(), Point.getCPtr(point), point, f, Extent.getCPtr(extent), extent, z, z2), StandardCharsets.UTF_8);
    }

    public String importObjectAt(LayoutGrid layoutGrid, String str, String str2, String str3, Point point, float f, Extent extent, boolean z) {
        return new String(NeboEngineJNI.CompositeBox_importObjectAt__SWIG_1(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid, str.getBytes(), str2.getBytes(), str3.getBytes(), Point.getCPtr(point), point, f, Extent.getCPtr(extent), extent, z), StandardCharsets.UTF_8);
    }

    public String importObjectAt(LayoutGrid layoutGrid, String str, String str2, String str3, Point point, float f, Extent extent) {
        return new String(NeboEngineJNI.CompositeBox_importObjectAt__SWIG_2(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid, str.getBytes(), str2.getBytes(), str3.getBytes(), Point.getCPtr(point), point, f, Extent.getCPtr(extent), extent), StandardCharsets.UTF_8);
    }

    public String importObjectAt(LayoutGrid layoutGrid, String str, String str2, String str3, Point point, float f) {
        return new String(NeboEngineJNI.CompositeBox_importObjectAt__SWIG_3(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid, str.getBytes(), str2.getBytes(), str3.getBytes(), Point.getCPtr(point), point, f), StandardCharsets.UTF_8);
    }

    public String importObjectAt(LayoutGrid layoutGrid, String str, String str2, String str3, Point point) {
        return new String(NeboEngineJNI.CompositeBox_importObjectAt__SWIG_4(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid, str.getBytes(), str2.getBytes(), str3.getBytes(), Point.getCPtr(point), point), StandardCharsets.UTF_8);
    }

    public String importObjectAt(LayoutGrid layoutGrid, String str, String str2, String str3) {
        return new String(NeboEngineJNI.CompositeBox_importObjectAt__SWIG_5(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid, str.getBytes(), str2.getBytes(), str3.getBytes()), StandardCharsets.UTF_8);
    }

    public String importObjectToExtent(LayoutGrid layoutGrid, String str, String str2, String str3, Extent extent, float f, boolean z, boolean z2) {
        return new String(NeboEngineJNI.CompositeBox_importObjectToExtent__SWIG_0(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid, str.getBytes(), str2.getBytes(), str3.getBytes(), Extent.getCPtr(extent), extent, f, z, z2), StandardCharsets.UTF_8);
    }

    public String importObjectToExtent(LayoutGrid layoutGrid, String str, String str2, String str3, Extent extent, float f, boolean z) {
        return new String(NeboEngineJNI.CompositeBox_importObjectToExtent__SWIG_1(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid, str.getBytes(), str2.getBytes(), str3.getBytes(), Extent.getCPtr(extent), extent, f, z), StandardCharsets.UTF_8);
    }

    public String importObjectToExtent(LayoutGrid layoutGrid, String str, String str2, String str3, Extent extent, float f) {
        return new String(NeboEngineJNI.CompositeBox_importObjectToExtent__SWIG_2(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid, str.getBytes(), str2.getBytes(), str3.getBytes(), Extent.getCPtr(extent), extent, f), StandardCharsets.UTF_8);
    }

    public String importObjectToExtent(LayoutGrid layoutGrid, String str, String str2, String str3, Extent extent) {
        return new String(NeboEngineJNI.CompositeBox_importObjectToExtent__SWIG_3(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid, str.getBytes(), str2.getBytes(), str3.getBytes(), Extent.getCPtr(extent), extent), StandardCharsets.UTF_8);
    }

    public Selection importBackgroundObject(LayoutGrid layoutGrid, String str, String str2, String str3, Rectangle.FitOption fitOption) {
        return new Selection(NeboEngineJNI.CompositeBox_importBackgroundObject__SWIG_0(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid, str.getBytes(), str2.getBytes(), str3.getBytes(), fitOption.swigValue()), true);
    }

    public Selection importBackgroundObject(LayoutGrid layoutGrid, String str, String str2, String str3) {
        return new Selection(NeboEngineJNI.CompositeBox_importBackgroundObject__SWIG_1(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid, str.getBytes(), str2.getBytes(), str3.getBytes()), true);
    }

    public Selection backgroundObject() {
        return new Selection(NeboEngineJNI.CompositeBox_backgroundObject(this.swigCPtr, this), true);
    }

    public String replaceSelectedObject(LayoutGrid layoutGrid, String str, String str2) {
        return new String(NeboEngineJNI.CompositeBox_replaceSelectedObject(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid, str.getBytes(), str2.getBytes()), StandardCharsets.UTF_8);
    }

    public ActiveArea activeArea() {
        return new ActiveArea(NeboEngineJNI.CompositeBox_activeArea(this.swigCPtr, this), true);
    }

    public static boolean removeBorderObject(SWIGTYPE_p_std__shared_ptrT_snt__GridBoxFactory_t sWIGTYPE_p_std__shared_ptrT_snt__GridBoxFactory_t, LayoutGroup layoutGroup) {
        return NeboEngineJNI.CompositeBox_removeBorderObject(SWIGTYPE_p_std__shared_ptrT_snt__GridBoxFactory_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_snt__GridBoxFactory_t), LayoutGroup.getCPtr(layoutGroup), layoutGroup);
    }

    public void createBorderObject() {
        NeboEngineJNI.CompositeBox_createBorderObject(this.swigCPtr, this);
    }

    public Extent getBorderExtent() {
        return new Extent(NeboEngineJNI.CompositeBox_getBorderExtent(this.swigCPtr, this), true);
    }

    public Selection getBorderSelection() {
        return new Selection(NeboEngineJNI.CompositeBox_getBorderSelection(this.swigCPtr, this), true);
    }

    public float padding() {
        return NeboEngineJNI.CompositeBox_padding(this.swigCPtr, this);
    }

    @Override // com.myscript.snt.core.GridBox
    public SWIGTYPE_p_std__shared_ptrT_atk__core__ActiveBackend_t activeBackend() {
        return new SWIGTYPE_p_std__shared_ptrT_atk__core__ActiveBackend_t(NeboEngineJNI.CompositeBox_activeBackend(this.swigCPtr, this), true);
    }

    public void setBackend(SWIGTYPE_p_std__shared_ptrT_atk__core__ActiveBackend_t sWIGTYPE_p_std__shared_ptrT_atk__core__ActiveBackend_t) {
        NeboEngineJNI.CompositeBox_setBackend(this.swigCPtr, this, SWIGTYPE_p_std__shared_ptrT_atk__core__ActiveBackend_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_atk__core__ActiveBackend_t));
    }

    public static String getATTR_SUBTYPE() {
        return new String(NeboEngineJNI.CompositeBox_ATTR_SUBTYPE_get(), StandardCharsets.UTF_8);
    }

    public static String getATTR_PADDING() {
        return new String(NeboEngineJNI.CompositeBox_ATTR_PADDING_get(), StandardCharsets.UTF_8);
    }
}
