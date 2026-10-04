package com.myscript.snt.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class NotebookKey {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public NotebookKey(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(NotebookKey notebookKey) {
        if (notebookKey == null) {
            return 0L;
        }
        return notebookKey.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_NotebookKey(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof NotebookKey)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return nativeEquals((NotebookKey) obj);
    }

    public NotebookKey() {
        this(NeboEngineJNI.new_NotebookKey__SWIG_0(), true);
    }

    public NotebookKey(String str) {
        this(NeboEngineJNI.new_NotebookKey__SWIG_1(str.getBytes()), true);
    }

    public NotebookKey(PageKey pageKey) {
        this(NeboEngineJNI.new_NotebookKey__SWIG_2(PageKey.getCPtr(pageKey), pageKey), true);
    }

    public NotebookKey(CollectionKey collectionKey, String str) {
        this(NeboEngineJNI.new_NotebookKey__SWIG_3(CollectionKey.getCPtr(collectionKey), collectionKey, str.getBytes()), true);
    }

    public boolean isValid() {
        return NeboEngineJNI.NotebookKey_isValid(this.swigCPtr, this);
    }

    public String relativePath() {
        return new String(NeboEngineJNI.NotebookKey_relativePath(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String uuid() {
        return new String(NeboEngineJNI.NotebookKey_uuid(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public long pathSize() {
        return NeboEngineJNI.NotebookKey_pathSize(this.swigCPtr, this);
    }

    public String serialize() {
        return new String(NeboEngineJNI.NotebookKey_serialize(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public static NotebookKey deserialize(String str) {
        return new NotebookKey(NeboEngineJNI.NotebookKey_deserialize(str.getBytes()), true);
    }

    public static NotebookKey createKeyFromUuid(String str) {
        return new NotebookKey(NeboEngineJNI.NotebookKey_createKeyFromUuid(str.getBytes()), true);
    }

    public static NotebookKey createKeyFromAbsolutePath(String str, String str2) {
        return new NotebookKey(NeboEngineJNI.NotebookKey_createKeyFromAbsolutePath(str.getBytes(), str2.getBytes()), true);
    }

    public static NotebookKey createKeyFromPageKey(PageKey pageKey) {
        return new NotebookKey(NeboEngineJNI.NotebookKey_createKeyFromPageKey(PageKey.getCPtr(pageKey), pageKey), true);
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
                    NeboEngineJNI.delete_NotebookKey_Hash(j);
                }
                this.swigCPtr = 0L;
            }
        }

        public Hash() {
            this(NeboEngineJNI.new_NotebookKey_Hash(), true);
        }
    }

    public int hashCode() {
        return NeboEngineJNI.NotebookKey_hashCode(this.swigCPtr, this);
    }

    public boolean nativeEquals(NotebookKey notebookKey) {
        return NeboEngineJNI.NotebookKey_nativeEquals(this.swigCPtr, this, getCPtr(notebookKey), notebookKey);
    }

    public String toString() {
        return new String(NeboEngineJNI.NotebookKey_toString(this.swigCPtr, this), StandardCharsets.UTF_8);
    }
}
