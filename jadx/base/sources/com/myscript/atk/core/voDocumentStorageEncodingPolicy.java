package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum voDocumentStorageEncodingPolicy {
    DOCUMENT_STORAGE_ENCODING_POLICY_ERR(-1),
    DOCUMENT_STORAGE_ENCODING_POLICY_USE_LEGACY,
    DOCUMENT_STORAGE_ENCODING_POLICY_USE_OPTIMIZED,
    DOCUMENT_STORAGE_ENCODING_POLICY_USE_OPTIMIZED_TILT,
    DOCUMENT_STORAGE_ENCODING_POLICY_COUNT;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static voDocumentStorageEncodingPolicy swigToEnum(int i) {
        voDocumentStorageEncodingPolicy[] vodocumentstorageencodingpolicyArr = (voDocumentStorageEncodingPolicy[]) voDocumentStorageEncodingPolicy.class.getEnumConstants();
        if (i < vodocumentstorageencodingpolicyArr.length && i >= 0) {
            voDocumentStorageEncodingPolicy vodocumentstorageencodingpolicy = vodocumentstorageencodingpolicyArr[i];
            if (vodocumentstorageencodingpolicy.swigValue == i) {
                return vodocumentstorageencodingpolicy;
            }
        }
        for (voDocumentStorageEncodingPolicy vodocumentstorageencodingpolicy2 : vodocumentstorageencodingpolicyArr) {
            if (vodocumentstorageencodingpolicy2.swigValue == i) {
                return vodocumentstorageencodingpolicy2;
            }
        }
        throw new IllegalArgumentException("No enum " + voDocumentStorageEncodingPolicy.class + " with value " + i);
    }

    voDocumentStorageEncodingPolicy() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    voDocumentStorageEncodingPolicy(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    voDocumentStorageEncodingPolicy(voDocumentStorageEncodingPolicy vodocumentstorageencodingpolicy) {
        int i = vodocumentstorageencodingpolicy.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
