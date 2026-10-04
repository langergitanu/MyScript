package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum DocumentType {
    Wordprocessing(1),
    Spreadsheet,
    Presentation,
    Clipboard,
    Unknown;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static DocumentType swigToEnum(int i) {
        DocumentType[] documentTypeArr = (DocumentType[]) DocumentType.class.getEnumConstants();
        if (i < documentTypeArr.length && i >= 0) {
            DocumentType documentType = documentTypeArr[i];
            if (documentType.swigValue == i) {
                return documentType;
            }
        }
        for (DocumentType documentType2 : documentTypeArr) {
            if (documentType2.swigValue == i) {
                return documentType2;
            }
        }
        throw new IllegalArgumentException("No enum " + DocumentType.class + " with value " + i);
    }

    DocumentType() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    DocumentType(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    DocumentType(DocumentType documentType) {
        int i = documentType.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
