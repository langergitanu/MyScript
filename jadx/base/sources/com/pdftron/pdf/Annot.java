package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Annot {
    public static final int e_3D = 24;
    public static final int e_Caret = 13;
    public static final int e_Circle = 5;
    public static final int e_FileAttachment = 16;
    public static final int e_FreeText = 2;
    public static final int e_Highlight = 8;
    public static final int e_Ink = 14;
    public static final int e_Line = 3;
    public static final int e_Link = 1;
    public static final int e_Movie = 18;
    public static final int e_Polygon = 6;
    public static final int e_Polyline = 7;
    public static final int e_Popup = 15;
    public static final int e_PrinterMark = 21;
    public static final int e_Projection = 26;
    public static final int e_Redact = 25;
    public static final int e_RichMedia = 27;
    public static final int e_Screen = 20;
    public static final int e_Sound = 17;
    public static final int e_Square = 4;
    public static final int e_Squiggly = 10;
    public static final int e_Stamp = 12;
    public static final int e_StrikeOut = 11;
    public static final int e_Text = 0;
    public static final int e_TrapNet = 22;
    public static final int e_Underline = 9;
    public static final int e_Unknown = 28;
    public static final int e_Watermark = 23;
    public static final int e_Widget = 19;
    public static final int e_action_trigger_activate = 0;
    public static final int e_action_trigger_annot_blur = 6;
    public static final int e_action_trigger_annot_down = 3;
    public static final int e_action_trigger_annot_enter = 1;
    public static final int e_action_trigger_annot_exit = 2;
    public static final int e_action_trigger_annot_focus = 5;
    public static final int e_action_trigger_annot_page_close = 8;
    public static final int e_action_trigger_annot_page_invisible = 10;
    public static final int e_action_trigger_annot_page_open = 7;
    public static final int e_action_trigger_annot_page_visible = 9;
    public static final int e_action_trigger_annot_up = 4;
    public static final int e_down = 2;
    public static final int e_hidden = 1;
    public static final int e_invisible = 0;
    public static final int e_locked = 7;
    public static final int e_locked_contents = 9;
    public static final int e_no_rotate = 4;
    public static final int e_no_view = 5;
    public static final int e_no_zoom = 3;
    public static final int e_normal = 0;
    public static final int e_print = 2;
    public static final int e_read_only = 6;
    public static final int e_rollover = 1;
    public static final int e_toggle_no_view = 8;

    /* JADX INFO: renamed from: a */
    long f1439a;

    /* JADX INFO: renamed from: b */
    private Object f1440b;

    static native double[] BSGetDash(long j);

    static native int BSGetHR(long j);

    static native int BSGetStyle(long j);

    static native int BSGetVR(long j);

    static native double BSGetWidth(long j);

    static native void BSSetDash(long j, double[] dArr);

    static native void BSSetHR(long j, int i);

    static native void BSSetStyle(long j, int i);

    static native void BSSetVR(long j, int i);

    static native void BSSetWidth(long j, double d);

    static native long BorderStyleCreate(int i, int i2, int i3, int i4);

    static native long BorderStyleCreate(int i, int i2, int i3, int i4, double[] dArr);

    static native void BorderStyleDestroy(long j);

    static native long Create(long j, int i, long j2);

    static native void DeleteCustomData(long j, String str);

    static native void Flatten(long j, long j2);

    static native String GetActiveAppearanceState(long j);

    static native long GetAppearance(long j, int i, String str);

    static native long GetBorderStyle(long j);

    static native long GetColorAsCMYK(long j);

    static native long GetColorAsGray(long j);

    static native long GetColorAsRGB(long j);

    static native int GetColorCompNum(long j);

    static native String GetContents(long j);

    static native String GetCustomData(long j, String str);

    static native long GetDate(long j);

    static native boolean GetFlag(long j, int i);

    static native long GetOptionalContent(long j);

    static native long GetPage(long j);

    static native long GetRect(long j);

    static native int GetRotation(long j);

    static native int GetStructParent(long j);

    static native long GetTriggerAction(long j, int i);

    static native int GetType(long j);

    static native long GetUniqueID(long j);

    static native long GetVisibleContentBox(long j);

    static native boolean IsMarkup(long j);

    static native boolean IsValid(long j);

    static native void RefreshAppearance(long j);

    static native void RefreshAppearanceRefreshOptions(long j, long j2);

    static native void RemoveAppearance(long j, int i, String str);

    static native void Resize(long j, long j2);

    static native void SetActiveAppearanceState(long j, String str);

    static native void SetAppearance(long j, long j2, int i, String str);

    static native void SetBorderStyle(long j, long j2);

    static native void SetColor(long j, long j2, int i);

    static native void SetContents(long j, String str);

    static native void SetCustomData(long j, String str, String str2);

    static native void SetDate(long j, long j2);

    static native void SetDateToNow(long j);

    static native void SetFlag(long j, int i, boolean z);

    static native void SetOptionalContent(long j, long j2);

    static native long SetPage(long j, long j2);

    static native void SetRect(long j, long j2);

    static native void SetRotation(long j, int i);

    static native void SetStructParent(long j, int i);

    static native void SetUniqueID(long j, String str);

    public static Annot create(Doc doc, int i, Rect rect) throws PDFNetException {
        Annot annot = new Annot(Create(doc.__GetHandle(), i, rect.f2037a), doc);
        ReachabilityHelper.ensureReachable(doc);
        ReachabilityHelper.ensureReachable(rect);
        return annot;
    }

    public Annot(Obj obj) {
        this.f1439a = obj.__GetHandle();
        this.f1440b = obj.__GetRefHandle();
    }

    public Annot() {
        this.f1439a = 0L;
        this.f1440b = null;
    }

    public Obj getTriggerAction(int i) throws PDFNetException {
        return Obj.__Create(GetTriggerAction(this.f1439a, i), this.f1440b);
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof Annot) && this.f1439a == ((Annot) obj).f1439a;
    }

    public int hashCode() {
        return (int) this.f1439a;
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.f1439a);
    }

    public Obj getSDFObj() throws PDFNetException {
        return Obj.__Create(this.f1439a, this.f1440b);
    }

    public int getType() throws PDFNetException {
        return GetType(this.f1439a);
    }

    public boolean isMarkup() throws PDFNetException {
        return IsMarkup(this.f1439a);
    }

    public String getContents() throws PDFNetException {
        return GetContents(this.f1439a);
    }

    public void setContents(String str) throws PDFNetException {
        SetContents(this.f1439a, str);
    }

    public Rect getRect() throws PDFNetException {
        return new Rect(GetRect(this.f1439a));
    }

    public Rect getVisibleContentBox() throws PDFNetException {
        return new Rect(GetVisibleContentBox(this.f1439a));
    }

    public void setRect(Rect rect) throws PDFNetException {
        SetRect(this.f1439a, rect.f2037a);
        ReachabilityHelper.ensureReachable(rect);
    }

    public Page getPage() throws PDFNetException {
        return new Page(GetPage(this.f1439a), this.f1440b);
    }

    public void setPage(Page page) throws PDFNetException {
        SetPage(this.f1439a, page.f1990a);
        ReachabilityHelper.ensureReachable(page);
    }

    public Obj getUniqueID() throws PDFNetException {
        return Obj.__Create(GetUniqueID(this.f1439a), this.f1440b);
    }

    public void setUniqueID(String str) throws PDFNetException {
        SetUniqueID(this.f1439a, str);
    }

    public Date getDate() throws PDFNetException {
        return new Date(GetDate(this.f1439a));
    }

    public void setDate(Date date) throws PDFNetException {
        SetDate(this.f1439a, date.f1515a);
        ReachabilityHelper.ensureReachable(date);
    }

    public void setDateToNow() throws PDFNetException {
        SetDateToNow(this.f1439a);
    }

    public boolean getFlag(int i) throws PDFNetException {
        return GetFlag(this.f1439a, i);
    }

    public void setFlag(int i, boolean z) throws PDFNetException {
        SetFlag(this.f1439a, i, z);
    }

    public static class BorderStyle implements AutoCloseable {
        public static final int e_beveled = 2;
        public static final int e_dashed = 1;
        public static final int e_inset = 3;
        public static final int e_solid = 0;
        public static final int e_underline = 4;

        /* JADX INFO: renamed from: a */
        long f1441a;

        public BorderStyle(int i, int i2, int i3, int i4) throws PDFNetException {
            this.f1441a = Annot.BorderStyleCreate(i, i2, i3, i4);
        }

        public BorderStyle(int i, int i2, int i3, int i4, double[] dArr) throws PDFNetException {
            this.f1441a = Annot.BorderStyleCreate(i, i2, i3, i4, dArr);
        }

        public void destroy() throws PDFNetException {
            long j = this.f1441a;
            if (j != 0) {
                Annot.BorderStyleDestroy(j);
                this.f1441a = 0L;
            }
        }

        protected void finalize() throws Throwable {
            destroy();
        }

        public int getStyle() throws PDFNetException {
            return Annot.BSGetStyle(this.f1441a);
        }

        public void setStyle(int i) throws PDFNetException {
            Annot.BSSetStyle(this.f1441a, i);
        }

        public int getHR() throws PDFNetException {
            return Annot.BSGetHR(this.f1441a);
        }

        public void setHR(int i) throws PDFNetException {
            Annot.BSSetHR(this.f1441a, i);
        }

        public int getVR() throws PDFNetException {
            return Annot.BSGetVR(this.f1441a);
        }

        public void setVR(int i) throws PDFNetException {
            Annot.BSSetVR(this.f1441a, i);
        }

        public double getWidth() throws PDFNetException {
            return Annot.BSGetWidth(this.f1441a);
        }

        public void setWidth(double d) throws PDFNetException {
            Annot.BSSetWidth(this.f1441a, d);
        }

        public double[] getDash() throws PDFNetException {
            return Annot.BSGetDash(this.f1441a);
        }

        public void setDash(double[] dArr) throws PDFNetException {
            Annot.BSSetDash(this.f1441a, dArr);
        }

        BorderStyle(long j) {
            this.f1441a = j;
        }

        @Override // java.lang.AutoCloseable
        public void close() throws PDFNetException {
            destroy();
        }
    }

    public BorderStyle getBorderStyle() throws PDFNetException {
        return new BorderStyle(GetBorderStyle(this.f1439a));
    }

    public void setBorderStyle(BorderStyle borderStyle) throws PDFNetException {
        SetBorderStyle(this.f1439a, borderStyle.f1441a);
        ReachabilityHelper.ensureReachable(borderStyle);
    }

    public Obj getAppearance() throws PDFNetException {
        return Obj.__Create(GetAppearance(this.f1439a, 0, null), this.f1440b);
    }

    public Obj getAppearance(int i) throws PDFNetException {
        return Obj.__Create(GetAppearance(this.f1439a, i, null), this.f1440b);
    }

    public Obj getAppearance(int i, String str) throws PDFNetException {
        return Obj.__Create(GetAppearance(this.f1439a, i, str), this.f1440b);
    }

    public void setAppearance(Obj obj) throws PDFNetException {
        SetAppearance(this.f1439a, obj.__GetHandle(), 0, null);
        ReachabilityHelper.ensureReachable(obj);
    }

    public void removeAppearance() throws PDFNetException {
        RemoveAppearance(this.f1439a, 0, null);
    }

    public void removeAppearance(int i, String str) throws PDFNetException {
        RemoveAppearance(this.f1439a, i, str);
    }

    public void setAppearance(Obj obj, int i) throws PDFNetException {
        SetAppearance(this.f1439a, obj.__GetHandle(), i, null);
        ReachabilityHelper.ensureReachable(obj);
    }

    public void setAppearance(Obj obj, int i, String str) throws PDFNetException {
        SetAppearance(this.f1439a, obj.__GetHandle(), i, str);
        ReachabilityHelper.ensureReachable(obj);
    }

    public void flatten(Page page) throws PDFNetException {
        Flatten(this.f1439a, page.f1990a);
        ReachabilityHelper.ensureReachable(page);
    }

    public String getActiveAppearanceState() throws PDFNetException {
        return GetActiveAppearanceState(this.f1439a);
    }

    public void setActiveAppearanceState(String str) throws PDFNetException {
        SetActiveAppearanceState(this.f1439a, str);
    }

    public ColorPt getColorAsRGB() throws PDFNetException {
        return new ColorPt(GetColorAsRGB(this.f1439a));
    }

    public ColorPt getColorAsCMYK() throws PDFNetException {
        return new ColorPt(GetColorAsCMYK(this.f1439a));
    }

    public ColorPt getColorAsGray() throws PDFNetException {
        return new ColorPt(GetColorAsGray(this.f1439a));
    }

    public int getColorCompNum() throws PDFNetException {
        return GetColorCompNum(this.f1439a);
    }

    public void setColor(ColorPt colorPt) throws PDFNetException {
        setColor(colorPt, 3);
    }

    public void setColor(ColorPt colorPt, int i) throws PDFNetException {
        SetColor(this.f1439a, colorPt.f1458a, i);
        ReachabilityHelper.ensureReachable(colorPt);
    }

    public int GetStructParent() throws PDFNetException {
        return GetStructParent(this.f1439a);
    }

    public void setStructParent(int i) throws PDFNetException {
        SetStructParent(this.f1439a, i);
    }

    public Obj getOptionalContent() throws PDFNetException {
        return Obj.__Create(GetOptionalContent(this.f1439a), this.f1440b);
    }

    public void setOptionalContent(Obj obj) throws PDFNetException {
        SetOptionalContent(this.f1439a, obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
    }

    public int getRotation() throws PDFNetException {
        return GetRotation(this.f1439a);
    }

    public void setRotation(int i) throws PDFNetException {
        SetRotation(this.f1439a, i);
    }

    public void refreshAppearance() throws PDFNetException {
        RefreshAppearance(this.f1439a);
    }

    public void refreshAppearance(RefreshOptions refreshOptions) throws PDFNetException {
        RefreshAppearanceRefreshOptions(this.f1439a, refreshOptions != null ? refreshOptions.mo1134a() : 0L);
        ReachabilityHelper.ensureReachable(refreshOptions);
    }

    public String getCustomData(String str) throws PDFNetException {
        return GetCustomData(this.f1439a, str);
    }

    public void setCustomData(String str, String str2) throws PDFNetException {
        SetCustomData(this.f1439a, str, str2);
    }

    public void deleteCustomData(String str) throws PDFNetException {
        DeleteCustomData(this.f1439a, str);
    }

    public void resize(Rect rect) throws PDFNetException {
        Resize(this.f1439a, rect.f2037a);
        ReachabilityHelper.ensureReachable(rect);
    }

    protected Annot(long j, Object obj) {
        this.f1439a = j;
        this.f1440b = obj;
    }

    public static Annot __Create(long j, Object obj) {
        if (j == 0) {
            return null;
        }
        return new Annot(j, obj);
    }

    public long __GetHandle() {
        return this.f1439a;
    }

    public Object __GetRefHandle() {
        return this.f1440b;
    }
}
