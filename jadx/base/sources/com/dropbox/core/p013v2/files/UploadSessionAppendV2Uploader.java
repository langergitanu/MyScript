package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxUploader;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.p013v2.files.UploadSessionAppendError;
import com.dropbox.core.stone.StoneSerializers;

/* JADX INFO: loaded from: classes4.dex */
public class UploadSessionAppendV2Uploader extends DbxUploader<Void, UploadSessionAppendError, UploadSessionAppendErrorException> {
    public UploadSessionAppendV2Uploader(HttpRequestor.Uploader uploader, String str) {
        super(uploader, StoneSerializers.void_(), UploadSessionAppendError.Serializer.INSTANCE, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.dropbox.core.DbxUploader
    public UploadSessionAppendErrorException newException(DbxWrappedException dbxWrappedException) {
        return new UploadSessionAppendErrorException("2/files/upload_session/append_v2", dbxWrappedException.getRequestId(), dbxWrappedException.getUserMessage(), (UploadSessionAppendError) dbxWrappedException.getErrorValue());
    }
}
