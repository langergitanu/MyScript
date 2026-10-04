package com.pdftron.pdf;

import com.pdftron.common.Matrix2D;
import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class GState {
    public static final int e_BG_funct = 33;
    public static final int e_UCR_funct = 34;
    public static final int e_absolute_colorimetric = 0;
    public static final int e_alpha_is_shape = 25;
    public static final int e_auto_stoke_adjust = 28;
    public static final int e_bevel_join = 2;
    public static final int e_bl_color = 16;
    public static final int e_bl_color_burn = 8;
    public static final int e_bl_color_dodge = 7;
    public static final int e_bl_compatible = 0;
    public static final int e_bl_darken = 5;
    public static final int e_bl_difference = 4;
    public static final int e_bl_exclusion = 9;
    public static final int e_bl_hard_light = 10;
    public static final int e_bl_hue = 14;
    public static final int e_bl_lighten = 6;
    public static final int e_bl_luminosity = 13;
    public static final int e_bl_multiply = 2;
    public static final int e_bl_normal = 1;
    public static final int e_bl_overlay = 11;
    public static final int e_bl_saturation = 15;
    public static final int e_bl_screen = 3;
    public static final int e_bl_soft_light = 12;
    public static final int e_blend_mode = 22;
    public static final int e_butt_cap = 0;
    public static final int e_char_spacing = 12;
    public static final int e_clip_text = 7;
    public static final int e_dash_pattern = 11;
    public static final int e_fill_clip_text = 4;
    public static final int e_fill_color = 5;
    public static final int e_fill_cs = 4;
    public static final int e_fill_overprint = 30;
    public static final int e_fill_stroke_clip_text = 6;
    public static final int e_fill_stroke_text = 2;
    public static final int e_fill_text = 0;
    public static final int e_flatness = 9;
    public static final int e_font = 16;
    public static final int e_font_size = 17;
    public static final int e_halftone = 35;
    public static final int e_horizontal_scale = 14;
    public static final int e_invisible_text = 3;
    public static final int e_leading = 15;
    public static final int e_line_cap = 7;
    public static final int e_line_join = 8;
    public static final int e_line_width = 6;
    public static final int e_miter_join = 0;
    public static final int e_miter_limit = 10;
    public static final int e_null = 36;
    public static final int e_opacity_fill = 23;
    public static final int e_opacity_stroke = 24;
    public static final int e_overprint_mode = 31;
    public static final int e_perceptual = 3;
    public static final int e_relative_colorimetric = 1;
    public static final int e_rendering_intent = 1;
    public static final int e_round_cap = 1;
    public static final int e_round_join = 1;
    public static final int e_saturation = 2;
    public static final int e_smoothnes = 27;
    public static final int e_soft_mask = 26;
    public static final int e_square_cap = 2;
    public static final int e_stroke_clip_text = 5;
    public static final int e_stroke_color = 3;
    public static final int e_stroke_cs = 2;
    public static final int e_stroke_overprint = 29;
    public static final int e_stroke_text = 1;
    public static final int e_text_knockout = 20;
    public static final int e_text_pos_offset = 21;
    public static final int e_text_render_mode = 18;
    public static final int e_text_rise = 19;
    public static final int e_transfer_funct = 32;
    public static final int e_transform = 0;
    public static final int e_word_spacing = 13;

    /* JADX INFO: renamed from: a */
    long f1562a;

    /* JADX INFO: renamed from: b */
    private Object f1563b;

    /* JADX INFO: renamed from: c */
    private Object f1564c;

    static native void Concat(long j, double d, double d2, double d3, double d4, double d5, double d6);

    static native void Concat(long j, long j2);

    static native boolean GetAISFlag(long j);

    static native boolean GetAutoStrokeAdjust(long j);

    static native long GetBlackGenFunct(long j);

    static native int GetBlendMode(long j);

    static native double GetCharSpacing(long j);

    static native double[] GetDashes(long j);

    static native long GetFillColor(long j);

    static native long GetFillColorSpace(long j);

    static native double GetFillOpacity(long j);

    static native boolean GetFillOverprint(long j);

    static native long GetFillPattern(long j);

    static native double GetFlatness(long j);

    static native long GetFont(long j);

    static native double GetFontSize(long j);

    static native long GetHalftone(long j);

    static native double GetHorizontalScale(long j);

    static native double GetLeading(long j);

    static native int GetLineCap(long j);

    static native int GetLineJoin(long j);

    static native double GetLineWidth(long j);

    static native double GetMiterLimit(long j);

    static native int GetOverprintMode(long j);

    static native double GetPhase(long j);

    static native int GetRenderingIntent(long j);

    static native double GetSmoothnessTolerance(long j);

    static native long GetSoftMask(long j);

    static native long GetSoftMaskTransform(long j);

    static native long GetStrokeColor(long j);

    static native long GetStrokeColorSpace(long j);

    static native double GetStrokeOpacity(long j);

    static native boolean GetStrokeOverprint(long j);

    static native long GetStrokePattern(long j);

    static native int GetTextRenderMode(long j);

    static native double GetTextRise(long j);

    static native long GetTransferFunct(long j);

    static native long GetTransform(long j);

    static native long GetUCRFunct(long j);

    static native double GetWordSpacing(long j);

    static native boolean IsTextKnockout(long j);

    static native void SetAISFlag(long j, boolean z);

    static native void SetAutoStrokeAdjust(long j, boolean z);

    static native void SetBlackGenFunct(long j, long j2);

    static native void SetBlendMode(long j, int i);

    static native void SetCharSpacing(long j, double d);

    static native void SetDashPattern(long j, double[] dArr, double d);

    static native void SetFillColor(long j, long j2);

    static native void SetFillColor(long j, long j2, long j3);

    static native void SetFillColorPt(long j, long j2);

    static native void SetFillColorSpace(long j, long j2);

    static native void SetFillOpacity(long j, double d);

    static native void SetFillOverprint(long j, boolean z);

    static native void SetFlatness(long j, double d);

    static native void SetFont(long j, long j2, double d);

    static native void SetHalftone(long j, long j2);

    static native void SetHorizontalScale(long j, double d);

    static native void SetLeading(long j, double d);

    static native void SetLineCap(long j, int i);

    static native void SetLineJoin(long j, int i);

    static native void SetLineWidth(long j, double d);

    static native void SetMiterLimit(long j, double d);

    static native void SetOverprintMode(long j, int i);

    static native void SetRenderingIntent(long j, int i);

    static native void SetSmoothnessTolerance(long j, double d);

    static native void SetSoftMask(long j, long j2);

    static native void SetStrokeColor(long j, long j2);

    static native void SetStrokeColor(long j, long j2, long j3);

    static native void SetStrokeColorPt(long j, long j2);

    static native void SetStrokeColorSpace(long j, long j2);

    static native void SetStrokeOpacity(long j, double d);

    static native void SetStrokeOverprint(long j, boolean z);

    static native void SetTextKnockout(long j, boolean z);

    static native void SetTextRenderMode(long j, int i);

    static native void SetTextRise(long j, double d);

    static native void SetTransferFunct(long j, long j2);

    static native void SetTransform(long j, double d, double d2, double d3, double d4, double d5, double d6);

    static native void SetTransform(long j, long j2);

    static native void SetUCRFunct(long j, long j2);

    static native void SetWordSpacing(long j, double d);

    public Matrix2D getTransform() throws PDFNetException {
        return Matrix2D.__Create(GetTransform(this.f1562a));
    }

    public ColorSpace getStrokeColorSpace() throws PDFNetException {
        return ColorSpace.__Create(GetStrokeColorSpace(this.f1562a), this.f1563b);
    }

    public ColorSpace getFillColorSpace() throws PDFNetException {
        return ColorSpace.__Create(GetFillColorSpace(this.f1562a), this.f1563b);
    }

    public ColorPt getStrokeColor() throws PDFNetException {
        return new ColorPt(GetStrokeColor(this.f1562a));
    }

    public PatternColor GetStrokePattern() throws PDFNetException {
        return PatternColor.m1467a(GetStrokePattern(this.f1562a), this.f1564c);
    }

    public ColorPt getFillColor() throws PDFNetException {
        return new ColorPt(GetFillColor(this.f1562a));
    }

    public PatternColor getFillPattern() throws PDFNetException {
        return PatternColor.m1467a(GetFillPattern(this.f1562a), this.f1564c);
    }

    public double getFlatness() throws PDFNetException {
        return GetFlatness(this.f1562a);
    }

    public int getLineCap() throws PDFNetException {
        return GetLineCap(this.f1562a);
    }

    public int getLineJoin() throws PDFNetException {
        return GetLineJoin(this.f1562a);
    }

    public double getLineWidth() throws PDFNetException {
        return GetLineWidth(this.f1562a);
    }

    public double getMiterLimit() throws PDFNetException {
        return GetMiterLimit(this.f1562a);
    }

    public double[] getDashes() throws PDFNetException {
        return GetDashes(this.f1562a);
    }

    public double getPhase() throws PDFNetException {
        return GetPhase(this.f1562a);
    }

    public double getCharSpacing() throws PDFNetException {
        return GetCharSpacing(this.f1562a);
    }

    public double getWordSpacing() throws PDFNetException {
        return GetWordSpacing(this.f1562a);
    }

    public double getHorizontalScale() throws PDFNetException {
        return GetHorizontalScale(this.f1562a);
    }

    public double getLeading() throws PDFNetException {
        return GetLeading(this.f1562a);
    }

    public Font getFont() throws PDFNetException {
        return Font.__Create(GetFont(this.f1562a), this.f1563b);
    }

    public double getFontSize() throws PDFNetException {
        return GetFontSize(this.f1562a);
    }

    public int getTextRenderMode() throws PDFNetException {
        return GetTextRenderMode(this.f1562a);
    }

    public double getTextRise() throws PDFNetException {
        return GetTextRise(this.f1562a);
    }

    public boolean isTextKnockout() throws PDFNetException {
        return IsTextKnockout(this.f1562a);
    }

    public int getRenderingIntent() throws PDFNetException {
        return GetRenderingIntent(this.f1562a);
    }

    public int getBlendMode() throws PDFNetException {
        return GetBlendMode(this.f1562a);
    }

    public double getFillOpacity() throws PDFNetException {
        return GetFillOpacity(this.f1562a);
    }

    public double getStrokeOpacity() throws PDFNetException {
        return GetStrokeOpacity(this.f1562a);
    }

    public boolean getAISFlag() throws PDFNetException {
        return GetAISFlag(this.f1562a);
    }

    public Obj getSoftMask() throws PDFNetException {
        return Obj.__Create(GetSoftMask(this.f1562a), this.f1564c);
    }

    public Matrix2D getSoftMaskTransform() throws PDFNetException {
        return Matrix2D.__Create(GetSoftMaskTransform(this.f1562a));
    }

    public boolean getStrokeOverprint() throws PDFNetException {
        return GetStrokeOverprint(this.f1562a);
    }

    public boolean getFillOverprint() throws PDFNetException {
        return GetFillOverprint(this.f1562a);
    }

    public int getOverprintMode() throws PDFNetException {
        return GetOverprintMode(this.f1562a);
    }

    public boolean getAutoStrokeAdjust() throws PDFNetException {
        return GetAutoStrokeAdjust(this.f1562a);
    }

    public double getSmoothnessTolerance() throws PDFNetException {
        return GetSmoothnessTolerance(this.f1562a);
    }

    public Obj getTransferFunct() throws PDFNetException {
        return Obj.__Create(GetTransferFunct(this.f1562a), this.f1564c);
    }

    public Obj getBlackGenFunct() throws PDFNetException {
        return Obj.__Create(GetBlackGenFunct(this.f1562a), this.f1564c);
    }

    public Obj getUCRFunct() throws PDFNetException {
        return Obj.__Create(GetUCRFunct(this.f1562a), this.f1564c);
    }

    public Obj getHalftone() throws PDFNetException {
        return Obj.__Create(GetHalftone(this.f1562a), this.f1564c);
    }

    public void setTransform(Matrix2D matrix2D) throws PDFNetException {
        SetTransform(this.f1562a, matrix2D.__GetHandle());
        ReachabilityHelper.ensureReachable(matrix2D);
    }

    public void setTransform(double d, double d2, double d3, double d4, double d5, double d6) throws PDFNetException {
        SetTransform(this.f1562a, d, d2, d3, d4, d5, d6);
    }

    public void concat(Matrix2D matrix2D) throws PDFNetException {
        Concat(this.f1562a, matrix2D.__GetHandle());
        ReachabilityHelper.ensureReachable(matrix2D);
    }

    public void concat(double d, double d2, double d3, double d4, double d5, double d6) throws PDFNetException {
        Concat(this.f1562a, d, d2, d3, d4, d5, d6);
    }

    public void setStrokeColorSpace(ColorSpace colorSpace) throws PDFNetException {
        SetStrokeColorSpace(this.f1562a, colorSpace.f1459a);
        ReachabilityHelper.ensureReachable(colorSpace);
    }

    public void setFillColorSpace(ColorSpace colorSpace) throws PDFNetException {
        SetFillColorSpace(this.f1562a, colorSpace.f1459a);
        ReachabilityHelper.ensureReachable(colorSpace);
    }

    public void setStrokeColor(ColorPt colorPt) throws PDFNetException {
        SetStrokeColorPt(this.f1562a, colorPt.f1458a);
        ReachabilityHelper.ensureReachable(colorPt);
    }

    public void setStrokeColor(PatternColor patternColor) throws PDFNetException {
        SetStrokeColor(this.f1562a, patternColor.f1999a);
        ReachabilityHelper.ensureReachable(patternColor);
    }

    public void setStrokeColor(PatternColor patternColor, ColorPt colorPt) throws PDFNetException {
        SetStrokeColor(this.f1562a, patternColor.f1999a, colorPt.f1458a);
        ReachabilityHelper.ensureReachable(patternColor);
    }

    public void setFillColor(ColorPt colorPt) throws PDFNetException {
        SetFillColorPt(this.f1562a, colorPt.f1458a);
        ReachabilityHelper.ensureReachable(colorPt);
    }

    public void setFillColor(PatternColor patternColor) throws PDFNetException {
        SetFillColor(this.f1562a, patternColor.f1999a);
        ReachabilityHelper.ensureReachable(patternColor);
    }

    public void setFillColor(PatternColor patternColor, ColorPt colorPt) throws PDFNetException {
        SetFillColor(this.f1562a, patternColor.f1999a, colorPt.f1458a);
        ReachabilityHelper.ensureReachable(patternColor);
        ReachabilityHelper.ensureReachable(colorPt);
    }

    public void setFlatness(double d) throws PDFNetException {
        SetFlatness(this.f1562a, d);
    }

    public void setLineCap(int i) throws PDFNetException {
        SetLineCap(this.f1562a, i);
    }

    public void setLineJoin(int i) throws PDFNetException {
        SetLineJoin(this.f1562a, i);
    }

    public void setLineWidth(double d) throws PDFNetException {
        SetLineWidth(this.f1562a, d);
    }

    public void setMiterLimit(double d) throws PDFNetException {
        SetMiterLimit(this.f1562a, d);
    }

    public void setDashPattern(double[] dArr, double d) throws PDFNetException {
        SetDashPattern(this.f1562a, dArr, d);
    }

    public void setCharSpacing(double d) throws PDFNetException {
        SetCharSpacing(this.f1562a, d);
    }

    public void setWordSpacing(double d) throws PDFNetException {
        SetWordSpacing(this.f1562a, d);
    }

    public void setHorizontalScale(double d) throws PDFNetException {
        SetHorizontalScale(this.f1562a, d);
    }

    public void setLeading(double d) throws PDFNetException {
        SetLeading(this.f1562a, d);
    }

    public void setFont(Font font, double d) throws PDFNetException {
        SetFont(this.f1562a, font.f1556a, d);
        ReachabilityHelper.ensureReachable(font);
    }

    public void setTextRenderMode(int i) throws PDFNetException {
        SetTextRenderMode(this.f1562a, i);
    }

    public void setTextRise(double d) throws PDFNetException {
        SetTextRise(this.f1562a, d);
    }

    public void setTextKnockout(boolean z) throws PDFNetException {
        SetTextKnockout(this.f1562a, z);
    }

    public void setRenderingIntent(int i) throws PDFNetException {
        SetRenderingIntent(this.f1562a, i);
    }

    public void setBlendMode(int i) throws PDFNetException {
        SetBlendMode(this.f1562a, i);
    }

    public void setFillOpacity(double d) throws PDFNetException {
        SetFillOpacity(this.f1562a, d);
    }

    public void setStrokeOpacity(double d) throws PDFNetException {
        SetStrokeOpacity(this.f1562a, d);
    }

    public void setAISFlag(boolean z) throws PDFNetException {
        SetAISFlag(this.f1562a, z);
    }

    public void setSoftMask(Obj obj) throws PDFNetException {
        SetSoftMask(this.f1562a, obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
    }

    public void setStrokeOverprint(boolean z) throws PDFNetException {
        SetStrokeOverprint(this.f1562a, z);
    }

    public void setFillOverprint(boolean z) throws PDFNetException {
        SetFillOverprint(this.f1562a, z);
    }

    public void setOverprintMode(int i) throws PDFNetException {
        SetOverprintMode(this.f1562a, i);
    }

    public void setAutoStrokeAdjust(boolean z) throws PDFNetException {
        SetAutoStrokeAdjust(this.f1562a, z);
    }

    public void setSmoothnessTolerance(double d) throws PDFNetException {
        SetSmoothnessTolerance(this.f1562a, d);
    }

    public void setBlackGenFunct(Obj obj) throws PDFNetException {
        SetBlackGenFunct(this.f1562a, obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
    }

    public void setUCRFunct(Obj obj) throws PDFNetException {
        SetUCRFunct(this.f1562a, obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
    }

    public void setTransferFunct(Obj obj) throws PDFNetException {
        SetTransferFunct(this.f1562a, obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
    }

    public void setHalftone(Obj obj) throws PDFNetException {
        SetHalftone(this.f1562a, obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
    }

    GState(long j, Object obj, Object obj2) {
        this.f1562a = j;
        this.f1563b = obj;
        this.f1564c = obj2;
    }
}
