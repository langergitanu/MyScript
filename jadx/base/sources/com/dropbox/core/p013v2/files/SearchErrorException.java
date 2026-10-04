package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class SearchErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final SearchError errorValue;

    public SearchErrorException(String str, String str2, LocalizedText localizedText, SearchError searchError) {
        super(str2, localizedText, buildMessage(str, localizedText, searchError));
        if (searchError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = searchError;
    }
}
