package com.myscript.nebo.dms.cloud.common.api;

import com.myscript.snt.dms.SWIGVectorCloudFileRequest;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Downloader implements Cancelable {
    public abstract Object download(SWIGVectorCloudFileRequest sWIGVectorCloudFileRequest, ProgressListener progressListener) throws Exception;
}
