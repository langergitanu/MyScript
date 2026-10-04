package com.dropbox.core.p013v2.filerequests;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class CountFileRequestsErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final CountFileRequestsError errorValue;

    public CountFileRequestsErrorException(String str, String str2, LocalizedText localizedText, CountFileRequestsError countFileRequestsError) {
        super(str2, localizedText, buildMessage(str, localizedText, countFileRequestsError));
        if (countFileRequestsError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = countFileRequestsError;
    }
}
