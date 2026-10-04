package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;
import com.pdftron.sdf.ObjSet;

/* JADX INFO: loaded from: classes7.dex */
public class OptionsBase {
    protected Obj mDict;
    protected ObjSet mObjSet;

    public OptionsBase() throws PDFNetException {
        ObjSet objSet = new ObjSet();
        this.mObjSet = objSet;
        this.mDict = objSet.createDict();
    }

    public OptionsBase(String str) throws PDFNetException {
        ObjSet objSet = new ObjSet();
        this.mObjSet = objSet;
        this.mDict = objSet.createFromJson(str);
    }

    /* JADX INFO: renamed from: a */
    long mo1134a() throws PDFNetException {
        return this.mDict.__GetHandle();
    }

    /* JADX INFO: renamed from: a */
    private Obj m1195a(String str) throws PDFNetException {
        Obj objFindObj = this.mDict.findObj(str);
        return objFindObj == null ? this.mDict.putArray(str) : objFindObj;
    }

    /* JADX INFO: renamed from: a */
    static ColorPt m1194a(double d) throws PDFNetException {
        long j = (long) d;
        return new ColorPt(((j >> 16) & 255) / 255.0d, ((j >> 8) & 255) / 255.0d, (j & 255) / 255.0d, ((j >> 24) & 255) / 255.0d);
    }

    /* JADX INFO: renamed from: a */
    static double m1193a(ColorPt colorPt) throws PDFNetException {
        return ((((long) (colorPt.get(0) * 255.0d)) & 255) << 16) | 4278190080L | ((((long) (colorPt.get(1) * 255.0d)) & 255) << 8) | (((long) (colorPt.get(2) * 255.0d)) & 255);
    }

    protected void putNumber(String str, double d) throws PDFNetException {
        this.mDict.putNumber(str, d);
    }

    protected void putBool(String str, Boolean bool) throws PDFNetException {
        this.mDict.putBool(str, bool.booleanValue());
    }

    protected void putText(String str, String str2) throws PDFNetException {
        this.mDict.putText(str, str2);
    }

    protected void putRect(String str, Rect rect) throws PDFNetException {
        this.mDict.putRect(str, rect.getX1(), rect.getY1(), rect.getX2(), rect.getY2());
    }

    protected void pushBackNumber(String str, double d) throws PDFNetException {
        m1195a(str).pushBackNumber(d);
    }

    protected void pushBackBool(String str, Boolean bool) throws PDFNetException {
        m1195a(str).pushBackBool(bool.booleanValue());
    }

    protected void pushBackText(String str, String str2) throws PDFNetException {
        m1195a(str).pushBackText(str2);
    }

    protected void pushBackRect(String str, Rect rect) throws PDFNetException {
        m1195a(str).pushBackRect(rect.getX1(), rect.getY1(), rect.getX2(), rect.getY2());
    }

    protected void insertRectCollection(String str, RectCollection rectCollection, int i) throws PDFNetException {
        Obj objM1195a = m1195a(str);
        while (objM1195a.size() <= i) {
            objM1195a.pushBackArray();
        }
        Obj at = objM1195a.getAt(i);
        for (int i2 = 0; i2 < rectCollection.getNumRects(); i2++) {
            Rect rectAt = rectCollection.getRectAt(i2);
            at.pushBackRect(rectAt.getX1(), rectAt.getY1(), rectAt.getX2(), rectAt.getY2());
        }
    }

    protected static Rect rectFromArray(Obj obj) throws PDFNetException {
        return new Rect(obj.getAt(0).getNumber(), obj.getAt(1).getNumber(), obj.getAt(2).getNumber(), obj.getAt(3).getNumber());
    }
}
