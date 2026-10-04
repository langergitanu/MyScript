package com.myscript.snt.core;

import com.myscript.atk.core.Extent;
import com.myscript.atk.core.Selection;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class DivisionBox extends GridBox {
    private transient boolean swigCMemOwnDerived;
    private transient long swigCPtr;

    public DivisionBox(long j, boolean z) {
        super(NeboEngineJNI.DivisionBox_SWIGSmartPtrUpcast(j), true);
        this.swigCMemOwnDerived = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(DivisionBox divisionBox) {
        if (divisionBox == null) {
            return 0L;
        }
        return divisionBox.swigCPtr;
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
                NeboEngineJNI.delete_DivisionBox(j);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public static String getTYPE() {
        return new String(NeboEngineJNI.DivisionBox_TYPE_get(), StandardCharsets.UTF_8);
    }

    public static String getATTR_VERTICAL() {
        return new String(NeboEngineJNI.DivisionBox_ATTR_VERTICAL_get(), StandardCharsets.UTF_8);
    }

    public static boolean getVERTICAL() {
        return NeboEngineJNI.DivisionBox_VERTICAL_get();
    }

    public static boolean getHORIZONTAL() {
        return NeboEngineJNI.DivisionBox_HORIZONTAL_get();
    }

    @Override // com.myscript.snt.core.GridBox
    public String getType() {
        return new String(NeboEngineJNI.DivisionBox_getType(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    @Override // com.myscript.snt.core.GridBox
    public boolean fitTo(Extent extent, LayoutGrid layoutGrid, SWIGTYPE_p_snt__ReflowSettings sWIGTYPE_p_snt__ReflowSettings) {
        return NeboEngineJNI.DivisionBox_fitTo(this.swigCPtr, this, Extent.getCPtr(extent), extent, LayoutGrid.getCPtr(layoutGrid), layoutGrid, SWIGTYPE_p_snt__ReflowSettings.getCPtr(sWIGTYPE_p_snt__ReflowSettings));
    }

    @Override // com.myscript.atk.core.Box
    public Selection selection() {
        return new Selection(NeboEngineJNI.DivisionBox_selection(this.swigCPtr, this), true);
    }

    @Override // com.myscript.snt.core.GridBox, com.myscript.atk.core.Box
    public String toString() {
        return new String(NeboEngineJNI.DivisionBox_toString(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    @Override // com.myscript.snt.core.GridBox, com.myscript.atk.core.Box
    public Extent extent() {
        return new Extent(NeboEngineJNI.DivisionBox_extent(this.swigCPtr, this), true);
    }

    @Override // com.myscript.atk.core.Box
    public void move(float f, float f2) {
        NeboEngineJNI.DivisionBox_move(this.swigCPtr, this, f, f2);
    }

    @Override // com.myscript.atk.core.Box
    public void remove() {
        NeboEngineJNI.DivisionBox_remove(this.swigCPtr, this);
    }

    @Override // com.myscript.snt.core.GridBox, com.myscript.atk.core.Box
    public boolean hasValidContent() {
        return NeboEngineJNI.DivisionBox_hasValidContent(this.swigCPtr, this);
    }

    public int childCount() {
        return NeboEngineJNI.DivisionBox_childCount(this.swigCPtr, this);
    }

    public GridBox childAt(int i) {
        long jDivisionBox_childAt = NeboEngineJNI.DivisionBox_childAt(this.swigCPtr, this, i);
        if (jDivisionBox_childAt == 0) {
            return null;
        }
        String type = new GridBox(jDivisionBox_childAt, false).getType();
        if ("TextBox".equals(type)) {
            return new TextBox(jDivisionBox_childAt, false);
        }
        if ("DivisionBox".equals(type)) {
            return new DivisionBox(jDivisionBox_childAt, false);
        }
        if ("CompositeBox".equals(type)) {
            return new CompositeBox(jDivisionBox_childAt, false);
        }
        return new GridBox(jDivisionBox_childAt, false);
    }

    public boolean isVertical() {
        return NeboEngineJNI.DivisionBox_isVertical(this.swigCPtr, this);
    }

    public boolean isHorizontal() {
        return NeboEngineJNI.DivisionBox_isHorizontal(this.swigCPtr, this);
    }

    @Override // com.myscript.atk.core.Box
    public boolean empty() {
        return NeboEngineJNI.DivisionBox_empty(this.swigCPtr, this);
    }
}
