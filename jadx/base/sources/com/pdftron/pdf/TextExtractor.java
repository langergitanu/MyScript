package com.pdftron.pdf;

import com.pdftron.helpers.BitmapHelper;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.ocg.Context;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class TextExtractor implements AutoCloseable {
    public static final int e_extract_using_zorder = 256;
    public static final int e_no_dup_remove = 2;
    public static final int e_no_invisible_text = 16;
    public static final int e_no_ligature_exp = 1;
    public static final int e_no_watermarks = 128;
    public static final int e_output_bbox = 2;
    public static final int e_output_style_info = 4;
    public static final int e_punct_break = 4;
    public static final int e_remove_hidden_text = 8;
    public static final int e_words_as_elements = 1;

    /* JADX INFO: renamed from: a */
    private Object f2061a;

    /* JADX INFO: renamed from: b */
    private long f2062b = TextExtractorCreate();

    static native void Begin(long j, long j2, long j3, int i);

    static native void Destroy(long j);

    static native String GetAsText(long j, boolean z);

    static native String GetAsXML(long j, int i);

    static native long GetFirstLine(long j);

    static native Highlights GetHighlights(long j, int[] iArr);

    static native int GetNumLines(long j);

    static native boolean GetRightToLeftLanguage(long j);

    static native String GetTextUnderAnnot(long j, long j2);

    static native int GetWordCount(long j);

    static native void LineDestroy(long j);

    static native boolean LineEndsWithHyphen(long j);

    static native boolean LineEquals(long j, long j2);

    static native long LineGetBBox(long j);

    static native int LineGetCurrentNum(long j);

    static native long LineGetFirstWord(long j);

    static native int LineGetFlowID(long j);

    static native long LineGetNextLine(long j);

    static native int LineGetNumWords(long j);

    static native int LineGetParagraphID(long j);

    static native double[] LineGetQuad(long j);

    static native long LineGetStyle(long j);

    static native long LineGetWord(long j, int i);

    static native boolean LineIsSimpleLine(long j);

    static native boolean LineIsValid(long j);

    static native void SetOCGContext(long j, long j2);

    static native void SetRightToLeftLanguage(long j, boolean z);

    static native void StyleDestroy(long j);

    static native boolean StyleEquals(long j, long j2);

    static native int[] StyleGetColor(long j);

    static native long StyleGetFont(long j);

    static native String StyleGetFontName(long j);

    static native double StyleGetFontSize(long j);

    static native int StyleGetWeight(long j);

    static native boolean StyleIsItalic(long j);

    static native boolean StyleIsSerif(long j);

    static native long TextExtractorCreate();

    static native void WordDestroy(long j);

    static native boolean WordEquals(long j, long j2);

    static native long WordGetBBox(long j);

    static native long WordGetCharStyle(long j, int i);

    static native int WordGetCurrentNum(long j);

    static native double[] WordGetGlyphQuad(long j, int i);

    static native long WordGetNextWord(long j);

    static native int WordGetNumGlyphs(long j);

    static native double[] WordGetQuad(long j);

    static native String WordGetString(long j);

    static native int WordGetStringLen(long j);

    static native long WordGetStyle(long j);

    static native boolean WordIsValid(long j);

    public void destroy() {
        long j = this.f2062b;
        if (j != 0) {
            Destroy(j);
            this.f2062b = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        destroy();
    }

    public void begin(Page page) {
        Begin(this.f2062b, page.f1990a, 0L, 0);
        this.f2061a = page.f1991b;
    }

    public void begin(Page page, Rect rect) {
        Begin(this.f2062b, page.f1990a, rect != null ? rect.f2037a : 0L, 0);
        ReachabilityHelper.ensureReachable(rect);
        this.f2061a = page.f1991b;
    }

    public void begin(Page page, Rect rect, int i) {
        Begin(this.f2062b, page.f1990a, rect != null ? rect.f2037a : 0L, i);
        ReachabilityHelper.ensureReachable(rect);
        this.f2061a = page.f1991b;
    }

    public int getWordCount() {
        return GetWordCount(this.f2062b);
    }

    public String getAsText() {
        return GetAsText(this.f2062b, true);
    }

    public String getAsText(boolean z) {
        return GetAsText(this.f2062b, z);
    }

    public String getTextUnderAnnot(Annot annot) {
        String strGetTextUnderAnnot = GetTextUnderAnnot(this.f2062b, annot.__GetHandle());
        ReachabilityHelper.ensureReachable(annot);
        return strGetTextUnderAnnot;
    }

    public String getAsXML() {
        return GetAsXML(this.f2062b, 0);
    }

    public class CharRange {
        public int index;
        public int length;

        public CharRange(TextExtractor textExtractor, int i, int i2) {
            this.index = i;
            this.length = i2;
        }
    }

    public Highlights getHighlights(CharRange[] charRangeArr) {
        int length = charRangeArr.length;
        int[] iArr = new int[length << 1];
        for (int i = 0; i < length; i++) {
            int i2 = i << 1;
            iArr[i2] = charRangeArr[i].index;
            iArr[i2 + 1] = charRangeArr[i].length;
        }
        Highlights highlightsGetHighlights = GetHighlights(this.f2062b, iArr);
        highlightsGetHighlights.f1567b = this;
        return highlightsGetHighlights;
    }

    public String getAsXML(int i) {
        return GetAsXML(this.f2062b, i);
    }

    public int getNumLines() {
        return GetNumLines(this.f2062b);
    }

    public Line getFirstLine() {
        return new Line(GetFirstLine(this.f2062b), this.f2061a);
    }

    public boolean getRightToLeftLanguage() {
        return GetRightToLeftLanguage(this.f2062b);
    }

    public void setRightToLeftLanguage(boolean z) {
        SetRightToLeftLanguage(this.f2062b, z);
    }

    public void setOCGContext(Context context) {
        if (context == null) {
            SetOCGContext(this.f2062b, 0L);
        } else {
            SetOCGContext(this.f2062b, context.__GetHandle());
            ReachabilityHelper.ensureReachable(context);
        }
    }

    public class Style implements AutoCloseable {

        /* JADX INFO: renamed from: a */
        private Object f2066a;

        /* JADX INFO: renamed from: b */
        private long f2067b;

        Style(TextExtractor textExtractor, long j, Object obj) {
            this.f2067b = j;
            this.f2066a = obj;
        }

        public void destroy() {
            long j = this.f2067b;
            if (j != 0) {
                TextExtractor.StyleDestroy(j);
                this.f2067b = 0L;
            }
        }

        protected void finalize() throws Throwable {
            destroy();
        }

        public Obj getFont() {
            return Obj.__Create(TextExtractor.StyleGetFont(this.f2067b), this.f2066a);
        }

        public String getFontName() {
            return TextExtractor.StyleGetFontName(this.f2067b);
        }

        public double getFontSize() {
            return TextExtractor.StyleGetFontSize(this.f2067b);
        }

        public int getWeight() {
            return TextExtractor.StyleGetWeight(this.f2067b);
        }

        public boolean isItalic() {
            return TextExtractor.StyleIsItalic(this.f2067b);
        }

        public boolean isSerif() {
            return TextExtractor.StyleIsSerif(this.f2067b);
        }

        public byte[] getColor() {
            return BitmapHelper.getColor(TextExtractor.StyleGetColor(this.f2067b));
        }

        public boolean equals(Object obj) {
            if (obj == null || !obj.getClass().equals(getClass())) {
                return false;
            }
            boolean zStyleEquals = TextExtractor.StyleEquals(this.f2067b, ((Style) obj).f2067b);
            ReachabilityHelper.ensureReachable(obj);
            return zStyleEquals;
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            destroy();
        }
    }

    public class Word implements AutoCloseable {

        /* JADX INFO: renamed from: a */
        long f2068a;

        /* JADX INFO: renamed from: b */
        private Object f2069b;

        public void destroy() {
            long j = this.f2068a;
            if (j != 0) {
                TextExtractor.WordDestroy(j);
                this.f2068a = 0L;
            }
        }

        protected void finalize() throws Throwable {
            destroy();
        }

        public int getNumGlyphs() {
            return TextExtractor.WordGetNumGlyphs(this.f2068a);
        }

        public Rect getBBox() {
            return new Rect(TextExtractor.WordGetBBox(this.f2068a));
        }

        public double[] getQuad() {
            return TextExtractor.WordGetQuad(this.f2068a);
        }

        public double[] getGlyphQuad(int i) {
            return TextExtractor.WordGetGlyphQuad(this.f2068a, i);
        }

        public Style getCharStyle(int i) {
            return new Style(TextExtractor.this, TextExtractor.WordGetCharStyle(this.f2068a, i), this.f2069b);
        }

        public Style getStyle() {
            return new Style(TextExtractor.this, TextExtractor.WordGetStyle(this.f2068a), this.f2069b);
        }

        public int getStringLen() {
            return TextExtractor.WordGetStringLen(this.f2068a);
        }

        public String getString() {
            return TextExtractor.WordGetString(this.f2068a);
        }

        public Word getNextWord() {
            return TextExtractor.this.new Word(TextExtractor.WordGetNextWord(this.f2068a), this.f2069b);
        }

        public int getCurrentNum() {
            return TextExtractor.WordGetCurrentNum(this.f2068a);
        }

        public boolean equals(Object obj) {
            if (obj == null || !obj.getClass().equals(getClass())) {
                return false;
            }
            boolean zWordEquals = TextExtractor.WordEquals(this.f2068a, ((Word) obj).f2068a);
            ReachabilityHelper.ensureReachable(obj);
            return zWordEquals;
        }

        public boolean isValid() {
            long j = this.f2068a;
            if (j != 0) {
                return TextExtractor.WordIsValid(j);
            }
            return false;
        }

        Word(long j, Object obj) {
            this.f2068a = j;
            this.f2069b = obj;
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            destroy();
        }
    }

    public class Line implements AutoCloseable {

        /* JADX INFO: renamed from: a */
        private Object f2063a;

        /* JADX INFO: renamed from: b */
        private long f2064b;

        public void destroy() {
            long j = this.f2064b;
            if (j != 0) {
                TextExtractor.LineDestroy(j);
                this.f2064b = 0L;
            }
        }

        protected void finalize() throws Throwable {
            destroy();
        }

        public int getNumWords() {
            return TextExtractor.LineGetNumWords(this.f2064b);
        }

        public boolean isSimpleLine() {
            return TextExtractor.LineIsSimpleLine(this.f2064b);
        }

        public Rect getBBox() {
            return new Rect(TextExtractor.LineGetBBox(this.f2064b));
        }

        public double[] getQuad() {
            return TextExtractor.LineGetQuad(this.f2064b);
        }

        public Word getFirstWord() {
            return TextExtractor.this.new Word(TextExtractor.LineGetFirstWord(this.f2064b), this.f2063a);
        }

        public Word getWord(int i) {
            return TextExtractor.this.new Word(TextExtractor.LineGetWord(this.f2064b, i), this.f2063a);
        }

        public Line getNextLine() {
            return TextExtractor.this.new Line(TextExtractor.LineGetNextLine(this.f2064b), this.f2063a);
        }

        public int getCurrentNum() {
            return TextExtractor.LineGetCurrentNum(this.f2064b);
        }

        public Style getStyle() {
            return new Style(TextExtractor.this, TextExtractor.LineGetStyle(this.f2064b), this.f2063a);
        }

        public int getParagraphID() {
            return TextExtractor.LineGetParagraphID(this.f2064b);
        }

        public int getFlowID() {
            return TextExtractor.LineGetFlowID(this.f2064b);
        }

        public boolean endsWithHyphen() {
            return TextExtractor.LineEndsWithHyphen(this.f2064b);
        }

        public boolean equals(Object obj) {
            if (obj == null || !obj.getClass().equals(getClass())) {
                return false;
            }
            boolean zLineEquals = TextExtractor.LineEquals(this.f2064b, ((Word) obj).f2068a);
            ReachabilityHelper.ensureReachable(obj);
            return zLineEquals;
        }

        public boolean isValid() {
            long j = this.f2064b;
            if (j != 0) {
                return TextExtractor.LineIsValid(j);
            }
            return false;
        }

        Line(long j, Object obj) {
            this.f2064b = j;
            this.f2063a = obj;
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            destroy();
        }
    }

    public static class Compat {
        public static void SetRightToLeftLanguage(long j, boolean z) {
            TextExtractor.SetRightToLeftLanguage(j, z);
        }

        public static boolean GetRightToLeftLanguage(long j) {
            return TextExtractor.GetRightToLeftLanguage(j);
        }
    }
}
