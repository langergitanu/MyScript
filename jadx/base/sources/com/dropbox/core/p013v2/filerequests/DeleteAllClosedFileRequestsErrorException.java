package com.dropbox.core.p013v2.filerequests;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class DeleteAllClosedFileRequestsErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final DeleteAllClosedFileRequestsError errorValue;

    public DeleteAllClosedFileRequestsErrorException(String str, String str2, LocalizedText localizedText, DeleteAllClosedFileRequestsError deleteAllClosedFileRequestsError) {
        super(str2, localizedText, buildMessage(str, localizedText, deleteAllClosedFileRequestsError));
        if (deleteAllClosedFileRequestsError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = deleteAllClosedFileRequestsError;
    }
}
