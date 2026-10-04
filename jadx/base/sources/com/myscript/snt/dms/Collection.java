package com.myscript.snt.dms;

import com.myscript.snt.core.CollectionKey;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class Collection implements AutoCloseable {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public Collection(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(Collection collection) {
        if (collection == null) {
            return 0L;
        }
        return collection.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_Collection(j);
            }
            this.swigCPtr = 0L;
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        delete();
    }

    public Collection(CollectionKey collectionKey, CollectionInfo collectionInfo) {
        this(NeboDMSJNI.new_Collection(CollectionKey.getCPtr(collectionKey), collectionKey, CollectionInfo.getCPtr(collectionInfo), collectionInfo), true);
    }

    public CollectionKey getKey() {
        return new CollectionKey(NeboDMSJNI.Collection_getKey(this.swigCPtr, this), true);
    }

    public String getName() {
        return new String(NeboDMSJNI.Collection_getName(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public long getCreationDate() {
        return NeboDMSJNI.Collection_getCreationDate(this.swigCPtr, this);
    }

    public SyncState syncState() {
        return SyncState.swigToEnum(NeboDMSJNI.Collection_syncState(this.swigCPtr, this));
    }

    public boolean isTrashed() {
        return NeboDMSJNI.Collection_isTrashed(this.swigCPtr, this);
    }

    public int hashCode() {
        return NeboDMSJNI.Collection_hashCode(this.swigCPtr, this);
    }

    public boolean nativeEquals(Collection collection) {
        return NeboDMSJNI.Collection_nativeEquals(this.swigCPtr, this, getCPtr(collection), collection);
    }

    public String toString() {
        return new String(NeboDMSJNI.Collection_toString(this.swigCPtr, this), StandardCharsets.UTF_8);
    }
}
