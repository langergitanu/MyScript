package com.dropbox.core.p013v2.paper;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class DocLookupErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final DocLookupError errorValue;

    public DocLookupErrorException(String str, String str2, LocalizedText localizedText, DocLookupError docLookupError) {
        super(str2, localizedText, buildMessage(str, localizedText, docLookupError));
        if (docLookupError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = docLookupError;
    }
}
