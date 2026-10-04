package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum MimeType {
    NONE(0),
    TEXT(1),
    HTML(2),
    MATHML(4),
    LATEX(8),
    GRAPHML(16),
    MUSICXML(32),
    SVG(64),
    JIIX(128),
    JPEG(256),
    PNG(512),
    GIF(1024),
    PDF(2048),
    DOCX(4096),
    PPTX(8192),
    OFFICE_CLIPBOARD(16384),
    NEBO(32768),
    IINK(65536),
    MYSCRIPT_SHAPE(131072),
    MYSCRIPT_SECTION_BORDER(262144),
    BMP(524288),
    XLSX(1048576),
    DOC(2097152),
    PPT(4194304),
    XLS(8388608),
    PTR_ATK_CORE_PAGE(16777216),
    ALL(33554431),
    UNKNOWN(33554432);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static MimeType swigToEnum(int i) {
        MimeType[] mimeTypeArr = (MimeType[]) MimeType.class.getEnumConstants();
        if (i < mimeTypeArr.length && i >= 0) {
            MimeType mimeType = mimeTypeArr[i];
            if (mimeType.swigValue == i) {
                return mimeType;
            }
        }
        for (MimeType mimeType2 : mimeTypeArr) {
            if (mimeType2.swigValue == i) {
                return mimeType2;
            }
        }
        throw new IllegalArgumentException("No enum " + MimeType.class + " with value " + i);
    }

    MimeType() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    MimeType(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    MimeType(MimeType mimeType) {
        int i = mimeType.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
