package com.dropbox.core.p013v2.filerequests;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class ListFileRequestsErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final ListFileRequestsError errorValue;

    public ListFileRequestsErrorException(String str, String str2, LocalizedText localizedText, ListFileRequestsError listFileRequestsError) {
        super(str2, localizedText, buildMessage(str, localizedText, listFileRequestsError));
        if (listFileRequestsError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = listFileRequestsError;
    }
}
