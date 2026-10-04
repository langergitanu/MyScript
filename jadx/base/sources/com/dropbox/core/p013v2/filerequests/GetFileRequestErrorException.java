package com.dropbox.core.p013v2.filerequests;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class GetFileRequestErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final GetFileRequestError errorValue;

    public GetFileRequestErrorException(String str, String str2, LocalizedText localizedText, GetFileRequestError getFileRequestError) {
        super(str2, localizedText, buildMessage(str, localizedText, getFileRequestError));
        if (getFileRequestError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = getFileRequestError;
    }
}
