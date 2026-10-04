package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxUploader;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.p013v2.files.PaperUpdateError;
import com.dropbox.core.p013v2.files.PaperUpdateResult;

/* JADX INFO: loaded from: classes4.dex */
public class PaperUpdateUploader extends DbxUploader<PaperUpdateResult, PaperUpdateError, PaperUpdateErrorException> {
    public PaperUpdateUploader(HttpRequestor.Uploader uploader, String str) {
        super(uploader, PaperUpdateResult.Serializer.INSTANCE, PaperUpdateError.Serializer.INSTANCE, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.dropbox.core.DbxUploader
    public PaperUpdateErrorException newException(DbxWrappedException dbxWrappedException) {
        return new PaperUpdateErrorException("2/files/paper/update", dbxWrappedException.getRequestId(), dbxWrappedException.getUserMessage(), (PaperUpdateError) dbxWrappedException.getErrorValue());
    }
}
