package com.myscript.snt.core;

import com.myscript.atk.core.Extent;
import com.myscript.atk.core.Selection;
import com.myscript.atk.core.Transform;
import com.myscript.snt.core.LayoutGrid;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class TextBox extends GridBox {
    private transient boolean swigCMemOwnDerived;
    private transient long swigCPtr;

    public TextBox(long j, boolean z) {
        super(NeboEngineJNI.TextBox_SWIGSmartPtrUpcast(j), true);
        this.swigCMemOwnDerived = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(TextBox textBox) {
        if (textBox == null) {
            return 0L;
        }
        return textBox.swigCPtr;
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
                NeboEngineJNI.delete_TextBox(j);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public static String getTYPE() {
        return new String(NeboEngineJNI.TextBox_TYPE_get(), StandardCharsets.UTF_8);
    }

    public String contentFieldId() {
        return new String(NeboEngineJNI.TextBox_contentFieldId(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String contentField() {
        return NeboEngineJNI.TextBox_contentField(this.swigCPtr, this);
    }

    @Override // com.myscript.snt.core.GridBox
    public boolean fitTo(Extent extent, LayoutGrid layoutGrid, SWIGTYPE_p_snt__ReflowSettings sWIGTYPE_p_snt__ReflowSettings) {
        return NeboEngineJNI.TextBox_fitTo(this.swigCPtr, this, Extent.getCPtr(extent), extent, LayoutGrid.getCPtr(layoutGrid), layoutGrid, SWIGTYPE_p_snt__ReflowSettings.getCPtr(sWIGTYPE_p_snt__ReflowSettings));
    }

    @Override // com.myscript.snt.core.GridBox
    public SWIGTYPE_p_atk__core__ActiveBackend__TypesetSettings typesetSettings(SWIGTYPE_p_atk__core__ActiveBackend__TypesetRequest sWIGTYPE_p_atk__core__ActiveBackend__TypesetRequest) {
        return new SWIGTYPE_p_atk__core__ActiveBackend__TypesetSettings(NeboEngineJNI.TextBox_typesetSettings(this.swigCPtr, this, SWIGTYPE_p_atk__core__ActiveBackend__TypesetRequest.getCPtr(sWIGTYPE_p_atk__core__ActiveBackend__TypesetRequest)), true);
    }

    @Override // com.myscript.snt.core.GridBox, com.myscript.atk.core.Box
    public void updateSelection() {
        NeboEngineJNI.TextBox_updateSelection(this.swigCPtr, this);
    }

    @Override // com.myscript.snt.core.GridBox
    public void updateExtent(LayoutGrid layoutGrid) {
        NeboEngineJNI.TextBox_updateExtent__SWIG_0(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid);
    }

    public void transform(Transform transform, LayoutGrid.StyleProperties styleProperties, boolean z, float f) {
        NeboEngineJNI.TextBox_transform(this.swigCPtr, this, Transform.getCPtr(transform), transform, LayoutGrid.StyleProperties.getCPtr(styleProperties), styleProperties, z, f);
    }

    public void updateExtent(LayoutGrid layoutGrid, float f, float f2) {
        NeboEngineJNI.TextBox_updateExtent__SWIG_1(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid, f, f2);
    }

    public Extent computeExtent(LayoutGrid layoutGrid) {
        return new Extent(NeboEngineJNI.TextBox_computeExtent__SWIG_0(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid), true);
    }

    public Extent computeExtent(LayoutGrid layoutGrid, Selection selection) {
        return new Extent(NeboEngineJNI.TextBox_computeExtent__SWIG_1(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid, Selection.getCPtr(selection), selection), true);
    }

    public void process() {
        NeboEngineJNI.TextBox_process(this.swigCPtr, this);
    }

    public boolean isProcessPending() {
        return NeboEngineJNI.TextBox_isProcessPending(this.swigCPtr, this);
    }

    public boolean isProcessRequired() {
        return NeboEngineJNI.TextBox_isProcessRequired(this.swigCPtr, this);
    }

    public boolean isProcessPendingOrRequired() {
        return NeboEngineJNI.TextBox_isProcessPendingOrRequired(this.swigCPtr, this);
    }

    @Override // com.myscript.snt.core.GridBox
    public int minWidthColumn(LayoutGrid layoutGrid) {
        return NeboEngineJNI.TextBox_minWidthColumn(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid);
    }

    @Override // com.myscript.atk.core.Box
    public Selection selection() {
        return new Selection(NeboEngineJNI.TextBox_selection(this.swigCPtr, this), true);
    }

    @Override // com.myscript.snt.core.GridBox
    public String getType() {
        return new String(NeboEngineJNI.TextBox_getType(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    @Override // com.myscript.snt.core.GridBox
    public Extent extentWithStrokes(LayoutGrid layoutGrid) {
        return new Extent(NeboEngineJNI.TextBox_extentWithStrokes__SWIG_0(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid), true);
    }

    @Override // com.myscript.snt.core.GridBox
    public Extent extentWithStrokes(LayoutGrid layoutGrid, Selection selection) {
        return new Extent(NeboEngineJNI.TextBox_extentWithStrokes__SWIG_1(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid, Selection.getCPtr(selection), selection), true);
    }

    @Override // com.myscript.atk.core.Box
    public void move(float f, float f2) {
        NeboEngineJNI.TextBox_move(this.swigCPtr, this, f, f2);
    }

    @Override // com.myscript.atk.core.Box
    public void remove() {
        NeboEngineJNI.TextBox_remove(this.swigCPtr, this);
    }

    @Override // com.myscript.snt.core.GridBox, com.myscript.atk.core.Box
    public boolean hasValidContent() {
        return NeboEngineJNI.TextBox_hasValidContent(this.swigCPtr, this);
    }

    @Override // com.myscript.atk.core.Box
    public boolean empty() {
        return NeboEngineJNI.TextBox_empty(this.swigCPtr, this);
    }

    public void setTextBoxType(SWIGTYPE_p_atk__text__TextBoxType sWIGTYPE_p_atk__text__TextBoxType) {
        NeboEngineJNI.TextBox_setTextBoxType(this.swigCPtr, this, SWIGTYPE_p_atk__text__TextBoxType.getCPtr(sWIGTYPE_p_atk__text__TextBoxType));
    }

    public SWIGTYPE_p_atk__text__TextBoxType textBoxType() {
        return new SWIGTYPE_p_atk__text__TextBoxType(NeboEngineJNI.TextBox_textBoxType(this.swigCPtr, this), true);
    }

    public void setTextBoxStyle(SWIGTYPE_p_atk__text__TextBoxStyle sWIGTYPE_p_atk__text__TextBoxStyle) {
        NeboEngineJNI.TextBox_setTextBoxStyle(this.swigCPtr, this, SWIGTYPE_p_atk__text__TextBoxStyle.getCPtr(sWIGTYPE_p_atk__text__TextBoxStyle));
    }

    public SWIGTYPE_p_atk__text__TextBoxStyle textBoxStyle() {
        return new SWIGTYPE_p_atk__text__TextBoxStyle(NeboEngineJNI.TextBox_textBoxStyle(this.swigCPtr, this), true);
    }

    public SWIGTYPE_p_atk__text__TextBoxStyle textBoxTag(LayoutGrid layoutGrid) {
        return new SWIGTYPE_p_atk__text__TextBoxStyle(NeboEngineJNI.TextBox_textBoxTag(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid), true);
    }

    public static int textBoxStyleType(TextBox textBox) {
        return NeboEngineJNI.TextBox_textBoxStyleType(getCPtr(textBox), textBox);
    }

    public static int textBoxTagType(LayoutGrid layoutGrid, TextBox textBox) {
        return NeboEngineJNI.TextBox_textBoxTagType(LayoutGrid.getCPtr(layoutGrid), layoutGrid, getCPtr(textBox), textBox);
    }

    public void setTextAlignment(SWIGTYPE_p_atk__text__TextAlignment sWIGTYPE_p_atk__text__TextAlignment) {
        NeboEngineJNI.TextBox_setTextAlignment(this.swigCPtr, this, SWIGTYPE_p_atk__text__TextAlignment.getCPtr(sWIGTYPE_p_atk__text__TextAlignment));
    }

    public SWIGTYPE_p_atk__text__TextAlignment textAlignment() {
        return new SWIGTYPE_p_atk__text__TextAlignment(NeboEngineJNI.TextBox_textAlignment(this.swigCPtr, this), true);
    }

    public float lineGap(LayoutGrid layoutGrid) {
        return NeboEngineJNI.TextBox_lineGap(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid);
    }

    public float fontSize(LayoutGrid layoutGrid) {
        return NeboEngineJNI.TextBox_fontSize(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid);
    }

    public SWIGTYPE_p_atk__text__TextBoxReflowContext reflowContext() {
        return new SWIGTYPE_p_atk__text__TextBoxReflowContext(NeboEngineJNI.TextBox_reflowContext(this.swigCPtr, this), true);
    }

    public void setShouldReflow(int i, int i2) {
        NeboEngineJNI.TextBox_setShouldReflow__SWIG_0(this.swigCPtr, this, i, i2);
    }

    public void setShouldReflow(int i) {
        NeboEngineJNI.TextBox_setShouldReflow__SWIG_1(this.swigCPtr, this, i);
    }

    @Override // com.myscript.snt.core.GridBox
    public void setShouldReflow() {
        NeboEngineJNI.TextBox_setShouldReflow__SWIG_2(this.swigCPtr, this);
    }

    public void setFontDescender(float f) {
        NeboEngineJNI.TextBox_setFontDescender(this.swigCPtr, this, f);
    }

    public float fontDescender() {
        return NeboEngineJNI.TextBox_fontDescender(this.swigCPtr, this);
    }

    public float firstLine() {
        return NeboEngineJNI.TextBox_firstLine(this.swigCPtr, this);
    }

    public float lastLine() {
        return NeboEngineJNI.TextBox_lastLine(this.swigCPtr, this);
    }

    @Override // com.myscript.snt.core.GridBox, com.myscript.atk.core.Box
    public String toString() {
        return new String(NeboEngineJNI.TextBox_toString(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public boolean check(LayoutGrid layoutGrid) {
        return NeboEngineJNI.TextBox_check(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid);
    }

    public static SWIGTYPE_p_std__pairT_float_float_t computePaddingTopBottom(LayoutGrid layoutGrid, float f, int i) {
        return new SWIGTYPE_p_std__pairT_float_float_t(NeboEngineJNI.TextBox_computePaddingTopBottom(LayoutGrid.getCPtr(layoutGrid), layoutGrid, f, i), true);
    }

    public int removeEmptyLines(LayoutGrid layoutGrid) {
        return NeboEngineJNI.TextBox_removeEmptyLines(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid);
    }

    public void updateTextStructureIndentations(LayoutGrid layoutGrid, boolean z) {
        NeboEngineJNI.TextBox_updateTextStructureIndentations(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid, z);
    }

    public String getLabel() {
        return new String(NeboEngineJNI.TextBox_getLabel__SWIG_0(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public static String getATTR_TEXTBOX_TYPE() {
        return new String(NeboEngineJNI.TextBox_ATTR_TEXTBOX_TYPE_get(), StandardCharsets.UTF_8);
    }

    public static String getATTR_TEXTBOX_STYLE() {
        return new String(NeboEngineJNI.TextBox_ATTR_TEXTBOX_STYLE_get(), StandardCharsets.UTF_8);
    }

    public static String getATTR_SHOULD_REFLOW_PIVOT() {
        return new String(NeboEngineJNI.TextBox_ATTR_SHOULD_REFLOW_PIVOT_get(), StandardCharsets.UTF_8);
    }

    public static String getATTR_SHOULD_REFLOW_PIVOT_STOP() {
        return new String(NeboEngineJNI.TextBox_ATTR_SHOULD_REFLOW_PIVOT_STOP_get(), StandardCharsets.UTF_8);
    }

    public static String getATTR_TEXT_ALIGNMENT() {
        return new String(NeboEngineJNI.TextBox_ATTR_TEXT_ALIGNMENT_get(), StandardCharsets.UTF_8);
    }

    public static String getATTR_TEXTBOX_USECACHE() {
        return new String(NeboEngineJNI.TextBox_ATTR_TEXTBOX_USECACHE_get(), StandardCharsets.UTF_8);
    }

    public static String getATTR_LIST_LINE_FROM() {
        return new String(NeboEngineJNI.TextBox_ATTR_LIST_LINE_FROM_get(), StandardCharsets.UTF_8);
    }

    public static String getATTR_LIST_LINE_TO() {
        return new String(NeboEngineJNI.TextBox_ATTR_LIST_LINE_TO_get(), StandardCharsets.UTF_8);
    }

    public static TextBox asTextBox2(GridBox gridBox) {
        long jTextBox_asTextBox2 = NeboEngineJNI.TextBox_asTextBox2(GridBox.getCPtr(gridBox), gridBox);
        if (jTextBox_asTextBox2 == 0) {
            return null;
        }
        return new TextBox(jTextBox_asTextBox2, true);
    }
}
