package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class UploadSessionStartErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final UploadSessionStartError errorValue;

    public UploadSessionStartErrorException(String str, String str2, LocalizedText localizedText, UploadSessionStartError uploadSessionStartError) {
        super(str2, localizedText, buildMessage(str, localizedText, uploadSessionStartError));
        if (uploadSessionStartError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = uploadSessionStartError;
    }
}
