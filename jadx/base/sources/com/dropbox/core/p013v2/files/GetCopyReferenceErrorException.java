package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class GetCopyReferenceErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final GetCopyReferenceError errorValue;

    public GetCopyReferenceErrorException(String str, String str2, LocalizedText localizedText, GetCopyReferenceError getCopyReferenceError) {
        super(str2, localizedText, buildMessage(str, localizedText, getCopyReferenceError));
        if (getCopyReferenceError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = getCopyReferenceError;
    }
}
