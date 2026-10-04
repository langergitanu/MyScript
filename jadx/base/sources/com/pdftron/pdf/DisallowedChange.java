package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public class DisallowedChange implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f1528a;

    static native void Destroy(long j);

    static native int GetObjNum(long j);

    static native int GetType(long j);

    static native String GetTypeAsString(long j);

    public enum Type {
        e_form_filled(0),
        e_digital_signature_signed(1),
        e_page_template_instantiated(2),
        e_annotation_created_or_updated_or_deleted(3),
        e_other(4),
        e_unknown(5);


        /* JADX INFO: renamed from: b */
        private static HashMap<Integer, Type> f1529b = new HashMap<>();

        /* JADX INFO: renamed from: a */
        private int f1531a;

        static {
            for (Type type : values()) {
                f1529b.put(Integer.valueOf(type.f1531a), type);
            }
        }

        Type(int i) {
            this.f1531a = i;
        }

        /* JADX INFO: renamed from: a */
        static Type m1155a(int i) {
            return f1529b.get(Integer.valueOf(i));
        }
    }

    public void destroy() throws PDFNetException {
        long j = this.f1528a;
        if (j != 0) {
            Destroy(j);
            this.f1528a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public DisallowedChange(long j) {
        this.f1528a = j;
    }

    public int getObjNum() throws PDFNetException {
        return GetObjNum(this.f1528a);
    }

    public Type getType() throws PDFNetException {
        return Type.m1155a(GetType(this.f1528a));
    }

    public String getTypeAsString() throws PDFNetException {
        return GetTypeAsString(this.f1528a);
    }

    public long __GetHandle() {
        return this.f1528a;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
