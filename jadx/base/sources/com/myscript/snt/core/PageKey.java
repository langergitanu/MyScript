package com.myscript.snt.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class PageKey {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public PageKey(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(PageKey pageKey) {
        if (pageKey == null) {
            return 0L;
        }
        return pageKey.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_PageKey(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PageKey)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return nativeEquals((PageKey) obj);
    }

    public PageKey() {
        this(NeboEngineJNI.new_PageKey__SWIG_0(), true);
    }

    public PageKey(String str, String str2) {
        this(NeboEngineJNI.new_PageKey__SWIG_1(str.getBytes(), str2.getBytes()), true);
    }

    public PageKey(NotebookKey notebookKey, String str) {
        this(NeboEngineJNI.new_PageKey__SWIG_2(NotebookKey.getCPtr(notebookKey), notebookKey, str.getBytes()), true);
    }

    public PageKey(String str) {
        this(NeboEngineJNI.new_PageKey__SWIG_3(str.getBytes()), true);
    }

    public boolean isValid() {
        return NeboEngineJNI.PageKey_isValid(this.swigCPtr, this);
    }

    public String relativeDocumentPath() {
        return new String(NeboEngineJNI.PageKey_relativeDocumentPath(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String loweredRelativeDocumentPath() {
        return new String(NeboEngineJNI.PageKey_loweredRelativeDocumentPath(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String pageId() {
        return new String(NeboEngineJNI.PageKey_pageId(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String uuid() {
        return new String(NeboEngineJNI.PageKey_uuid(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public boolean move(String str) {
        return NeboEngineJNI.PageKey_move(this.swigCPtr, this, str.getBytes());
    }

    public String serialize() {
        return new String(NeboEngineJNI.PageKey_serialize(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public static PageKey deserialize(String str) {
        return new PageKey(NeboEngineJNI.PageKey_deserialize(str.getBytes()), true);
    }

    public static PageKey createKeyFromAbsolutePath(String str, String str2, String str3) {
        return new PageKey(NeboEngineJNI.PageKey_createKeyFromAbsolutePath(str.getBytes(), str2.getBytes(), str3.getBytes()), true);
    }

    public static PageKey createKeyFromUuid(String str) {
        return new PageKey(NeboEngineJNI.PageKey_createKeyFromUuid(str.getBytes()), true);
    }

    public static class Hash {
        protected transient boolean swigCMemOwn;
        private transient long swigCPtr;

        public Hash(long j, boolean z) {
            this.swigCMemOwn = z;
            this.swigCPtr = j;
        }

        public static long getCPtr(Hash hash) {
            if (hash == null) {
                return 0L;
            }
            return hash.swigCPtr;
        }

        protected void finalize() {
            delete();
        }

        public synchronized void delete() {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    NeboEngineJNI.delete_PageKey_Hash(j);
                }
                this.swigCPtr = 0L;
            }
        }

        public Hash() {
            this(NeboEngineJNI.new_PageKey_Hash(), true);
        }
    }

    public int hashCode() {
        return NeboEngineJNI.PageKey_hashCode(this.swigCPtr, this);
    }

    public boolean nativeEquals(PageKey pageKey) {
        return NeboEngineJNI.PageKey_nativeEquals(this.swigCPtr, this, getCPtr(pageKey), pageKey);
    }

    public String toString() {
        return new String(NeboEngineJNI.PageKey_toString(this.swigCPtr, this), StandardCharsets.UTF_8);
    }
}
