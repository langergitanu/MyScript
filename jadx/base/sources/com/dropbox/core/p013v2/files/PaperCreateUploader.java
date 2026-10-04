package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxUploader;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.p013v2.files.PaperCreateError;
import com.dropbox.core.p013v2.files.PaperCreateResult;

/* JADX INFO: loaded from: classes4.dex */
public class PaperCreateUploader extends DbxUploader<PaperCreateResult, PaperCreateError, PaperCreateErrorException> {
    public PaperCreateUploader(HttpRequestor.Uploader uploader, String str) {
        super(uploader, PaperCreateResult.Serializer.INSTANCE, PaperCreateError.Serializer.INSTANCE, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.dropbox.core.DbxUploader
    public PaperCreateErrorException newException(DbxWrappedException dbxWrappedException) {
        return new PaperCreateErrorException("2/files/paper/create", dbxWrappedException.getRequestId(), dbxWrappedException.getUserMessage(), (PaperCreateError) dbxWrappedException.getErrorValue());
    }
}
