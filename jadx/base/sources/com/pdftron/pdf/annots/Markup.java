package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.ColorPt;
import com.pdftron.pdf.Date;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Markup extends Annot {
    public static final int e_Cloudy = 1;
    public static final int e_None = 0;

    static native int GetBorderEffect(long j);

    static native double GetBorderEffectIntensity(long j);

    static native long GetContentRect(long j);

    static native long GetCreationDates(long j);

    static native long GetInteriorColor(long j);

    static native int GetInteriorColorCompNum(long j);

    static native double GetOpacity(long j);

    static native long GetPadding(long j);

    static native long GetPopup(long j);

    static native String GetSubject(long j);

    static native String GetTitle(long j);

    static native void RotateAppearance(long j, double d);

    static native void SetBorderEffect(long j, int i);

    static native void SetBorderEffectIntensity(long j, double d);

    static native void SetContentRect(long j, long j2);

    static native void SetCreationDates(long j, long j2);

    static native void SetInteriorColor(long j, long j2, int i);

    static native void SetOpacity(long j, double d);

    static native void SetPadding(long j, long j2);

    static native void SetPopup(long j, long j2);

    static native void SetSubject(long j, String str);

    static native void SetTitle(long j, String str);

    public Markup(Obj obj) {
        super(obj);
    }

    public Markup() {
    }

    Markup(long j, Object obj) {
        super(j, obj);
    }

    public Markup(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public String getTitle() throws PDFNetException {
        return GetTitle(__GetHandle());
    }

    public void setTitle(String str) throws PDFNetException {
        SetTitle(__GetHandle(), str);
    }

    public Popup getPopup() throws PDFNetException {
        return new Popup(GetPopup(__GetHandle()), __GetRefHandle());
    }

    public void setPopup(Popup popup) throws PDFNetException {
        SetPopup(__GetHandle(), popup.__GetHandle());
        ReachabilityHelper.ensureReachable(popup);
    }

    public double getOpacity() throws PDFNetException {
        return GetOpacity(__GetHandle());
    }

    public void setOpacity(double d) throws PDFNetException {
        SetOpacity(__GetHandle(), d);
    }

    public String getSubject() throws PDFNetException {
        return GetSubject(__GetHandle());
    }

    public void setSubject(String str) throws PDFNetException {
        SetSubject(__GetHandle(), str);
    }

    public Date getCreationDates() throws PDFNetException {
        return Date.__Create(GetCreationDates(__GetHandle()));
    }

    public void setCreationDates(Date date) throws PDFNetException {
        SetCreationDates(__GetHandle(), date.__GetHandle());
        ReachabilityHelper.ensureReachable(date);
    }

    public int getBorderEffect() throws PDFNetException {
        return GetBorderEffect(__GetHandle());
    }

    public void setBorderEffect(int i) throws PDFNetException {
        SetBorderEffect(__GetHandle(), i);
    }

    public double getBorderEffectIntensity() throws PDFNetException {
        return GetBorderEffectIntensity(__GetHandle());
    }

    public void setBorderEffectIntensity(double d) throws PDFNetException {
        SetBorderEffectIntensity(__GetHandle(), d);
    }

    public ColorPt getInteriorColor() throws PDFNetException {
        return ColorPt.__Create(GetInteriorColor(__GetHandle()));
    }

    public int getInteriorColorCompNum() throws PDFNetException {
        return GetInteriorColorCompNum(__GetHandle());
    }

    public void setInteriorColor(ColorPt colorPt, int i) throws PDFNetException {
        SetInteriorColor(__GetHandle(), colorPt.__GetHandle(), i);
        ReachabilityHelper.ensureReachable(colorPt);
    }

    public Rect getContentRect() throws PDFNetException {
        return Rect.__Create(GetContentRect(__GetHandle()));
    }

    public void setContentRect(Rect rect) throws PDFNetException {
        SetContentRect(__GetHandle(), rect.__GetHandle());
        ReachabilityHelper.ensureReachable(rect);
    }

    public Rect getPadding() throws PDFNetException {
        return Rect.__Create(GetPadding(__GetHandle()));
    }

    public void setPadding(Rect rect) throws PDFNetException {
        SetPadding(__GetHandle(), rect.__GetHandle());
        ReachabilityHelper.ensureReachable(rect);
    }

    public void setPadding(double d) throws PDFNetException {
        setPadding(new Rect(d, d, d, d));
    }

    public void rotateAppearance(double d) throws PDFNetException {
        RotateAppearance(__GetHandle(), d);
    }
}
