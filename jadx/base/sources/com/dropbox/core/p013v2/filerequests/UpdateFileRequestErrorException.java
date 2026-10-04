package com.dropbox.core.p013v2.filerequests;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class UpdateFileRequestErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final UpdateFileRequestError errorValue;

    public UpdateFileRequestErrorException(String str, String str2, LocalizedText localizedText, UpdateFileRequestError updateFileRequestError) {
        super(str2, localizedText, buildMessage(str, localizedText, updateFileRequestError));
        if (updateFileRequestError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = updateFileRequestError;
    }
}
