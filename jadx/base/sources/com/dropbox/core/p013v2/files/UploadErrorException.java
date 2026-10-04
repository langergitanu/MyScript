package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class UploadErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final UploadError errorValue;

    public UploadErrorException(String str, String str2, LocalizedText localizedText, UploadError uploadError) {
        super(str2, localizedText, buildMessage(str, localizedText, uploadError));
        if (uploadError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = uploadError;
    }
}
