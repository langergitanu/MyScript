package com.pdftron.pdf;

import com.pdftron.common.Matrix2D;
import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;
import java.io.InputStream;

/* JADX INFO: loaded from: classes7.dex */
public class Font {
    public static final int e_CIDType0 = 5;
    public static final int e_CIDType2 = 6;
    public static final int e_IdentityH = 0;
    public static final int e_Indices = 1;
    public static final int e_MMType1 = 2;
    public static final int e_TrueType = 1;
    public static final int e_Type0 = 4;
    public static final int e_Type1 = 0;
    public static final int e_Type3 = 3;
    public static final int e_courier = 8;
    public static final int e_courier_bold = 9;
    public static final int e_courier_bold_oblique = 11;
    public static final int e_courier_oblique = 10;
    public static final int e_helvetica = 4;
    public static final int e_helvetica_bold = 5;
    public static final int e_helvetica_bold_oblique = 7;
    public static final int e_helvetica_oblique = 6;
    public static final int e_null = 14;
    public static final int e_symbol = 12;
    public static final int e_times_bold = 1;
    public static final int e_times_bold_italic = 3;
    public static final int e_times_italic = 2;
    public static final int e_times_roman = 0;
    public static final int e_zapf_dingbats = 13;

    /* JADX INFO: renamed from: a */
    long f1556a;

    /* JADX INFO: renamed from: b */
    Object f1557b;

    static native long Create(long j, int i, boolean z);

    static native long Create(long j, long j2, String str);

    static native long Create(long j, String str, String str2);

    static native long CreateCIDTrueTypeFont(long j, String str, boolean z, boolean z2, int i, long j2);

    static native long CreateCIDTrueTypeFontFromStream(long j, InputStream inputStream, boolean z, boolean z2, int i, long j2);

    static native long CreateTrueTypeFont(long j, String str, boolean z, boolean z2);

    static native long CreateTrueTypeFontFromStream(long j, InputStream inputStream, boolean z, boolean z2);

    static native long CreateType1Font(long j, String str, boolean z);

    static native double GetAscent(long j);

    static native long GetBBox(long j);

    static native long GetCharCodeIterator(long j);

    static native double GetDescent(long j);

    static native long GetDescriptor(long j);

    static native long GetEmbeddedFont(long j);

    static native int GetEmbeddedFontBufSize(long j);

    static native String GetEmbeddedFontName(long j);

    static native String[] GetEncoding(long j);

    static native String GetFamilyName(long j);

    static native PathData GetGlyphPath(long j, long j2, boolean z, long j3);

    static native double GetMaxWidth(long j);

    static native double GetMissingWidth(long j);

    static native String GetName(long j);

    static native long GetShapedText(long j, String str);

    static native int GetStandardType1FontType(long j);

    static native int GetType(long j);

    static native long GetType3FontMatrix(long j);

    static native long GetType3GlyphStream(long j, long j2);

    static native int GetTypeStatic(long j);

    static native short GetUnitsPerEm(long j);

    static native double GetWidth(long j, long j2);

    static native boolean IsAllCap(long j);

    static native boolean IsCFF(long j);

    static native boolean IsEmbedded(long j);

    static native boolean IsFixedWidth(long j);

    static native boolean IsForceBold(long j);

    static native boolean IsHorizontalMode(long j);

    static native boolean IsItalic(long j);

    static native boolean IsSerif(long j);

    static native boolean IsSimple(long j);

    static native boolean IsSymbolic(long j);

    static native char[] MapToUnicode(long j, long j2);

    public Font() {
        this.f1556a = 0L;
        this.f1557b = null;
    }

    public Font(Obj obj) {
        this.f1556a = obj.__GetHandle();
        this.f1557b = obj.__GetRefHandle();
    }

    public static Font create(Doc doc, int i) throws PDFNetException {
        return __Create(Create(doc.__GetHandle(), i, false), doc);
    }

    public static Font create(Doc doc, int i, boolean z) throws PDFNetException {
        return __Create(Create(doc.__GetHandle(), i, z), doc);
    }

    public static Font create(Doc doc, Font font, String str) throws PDFNetException {
        Font font__Create = __Create(Create(doc.__GetHandle(), font.f1556a, str), doc);
        ReachabilityHelper.ensureReachable(font);
        return font__Create;
    }

    public static Font create(Doc doc, String str, String str2) throws PDFNetException {
        return __Create(Create(doc.__GetHandle(), str, str2), doc);
    }

    public static Font createTrueTypeFont(Doc doc, String str) throws PDFNetException {
        return __Create(CreateTrueTypeFont(doc.__GetHandle(), str, true, true), doc);
    }

    public static Font createTrueTypeFont(Doc doc, InputStream inputStream) throws PDFNetException {
        return __Create(CreateTrueTypeFontFromStream(doc.__GetHandle(), inputStream, true, true), doc);
    }

    public static Font createTrueTypeFont(Doc doc, String str, boolean z) throws PDFNetException {
        return __Create(CreateTrueTypeFont(doc.__GetHandle(), str, z, true), doc);
    }

    public static Font createTrueTypeFont(Doc doc, InputStream inputStream, boolean z) throws PDFNetException {
        return __Create(CreateTrueTypeFontFromStream(doc.__GetHandle(), inputStream, z, true), doc);
    }

    public static Font createTrueTypeFont(Doc doc, String str, boolean z, boolean z2) throws PDFNetException {
        return __Create(CreateTrueTypeFont(doc.__GetHandle(), str, z, z2), doc);
    }

    public static Font createTrueTypeFont(Doc doc, InputStream inputStream, boolean z, boolean z2) throws PDFNetException {
        return __Create(CreateTrueTypeFontFromStream(doc.__GetHandle(), inputStream, z, z2), doc);
    }

    public static Font createCIDTrueTypeFont(Doc doc, String str) throws PDFNetException {
        return __Create(CreateCIDTrueTypeFont(doc.__GetHandle(), str, true, true, 0, 0L), doc);
    }

    public static Font createCIDTrueTypeFont(Doc doc, InputStream inputStream) throws PDFNetException {
        return __Create(CreateCIDTrueTypeFontFromStream(doc.__GetHandle(), inputStream, true, true, 0, 0L), doc);
    }

    public static Font createCIDTrueTypeFont(Doc doc, String str, boolean z, boolean z2) throws PDFNetException {
        return __Create(CreateCIDTrueTypeFont(doc.__GetHandle(), str, z, z2, 0, 0L), doc);
    }

    public static Font createCIDTrueTypeFont(Doc doc, InputStream inputStream, boolean z, boolean z2) throws PDFNetException {
        return __Create(CreateCIDTrueTypeFontFromStream(doc.__GetHandle(), inputStream, z, z2, 0, 0L), doc);
    }

    public static Font createCIDTrueTypeFont(Doc doc, String str, boolean z, boolean z2, int i) throws PDFNetException {
        return __Create(CreateCIDTrueTypeFont(doc.__GetHandle(), str, z, z2, i, 0L), doc);
    }

    public static Font createCIDTrueTypeFont(Doc doc, InputStream inputStream, boolean z, boolean z2, int i) throws PDFNetException {
        return __Create(CreateCIDTrueTypeFontFromStream(doc.__GetHandle(), inputStream, z, z2, i, 0L), doc);
    }

    public static Font createCIDTrueTypeFont(Doc doc, String str, boolean z, boolean z2, int i, long j) throws PDFNetException {
        return __Create(CreateCIDTrueTypeFont(doc.__GetHandle(), str, z, z2, i, j), doc);
    }

    public static Font createCIDTrueTypeFont(Doc doc, InputStream inputStream, boolean z, boolean z2, int i, long j) throws PDFNetException {
        return __Create(CreateCIDTrueTypeFontFromStream(doc.__GetHandle(), inputStream, z, z2, i, j), doc);
    }

    public static Font createType1Font(Doc doc, String str) throws PDFNetException {
        return __Create(CreateType1Font(doc.__GetHandle(), str, true), doc);
    }

    public static Font createType1Font(Doc doc, String str, boolean z) throws PDFNetException {
        return __Create(CreateType1Font(doc.__GetHandle(), str, z), doc);
    }

    public int getType() throws PDFNetException {
        return GetType(this.f1556a);
    }

    public boolean isSimple() throws PDFNetException {
        return IsSimple(this.f1556a);
    }

    public static int getType(Obj obj) throws PDFNetException {
        int iGetTypeStatic = GetTypeStatic(obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
        return iGetTypeStatic;
    }

    public Obj GetSDFObj() {
        return Obj.__Create(this.f1556a, this.f1557b);
    }

    public Obj GetDescriptor() throws PDFNetException {
        return Obj.__Create(GetDescriptor(this.f1556a), this.f1557b);
    }

    public String getName() throws PDFNetException {
        return GetName(this.f1556a);
    }

    public String getFamilyName() throws PDFNetException {
        return GetFamilyName(this.f1556a);
    }

    public boolean isFixedWidth() throws PDFNetException {
        return IsFixedWidth(this.f1556a);
    }

    public boolean isSerif() throws PDFNetException {
        return IsSerif(this.f1556a);
    }

    public boolean isSymbolic() throws PDFNetException {
        return IsSymbolic(this.f1556a);
    }

    public boolean isItalic() throws PDFNetException {
        return IsItalic(this.f1556a);
    }

    public boolean isAllCap() throws PDFNetException {
        return IsAllCap(this.f1556a);
    }

    public boolean isForceBold() throws PDFNetException {
        return IsForceBold(this.f1556a);
    }

    public boolean isHorizontalMode() throws PDFNetException {
        return IsHorizontalMode(this.f1556a);
    }

    public double getWidth(long j) throws PDFNetException {
        return GetWidth(this.f1556a, j);
    }

    public double getMaxWidth() throws PDFNetException {
        return GetMaxWidth(this.f1556a);
    }

    public double getMissingWidth() throws PDFNetException {
        return GetMissingWidth(this.f1556a);
    }

    public FontCharCodeIterator getCharCodeIterator() throws PDFNetException {
        return new FontCharCodeIterator(GetCharCodeIterator(this.f1556a), this.f1557b);
    }

    public PathData getGlyphPath(long j, boolean z) {
        return GetGlyphPath(this.f1556a, j, z, 0L);
    }

    public PathData getGlyphPath(long j, boolean z, Matrix2D matrix2D) {
        PathData pathDataGetGlyphPath = GetGlyphPath(this.f1556a, j, z, matrix2D.__GetHandle());
        ReachabilityHelper.ensureReachable(matrix2D);
        return pathDataGetGlyphPath;
    }

    public ShapedText getShapedText(String str) {
        return new ShapedText(GetShapedText(this.f1556a, str));
    }

    public char[] mapToUnicode(long j) throws PDFNetException {
        return MapToUnicode(this.f1556a, j);
    }

    public String[] getEncoding() throws PDFNetException {
        return GetEncoding(this.f1556a);
    }

    public boolean isEmbedded() throws PDFNetException {
        return IsEmbedded(this.f1556a);
    }

    public String getEmbeddedFontName() throws PDFNetException {
        return GetEmbeddedFontName(this.f1556a);
    }

    public Obj getEmbeddedFont() throws PDFNetException {
        return Obj.__Create(GetEmbeddedFont(this.f1556a), this.f1557b);
    }

    public int getEmbeddedFontBufSize() throws PDFNetException {
        return GetEmbeddedFontBufSize(this.f1556a);
    }

    public short getUnitsPerEm() throws PDFNetException {
        return GetUnitsPerEm(this.f1556a);
    }

    public Rect getBBox() throws PDFNetException {
        return new Rect(GetBBox(this.f1556a));
    }

    public double getAscent() throws PDFNetException {
        return GetAscent(this.f1556a);
    }

    public double getDescent() throws PDFNetException {
        return GetDescent(this.f1556a);
    }

    public int getStandardType1FontType() throws PDFNetException {
        return GetStandardType1FontType(this.f1556a);
    }

    public boolean isCFF() throws PDFNetException {
        return IsCFF(this.f1556a);
    }

    public Matrix2D getType3FontMatrix() throws PDFNetException {
        return Matrix2D.__Create(GetType3FontMatrix(this.f1556a));
    }

    public Obj getType3GlyphStream(long j) {
        return Obj.__Create(GetType3GlyphStream(this.f1556a, j), this.f1557b);
    }

    private Font(long j, Object obj) {
        this.f1556a = j;
        this.f1557b = obj;
    }

    public static Font __Create(long j, Object obj) {
        if (j == 0) {
            return null;
        }
        return new Font(j, obj);
    }

    public long __GetHandle() {
        return this.f1556a;
    }

    public Object __GetRefHandle() {
        return this.f1557b;
    }
}
