package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Action;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.ColorPt;
import com.pdftron.pdf.Field;
import com.pdftron.pdf.Font;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Widget extends Annot {
    public static final int e_Always = 0;
    public static final int e_Anamorphic = 0;
    public static final int e_CAboveI = 3;
    public static final int e_CBelowI = 2;
    public static final int e_CLeftIRight = 5;
    public static final int e_COverlayI = 6;
    public static final int e_CRightILeft = 4;
    public static final int e_Never = 3;
    public static final int e_NoCaption = 1;
    public static final int e_NoIcon = 0;
    public static final int e_Proportional = 1;
    public static final int e_WhenBigger = 1;
    public static final int e_WhenSmaller = 2;
    public static final int e_invert = 1;
    public static final int e_none = 0;
    public static final int e_outline = 2;
    public static final int e_push = 3;
    public static final int e_toggle = 4;

    static native long Create(long j, long j2, long j3);

    static native long GetAction(long j);

    static native long GetBackgroundColor(long j);

    static native int GetBackgroundColorCompNum(long j);

    static native long GetBorderColor(long j);

    static native int GetBorderColorCompNum(long j);

    static native long GetField(long j);

    static native boolean GetFitFull(long j);

    static native long GetFont(long j);

    static native double GetFontSize(long j);

    static native double GetHIconLeftOver(long j);

    static native int GetHighlightingMode(long j);

    static native int GetIconCaptionRelation(long j);

    static native String GetMouseDownCaptionText(long j);

    static native long GetMouseDownIcon(long j);

    static native String GetRolloverCaptionText(long j);

    static native long GetRolloverIcon(long j);

    static native int GetScaleCondition(long j);

    static native int GetScaleType(long j);

    static native String GetStaticCaptionText(long j);

    static native long GetStaticIcon(long j);

    static native long GetTextColor(long j);

    static native int GetTextColorCompNum(long j);

    static native double GetVIconLeftOver(long j);

    static native void SetAction(long j, long j2);

    static native void SetBackgroundColor(long j, long j2, int i);

    static native void SetBorderColor(long j, long j2, int i);

    static native void SetFitFull(long j, boolean z);

    static native void SetFont(long j, long j2);

    static native void SetFontSize(long j, double d);

    static native void SetHIconLeftOver(long j, double d);

    static native void SetHighlightingMode(long j, int i);

    static native void SetIconCaptionRelation(long j, int i);

    static native void SetMouseDownCaptionText(long j, String str);

    static native void SetMouseDownIcon(long j, long j2);

    static native void SetRolloverCaptionText(long j, String str);

    static native void SetRolloverIcon(long j, long j2);

    static native void SetScaleCondition(long j, int i);

    static native void SetScaleType(long j, int i);

    static native void SetStaticCaptionText(long j, String str);

    static native void SetStaticIcon(long j, long j2);

    static native void SetTextColor(long j, long j2, int i);

    static native void SetVIconLeftOver(long j, double d);

    public Widget(Obj obj) {
        super(obj);
    }

    public Widget() {
    }

    Widget(long j, Object obj) {
        super(j, obj);
    }

    public Widget(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public static Widget create(Doc doc, Rect rect, Field field) throws PDFNetException {
        Widget widget = new Widget(Create(doc.__GetHandle(), rect.__GetHandle(), field.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        ReachabilityHelper.ensureReachable(field);
        return widget;
    }

    public Field getField() throws PDFNetException {
        return Field.__Create(GetField(__GetHandle()), __GetRefHandle());
    }

    public int getHighlightingMode() throws PDFNetException {
        return GetHighlightingMode(__GetHandle());
    }

    public void setHighlightingMode(int i) throws PDFNetException {
        SetHighlightingMode(__GetHandle(), i);
    }

    public Action getAction() throws PDFNetException {
        return Action.__Create(GetAction(__GetHandle()), __GetRefHandle());
    }

    public void setAction(Action action) throws PDFNetException {
        SetAction(__GetHandle(), action.__GetHandle());
        ReachabilityHelper.ensureReachable(action);
    }

    public int getBorderColorCompNum() throws PDFNetException {
        return GetBorderColorCompNum(__GetHandle());
    }

    public ColorPt getBorderColor() throws PDFNetException {
        return ColorPt.__Create(GetBorderColor(__GetHandle()));
    }

    public void setBorderColor(ColorPt colorPt, int i) throws PDFNetException {
        SetBorderColor(__GetHandle(), colorPt.__GetHandle(), i);
        ReachabilityHelper.ensureReachable(colorPt);
    }

    public int getBackgroundColorCompNum() throws PDFNetException {
        return GetBackgroundColorCompNum(__GetHandle());
    }

    public ColorPt getBackgroundColor() throws PDFNetException {
        return ColorPt.__Create(GetBackgroundColor(__GetHandle()));
    }

    public void setBackgroundColor(ColorPt colorPt, int i) throws PDFNetException {
        SetBackgroundColor(__GetHandle(), colorPt.__GetHandle(), i);
        ReachabilityHelper.ensureReachable(colorPt);
    }

    public String getStaticCaptionText() throws PDFNetException {
        return GetStaticCaptionText(__GetHandle());
    }

    public void setStaticCaptionText(String str) throws PDFNetException {
        SetStaticCaptionText(__GetHandle(), str);
    }

    public String getRolloverCaptionText() throws PDFNetException {
        return GetRolloverCaptionText(__GetHandle());
    }

    public void setRolloverCaptionText(String str) throws PDFNetException {
        SetRolloverCaptionText(__GetHandle(), str);
    }

    public String getMouseDownCaptionText() throws PDFNetException {
        return GetMouseDownCaptionText(__GetHandle());
    }

    public void setMouseDownCaptionText(String str) throws PDFNetException {
        SetMouseDownCaptionText(__GetHandle(), str);
    }

    public Obj getStaticIcon() throws PDFNetException {
        return Obj.__Create(GetStaticIcon(__GetHandle()), __GetRefHandle());
    }

    public void setStaticIcon(Obj obj) throws PDFNetException {
        SetStaticIcon(__GetHandle(), obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
    }

    public Obj getRolloverIcon() throws PDFNetException {
        return Obj.__Create(GetRolloverIcon(__GetHandle()), __GetRefHandle());
    }

    public void setRolloverIcon(Obj obj) throws PDFNetException {
        SetRolloverIcon(__GetHandle(), obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
    }

    public Obj getMouseDownIcon() throws PDFNetException {
        return Obj.__Create(GetMouseDownIcon(__GetHandle()), __GetRefHandle());
    }

    public void setMouseDownIcon(Obj obj) throws PDFNetException {
        SetMouseDownIcon(__GetHandle(), obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
    }

    public int getScaleType() throws PDFNetException {
        return GetScaleType(__GetHandle());
    }

    public void setScaleType(int i) throws PDFNetException {
        SetScaleType(__GetHandle(), i);
    }

    public int getIconCaptionRelation() throws PDFNetException {
        return GetIconCaptionRelation(__GetHandle());
    }

    public void setIconCaptionRelation(int i) throws PDFNetException {
        SetIconCaptionRelation(__GetHandle(), i);
    }

    public int getScaleCondition() throws PDFNetException {
        return GetScaleCondition(__GetHandle());
    }

    public void SetScaleCondition(int i) throws PDFNetException {
        SetScaleCondition(__GetHandle(), i);
    }

    public double getHIconLeftOver() throws PDFNetException {
        return GetHIconLeftOver(__GetHandle());
    }

    public void setHIconLeftOver(double d) throws PDFNetException {
        SetHIconLeftOver(__GetHandle(), d);
    }

    public double getVIconLeftOver() throws PDFNetException {
        return GetVIconLeftOver(__GetHandle());
    }

    public void setVIconLeftOver(double d) throws PDFNetException {
        SetVIconLeftOver(__GetHandle(), d);
    }

    public boolean getFitFull() throws PDFNetException {
        return GetFitFull(__GetHandle());
    }

    public void setFitFull(boolean z) throws PDFNetException {
        SetFitFull(__GetHandle(), z);
    }

    public ColorPt getTextColor() throws PDFNetException {
        return ColorPt.__Create(GetTextColor(__GetHandle()));
    }

    public int getTextColorCompNum() throws PDFNetException {
        return GetTextColorCompNum(__GetHandle());
    }

    public void setTextColor(ColorPt colorPt, int i) throws PDFNetException {
        SetTextColor(__GetHandle(), colorPt.__GetHandle(), i);
        ReachabilityHelper.ensureReachable(colorPt);
    }

    public double getFontSize() throws PDFNetException {
        return GetFontSize(__GetHandle());
    }

    public void setFontSize(double d) throws PDFNetException {
        SetFontSize(__GetHandle(), d);
    }

    public Font getFont() throws PDFNetException {
        return Font.__Create(GetFont(__GetHandle()), __GetRefHandle());
    }

    public void setFont(Font font) throws PDFNetException {
        SetFont(__GetHandle(), font.__GetHandle());
        ReachabilityHelper.ensureReachable(font);
    }
}
