package com.myscript.snt.core;

import com.myscript.atk.core.ITypesetListener;
import com.myscript.atk.core.ViewTransform;
import com.myscript.snt.core.LayoutGrid;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class StyleUtils {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public StyleUtils(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(StyleUtils styleUtils) {
        if (styleUtils == null) {
            return 0L;
        }
        return styleUtils.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_StyleUtils(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public static int getTYPE_HANDWRITING() {
        return NeboEngineJNI.StyleUtils_TYPE_HANDWRITING_get();
    }

    public static int getTYPE_TYPESET_SMALL() {
        return NeboEngineJNI.StyleUtils_TYPE_TYPESET_SMALL_get();
    }

    public static int getTYPE_TYPESET_BIG() {
        return NeboEngineJNI.StyleUtils_TYPE_TYPESET_BIG_get();
    }

    public static int getTYPE_TYPESET_H1() {
        return NeboEngineJNI.StyleUtils_TYPE_TYPESET_H1_get();
    }

    public static int getTYPE_TYPESET_H2() {
        return NeboEngineJNI.StyleUtils_TYPE_TYPESET_H2_get();
    }

    public static int getTYPE_TYPESET_H3() {
        return NeboEngineJNI.StyleUtils_TYPE_TYPESET_H3_get();
    }

    public static int getTYPE_2D() {
        return NeboEngineJNI.StyleUtils_TYPE_2D_get();
    }

    public static int getPROPERTY_FONTSIZE() {
        return NeboEngineJNI.StyleUtils_PROPERTY_FONTSIZE_get();
    }

    public static int getPROPERTY_LINEGAP() {
        return NeboEngineJNI.StyleUtils_PROPERTY_LINEGAP_get();
    }

    public static int getPROPERTY_PADDING_TOP() {
        return NeboEngineJNI.StyleUtils_PROPERTY_PADDING_TOP_get();
    }

    public static int getPROPERTY_PADDING_BOTTOM() {
        return NeboEngineJNI.StyleUtils_PROPERTY_PADDING_BOTTOM_get();
    }

    public static int getPROPERTY_MASKING_TOP() {
        return NeboEngineJNI.StyleUtils_PROPERTY_MASKING_TOP_get();
    }

    public static int getPROPERTY_MASKING_BOTTOM() {
        return NeboEngineJNI.StyleUtils_PROPERTY_MASKING_BOTTOM_get();
    }

    public static String getGUIDE_STYLE_NAME() {
        return new String(NeboEngineJNI.StyleUtils_GUIDE_STYLE_NAME_get(), StandardCharsets.UTF_8);
    }

    public static String getGUIDE_DASH_STYLE_NAME() {
        return new String(NeboEngineJNI.StyleUtils_GUIDE_DASH_STYLE_NAME_get(), StandardCharsets.UTF_8);
    }

    public static String getGUIDE_COLOR() {
        return new String(NeboEngineJNI.StyleUtils_GUIDE_COLOR_get(), StandardCharsets.UTF_8);
    }

    public static String getGUIDE_COLOR_DARK() {
        return new String(NeboEngineJNI.StyleUtils_GUIDE_COLOR_DARK_get(), StandardCharsets.UTF_8);
    }

    public static String getTRANSPARENT_INK_STYLE_NAME() {
        return new String(NeboEngineJNI.StyleUtils_TRANSPARENT_INK_STYLE_NAME_get(), StandardCharsets.UTF_8);
    }

    public static String getINK_RUBBER_STYLE_NAME() {
        return new String(NeboEngineJNI.StyleUtils_INK_RUBBER_STYLE_NAME_get(), StandardCharsets.UTF_8);
    }

    public static String getERASER_PEN_STYLE_NAME() {
        return new String(NeboEngineJNI.StyleUtils_ERASER_PEN_STYLE_NAME_get(), StandardCharsets.UTF_8);
    }

    public static String getBIG_TYPESET_STYLE_NAME() {
        return new String(NeboEngineJNI.StyleUtils_BIG_TYPESET_STYLE_NAME_get(), StandardCharsets.UTF_8);
    }

    public static String getSMALL_TYPESET_STYLE_NAME() {
        return new String(NeboEngineJNI.StyleUtils_SMALL_TYPESET_STYLE_NAME_get(), StandardCharsets.UTF_8);
    }

    public static String getBRUSH_STYLE_NAME() {
        return new String(NeboEngineJNI.StyleUtils_BRUSH_STYLE_NAME_get(), StandardCharsets.UTF_8);
    }

    public static String getBRUSH_ORIENTED_STYLE_NAME() {
        return new String(NeboEngineJNI.StyleUtils_BRUSH_ORIENTED_STYLE_NAME_get(), StandardCharsets.UTF_8);
    }

    public static String getSPACE_MANAGEMENT_STYLE_LINE() {
        return new String(NeboEngineJNI.StyleUtils_SPACE_MANAGEMENT_STYLE_LINE_get(), StandardCharsets.UTF_8);
    }

    public static String getSEARCH_STYLE_ACTIVE() {
        return new String(NeboEngineJNI.StyleUtils_SEARCH_STYLE_ACTIVE_get(), StandardCharsets.UTF_8);
    }

    public static String getSEARCH_STYLE_INACTIVE() {
        return new String(NeboEngineJNI.StyleUtils_SEARCH_STYLE_INACTIVE_get(), StandardCharsets.UTF_8);
    }

    public static String defaultStyle(LayoutGrid.StyleProperties styleProperties, boolean z) {
        return new String(NeboEngineJNI.StyleUtils_defaultStyle__SWIG_0(LayoutGrid.StyleProperties.getCPtr(styleProperties), styleProperties, z), StandardCharsets.UTF_8);
    }

    public static String defaultStyle(LayoutGrid.StyleProperties styleProperties) {
        return new String(NeboEngineJNI.StyleUtils_defaultStyle__SWIG_1(LayoutGrid.StyleProperties.getCPtr(styleProperties), styleProperties), StandardCharsets.UTF_8);
    }

    public static String fontName() {
        return new String(NeboEngineJNI.StyleUtils_fontName(), StandardCharsets.UTF_8);
    }

    public static float getValue(int i, int i2, LayoutGrid.StyleProperties styleProperties) {
        return NeboEngineJNI.StyleUtils_getValue(i, i2, LayoutGrid.StyleProperties.getCPtr(styleProperties), styleProperties);
    }

    public static String getOverallStyleName(int i) {
        return new String(NeboEngineJNI.StyleUtils_getOverallStyleName(i), StandardCharsets.UTF_8);
    }

    public static int type(SWIGTYPE_p_atk__text__TextBoxType sWIGTYPE_p_atk__text__TextBoxType, SWIGTYPE_p_atk__text__TextBoxStyle sWIGTYPE_p_atk__text__TextBoxStyle) {
        return NeboEngineJNI.StyleUtils_type(SWIGTYPE_p_atk__text__TextBoxType.getCPtr(sWIGTYPE_p_atk__text__TextBoxType), SWIGTYPE_p_atk__text__TextBoxStyle.getCPtr(sWIGTYPE_p_atk__text__TextBoxStyle));
    }

    public static float defaultFontSize() {
        return NeboEngineJNI.StyleUtils_defaultFontSize();
    }

    public static float defaultLineHeight() {
        return NeboEngineJNI.StyleUtils_defaultLineHeight();
    }

    public static float defaultLineGapMM(ViewTransform viewTransform, ITypesetListener iTypesetListener, float f) {
        return NeboEngineJNI.StyleUtils_defaultLineGapMM__SWIG_0(ViewTransform.getCPtr(viewTransform), viewTransform, iTypesetListener, f);
    }

    public static float defaultLineGapMM(ViewTransform viewTransform, ITypesetListener iTypesetListener) {
        return NeboEngineJNI.StyleUtils_defaultLineGapMM__SWIG_1(ViewTransform.getCPtr(viewTransform), viewTransform, iTypesetListener);
    }

    public static float defaultLineGapMM(float f, ITypesetListener iTypesetListener, float f2) {
        return NeboEngineJNI.StyleUtils_defaultLineGapMM__SWIG_2(f, iTypesetListener, f2);
    }

    public static float defaultLineGapMM(float f, ITypesetListener iTypesetListener) {
        return NeboEngineJNI.StyleUtils_defaultLineGapMM__SWIG_3(f, iTypesetListener);
    }

    public static float lineGapMM(ViewTransform viewTransform, ITypesetListener iTypesetListener, LayoutGrid.StyleProperties styleProperties, float f) {
        return NeboEngineJNI.StyleUtils_lineGapMM__SWIG_0(ViewTransform.getCPtr(viewTransform), viewTransform, iTypesetListener, LayoutGrid.StyleProperties.getCPtr(styleProperties), styleProperties, f);
    }

    public static float lineGapMM(ViewTransform viewTransform, ITypesetListener iTypesetListener, LayoutGrid.StyleProperties styleProperties) {
        return NeboEngineJNI.StyleUtils_lineGapMM__SWIG_1(ViewTransform.getCPtr(viewTransform), viewTransform, iTypesetListener, LayoutGrid.StyleProperties.getCPtr(styleProperties), styleProperties);
    }

    public static float lineGapMM(float f, ITypesetListener iTypesetListener, LayoutGrid.StyleProperties styleProperties, float f2) {
        return NeboEngineJNI.StyleUtils_lineGapMM__SWIG_2(f, iTypesetListener, LayoutGrid.StyleProperties.getCPtr(styleProperties), styleProperties, f2);
    }

    public static float lineGapMM(float f, ITypesetListener iTypesetListener, LayoutGrid.StyleProperties styleProperties) {
        return NeboEngineJNI.StyleUtils_lineGapMM__SWIG_3(f, iTypesetListener, LayoutGrid.StyleProperties.getCPtr(styleProperties), styleProperties);
    }

    public static float diagramLineGapMM(LayoutGrid.StyleProperties styleProperties) {
        return NeboEngineJNI.StyleUtils_diagramLineGapMM(LayoutGrid.StyleProperties.getCPtr(styleProperties), styleProperties);
    }

    public StyleUtils() {
        this(NeboEngineJNI.new_StyleUtils(), true);
    }
}
