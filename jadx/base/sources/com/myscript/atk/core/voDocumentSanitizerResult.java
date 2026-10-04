package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum voDocumentSanitizerResult {
    DOCUMENTSANITIZER_ERROR(-1),
    DOCUMENTSANITIZER_VALID(0),
    DOCUMENTSANITIZER_FILE_ARCHIVE_CORRUPTED,
    DOCUMENTSANITIZER_FILE_INDEX_LOAD_FAILURE,
    DOCUMENTSANITIZER_FILE_INDEX_INVALID,
    DOCUMENTSANITIZER_PAGE_INK_LOAD_FAILURE,
    DOCUMENTSANITIZER_PAGE_TREE_LOAD_FAILURE,
    DOCUMENTSANITIZER_PAGE_TREE_INVALID,
    DOCUMENTSANITIZER_PAGE_LAYOUT_INVALID,
    DOCUMENTSANITIZER_CONTENT_HAS_RESET_FIELDS,
    DOCUMENTSANITIZER_CONTENTFIELD_UNKNWON_FIELD,
    DOCUMENTSANITIZER_CONTENTFIELD_INVALID_RESULT;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static voDocumentSanitizerResult swigToEnum(int i) {
        voDocumentSanitizerResult[] vodocumentsanitizerresultArr = (voDocumentSanitizerResult[]) voDocumentSanitizerResult.class.getEnumConstants();
        if (i < vodocumentsanitizerresultArr.length && i >= 0) {
            voDocumentSanitizerResult vodocumentsanitizerresult = vodocumentsanitizerresultArr[i];
            if (vodocumentsanitizerresult.swigValue == i) {
                return vodocumentsanitizerresult;
            }
        }
        for (voDocumentSanitizerResult vodocumentsanitizerresult2 : vodocumentsanitizerresultArr) {
            if (vodocumentsanitizerresult2.swigValue == i) {
                return vodocumentsanitizerresult2;
            }
        }
        throw new IllegalArgumentException("No enum " + voDocumentSanitizerResult.class + " with value " + i);
    }

    voDocumentSanitizerResult() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    voDocumentSanitizerResult(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    voDocumentSanitizerResult(voDocumentSanitizerResult vodocumentsanitizerresult) {
        int i = vodocumentsanitizerresult.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
