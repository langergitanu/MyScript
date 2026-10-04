package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.Point;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Text extends Markup {
    public static final int e_Comment = 0;
    public static final int e_Help = 2;
    public static final int e_Insert = 5;
    public static final int e_Key = 1;
    public static final int e_NewParagraph = 3;
    public static final int e_Note = 6;
    public static final int e_Paragraph = 4;
    public static final int e_Unknown = 7;

    static native long Create(long j, double d, double d2);

    static native long Create(long j, double d, double d2, String str);

    static native double GetAnchorPositionX(long j);

    static native int GetIcon(long j);

    static native String GetIconName(long j);

    static native String GetState(long j);

    static native String GetStateModel(long j);

    static native double SetAnchorPosition(long j, double d, double d2);

    static native void SetIcon(long j, int i);

    static native void SetIcon(long j, String str);

    static native void SetState(long j, String str);

    static native void SetStateModel(long j, String str);

    public Text(Obj obj) {
        super(obj);
    }

    public Text() {
    }

    private Text(long j, Object obj) {
        super(j, obj);
    }

    public Text(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public static Text create(Doc doc, Point point) throws PDFNetException {
        return new Text(Create(doc.__GetHandle(), point.f2001x, point.f2002y), doc);
    }

    public static Text create(Doc doc, Point point, String str) throws PDFNetException {
        return new Text(Create(doc.__GetHandle(), point.f2001x, point.f2002y, str), doc);
    }

    public int getIcon() throws PDFNetException {
        return GetIcon(__GetHandle());
    }

    public String getIconName() throws PDFNetException {
        return GetIconName(__GetHandle());
    }

    public void setIcon(int i) throws PDFNetException {
        SetIcon(__GetHandle(), i);
    }

    public void setIcon(String str) throws PDFNetException {
        SetIcon(__GetHandle(), str);
    }

    public String getState() throws PDFNetException {
        return GetState(__GetHandle());
    }

    public void setState(String str) throws PDFNetException {
        SetState(__GetHandle(), str);
    }

    public String getStateModel() throws PDFNetException {
        return GetStateModel(__GetHandle());
    }

    public Point getAnchorPosition() {
        return new Point(GetAnchorPositionX(__GetHandle()), GetAnchorPositionX(__GetHandle()));
    }

    public void setAnchorPosition(Point point) {
        SetAnchorPosition(__GetHandle(), point.f2001x, point.f2002y);
    }

    public void setStateModel(String str) throws PDFNetException {
        SetStateModel(__GetHandle(), str);
    }
}
