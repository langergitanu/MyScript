package com.dropbox.core.p013v2.paper;

import com.dropbox.core.DbxUploader;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.p013v2.paper.PaperDocCreateError;
import com.dropbox.core.p013v2.paper.PaperDocCreateUpdateResult;

/* JADX INFO: loaded from: classes4.dex */
public class DocsCreateUploader extends DbxUploader<PaperDocCreateUpdateResult, PaperDocCreateError, PaperDocCreateErrorException> {
    public DocsCreateUploader(HttpRequestor.Uploader uploader, String str) {
        super(uploader, PaperDocCreateUpdateResult.Serializer.INSTANCE, PaperDocCreateError.Serializer.INSTANCE, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.dropbox.core.DbxUploader
    public PaperDocCreateErrorException newException(DbxWrappedException dbxWrappedException) {
        return new PaperDocCreateErrorException("2/paper/docs/create", dbxWrappedException.getRequestId(), dbxWrappedException.getUserMessage(), (PaperDocCreateError) dbxWrappedException.getErrorValue());
    }
}
