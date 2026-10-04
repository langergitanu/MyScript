package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class ListRevisionsErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final ListRevisionsError errorValue;

    public ListRevisionsErrorException(String str, String str2, LocalizedText localizedText, ListRevisionsError listRevisionsError) {
        super(str2, localizedText, buildMessage(str, localizedText, listRevisionsError));
        if (listRevisionsError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = listRevisionsError;
    }
}
