package com.myscript.snt.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class QueryBuilder {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public QueryBuilder(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(QueryBuilder queryBuilder) {
        if (queryBuilder == null) {
            return 0L;
        }
        return queryBuilder.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_QueryBuilder(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public static String build(String str) {
        return new String(NeboEngineJNI.QueryBuilder_build(str.getBytes()), StandardCharsets.UTF_8);
    }

    public static boolean valid(String str) {
        return NeboEngineJNI.QueryBuilder_valid(str.getBytes());
    }

    public QueryBuilder() {
        this(NeboEngineJNI.new_QueryBuilder(), true);
    }
}
