package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum VO_DOCUMENT_PRIVATE_T {
    ActiveArea(3262),
    LayoutItem,
    LayoutItemStroke,
    LayoutItemArc,
    LayoutItemLine,
    LayoutItemPoint,
    LayoutItemObject,
    LayoutItemGuide,
    LayoutItemString,
    LayoutItemDecoration,
    LayoutGroup,
    LayoutIterator,
    FillAreaDecorationHelper,
    MathInspector,
    ShapeInspector,
    TextSelection,
    TextImporter,
    DocumentSanitizer,
    ContentFieldIterator(3295),
    DetachedLayout(3800),
    MathResultBuilder(3801),
    TextStructureInterval(3803),
    TextStructureEditor(3804),
    AnalyzerInspector(3807),
    LaTeXConverter(3832),
    SeqSubsetBuilder(3834);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static VO_DOCUMENT_PRIVATE_T swigToEnum(int i) {
        VO_DOCUMENT_PRIVATE_T[] vo_document_private_tArr = (VO_DOCUMENT_PRIVATE_T[]) VO_DOCUMENT_PRIVATE_T.class.getEnumConstants();
        if (i < vo_document_private_tArr.length && i >= 0) {
            VO_DOCUMENT_PRIVATE_T vo_document_private_t = vo_document_private_tArr[i];
            if (vo_document_private_t.swigValue == i) {
                return vo_document_private_t;
            }
        }
        for (VO_DOCUMENT_PRIVATE_T vo_document_private_t2 : vo_document_private_tArr) {
            if (vo_document_private_t2.swigValue == i) {
                return vo_document_private_t2;
            }
        }
        throw new IllegalArgumentException("No enum " + VO_DOCUMENT_PRIVATE_T.class + " with value " + i);
    }

    VO_DOCUMENT_PRIVATE_T() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    VO_DOCUMENT_PRIVATE_T(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    VO_DOCUMENT_PRIVATE_T(VO_DOCUMENT_PRIVATE_T vo_document_private_t) {
        int i = vo_document_private_t.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
