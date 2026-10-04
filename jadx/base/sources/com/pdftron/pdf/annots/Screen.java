package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Action;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.ColorPt;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Screen extends Annot {
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

    static native long Create(long j, long j2);

    static native long GetAction(long j);

    static native long GetBackgroundColor(long j);

    static native int GetBackgroundColorCompNum(long j);

    static native long GetBorderColor(long j);

    static native int GetBorderColorCompNum(long j);

    static native boolean GetFitFull(long j);

    static native double GetHIconLeftOver(long j);

    static native int GetIconCaptionRelation(long j);

    static native String GetMouseDownCaptionText(long j);

    static native long GetMouseDownIcon(long j);

    static native String GetRolloverCaptionText(long j);

    static native long GetRolloverIcon(long j);

    static native int GetScaleCondition(long j);

    static native int GetScaleType(long j);

    static native String GetStaticCaptionText(long j);

    static native long GetStaticIcon(long j);

    static native String GetTitle(long j);

    static native double GetVIconLeftOver(long j);

    static native void SetAction(long j, long j2);

    static native void SetBackgroundColor(long j, long j2, int i);

    static native void SetBorderColor(long j, long j2, int i);

    static native void SetFitFull(long j, boolean z);

    static native void SetHIconLeftOver(long j, double d);

    static native void SetIconCaptionRelation(long j, int i);

    static native void SetMouseDownCaptionText(long j, String str);

    static native void SetMouseDownIcon(long j, long j2);

    static native void SetRolloverCaptionText(long j, String str);

    static native void SetRolloverIcon(long j, long j2);

    static native void SetScaleCondition(long j, int i);

    static native void SetScaleType(long j, int i);

    static native void SetStaticCaptionText(long j, String str);

    static native void SetStaticIcon(long j, long j2);

    static native void SetTitle(long j, String str);

    static native void SetVIconLeftOver(long j, double d);

    public Screen(Obj obj) {
        super(obj);
    }

    public Screen() {
    }

    private Screen(long j, Object obj) {
        super(j, obj);
    }

    public Screen(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public static Screen create(Doc doc, Rect rect) throws PDFNetException {
        Screen screen = new Screen(Create(doc.__GetHandle(), rect.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        return screen;
    }

    public Action getAction() throws PDFNetException {
        return Action.__Create(GetAction(__GetHandle()), __GetRefHandle());
    }

    public String getTitle() throws PDFNetException {
        return GetTitle(__GetHandle());
    }

    public void setTitle(String str) throws PDFNetException {
        SetTitle(__GetHandle(), str);
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
}
