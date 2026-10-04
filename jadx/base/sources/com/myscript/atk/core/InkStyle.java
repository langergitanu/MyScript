package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class InkStyle {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public InkStyle(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(InkStyle inkStyle) {
        if (inkStyle == null) {
            return 0L;
        }
        return inkStyle.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_InkStyle(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setFontWeight(int i) {
        ATKCoreJNI.InkStyle_FontWeight_set(this.swigCPtr, this, i);
    }

    public int getFontWeight() {
        return ATKCoreJNI.InkStyle_FontWeight_get(this.swigCPtr, this);
    }

    public void setFontSize(float f) {
        ATKCoreJNI.InkStyle_FontSize_set(this.swigCPtr, this, f);
    }

    public float getFontSize() {
        return ATKCoreJNI.InkStyle_FontSize_get(this.swigCPtr, this);
    }

    public void setFontLineHeight(float f) {
        ATKCoreJNI.InkStyle_FontLineHeight_set(this.swigCPtr, this, f);
    }

    public float getFontLineHeight() {
        return ATKCoreJNI.InkStyle_FontLineHeight_get(this.swigCPtr, this);
    }

    public void setColor(int i) {
        ATKCoreJNI.InkStyle_color_set(this.swigCPtr, this, i);
    }

    public int getColor() {
        return ATKCoreJNI.InkStyle_color_get(this.swigCPtr, this);
    }

    public void setWidth(float f) {
        ATKCoreJNI.InkStyle_width_set(this.swigCPtr, this, f);
    }

    public float getWidth() {
        return ATKCoreJNI.InkStyle_width_get(this.swigCPtr, this);
    }

    public void setFillColor(int i) {
        ATKCoreJNI.InkStyle_fillColor_set(this.swigCPtr, this, i);
    }

    public int getFillColor() {
        return ATKCoreJNI.InkStyle_fillColor_get(this.swigCPtr, this);
    }

    public void setTextDecorationBrush(String str) {
        ATKCoreJNI.InkStyle_textDecorationBrush_set(this.swigCPtr, this, str);
    }

    public String getTextDecorationBrush() {
        return ATKCoreJNI.InkStyle_textDecorationBrush_get(this.swigCPtr, this);
    }

    public void setTextDecorationColor(int i) {
        ATKCoreJNI.InkStyle_textDecorationColor_set(this.swigCPtr, this, i);
    }

    public int getTextDecorationColor() {
        return ATKCoreJNI.InkStyle_textDecorationColor_get(this.swigCPtr, this);
    }

    public void setTextDecorationBackgroundColor(int i) {
        ATKCoreJNI.InkStyle_textDecorationBackgroundColor_set(this.swigCPtr, this, i);
    }

    public int getTextDecorationBackgroundColor() {
        return ATKCoreJNI.InkStyle_textDecorationBackgroundColor_get(this.swigCPtr, this);
    }

    public void setTextDecorationWidth(float f) {
        ATKCoreJNI.InkStyle_textDecorationWidth_set(this.swigCPtr, this, f);
    }

    public float getTextDecorationWidth() {
        return ATKCoreJNI.InkStyle_textDecorationWidth_get(this.swigCPtr, this);
    }

    public void setTextDecorationSmoothing(String str) {
        ATKCoreJNI.InkStyle_textDecorationSmoothing_set(this.swigCPtr, this, str);
    }

    public String getTextDecorationSmoothing() {
        return ATKCoreJNI.InkStyle_textDecorationSmoothing_get(this.swigCPtr, this);
    }

    public void setBackgroundColor(int i) {
        ATKCoreJNI.InkStyle_backgroundColor_set(this.swigCPtr, this, i);
    }

    public int getBackgroundColor() {
        return ATKCoreJNI.InkStyle_backgroundColor_get(this.swigCPtr, this);
    }

    public void setBeginArrowType(String str) {
        ATKCoreJNI.InkStyle_beginArrowType_set(this.swigCPtr, this, str);
    }

    public String getBeginArrowType() {
        return ATKCoreJNI.InkStyle_beginArrowType_get(this.swigCPtr, this);
    }

    public void setBeginArrowSize(float f) {
        ATKCoreJNI.InkStyle_beginArrowSize_set(this.swigCPtr, this, f);
    }

    public float getBeginArrowSize() {
        return ATKCoreJNI.InkStyle_beginArrowSize_get(this.swigCPtr, this);
    }

    public void setEndArrowType(String str) {
        ATKCoreJNI.InkStyle_endArrowType_set(this.swigCPtr, this, str);
    }

    public String getEndArrowType() {
        return ATKCoreJNI.InkStyle_endArrowType_get(this.swigCPtr, this);
    }

    public void setEndArrowSize(float f) {
        ATKCoreJNI.InkStyle_endArrowSize_set(this.swigCPtr, this, f);
    }

    public float getEndArrowSize() {
        return ATKCoreJNI.InkStyle_endArrowSize_get(this.swigCPtr, this);
    }

    public void setOrientation(float f) {
        ATKCoreJNI.InkStyle_orientation_set(this.swigCPtr, this, f);
    }

    public float getOrientation() {
        return ATKCoreJNI.InkStyle_orientation_get(this.swigCPtr, this);
    }

    public void setTilt(float f) {
        ATKCoreJNI.InkStyle_tilt_set(this.swigCPtr, this, f);
    }

    public float getTilt() {
        return ATKCoreJNI.InkStyle_tilt_get(this.swigCPtr, this);
    }

    public void setPressure(float f) {
        ATKCoreJNI.InkStyle_pressure_set(this.swigCPtr, this, f);
    }

    public float getPressure() {
        return ATKCoreJNI.InkStyle_pressure_get(this.swigCPtr, this);
    }

    public void setFontFamily(String str) {
        ATKCoreJNI.InkStyle_setFontFamily(this.swigCPtr, this, str.getBytes());
    }

    public void setFontStyle(String str) {
        ATKCoreJNI.InkStyle_setFontStyle(this.swigCPtr, this, str.getBytes());
    }

    public void setFontVariant(String str) {
        ATKCoreJNI.InkStyle_setFontVariant(this.swigCPtr, this, str.getBytes());
    }

    public void setSmoothing(String str) {
        ATKCoreJNI.InkStyle_setSmoothing(this.swigCPtr, this, str.getBytes());
    }

    public void setBrush(String str) {
        ATKCoreJNI.InkStyle_setBrush(this.swigCPtr, this, str.getBytes());
    }

    public void setFillStyle(String str) {
        ATKCoreJNI.InkStyle_setFillStyle(this.swigCPtr, this, str.getBytes());
    }

    public void setTextDecorationStyle(String str) {
        ATKCoreJNI.InkStyle_setTextDecorationStyle(this.swigCPtr, this, str.getBytes());
    }

    public String getFontFamily() {
        return new String(ATKCoreJNI.InkStyle_getFontFamily(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String getFontStyle() {
        return new String(ATKCoreJNI.InkStyle_getFontStyle(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String getFontVariant() {
        return new String(ATKCoreJNI.InkStyle_getFontVariant(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String getSmoothing() {
        return new String(ATKCoreJNI.InkStyle_getSmoothing(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String getBrush() {
        return new String(ATKCoreJNI.InkStyle_getBrush(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String getFillStyle() {
        return new String(ATKCoreJNI.InkStyle_getFillStyle(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String getTextDecorationStyle() {
        return new String(ATKCoreJNI.InkStyle_getTextDecorationStyle(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public int compare(InkStyle inkStyle, int i) {
        return ATKCoreJNI.InkStyle_compare(this.swigCPtr, this, getCPtr(inkStyle), inkStyle, i);
    }

    public InkStyle() {
        this(ATKCoreJNI.new_InkStyle(), true);
    }

    public enum InkStyleFlag {
        NONE(0),
        FONT_FAMILY(1),
        FONT_STYLE(2),
        FONT_VARIANT(4),
        FONT_WEIGHT(8),
        FONT_SIZE(16),
        FONT_LINEHEIGHT(32),
        COLOR(64),
        WIDTH(128),
        SMOOTHING(256),
        BRUSH(512),
        FILL_STYLE(1024),
        FILL_COLOR(2048),
        TEXT_DECORATION_STYLE(4096),
        TEXT_DECORATION_COLOR(8192),
        TEXT_DECORATION_BACKGROUND_COLOR(16384),
        TEXT_DECORATION_WIDTH(32768),
        BACKGROUND_COLOR(65536),
        BEGIN_ARROW_TYPE(131072),
        BEGIN_ARROW_SIZE(262144),
        END_ARROW_TYPE(524288),
        END_ARROW_SIZE(1048576),
        ALL(2097151);

        private final int swigValue;

        public final int swigValue() {
            return this.swigValue;
        }

        public static InkStyleFlag swigToEnum(int i) {
            InkStyleFlag[] inkStyleFlagArr = (InkStyleFlag[]) InkStyleFlag.class.getEnumConstants();
            if (i < inkStyleFlagArr.length && i >= 0) {
                InkStyleFlag inkStyleFlag = inkStyleFlagArr[i];
                if (inkStyleFlag.swigValue == i) {
                    return inkStyleFlag;
                }
            }
            for (InkStyleFlag inkStyleFlag2 : inkStyleFlagArr) {
                if (inkStyleFlag2.swigValue == i) {
                    return inkStyleFlag2;
                }
            }
            throw new IllegalArgumentException("No enum " + InkStyleFlag.class + " with value " + i);
        }

        InkStyleFlag() {
            int i = SwigNext.next;
            SwigNext.next = i + 1;
            this.swigValue = i;
        }

        InkStyleFlag(int i) {
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        InkStyleFlag(InkStyleFlag inkStyleFlag) {
            int i = inkStyleFlag.swigValue;
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
