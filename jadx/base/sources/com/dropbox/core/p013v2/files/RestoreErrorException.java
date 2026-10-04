package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class RestoreErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final RestoreError errorValue;

    public RestoreErrorException(String str, String str2, LocalizedText localizedText, RestoreError restoreError) {
        super(str2, localizedText, buildMessage(str, localizedText, restoreError));
        if (restoreError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = restoreError;
    }
}
