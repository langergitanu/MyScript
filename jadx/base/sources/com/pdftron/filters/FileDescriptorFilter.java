package com.pdftron.filters;

import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.util.Log;
import com.pdftron.common.PDFNetException;
import com.revenuecat.purchases.common.Constants;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes7.dex */
public class FileDescriptorFilter extends CustomFilter {
    public static final String TAG = "SaveFilter";
    protected FileChannel mFileChannel;
    protected FileDescriptorFilterManager mFilterManager;
    protected boolean mIsInputChannel;
    protected FileLock mLock;
    protected int mMode;
    protected int mMySequenceNumber;
    protected ParcelFileDescriptor mPfd;
    protected long mPosition;

    public boolean canWriteOnInputFilter() {
        return true;
    }

    @Override // com.pdftron.filters.CustomFilter, com.pdftron.filters.Filter
    public void destroy() throws PDFNetException {
    }

    public FileDescriptorFilter(int i, ParcelFileDescriptor parcelFileDescriptor) throws PDFNetException {
        super(i, parcelFileDescriptor);
        this.mPfd = parcelFileDescriptor;
        this.mMode = i;
        this.mFileChannel = new FileInputStream(parcelFileDescriptor.getFileDescriptor()).getChannel();
        this.mLock = null;
        this.mIsInputChannel = true;
        FileDescriptorFilterManager fileDescriptorFilterManager = new FileDescriptorFilterManager();
        this.mFilterManager = fileDescriptorFilterManager;
        this.mMySequenceNumber = fileDescriptorFilterManager.getNewSequenceNumber();
        Log.d(TAG, this.mMySequenceNumber + ": create FileDescriptorFilter in Input mode, actual mode: " + m1121a(i));
        if (!this.mFileChannel.isOpen()) {
            Log.d(TAG, this.mMySequenceNumber + ": create FileDescriptorFilter file channel closed!!!");
        }
        if (i == 0) {
            this.mFilterManager.addReadFilter(this);
        } else if (i == 1) {
            this.mFilterManager.addReadWriteFilter(this);
        }
    }

    public FileDescriptorFilter(int i, FileDescriptorFilter fileDescriptorFilter) throws PDFNetException {
        super(i, fileDescriptorFilter.mPfd);
        this.mPfd = fileDescriptorFilter.mPfd;
        this.mMode = i;
        this.mFileChannel = fileDescriptorFilter.mFileChannel;
        this.mIsInputChannel = fileDescriptorFilter.mIsInputChannel;
        FileDescriptorFilterManager fileDescriptorFilterManager = fileDescriptorFilter.mFilterManager;
        this.mFilterManager = fileDescriptorFilterManager;
        this.mMySequenceNumber = fileDescriptorFilterManager.getNewSequenceNumber();
        this.mLock = fileDescriptorFilter.mLock;
        if (!this.mIsInputChannel) {
            try {
                Log.d(TAG, this.mMySequenceNumber + ": FileDescriptorFilter copy READ mode close output");
                this.mFileChannel.close();
                this.mFileChannel = new FileInputStream(this.mPfd.getFileDescriptor()).getChannel();
                this.mLock = null;
                this.mIsInputChannel = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG, this.mMySequenceNumber + ": copy FileDescriptorFilter in Input mode, actual mode: " + m1121a(i));
        if (!this.mFileChannel.isOpen()) {
            Log.e(TAG, this.mMySequenceNumber + ": copy FileDescriptorFilter file channel closed!!!");
        }
        if (i == 0) {
            this.mFilterManager.addReadFilter(this);
        } else if (i == 1) {
            this.mFilterManager.addReadWriteFilter(this);
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m1121a(int i) {
        if (i == 0) {
            return "READ";
        }
        return "WRITE";
    }

    protected FileDescriptorFilter(long j, FileDescriptorFilter fileDescriptorFilter) {
        super(j, (Filter) null);
        this.mPfd = fileDescriptorFilter.mPfd;
        this.mMode = fileDescriptorFilter.mMode;
        this.mFileChannel = fileDescriptorFilter.mFileChannel;
        this.mIsInputChannel = fileDescriptorFilter.mIsInputChannel;
        this.mFilterManager = fileDescriptorFilter.mFilterManager;
        this.mMySequenceNumber = fileDescriptorFilter.mMySequenceNumber;
        this.mLock = fileDescriptorFilter.mLock;
    }

    public static FileDescriptorFilter __Create(long j, FileDescriptorFilter fileDescriptorFilter) {
        return new FileDescriptorFilter(j, fileDescriptorFilter);
    }

    public int getThreadId() {
        return Process.getThreadPriority(Process.myTid());
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
                this.mFileChannel.position(0L);
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
                this.mPosition = j + this.mPosition;
            } else if (i == 2) {
                this.mPosition = this.mFileChannel.size() + j;
            }
            this.mFileChannel.position(this.mPosition);
            this.mFileChannel.position(0L);
        } catch (Exception e) {
            Log.e(TAG, this.mMySequenceNumber + ": save FileDescriptorFilter onSeek ERROR: " + getThreadId() + "| isInputFilter:" + (this.mMode == 0));
            e.printStackTrace();
            i2 = -1;
        }
        return i2;
    }

    @Override // com.pdftron.filters.CustomFilter
    public long onTell(Object obj) {
        return this.mPosition;
    }

    @Override // com.pdftron.filters.CustomFilter
    public long onTruncate(long j, Object obj) {
        switchToWriteMode();
        if (this.mLock != null && !this.mIsInputChannel) {
            try {
                if (this.mPosition > j) {
                    this.mPosition = j;
                }
                this.mFileChannel.truncate(j);
                this.mFileChannel.position(0L);
                return this.mFileChannel.size();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    @Override // com.pdftron.filters.CustomFilter
    public long onFlush(Object obj) {
        if (this.mLock == null) {
            return -1L;
        }
        Log.d(TAG, this.mMySequenceNumber + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + getThreadId() + ": FileDescriptorFilter onFlush position: " + this.mPosition + " | mIsInputChannel: " + this.mIsInputChannel);
        try {
            try {
                this.mFileChannel.truncate(this.mPosition);
                this.mFilterManager.releaseLock();
                Log.d(TAG, this.mMySequenceNumber + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + getThreadId() + ": onFlush releaseLock");
                return 0L;
            } catch (IOException e) {
                Log.e(TAG, e.getMessage());
                this.mFilterManager.releaseLock();
                Log.d(TAG, this.mMySequenceNumber + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + getThreadId() + ": onFlush releaseLock");
                return -1L;
            }
        } catch (Throwable th) {
            this.mFilterManager.releaseLock();
            Log.d(TAG, this.mMySequenceNumber + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + getThreadId() + ": onFlush releaseLock");
            throw th;
        }
    }

    @Override // com.pdftron.filters.CustomFilter
    public long onWrite(byte[] bArr, Object obj) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        switchToWriteMode();
        if (this.mLock == null || this.mIsInputChannel) {
            return 0L;
        }
        try {
            this.mFileChannel.position(this.mPosition);
            int iWrite = this.mFileChannel.write(byteBufferWrap);
            this.mPosition = this.mFileChannel.position();
            return iWrite;
        } catch (IOException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public boolean switchToWriteMode() {
        if (this.mIsInputChannel) {
            try {
                this.mFileChannel.close();
                FileChannel channel = new FileOutputStream(this.mPfd.getFileDescriptor()).getChannel();
                this.mFileChannel = channel;
                try {
                    this.mLock = channel.lock();
                } catch (IOException e) {
                    this.mLock = null;
                    e.printStackTrace();
                }
                if (!this.mFilterManager.acquireLock()) {
                    this.mLock = null;
                }
                this.mIsInputChannel = false;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return !this.mIsInputChannel;
    }

    @Override // com.pdftron.filters.CustomFilter
    public long onCreateInputIterator(Object obj) {
        Log.d(TAG, this.mMySequenceNumber + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + getThreadId() + ": FileDescriptorFilter onCreateInputIterator position: " + this.mPosition);
        try {
            FileDescriptorFilter fileDescriptorFilter = new FileDescriptorFilter(0, this);
            this.callback_data = fileDescriptorFilter.callback_data;
            this.mPfd = fileDescriptorFilter.mPfd;
            this.mMode = fileDescriptorFilter.mMode;
            this.mFileChannel = fileDescriptorFilter.mFileChannel;
            this.mIsInputChannel = fileDescriptorFilter.mIsInputChannel;
            this.mFilterManager = fileDescriptorFilter.mFilterManager;
            this.mMySequenceNumber = fileDescriptorFilter.mMySequenceNumber;
            this.mLock = fileDescriptorFilter.mLock;
            return fileDescriptorFilter.__GetHandle();
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
            } else {
                this.mFilterManager.removeReadWriteFilter(this);
            }
            this.impl = 0L;
            this.callback_data = 0L;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public FileDescriptorFilter createOutputIterator() {
        try {
            if (this.mFileChannel == null) {
                Log.e(TAG, this.mMySequenceNumber + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + getThreadId() + ": FileDescriptorFilter createOutputIterator: FileChannel IS NULL!!!");
            }
            FileChannel fileChannel = this.mFileChannel;
            if (fileChannel != null && !fileChannel.isOpen()) {
                Log.e(TAG, this.mMySequenceNumber + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + getThreadId() + ": FileDescriptorFilter createOutputIterator: FileChannel IS CLOSED!!!");
            }
            FileDescriptorFilter fileDescriptorFilter = new FileDescriptorFilter(1, this.mPfd);
            fileDescriptorFilter.seek(0L, 2);
            Log.d(TAG, this.mMySequenceNumber + ": FileDescriptorFilter createOutputIterator: " + fileDescriptorFilter.mMySequenceNumber + " | position: " + fileDescriptorFilter.mPosition);
            return fileDescriptorFilter;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.pdftron.filters.CustomFilter, com.pdftron.filters.Filter, java.lang.AutoCloseable
    public void close() {
        this.mFilterManager.cleanup();
        try {
            this.mPfd.close();
            Log.d(TAG, this.mMySequenceNumber + ": FileDescriptorFilter close ParcelFileDescriptor");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
