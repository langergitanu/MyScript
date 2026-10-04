package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxUploader;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.p013v2.files.FileMetadata;
import com.dropbox.core.p013v2.files.UploadError;

/* JADX INFO: loaded from: classes4.dex */
public class UploadUploader extends DbxUploader<FileMetadata, UploadError, UploadErrorException> {
    public UploadUploader(HttpRequestor.Uploader uploader, String str) {
        super(uploader, FileMetadata.Serializer.INSTANCE, UploadError.Serializer.INSTANCE, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.dropbox.core.DbxUploader
    public UploadErrorException newException(DbxWrappedException dbxWrappedException) {
        return new UploadErrorException("2/files/upload", dbxWrappedException.getRequestId(), dbxWrappedException.getUserMessage(), (UploadError) dbxWrappedException.getErrorValue());
    }
}
