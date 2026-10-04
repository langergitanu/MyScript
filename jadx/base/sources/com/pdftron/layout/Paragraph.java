package com.pdftron.layout;

import com.pdftron.common.PDFNetException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public class Paragraph extends ContentNode {
    public static native void AddTabStop(long j, double d) throws PDFNetException;

    static native long AddText(long j, String str) throws PDFNetException;

    public static native double GetBorderThickness(long j) throws PDFNetException;

    public static native double GetDefaultTabStop(long j) throws PDFNetException;

    public static native double GetEndIndent(long j) throws PDFNetException;

    static native int GetJustificationMode(long j) throws PDFNetException;

    public static native double GetNextTabStop(long j, double d) throws PDFNetException;

    static native double GetSpaceAfter(long j) throws PDFNetException;

    static native double GetSpaceBefore(long j) throws PDFNetException;

    public static native int GetSpacesPerTab(long j) throws PDFNetException;

    public static native double GetStartIndent(long j) throws PDFNetException;

    public static native double GetTextIndent(long j) throws PDFNetException;

    public static native boolean IsDisplayRtl(long j) throws PDFNetException;

    public static native void SetBorder(long j, double d, int i, int i2, int i3) throws PDFNetException;

    public static native void SetDefaultTabStop(long j, double d) throws PDFNetException;

    public static native void SetDisplayRtl(long j, boolean z) throws PDFNetException;

    public static native void SetEndIndent(long j, double d) throws PDFNetException;

    static native void SetJustificationMode(long j, int i) throws PDFNetException;

    static native void SetSpaceAfter(long j, double d) throws PDFNetException;

    static native void SetSpaceBefore(long j, double d) throws PDFNetException;

    public static native void SetSpacesPerTab(long j, int i) throws PDFNetException;

    public static native void SetStartIndent(long j, double d) throws PDFNetException;

    public static native void SetTextIndent(long j, double d) throws PDFNetException;

    public enum TextJustification {
        e_text_justification_invalid(0),
        e_text_justify_left(1),
        e_text_justify_right(2),
        e_text_justify_center(3);


        /* JADX INFO: renamed from: b */
        private static HashMap<Integer, TextJustification> f1426b = new HashMap<>();

        /* JADX INFO: renamed from: a */
        private int f1428a;

        static {
            for (TextJustification textJustification : values()) {
                f1426b.put(Integer.valueOf(textJustification.f1428a), textJustification);
            }
        }

        TextJustification(int i) {
            this.f1428a = i;
        }
    }

    Paragraph(long j) {
        super(j);
    }

    public TextRun addText(String str) throws PDFNetException {
        return new TextRun(AddText(this.mImpl, str));
    }

    public void setSpaceBefore(double d) throws PDFNetException {
        SetSpaceBefore(this.mImpl, d);
    }

    public double getSpaceBefore() throws PDFNetException {
        return GetSpaceBefore(this.mImpl);
    }

    public void setSpaceAfter(double d) throws PDFNetException {
        SetSpaceAfter(this.mImpl, d);
    }

    public double getSpaceAfter() throws PDFNetException {
        return GetSpaceAfter(this.mImpl);
    }

    /* JADX INFO: renamed from: com.pdftron.layout.Paragraph$1 */
    static /* synthetic */ class C69271 {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f1425a;

        static {
            int[] iArr = new int[TextJustification.values().length];
            f1425a = iArr;
            try {
                iArr[TextJustification.e_text_justification_invalid.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1425a[TextJustification.e_text_justify_left.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1425a[TextJustification.e_text_justify_right.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1425a[TextJustification.e_text_justify_center.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0018 A[PHI: r1
      0x0018: PHI (r1v2 int) = (r1v0 int), (r1v3 int) binds: [B:5:0x000d, B:9:0x0013] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setJustificationMode(TextJustification textJustification) throws PDFNetException {
        int i = C69271.f1425a[textJustification.ordinal()];
        int i2 = 0;
        int i3 = 1;
        if (i != 1) {
            if (i != 2) {
                i3 = 3;
                if (i == 3) {
                    i2 = 2;
                } else if (i == 4) {
                    i2 = i3;
                }
            }
        }
        SetJustificationMode(this.mImpl, i2);
    }

    public TextJustification getJustificationMode() throws PDFNetException {
        int iGetJustificationMode = GetJustificationMode(this.mImpl);
        if (iGetJustificationMode == 1) {
            return TextJustification.e_text_justify_left;
        }
        if (iGetJustificationMode == 2) {
            return TextJustification.e_text_justify_right;
        }
        if (iGetJustificationMode != 3) {
            return TextJustification.e_text_justification_invalid;
        }
        return TextJustification.e_text_justify_center;
    }

    public void setStartIndent(double d) throws PDFNetException {
        SetStartIndent(this.mImpl, d);
    }

    public double getStartIndent() throws PDFNetException {
        return GetStartIndent(this.mImpl);
    }

    public void setEndIndent(double d) throws PDFNetException {
        SetEndIndent(this.mImpl, d);
    }

    public double getEndIndent() throws PDFNetException {
        return GetEndIndent(this.mImpl);
    }

    public void setTextIndent(double d) throws PDFNetException {
        SetTextIndent(this.mImpl, d);
    }

    public double getTextIndent() throws PDFNetException {
        return GetTextIndent(this.mImpl);
    }

    public void setBorder(double d, int i, int i2, int i3) throws PDFNetException {
        SetBorder(this.mImpl, d, i, i2, i3);
    }

    public double getBorderThickness() throws PDFNetException {
        return GetBorderThickness(this.mImpl);
    }

    public void addTabStop(double d) throws PDFNetException {
        AddTabStop(this.mImpl, d);
    }

    public double getNextTabStop(double d) throws PDFNetException {
        return GetNextTabStop(this.mImpl, d);
    }

    public void setDefaultTabStop(double d) throws PDFNetException {
        SetDefaultTabStop(this.mImpl, d);
    }

    public double getDefaultTabStop() throws PDFNetException {
        return GetDefaultTabStop(this.mImpl);
    }

    public void setSpacesPerTab(int i) throws PDFNetException {
        SetSpacesPerTab(this.mImpl, i);
    }

    public int getSpacesPerTab() throws PDFNetException {
        return GetSpacesPerTab(this.mImpl);
    }

    public void setDisplayRtl(boolean z) throws PDFNetException {
        SetDisplayRtl(this.mImpl, z);
    }

    public boolean isDisplayRtl() throws PDFNetException {
        return IsDisplayRtl(this.mImpl);
    }
}
