package com.myscript.snt.core;

import com.myscript.atk.core.Box;
import com.myscript.atk.core.Content;
import com.myscript.atk.core.Extent;
import com.myscript.atk.core.Layout;
import com.myscript.atk.core.Selection;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class GridBox extends Box {
    private transient boolean swigCMemOwnDerived;
    private transient long swigCPtr;

    public GridBox(long j, boolean z) {
        super(NeboEngineJNI.GridBox_SWIGSmartPtrUpcast(j), true);
        this.swigCMemOwnDerived = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(GridBox gridBox) {
        if (gridBox == null) {
            return 0L;
        }
        return gridBox.swigCPtr;
    }

    @Override // com.myscript.atk.core.Box
    protected void finalize() {
        delete();
    }

    @Override // com.myscript.atk.core.Box
    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwnDerived) {
                this.swigCMemOwnDerived = false;
                NeboEngineJNI.delete_GridBox(j);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public String getType() {
        return new String(NeboEngineJNI.GridBox_getType(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    @Override // com.myscript.atk.core.Box
    /* JADX INFO: renamed from: id */
    public String mo1042id() {
        return new String(NeboEngineJNI.GridBox_id(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    @Override // com.myscript.atk.core.Box
    public void updateSelection() {
        NeboEngineJNI.GridBox_updateSelection(this.swigCPtr, this);
    }

    @Override // com.myscript.atk.core.Box
    public Layout layout() {
        return new Layout(NeboEngineJNI.GridBox_layout(this.swigCPtr, this), true);
    }

    @Override // com.myscript.atk.core.Box
    public Content content() {
        return new Content(NeboEngineJNI.GridBox_content(this.swigCPtr, this), true);
    }

    public SWIGTYPE_p_std__shared_ptrT_snt__GridBoxFactory_t boxFactory() {
        return new SWIGTYPE_p_std__shared_ptrT_snt__GridBoxFactory_t(NeboEngineJNI.GridBox_boxFactory(this.swigCPtr, this), true);
    }

    public int minNbLines(float f) {
        return NeboEngineJNI.GridBox_minNbLines(this.swigCPtr, this, f);
    }

    @Override // com.myscript.atk.core.Box
    public String toString() {
        return new String(NeboEngineJNI.GridBox_toString(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    @Override // com.myscript.atk.core.Box
    public Extent extent() {
        return new Extent(NeboEngineJNI.GridBox_extent(this.swigCPtr, this), true);
    }

    public Extent extentWithStrokes(LayoutGrid layoutGrid) {
        return new Extent(NeboEngineJNI.GridBox_extentWithStrokes__SWIG_0(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid), true);
    }

    public Extent extentWithStrokes(LayoutGrid layoutGrid, Selection selection) {
        return new Extent(NeboEngineJNI.GridBox_extentWithStrokes__SWIG_1(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid, Selection.getCPtr(selection), selection), true);
    }

    public boolean fitTo(Extent extent, LayoutGrid layoutGrid, SWIGTYPE_p_snt__ReflowSettings sWIGTYPE_p_snt__ReflowSettings) {
        return NeboEngineJNI.GridBox_fitTo(this.swigCPtr, this, Extent.getCPtr(extent), extent, LayoutGrid.getCPtr(layoutGrid), layoutGrid, SWIGTYPE_p_snt__ReflowSettings.getCPtr(sWIGTYPE_p_snt__ReflowSettings));
    }

    public SWIGTYPE_p_atk__core__ActiveBackend__TypesetSettings typesetSettings(SWIGTYPE_p_atk__core__ActiveBackend__TypesetRequest sWIGTYPE_p_atk__core__ActiveBackend__TypesetRequest) {
        return new SWIGTYPE_p_atk__core__ActiveBackend__TypesetSettings(NeboEngineJNI.GridBox_typesetSettings(this.swigCPtr, this, SWIGTYPE_p_atk__core__ActiveBackend__TypesetRequest.getCPtr(sWIGTYPE_p_atk__core__ActiveBackend__TypesetRequest)), true);
    }

    public void moveTo(LayoutGrid layoutGrid, float f, float f2) {
        NeboEngineJNI.GridBox_moveTo(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid, f, f2);
    }

    @Override // com.myscript.atk.core.Box
    public boolean isRoot() {
        return NeboEngineJNI.GridBox_isRoot(this.swigCPtr, this);
    }

    public boolean isDetached() {
        return NeboEngineJNI.GridBox_isDetached(this.swigCPtr, this);
    }

    @Override // com.myscript.atk.core.Box
    public Box parent() {
        long jGridBox_parent = NeboEngineJNI.GridBox_parent(this.swigCPtr, this);
        if (jGridBox_parent == 0) {
            return null;
        }
        return new Box(jGridBox_parent, true);
    }

    @Override // com.myscript.atk.core.Box
    public Box previousBrother() {
        long jGridBox_previousBrother = NeboEngineJNI.GridBox_previousBrother(this.swigCPtr, this);
        if (jGridBox_previousBrother == 0) {
            return null;
        }
        return new Box(jGridBox_previousBrother, true);
    }

    @Override // com.myscript.atk.core.Box
    public Box nextBrother() {
        long jGridBox_nextBrother = NeboEngineJNI.GridBox_nextBrother(this.swigCPtr, this);
        if (jGridBox_nextBrother == 0) {
            return null;
        }
        return new Box(jGridBox_nextBrother, true);
    }

    public float widthRatio() {
        return NeboEngineJNI.GridBox_widthRatio(this.swigCPtr, this);
    }

    public boolean isFullWidth() {
        return NeboEngineJNI.GridBox_isFullWidth(this.swigCPtr, this);
    }

    public float xRelativeRatio() {
        return NeboEngineJNI.GridBox_xRelativeRatio(this.swigCPtr, this);
    }

    public float yOffset() {
        return NeboEngineJNI.GridBox_yOffset(this.swigCPtr, this);
    }

    public String anchorId() {
        return new String(NeboEngineJNI.GridBox_anchorId(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public boolean isStack() {
        return NeboEngineJNI.GridBox_isStack(this.swigCPtr, this);
    }

    public int previousPositionInParent() {
        return NeboEngineJNI.GridBox_previousPositionInParent(this.swigCPtr, this);
    }

    public Extent previousExtent() {
        return new Extent(NeboEngineJNI.GridBox_previousExtent(this.swigCPtr, this), true);
    }

    public float previousParentXmin() {
        return NeboEngineJNI.GridBox_previousParentXmin(this.swigCPtr, this);
    }

    public Extent previousExtentPreviousBrother() {
        return new Extent(NeboEngineJNI.GridBox_previousExtentPreviousBrother(this.swigCPtr, this), true);
    }

    public String previousAnchorId() {
        return new String(NeboEngineJNI.GridBox_previousAnchorId(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public int widthColumn(LayoutGrid layoutGrid) {
        return NeboEngineJNI.GridBox_widthColumn(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid);
    }

    public int minWidthColumn(LayoutGrid layoutGrid) {
        return NeboEngineJNI.GridBox_minWidthColumn(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid);
    }

    public int xRelativeColumn(LayoutGrid layoutGrid) {
        return NeboEngineJNI.GridBox_xRelativeColumn(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid);
    }

    public void setWidthRatio(float f) {
        NeboEngineJNI.GridBox_setWidthRatio(this.swigCPtr, this, f);
    }

    public void setFullWidth(boolean z) {
        NeboEngineJNI.GridBox_setFullWidth(this.swigCPtr, this, z);
    }

    public void setXRelativeRatio(float f) {
        NeboEngineJNI.GridBox_setXRelativeRatio(this.swigCPtr, this, f);
    }

    public void setYOffset(float f) {
        NeboEngineJNI.GridBox_setYOffset(this.swigCPtr, this, f);
    }

    public void setAnchorId(String str) {
        NeboEngineJNI.GridBox_setAnchorId(this.swigCPtr, this, str.getBytes());
    }

    public void setPreviousPositionInParent(int i) {
        NeboEngineJNI.GridBox_setPreviousPositionInParent(this.swigCPtr, this, i);
    }

    public void setPreviousExtent(Extent extent) {
        NeboEngineJNI.GridBox_setPreviousExtent(this.swigCPtr, this, Extent.getCPtr(extent), extent);
    }

    public void setPreviousParentXmin(float f) {
        NeboEngineJNI.GridBox_setPreviousParentXmin(this.swigCPtr, this, f);
    }

    public void setPreviousExtentPreviousBrother(Extent extent) {
        NeboEngineJNI.GridBox_setPreviousExtentPreviousBrother(this.swigCPtr, this, Extent.getCPtr(extent), extent);
    }

    public void setPreviousAnchorId(String str) {
        NeboEngineJNI.GridBox_setPreviousAnchorId(this.swigCPtr, this, str.getBytes());
    }

    public boolean shouldReflow() {
        return NeboEngineJNI.GridBox_shouldReflow(this.swigCPtr, this);
    }

    public void setShouldReflow() {
        NeboEngineJNI.GridBox_setShouldReflow(this.swigCPtr, this);
    }

    public void resetShouldReflow() {
        NeboEngineJNI.GridBox_resetShouldReflow(this.swigCPtr, this);
    }

    @Override // com.myscript.atk.core.Box
    public boolean needCheckReco() {
        return NeboEngineJNI.GridBox_needCheckReco(this.swigCPtr, this);
    }

    public void updateExtent(LayoutGrid layoutGrid) {
        NeboEngineJNI.GridBox_updateExtent(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid);
    }

    @Override // com.myscript.atk.core.Box
    public boolean hasValidContent() {
        return NeboEngineJNI.GridBox_hasValidContent(this.swigCPtr, this);
    }

    public static boolean find(SWIGTYPE_p_std__vectorT_std__shared_ptrT_snt__TextBox_t_t sWIGTYPE_p_std__vectorT_std__shared_ptrT_snt__TextBox_t_t, GridBox gridBox) {
        return NeboEngineJNI.GridBox_find(SWIGTYPE_p_std__vectorT_std__shared_ptrT_snt__TextBox_t_t.getCPtr(sWIGTYPE_p_std__vectorT_std__shared_ptrT_snt__TextBox_t_t), getCPtr(gridBox), gridBox);
    }

    public static String getATTR_ID() {
        return new String(NeboEngineJNI.GridBox_ATTR_ID_get(), StandardCharsets.UTF_8);
    }

    public static String getATTR_TYPE() {
        return new String(NeboEngineJNI.GridBox_ATTR_TYPE_get(), StandardCharsets.UTF_8);
    }

    public static String getATTR_CONTENT_FIELD_ID() {
        return new String(NeboEngineJNI.GridBox_ATTR_CONTENT_FIELD_ID_get(), StandardCharsets.UTF_8);
    }

    public static String getATTR_SHOULD_REFLOW() {
        return new String(NeboEngineJNI.GridBox_ATTR_SHOULD_REFLOW_get(), StandardCharsets.UTF_8);
    }

    public static String getATTR_WIDTH_RATIO() {
        return new String(NeboEngineJNI.GridBox_ATTR_WIDTH_RATIO_get(), StandardCharsets.UTF_8);
    }

    public static String getATTR_FULL_WIDTH() {
        return new String(NeboEngineJNI.GridBox_ATTR_FULL_WIDTH_get(), StandardCharsets.UTF_8);
    }

    public static String getATTR_X_RELATIVE_RATIO() {
        return new String(NeboEngineJNI.GridBox_ATTR_X_RELATIVE_RATIO_get(), StandardCharsets.UTF_8);
    }

    public static String getATTR_Y_OFFSET() {
        return new String(NeboEngineJNI.GridBox_ATTR_Y_OFFSET_get(), StandardCharsets.UTF_8);
    }

    public SWIGTYPE_p_std__shared_ptrT_atk__core__ActiveBackend_t activeBackend() {
        return new SWIGTYPE_p_std__shared_ptrT_atk__core__ActiveBackend_t(NeboEngineJNI.GridBox_activeBackend(this.swigCPtr, this), true);
    }
}
