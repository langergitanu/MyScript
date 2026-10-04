package com.dropbox.core.p013v2.filerequests;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class CreateFileRequestErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final CreateFileRequestError errorValue;

    public CreateFileRequestErrorException(String str, String str2, LocalizedText localizedText, CreateFileRequestError createFileRequestError) {
        super(str2, localizedText, buildMessage(str, localizedText, createFileRequestError));
        if (createFileRequestError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = createFileRequestError;
    }
}
