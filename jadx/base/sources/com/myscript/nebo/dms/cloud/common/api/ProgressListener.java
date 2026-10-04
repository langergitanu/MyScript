package com.myscript.nebo.dms.cloud.common.api;

/* JADX INFO: loaded from: classes7.dex */
public interface ProgressListener {
    void onComplete(Long l, String str);

    boolean onProgress(Long l, boolean z, long j, long j2);
}
