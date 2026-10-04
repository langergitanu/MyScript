package com.pdftron.filters;

import android.util.Log;
import android.util.SparseArray;
import java.nio.channels.FileChannel;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes7.dex */
public class FileDescriptorFilterManager {

    /* JADX INFO: renamed from: a */
    private boolean f1402a = false;

    /* JADX INFO: renamed from: b */
    private SparseArray<CustomFilter> f1403b;

    /* JADX INFO: renamed from: c */
    private final Lock f1404c;

    /* JADX INFO: renamed from: com.pdftron.filters.FileDescriptorFilterManager$a */
    static class C6926a {

        /* JADX INFO: renamed from: a */
        private static C6926a f1405a;

        /* JADX INFO: renamed from: b */
        private AtomicInteger f1406b = new AtomicInteger();

        /* JADX INFO: renamed from: a */
        public static C6926a m1124a() {
            if (f1405a == null) {
                f1405a = new C6926a();
            }
            return f1405a;
        }

        /* JADX INFO: renamed from: b */
        public final int m1126b() {
            return this.f1406b.incrementAndGet();
        }
    }

    public FileDescriptorFilterManager() {
        new Semaphore(1, true);
        this.f1404c = new ReentrantLock();
        this.f1403b = new SparseArray<>();
    }

    public boolean acquireLock() {
        Log.d("SaveFilterManager", "acquireLock");
        this.f1404c.lock();
        this.f1402a = true;
        return true;
    }

    public void releaseLock() {
        if (this.f1402a) {
            Log.d("SaveFilterManager", "releaseLock");
            this.f1402a = false;
            this.f1404c.unlock();
        }
    }

    public int getNewSequenceNumber() {
        int iIncrementAndGet;
        synchronized (this) {
            iIncrementAndGet = C6926a.m1124a().f1406b.incrementAndGet();
        }
        return iIncrementAndGet;
    }

    public void addReadFilter(CustomFilter customFilter) {
        synchronized (this) {
            m1122a(customFilter);
        }
    }

    public void removeReadFilter(CustomFilter customFilter) {
        synchronized (this) {
            m1123b(customFilter);
        }
    }

    public void addReadWriteFilter(CustomFilter customFilter) {
        synchronized (this) {
            m1122a(customFilter);
        }
    }

    public void removeReadWriteFilter(CustomFilter customFilter) {
        synchronized (this) {
            m1123b(customFilter);
        }
    }

    public void cleanup() {
        FileChannel fileChannel;
        int i;
        for (int i2 = 0; i2 < this.f1403b.size(); i2++) {
            CustomFilter customFilterValueAt = this.f1403b.valueAt(i2);
            if (customFilterValueAt instanceof FileDescriptorFilter) {
                FileDescriptorFilter fileDescriptorFilter = (FileDescriptorFilter) customFilterValueAt;
                fileChannel = fileDescriptorFilter.mFileChannel;
                i = fileDescriptorFilter.mMySequenceNumber;
            } else if (customFilterValueAt instanceof FileDescriptorReadOnlyFilter) {
                FileDescriptorReadOnlyFilter fileDescriptorReadOnlyFilter = (FileDescriptorReadOnlyFilter) customFilterValueAt;
                fileChannel = fileDescriptorReadOnlyFilter.mFileChannel;
                i = fileDescriptorReadOnlyFilter.mMySequenceNumber;
            } else {
                fileChannel = null;
                i = -1;
            }
            if (fileChannel != null) {
                try {
                    if (fileChannel.isOpen()) {
                        fileChannel.close();
                        Log.d("SaveFilterManager", i + ": FileDescriptorFilter close FileChannel");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1122a(CustomFilter customFilter) {
        int i;
        synchronized (this) {
            if (customFilter instanceof FileDescriptorFilter) {
                i = ((FileDescriptorFilter) customFilter).mMySequenceNumber;
            } else {
                i = customFilter instanceof FileDescriptorReadOnlyFilter ? ((FileDescriptorReadOnlyFilter) customFilter).mMySequenceNumber : -1;
            }
            if (i >= 0) {
                this.f1403b.put(i, customFilter);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m1123b(CustomFilter customFilter) {
        FileChannel fileChannel;
        int i;
        if (customFilter instanceof FileDescriptorFilter) {
            FileDescriptorFilter fileDescriptorFilter = (FileDescriptorFilter) customFilter;
            fileChannel = fileDescriptorFilter.mFileChannel;
            i = fileDescriptorFilter.mMySequenceNumber;
        } else if (customFilter instanceof FileDescriptorReadOnlyFilter) {
            FileDescriptorReadOnlyFilter fileDescriptorReadOnlyFilter = (FileDescriptorReadOnlyFilter) customFilter;
            fileChannel = fileDescriptorReadOnlyFilter.mFileChannel;
            i = fileDescriptorReadOnlyFilter.mMySequenceNumber;
        } else {
            fileChannel = null;
            i = -1;
        }
        if (fileChannel != null) {
            synchronized (this) {
                try {
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (fileChannel.isOpen()) {
                    fileChannel.close();
                    Log.d("SaveFilterManager", i + ": FileDescriptorFilter close FileChannel");
                    this.f1403b.remove(i);
                } else {
                    this.f1403b.remove(i);
                }
            }
        }
    }
}
