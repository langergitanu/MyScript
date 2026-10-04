package com.myscript.atk.resourcemanager.internal.bean;

import android.util.ArrayMap;
import android.util.ArraySet;
import androidx.collection.LongSparseArray;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadInfo {
    private int mAlreadyExistSize;
    private int mFileCount;
    private int mSize;
    private final Set<Long> mDownloadPending = new HashSet();
    private final Set<Long> mDownloadCompleted = new HashSet();
    private final LongSparseArray<Integer> mDownloadedSoFar = new LongSparseArray<>();
    private final LongSparseArray<File> mDestinationFiles = new LongSparseArray<>();
    private final LongSparseArray<File> mLocalFiles = new LongSparseArray<>();
    private final LongSparseArray<String> mFilesHash = new LongSparseArray<>();
    private final Map<String, Set<Long>> mFolderDownloadIds = new ArrayMap();

    public long[] getDownloadPendingIds() {
        return toArray(this.mDownloadPending);
    }

    public long[] getDownloadCompleted() {
        return toArray(this.mDownloadCompleted);
    }

    public long[] getDownloadIds() {
        long[] jArr = new long[this.mDownloadPending.size() + this.mDownloadCompleted.size()];
        Iterator<Long> it = this.mDownloadPending.iterator();
        int i = 0;
        while (it.hasNext()) {
            jArr[i] = it.next().longValue();
            i++;
        }
        Iterator<Long> it2 = this.mDownloadCompleted.iterator();
        while (it2.hasNext()) {
            jArr[i] = it2.next().longValue();
            i++;
        }
        return jArr;
    }

    public Set<Long> getDownloadIds(String str) {
        Set<Long> set = this.mFolderDownloadIds.get(str);
        return set == null ? new ArraySet() : set;
    }

    public boolean isEmpty() {
        return this.mDestinationFiles.isEmpty();
    }

    public void addDownloadId(long j, String str) {
        this.mFileCount++;
        this.mDownloadPending.add(Long.valueOf(j));
        Set<Long> arraySet = this.mFolderDownloadIds.get(str);
        if (arraySet == null) {
            arraySet = new ArraySet<>();
            this.mFolderDownloadIds.put(str, arraySet);
        }
        arraySet.add(Long.valueOf(j));
    }

    public void setDownloadComplete(long j) {
        this.mDownloadCompleted.add(Long.valueOf(j));
        this.mDownloadPending.remove(Long.valueOf(j));
    }

    public void setDownloadedSoFar(long j, int i) {
        this.mDownloadedSoFar.put(j, Integer.valueOf(i));
    }

    public int getDownloadedSoFar() {
        int iIntValue = 0;
        for (int i = 0; i < this.mDownloadedSoFar.size(); i++) {
            iIntValue += this.mDownloadedSoFar.valueAt(i).intValue();
        }
        return iIntValue;
    }

    public void setAlreadyExistSize(int i) {
        this.mAlreadyExistSize = i;
    }

    public int getAlreadyExistSize() {
        return this.mAlreadyExistSize;
    }

    public boolean isDownloadComplete() {
        return this.mDownloadCompleted.size() == this.mFileCount;
    }

    public void setDestinationFile(long j, File file) {
        this.mDestinationFiles.put(j, file);
    }

    public File getDestinationFile(long j) {
        return this.mDestinationFiles.get(j);
    }

    public void setLocalFile(long j, File file) {
        this.mLocalFiles.put(j, file);
    }

    public File getLocalFile(long j) {
        return this.mLocalFiles.get(j);
    }

    public void setFileHash(long j, String str) {
        this.mFilesHash.put(j, str);
    }

    public String getFileHash(long j) {
        return this.mFilesHash.get(j);
    }

    public int getSize() {
        return this.mSize;
    }

    public void setSize(int i) {
        this.mSize = i;
    }

    public Set<String> getFolders() {
        return this.mFolderDownloadIds.keySet();
    }

    public File findLocalFileDyDestinationName(String str, String str2) {
        Set<Long> set = this.mFolderDownloadIds.get(str2);
        File file = null;
        for (int i = 0; i < this.mDestinationFiles.size(); i++) {
            if (set.contains(Long.valueOf(this.mDestinationFiles.keyAt(i))) && this.mDestinationFiles.valueAt(i).getName().equals(str)) {
                file = this.mLocalFiles.get(this.mDestinationFiles.keyAt(i));
            }
        }
        return file;
    }

    private long[] toArray(Set<Long> set) {
        int i = 0;
        if (set == null) {
            return new long[0];
        }
        long[] jArr = new long[set.size()];
        Iterator<Long> it = set.iterator();
        while (it.hasNext()) {
            jArr[i] = it.next().longValue();
            i++;
        }
        return jArr;
    }
}
