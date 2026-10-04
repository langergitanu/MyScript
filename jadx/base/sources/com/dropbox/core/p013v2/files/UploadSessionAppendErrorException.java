package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class UploadSessionAppendErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final UploadSessionAppendError errorValue;

    public UploadSessionAppendErrorException(String str, String str2, LocalizedText localizedText, UploadSessionAppendError uploadSessionAppendError) {
        super(str2, localizedText, buildMessage(str, localizedText, uploadSessionAppendError));
        if (uploadSessionAppendError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = uploadSessionAppendError;
    }
}
