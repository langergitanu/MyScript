package com.myscript.nebo.dms.cloud.common.api;

import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Uploader implements Cancelable {
    public abstract List<UploadResult> upload(List<UploadItem> list, ProgressListener progressListener) throws Exception;

    public static class UploadItem {
        public String fileId;
        public Long lastModificationInMilliSeconds;
        public String notebookCloudPath;
        public String notebookName;
        public String notebookTempUploadPath;
        public String parentId;
        public Long requestId;
        public Long size;
        public UUID uuid;

        public UploadItem(Long l, String str, String str2) {
            this(l, null, null, null, str, str2, null, null);
        }

        public UploadItem(Long l, String str, String str2, String str3, String str4, String str5, Long l2, Long l3) {
            this.requestId = l;
            this.fileId = str;
            this.notebookName = str2;
            this.parentId = str3;
            this.notebookCloudPath = str4;
            this.notebookTempUploadPath = str5;
            this.lastModificationInMilliSeconds = l2;
            this.size = l3;
            this.uuid = UUID.randomUUID();
        }
    }

    public static class UploadResult {
        public String cloudId;
        public String cloudPath;
        public String content_hash;
        public Object extra;
        public boolean insufficientStorage;
        public Exception lastError;
        public String localPath;
        public long requestId;
        public String revision;
        public Long size;
        public boolean success;

        public UploadResult(long j, String str, String str2, String str3, String str4, long j2) {
            this(j, str, str2, str3, str4, null, false, false, null, null, j2);
        }

        public UploadResult(long j, String str, String str2, String str3, String str4, String str5, boolean z, boolean z2, Exception exc, Object obj, long j2) {
            this.requestId = j;
            this.cloudId = str;
            this.cloudPath = str2;
            this.revision = str3;
            this.localPath = str4;
            this.content_hash = str5;
            this.success = z;
            this.insufficientStorage = z2;
            this.lastError = exc;
            this.extra = obj;
            this.size = Long.valueOf(j2);
        }
    }
}
