package com.pdftron.filters;

import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.util.Log;
import com.pdftron.common.PDFNetException;
import com.revenuecat.purchases.common.Constants;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes7.dex */
public class FileDescriptorReadOnlyFilter extends CustomFilter {
    protected FileChannel mFileChannel;
    protected FileDescriptorFilterManager mFilterManager;
    protected boolean mIsInputChannel;
    protected FileLock mLock;
    protected int mMode;
    protected int mMySequenceNumber;
    protected ParcelFileDescriptor mPfd;
    protected long mPosition;

    public FileDescriptorReadOnlyFilter(int i, ParcelFileDescriptor parcelFileDescriptor) throws PDFNetException {
        super(i, parcelFileDescriptor);
        this.mPfd = parcelFileDescriptor;
        this.mMode = i;
        this.mFileChannel = new FileInputStream(parcelFileDescriptor.getFileDescriptor()).getChannel();
        this.mLock = null;
        this.mIsInputChannel = true;
        FileDescriptorFilterManager fileDescriptorFilterManager = new FileDescriptorFilterManager();
        this.mFilterManager = fileDescriptorFilterManager;
        this.mMySequenceNumber = fileDescriptorFilterManager.getNewSequenceNumber();
        Log.d(CustomFilter.TAG, this.mMySequenceNumber + ": create FileDescriptorFilter in Input mode, actual mode: " + m1127a(i));
        if (!this.mFileChannel.isOpen()) {
            Log.d(CustomFilter.TAG, this.mMySequenceNumber + ": create FileDescriptorFilter file channel closed!!!");
        }
        if (i == 0) {
            this.mFilterManager.addReadFilter(this);
        }
    }

    public FileDescriptorReadOnlyFilter(int i, FileDescriptorReadOnlyFilter fileDescriptorReadOnlyFilter) throws PDFNetException {
        super(i, fileDescriptorReadOnlyFilter.mPfd);
        this.mPfd = fileDescriptorReadOnlyFilter.mPfd;
        this.mMode = i;
        FileDescriptorFilterManager fileDescriptorFilterManager = fileDescriptorReadOnlyFilter.mFilterManager;
        this.mFilterManager = fileDescriptorFilterManager;
        this.mMySequenceNumber = fileDescriptorFilterManager.getNewSequenceNumber();
        try {
            Log.d(CustomFilter.TAG, this.mMySequenceNumber + ": FileDescriptorFilter copy READ mode close output");
            this.mFileChannel = new FileInputStream(this.mPfd.getFileDescriptor()).getChannel();
            this.mLock = null;
            this.mIsInputChannel = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d(CustomFilter.TAG, this.mMySequenceNumber + ": copy FileDescriptorFilter in Input mode, actual mode: " + m1127a(i));
        if (!this.mFileChannel.isOpen()) {
            Log.e(CustomFilter.TAG, this.mMySequenceNumber + ": copy FileDescriptorFilter file channel closed!!!");
        }
        if (i == 0) {
            this.mFilterManager.addReadFilter(this);
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m1127a(int i) {
        if (i == 0) {
            return "READ";
        }
        return "WRITE";
    }

    @Override // com.pdftron.filters.CustomFilter
    public long onRead(byte[] bArr, Object obj) {
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            if (!this.mIsInputChannel) {
                try {
                    this.mFileChannel.close();
                    this.mLock = null;
                    this.mFileChannel = new FileInputStream(this.mPfd.getFileDescriptor()).getChannel();
                    this.mIsInputChannel = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                this.mFileChannel.position(this.mPosition);
                int i = this.mFileChannel.read(byteBufferWrap);
                this.mPosition = this.mFileChannel.position();
                return i;
            } catch (IOException e2) {
                e2.printStackTrace();
                return 0L;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            return 0L;
        }
    }

    @Override // com.pdftron.filters.CustomFilter
    public long onSeek(long j, int i, Object obj) {
        int i2 = 0;
        try {
            if (i == 0) {
                if (j < 0) {
                    j = 0;
                }
                this.mPosition = j;
            } else if (i == 1) {
                this.mPosition = j + this.mFileChannel.position();
            } else if (i == 2) {
                this.mPosition = this.mFileChannel.size() + j;
            }
            this.mFileChannel.position(this.mPosition);
        } catch (Exception e) {
            Log.e(CustomFilter.TAG, this.mMySequenceNumber + ": save FileDescriptorFilter onSeek ERROR: " + Process.getThreadPriority(Process.myTid()) + "| isInputFilter:" + (this.mMode == 0));
            e.printStackTrace();
            i2 = -1;
        }
        return i2;
    }

    @Override // com.pdftron.filters.CustomFilter
    public long onTell(Object obj) {
        try {
            return this.mFileChannel.position();
        } catch (IOException e) {
            e.printStackTrace();
            return -1L;
        }
    }

    @Override // com.pdftron.filters.CustomFilter
    public long onFlush(Object obj) {
        Log.e(CustomFilter.TAG, this.mMySequenceNumber + ": onFlush on ReadOnly filter:  " + Process.getThreadPriority(Process.myTid()) + "| isInputFilter:" + (this.mMode == 0));
        return 0L;
    }

    @Override // com.pdftron.filters.CustomFilter
    public long onWrite(byte[] bArr, Object obj) {
        Log.e(CustomFilter.TAG, this.mMySequenceNumber + ": onWrite on ReadOnly filter:  " + Process.getThreadPriority(Process.myTid()) + "| isInputFilter:" + (this.mMode == 0));
        return 0L;
    }

    @Override // com.pdftron.filters.CustomFilter
    public long onCreateInputIterator(Object obj) {
        Log.d(CustomFilter.TAG, this.mMySequenceNumber + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + Process.getThreadPriority(Process.myTid()) + ": FileDescriptorFilter onCreateInputIterator position: " + this.mPosition);
        try {
            return new FileDescriptorReadOnlyFilter(0, this).__GetHandle();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // com.pdftron.filters.CustomFilter
    public void onDestroy(Object obj) {
        try {
            if (this.mMode == 0) {
                this.mFilterManager.removeReadFilter(this);
            }
            this.impl = 0L;
            this.callback_data = 0L;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.pdftron.filters.CustomFilter, com.pdftron.filters.Filter, java.lang.AutoCloseable
    public void close() {
        this.mFilterManager.cleanup();
        try {
            this.mPfd.close();
            Log.d(CustomFilter.TAG, this.mMySequenceNumber + ": FileDescriptorFilter close ParcelFileDescriptor");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
