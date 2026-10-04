package com.myscript.atk.core.p020ui.utils;

import androidx.media3.common.C2181C;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.myscript.atk.core.InkStyle;
import com.myscript.atk.core.rendering.BrushDashParser;

/* JADX INFO: loaded from: classes4.dex */
public final class InkStyleCacheData {
    private static final String NO_SMOOTHING = "None";
    private static final String ROUNDED_LINE_STYLE = "round";
    private static final String SHADOW_STROKE_STYLE = "shadow";
    private static final String SOLID_FILL_STYLE = "solid";
    public static final int FONT_PROPERTIES = InkStyle.InkStyleFlag.FONT_FAMILY.swigValue();
    private static final int FONT_FAMILY = InkStyle.InkStyleFlag.FONT_FAMILY.swigValue();
    private static final int FONT_STYLE = InkStyle.InkStyleFlag.FONT_STYLE.swigValue();
    private static final int FONT_WEIGHT = InkStyle.InkStyleFlag.FONT_WEIGHT.swigValue();
    private static final int FONT_SIZE = InkStyle.InkStyleFlag.FONT_SIZE.swigValue();
    public static final int WIDTH = InkStyle.InkStyleFlag.WIDTH.swigValue();
    public static final int COLOR = InkStyle.InkStyleFlag.COLOR.swigValue();
    public static final int FILL_COLOR = InkStyle.InkStyleFlag.FILL_COLOR.swigValue();
    public static final int FILL_STYLE = InkStyle.InkStyleFlag.FILL_STYLE.swigValue();
    public static final int BRUSH = InkStyle.InkStyleFlag.BRUSH.swigValue();
    public static final int SMOOTHING = InkStyle.InkStyleFlag.SMOOTHING.swigValue();
    private static final BrushDashParser sBrushParser = new BrushDashParser();
    private static InkStyle sCacheInkStyle = new InkStyle();
    private static int sCacheFlag = InkStyle.InkStyleFlag.NONE.swigValue();
    private static boolean sIsDefaultFont = false;
    private static boolean sIsSTIXFont = false;
    private static String sFontFamily = "";
    private static boolean sIsItalic = false;
    private static int sFontWeight = 0;
    private static float sWidth = 0.0f;
    private static int sColor = 0;
    private static int sFillColor = 0;
    private static String sFillStyle = "";
    private static boolean sFillStyleIsSolid = false;
    private static String sBrush = "";
    private static boolean sBrushIsDash = false;
    private static float sBrushDashDimension = 0.0f;
    private static float sBrushDashGapDimension = 0.0f;
    private static boolean sBrushIsRounded = false;
    private static boolean sBrushHasShadow = false;
    private static String sSmoothing = "";
    private static boolean sSmoothingIsEnabled = false;
    private static float sFontSize = 0.0f;
    public int updatedCacheFlag = InkStyle.InkStyleFlag.NONE.swigValue();
    public boolean isDefaultFont = false;
    public boolean isSTIXFont = false;
    private String fontFamily = "";
    private boolean isItalic = false;
    public int fontWeight = 0;
    public float width = 0.0f;
    public int color = 0;
    public int fillColor = 0;
    public String fillStyle = "";
    public boolean fillStyleIsSolid = false;
    public String brush = "";
    public boolean brushIsDash = false;
    public float brushDashDimension = 0.0f;
    public float brushDashGapDimension = 0.0f;
    public boolean brushIsRounded = false;
    public boolean brushHasShadow = false;
    public String smoothing = "";
    public boolean smoothingIsEnabled = false;
    public float fontSize = 0.0f;

    public static synchronized InkStyleCacheData getData(InkStyle inkStyle, int i) {
        InkStyleCacheData inkStyleCacheData;
        int i2 = FONT_PROPERTIES;
        if ((i & i2) != 0) {
            i |= FONT_WEIGHT | FONT_STYLE | FONT_SIZE | FONT_FAMILY;
        }
        int i3 = sCacheFlag;
        sCacheFlag = i3 - sCacheInkStyle.compare(inkStyle, i3);
        inkStyleCacheData = new InkStyleCacheData();
        if ((i & i2) != 0) {
            if ((sCacheFlag & FONT_WEIGHT) == 0) {
                sFontWeight = inkStyle.getFontWeight();
                inkStyleCacheData.updatedCacheFlag |= i2;
            }
            inkStyleCacheData.fontWeight = sFontWeight;
            if ((sCacheFlag & FONT_STYLE) == 0) {
                sIsItalic = TtmlNode.ITALIC.equals(inkStyle.getFontStyle());
                inkStyleCacheData.updatedCacheFlag |= i2;
            }
            inkStyleCacheData.isItalic = sIsItalic;
            if ((sCacheFlag & FONT_SIZE) == 0) {
                sFontSize = inkStyle.getFontSize();
                inkStyleCacheData.updatedCacheFlag |= i2;
            }
            inkStyleCacheData.fontSize = sFontSize;
            if ((sCacheFlag & FONT_FAMILY) == 0) {
                String fontFamily = inkStyle.getFontFamily();
                sFontFamily = fontFamily;
                boolean zEquals = C2181C.SANS_SERIF_NAME.equals(fontFamily);
                sIsDefaultFont = zEquals;
                sIsSTIXFont = !zEquals && sFontFamily.contains("STIX");
                inkStyleCacheData.updatedCacheFlag = i2 | inkStyleCacheData.updatedCacheFlag;
            }
            inkStyleCacheData.fontFamily = sFontFamily;
            inkStyleCacheData.isDefaultFont = sIsDefaultFont;
            inkStyleCacheData.isSTIXFont = sIsSTIXFont;
        }
        int i4 = WIDTH;
        if ((i & i4) != 0) {
            if ((sCacheFlag & i4) == 0) {
                sWidth = inkStyle.getWidth();
                inkStyleCacheData.updatedCacheFlag = i4 | inkStyleCacheData.updatedCacheFlag;
            }
            inkStyleCacheData.width = sWidth;
        }
        int i5 = COLOR;
        if ((i & i5) != 0) {
            if ((sCacheFlag & i5) == 0) {
                sColor = inkStyle.getColor();
                inkStyleCacheData.updatedCacheFlag = i5 | inkStyleCacheData.updatedCacheFlag;
            }
            inkStyleCacheData.color = sColor;
        }
        int i6 = FILL_COLOR;
        if ((i & i6) != 0) {
            if ((sCacheFlag & i6) == 0) {
                sFillColor = inkStyle.getFillColor();
                inkStyleCacheData.updatedCacheFlag = i6 | inkStyleCacheData.updatedCacheFlag;
            }
            inkStyleCacheData.fillColor = sFillColor;
        }
        int i7 = FILL_STYLE;
        if ((i & i7) != 0) {
            if ((sCacheFlag & i7) == 0) {
                String fillStyle = inkStyle.getFillStyle();
                sFillStyle = fillStyle;
                sFillStyleIsSolid = SOLID_FILL_STYLE.equals(fillStyle);
                inkStyleCacheData.updatedCacheFlag = i7 | inkStyleCacheData.updatedCacheFlag;
            }
            inkStyleCacheData.fillStyle = sFillStyle;
            inkStyleCacheData.fillStyleIsSolid = sFillStyleIsSolid;
        }
        int i8 = BRUSH;
        if ((i & i8) != 0) {
            if ((sCacheFlag & i8) == 0) {
                String brush = inkStyle.getBrush();
                sBrush = brush;
                BrushDashParser.BrushData brush2 = sBrushParser.parseBrush(brush);
                sBrushDashDimension = brush2.dashOn;
                sBrushDashGapDimension = brush2.dashOff;
                sBrushIsDash = !brush2.type.equals("");
                sBrushIsRounded = sBrush.contains(ROUNDED_LINE_STYLE) || brush2.type.equals(BrushDashParser.BrushData.DOTTED_TYPE);
                sBrushHasShadow = sBrush.contains(SHADOW_STROKE_STYLE);
                inkStyleCacheData.updatedCacheFlag = i8 | inkStyleCacheData.updatedCacheFlag;
            }
            inkStyleCacheData.brush = sBrush;
            inkStyleCacheData.brushIsDash = sBrushIsDash;
            inkStyleCacheData.brushDashDimension = sBrushDashDimension;
            inkStyleCacheData.brushDashGapDimension = sBrushDashGapDimension;
            inkStyleCacheData.brushIsRounded = sBrushIsRounded;
            inkStyleCacheData.brushHasShadow = sBrushHasShadow;
        }
        int i9 = SMOOTHING;
        if ((i & i9) != 0) {
            if ((sCacheFlag & i9) == 0) {
                sSmoothing = inkStyle.getSmoothing();
                sSmoothingIsEnabled = !NO_SMOOTHING.equalsIgnoreCase(r9);
                inkStyleCacheData.updatedCacheFlag |= i9;
            }
            inkStyleCacheData.smoothing = sSmoothing;
            inkStyleCacheData.smoothingIsEnabled = sSmoothingIsEnabled;
        }
        int i10 = inkStyleCacheData.updatedCacheFlag;
        if (i10 != 0) {
            sCacheInkStyle = inkStyle;
            sCacheFlag |= i10;
        }
        return inkStyleCacheData;
    }

    public boolean isItalic() {
        return this.isItalic;
    }

    public boolean isBold() {
        return this.fontWeight >= 700;
    }

    public String getFontFamily() {
        if (this.isDefaultFont) {
            return isBold() ? "MyScriptInter Bold" : "MyScriptInter Regular";
        }
        if (this.isSTIXFont) {
            return this.isItalic ? "STIXTwoText-Italic" : "STIXTwoMath-Regular";
        }
        return this.fontFamily;
    }
}
