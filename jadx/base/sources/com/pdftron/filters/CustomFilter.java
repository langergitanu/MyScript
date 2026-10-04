package com.pdftron.filters;

import androidx.credentials.provider.CredentialEntry;
import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public abstract class CustomFilter extends Filter implements AutoCloseable {
    public static final int APPEND_MODE = 2;
    public static final int READ_MODE = 0;
    public static final int SEEK_CUR = 1;
    public static final int SEEK_END = 2;
    public static final int SEEK_SET = 0;
    public static final String TAG = "save CustomFilter";
    public static final int WRITE_MODE = 1;

    /* JADX INFO: renamed from: a */
    private byte[] f1400a;

    /* JADX INFO: renamed from: b */
    private Object f1401b;
    protected long callback_data;

    static native void AfterRead(long j, byte[] bArr, long j2, long j3);

    static native long[] CustomFilterCreate(CustomFilterCallback customFilterCallback, int i);

    static native void Destroy(long j);

    static native void DestroyCallbackData(long j);

    @Override // com.pdftron.filters.Filter, java.lang.AutoCloseable
    public abstract void close();

    public abstract long onCreateInputIterator(Object obj);

    public abstract void onDestroy(Object obj);

    public abstract long onFlush(Object obj);

    public abstract long onRead(byte[] bArr, Object obj);

    public abstract long onSeek(long j, int i, Object obj);

    public abstract long onTell(Object obj);

    public long onTruncate(long j, Object obj) {
        return -1L;
    }

    public abstract long onWrite(byte[] bArr, Object obj);

    public CustomFilter(int i, Object obj) throws PDFNetException {
        super(0L, null);
        if (i < 0 || i > 2) {
            throw new PDFNetException(CredentialEntry.FALSE_STRING, 31L, "CustomFilter.java", "CustomFilter()", "Filter mode is incorrect.");
        }
        this.f1400a = null;
        this.f1401b = obj;
        long[] jArrCustomFilterCreate = CustomFilterCreate(new CustomFilterCallback(), i);
        this.impl = jArrCustomFilterCreate[0];
        this.callback_data = jArrCustomFilterCreate[1];
    }

    protected CustomFilter(long j, Filter filter) {
        super(j, filter);
    }

    public Object getUserObject() {
        return this.f1401b;
    }

    @Override // com.pdftron.filters.Filter
    public String getName() throws PDFNetException {
        return new String("CustomFilter");
    }

    @Override // com.pdftron.filters.Filter
    public void destroy() throws PDFNetException {
        if (this.attached == null && this.impl != 0 && this.ref == null) {
            Destroy(this.impl);
            this.impl = 0L;
        }
        if (this.attached == null && this.callback_data != 0 && this.ref == null) {
            DestroyCallbackData(this.callback_data);
            this.callback_data = 0L;
        }
    }

    @Override // com.pdftron.filters.Filter
    protected void finalize() throws Throwable {
        destroy();
    }

    class CustomFilterCallback {
        CustomFilterCallback() {
        }

        private long Read(long j, long j2, long j3) {
            int i = (int) (j * j2);
            if (CustomFilter.this.f1400a == null || CustomFilter.this.f1400a.length < i) {
                CustomFilter.this.f1400a = new byte[i];
            }
            CustomFilter customFilter = CustomFilter.this;
            long jOnRead = customFilter.onRead(customFilter.f1400a, CustomFilter.this.f1401b);
            CustomFilter customFilter2 = CustomFilter.this;
            CustomFilter.m1117a(customFilter2, customFilter2.f1400a, jOnRead, j3);
            return jOnRead;
        }

        private long Seek(long j, int i) {
            CustomFilter customFilter = CustomFilter.this;
            return customFilter.onSeek(j, i, customFilter.f1401b);
        }

        private long Tell() {
            CustomFilter customFilter = CustomFilter.this;
            return customFilter.onTell(customFilter.f1401b);
        }

        private long Truncate(long j) {
            CustomFilter customFilter = CustomFilter.this;
            return customFilter.onTruncate(j, customFilter.f1401b);
        }

        private long Flush() {
            CustomFilter customFilter = CustomFilter.this;
            return customFilter.onFlush(customFilter.f1401b);
        }

        private long Write(byte[] bArr) {
            CustomFilter customFilter = CustomFilter.this;
            return customFilter.onWrite(bArr, customFilter.f1401b);
        }

        private long CreateInputIterator() {
            CustomFilter customFilter = CustomFilter.this;
            return customFilter.onCreateInputIterator(customFilter.f1401b);
        }

        private void Destroy() {
            CustomFilter customFilter = CustomFilter.this;
            customFilter.onDestroy(customFilter.f1401b);
        }
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m1117a(CustomFilter customFilter, byte[] bArr, long j, long j2) {
        AfterRead(customFilter.impl, bArr, j, j2);
    }
}
