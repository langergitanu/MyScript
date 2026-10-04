package com.pdftron.filters;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.pdftron.common.PDFNetException;
import com.pdftron.filters.FileDescriptorFilterManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes7.dex */
public class SecondaryFileFilter extends CustomFilter {

    /* JADX INFO: renamed from: a */
    private static final String f1411a = "com.pdftron.filters.SecondaryFileFilter";

    /* JADX INFO: renamed from: b */
    private boolean f1412b;

    /* JADX INFO: renamed from: c */
    private final int f1413c;
    protected Context mContext;
    protected ParcelFileDescriptor.AutoCloseInputStream mFis;
    protected ParcelFileDescriptor.AutoCloseOutputStream mFos;
    protected final long mInitialSize;
    protected ParcelFileDescriptor mPfdInput;
    protected ParcelFileDescriptor mPfdOutput;
    protected long mPosition;
    protected Uri mTreeUri;

    public SecondaryFileFilter(Context context, Uri uri) throws PDFNetException, FileNotFoundException {
        this(context, uri, 0);
    }

    public SecondaryFileFilter(Context context, Uri uri, int i) throws PDFNetException, FileNotFoundException {
        super(i, uri);
        this.f1412b = false;
        this.f1413c = FileDescriptorFilterManager.C6926a.m1124a().m1126b();
        this.mContext = context;
        this.mTreeUri = uri;
        this.mPfdInput = context.getContentResolver().openFileDescriptor(uri, "r");
        this.mFis = new ParcelFileDescriptor.AutoCloseInputStream(this.mPfdInput);
        if (i != 0) {
            this.mPfdOutput = context.getContentResolver().openFileDescriptor(uri, "rw");
            this.mFos = new ParcelFileDescriptor.AutoCloseOutputStream(this.mPfdOutput);
        }
        this.mInitialSize = size();
    }

    public SecondaryFileFilter(int i, SecondaryFileFilter secondaryFileFilter) throws PDFNetException, IOException {
        super(i, secondaryFileFilter.mTreeUri);
        this.f1412b = false;
        this.f1413c = FileDescriptorFilterManager.C6926a.m1124a().m1126b();
        this.attached = secondaryFileFilter;
        m1128a(secondaryFileFilter);
        this.mInitialSize = size();
    }

    protected SecondaryFileFilter(long j, SecondaryFileFilter secondaryFileFilter) throws PDFNetException, IOException {
        super(j, secondaryFileFilter);
        this.f1412b = false;
        this.f1413c = FileDescriptorFilterManager.C6926a.m1124a().m1126b();
        m1128a(secondaryFileFilter);
        this.mInitialSize = size();
    }

    /* JADX INFO: renamed from: a */
    private void m1128a(SecondaryFileFilter secondaryFileFilter) {
        this.mContext = secondaryFileFilter.mContext;
        this.mTreeUri = secondaryFileFilter.mTreeUri;
        this.mPfdInput = secondaryFileFilter.mPfdInput;
        this.mFis = secondaryFileFilter.mFis;
        ParcelFileDescriptor parcelFileDescriptor = secondaryFileFilter.mPfdOutput;
        if (parcelFileDescriptor != null) {
            this.mPfdOutput = parcelFileDescriptor;
            this.mFos = secondaryFileFilter.mFos;
        }
    }

    public static SecondaryFileFilter __Create(long j, SecondaryFileFilter secondaryFileFilter) throws PDFNetException, IOException {
        return new SecondaryFileFilter(j, secondaryFileFilter);
    }

    @Override // com.pdftron.filters.Filter
    public long size() throws PDFNetException {
        try {
            return this.mFis.getChannel().size();
        } catch (Exception e) {
            e.printStackTrace();
            return super.size();
        }
    }

    @Override // com.pdftron.filters.CustomFilter
    public long onSeek(long j, int i, Object obj) {
        int i2;
        try {
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(f1411a, "onSeek exception for filter #: " + getSequenceNumber());
            i2 = -1;
        }
        if (i == 0) {
            if (j < 0) {
                j = 0;
            }
            this.mPosition = j;
        } else {
            if (i != 1) {
                if (i == 2) {
                    this.mPosition = size() + j;
                }
                i2 = 0;
                return i2;
            }
            this.mPosition = j + this.mPosition;
        }
        i2 = 0;
        return i2;
    }

    @Override // com.pdftron.filters.CustomFilter
    public long onTell(Object obj) {
        return this.mPosition;
    }

    @Override // com.pdftron.filters.CustomFilter
    public long onFlush(Object obj) {
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = this.mFos;
        if (autoCloseOutputStream == null) {
            return 0L;
        }
        FileChannel channel = autoCloseOutputStream.getChannel();
        try {
            channel.truncate(this.mPosition);
            return channel.size();
        } catch (Exception e) {
            Log.e(f1411a, "onFlush exception for filter #: " + getSequenceNumber());
            e.printStackTrace();
            return -1L;
        }
    }

    @Override // com.pdftron.filters.CustomFilter
    public long onWrite(byte[] bArr, Object obj) {
        if (this.mFos == null) {
            return 0L;
        }
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            FileChannel channel = this.mFos.getChannel();
            channel.position(this.mPosition);
            int iWrite = channel.write(byteBufferWrap);
            this.mPosition = channel.position();
            return iWrite;
        } catch (Exception e) {
            Log.e(f1411a, "onWrite exception for filter #: " + getSequenceNumber());
            e.printStackTrace();
            return -1L;
        }
    }

    @Override // com.pdftron.filters.CustomFilter
    public long onTruncate(long j, Object obj) {
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = this.mFos;
        if (autoCloseOutputStream == null) {
            return 0L;
        }
        FileChannel channel = autoCloseOutputStream.getChannel();
        try {
            channel.truncate(j);
            return channel.size();
        } catch (Exception e) {
            Log.e(f1411a, "onTruncate exception for filter #: " + getSequenceNumber());
            e.printStackTrace();
            return -1L;
        }
    }

    @Override // com.pdftron.filters.CustomFilter
    public long onCreateInputIterator(Object obj) {
        try {
            return new SecondaryFileFilter(this.mContext, this.mTreeUri, 0).__GetHandle();
        } catch (Exception e) {
            Log.e(f1411a, "onCreateInputIterator exception for filter #: " + this.f1413c);
            e.printStackTrace();
            return 0L;
        }
    }

    public SecondaryFileFilter createOutputIterator() {
        try {
            return new SecondaryFileFilter(this.mContext, this.mTreeUri, 1);
        } catch (Exception e) {
            Log.e(f1411a, "createOutputIterator exception for filter #: " + getSequenceNumber());
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.pdftron.filters.CustomFilter
    public void onDestroy(Object obj) {
        if (this.attached != null) {
            return;
        }
        close();
        this.impl = 0L;
        this.callback_data = 0L;
    }

    @Override // com.pdftron.filters.CustomFilter, com.pdftron.filters.Filter, java.lang.AutoCloseable
    public void close() {
        if (this.f1412b) {
            return;
        }
        cleanup();
        this.f1412b = true;
    }

    public void cleanup() {
        try {
            ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = this.mFos;
            if (autoCloseOutputStream != null) {
                autoCloseOutputStream.getChannel().close();
                this.mFos.close();
            }
        } catch (Exception e) {
            Log.e(f1411a, "close exception for filter #: " + getSequenceNumber());
            e.printStackTrace();
        }
        try {
            this.mFis.close();
        } catch (Exception e2) {
            Log.e(f1411a, "close exception for filter #: " + getSequenceNumber());
            e2.printStackTrace();
        }
    }

    public void force(boolean z) throws IOException {
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        if (this.mPfdOutput == null || (autoCloseOutputStream = this.mFos) == null) {
            return;
        }
        autoCloseOutputStream.getChannel().force(z);
        this.mPfdOutput.getFileDescriptor().sync();
    }

    public String getSequenceNumber() {
        return "[" + this.f1413c + "]";
    }

    public int getRawSequenceNumber() {
        return this.f1413c;
    }

    @Override // com.pdftron.filters.CustomFilter
    public long onRead(byte[] bArr, Object obj) {
        try {
            if (!this.mFis.getChannel().isOpen()) {
                this.mPfdInput = this.mContext.getContentResolver().openFileDescriptor(this.mTreeUri, "r");
                this.mFis = new ParcelFileDescriptor.AutoCloseInputStream(this.mPfdInput);
            }
            FileChannel channel = this.mFis.getChannel();
            channel.position(this.mPosition);
            int i = channel.read(ByteBuffer.wrap(bArr));
            this.mPosition = channel.position();
            return i;
        } catch (Exception e) {
            Log.e(f1411a, "onRead exception for filter #: " + getSequenceNumber());
            e.printStackTrace();
            return -1L;
        }
    }
}
