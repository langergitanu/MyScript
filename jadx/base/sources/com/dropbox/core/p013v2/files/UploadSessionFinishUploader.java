package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxUploader;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.p013v2.files.FileMetadata;
import com.dropbox.core.p013v2.files.UploadSessionFinishError;

/* JADX INFO: loaded from: classes4.dex */
public class UploadSessionFinishUploader extends DbxUploader<FileMetadata, UploadSessionFinishError, UploadSessionFinishErrorException> {
    public UploadSessionFinishUploader(HttpRequestor.Uploader uploader, String str) {
        super(uploader, FileMetadata.Serializer.INSTANCE, UploadSessionFinishError.Serializer.INSTANCE, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.dropbox.core.DbxUploader
    public UploadSessionFinishErrorException newException(DbxWrappedException dbxWrappedException) {
        return new UploadSessionFinishErrorException("2/files/upload_session/finish", dbxWrappedException.getRequestId(), dbxWrappedException.getUserMessage(), (UploadSessionFinishError) dbxWrappedException.getErrorValue());
    }
}
