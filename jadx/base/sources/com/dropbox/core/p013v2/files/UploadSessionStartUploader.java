package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxUploader;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.p013v2.files.UploadSessionStartError;
import com.dropbox.core.p013v2.files.UploadSessionStartResult;

/* JADX INFO: loaded from: classes4.dex */
public class UploadSessionStartUploader extends DbxUploader<UploadSessionStartResult, UploadSessionStartError, UploadSessionStartErrorException> {
    public UploadSessionStartUploader(HttpRequestor.Uploader uploader, String str) {
        super(uploader, UploadSessionStartResult.Serializer.INSTANCE, UploadSessionStartError.Serializer.INSTANCE, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.dropbox.core.DbxUploader
    public UploadSessionStartErrorException newException(DbxWrappedException dbxWrappedException) {
        return new UploadSessionStartErrorException("2/files/upload_session/start", dbxWrappedException.getRequestId(), dbxWrappedException.getUserMessage(), (UploadSessionStartError) dbxWrappedException.getErrorValue());
    }
}
