package com.myscript.snt.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class CollectionKey {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public CollectionKey(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(CollectionKey collectionKey) {
        if (collectionKey == null) {
            return 0L;
        }
        return collectionKey.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_CollectionKey(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof CollectionKey)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return nativeEquals((CollectionKey) obj);
    }

    public CollectionKey() {
        this(NeboEngineJNI.new_CollectionKey__SWIG_0(), true);
    }

    public CollectionKey(String str) {
        this(NeboEngineJNI.new_CollectionKey__SWIG_1(str.getBytes()), true);
    }

    public CollectionKey(NotebookKey notebookKey) {
        this(NeboEngineJNI.new_CollectionKey__SWIG_2(NotebookKey.getCPtr(notebookKey), notebookKey), true);
    }

    public CollectionKey(PageKey pageKey) {
        this(NeboEngineJNI.new_CollectionKey__SWIG_3(PageKey.getCPtr(pageKey), pageKey), true);
    }

    public boolean isValid() {
        return NeboEngineJNI.CollectionKey_isValid(this.swigCPtr, this);
    }

    public String relativePath() {
        return new String(NeboEngineJNI.CollectionKey_relativePath(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String uuid() {
        return new String(NeboEngineJNI.CollectionKey_uuid(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public long pathSize() {
        return NeboEngineJNI.CollectionKey_pathSize(this.swigCPtr, this);
    }

    public String serialize() {
        return new String(NeboEngineJNI.CollectionKey_serialize(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public static CollectionKey deserialize(String str) {
        return new CollectionKey(NeboEngineJNI.CollectionKey_deserialize(str.getBytes()), true);
    }

    public static CollectionKey createKeyFromUuid(String str) {
        return new CollectionKey(NeboEngineJNI.CollectionKey_createKeyFromUuid(str.getBytes()), true);
    }

    public static CollectionKey createKey(String str) {
        return new CollectionKey(NeboEngineJNI.CollectionKey_createKey(str.getBytes()), true);
    }

    public static CollectionKey createKeyFromAbsolutePath(String str, String str2) {
        return new CollectionKey(NeboEngineJNI.CollectionKey_createKeyFromAbsolutePath(str.getBytes(), str2.getBytes()), true);
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
                    NeboEngineJNI.delete_CollectionKey_Hash(j);
                }
                this.swigCPtr = 0L;
            }
        }

        public Hash() {
            this(NeboEngineJNI.new_CollectionKey_Hash(), true);
        }
    }

    public int hashCode() {
        return NeboEngineJNI.CollectionKey_hashCode(this.swigCPtr, this);
    }

    public boolean nativeEquals(CollectionKey collectionKey) {
        return NeboEngineJNI.CollectionKey_nativeEquals(this.swigCPtr, this, getCPtr(collectionKey), collectionKey);
    }

    public String toString() {
        return new String(NeboEngineJNI.CollectionKey_toString(this.swigCPtr, this), StandardCharsets.UTF_8);
    }
}
