package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class ListSharedLinksErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final ListSharedLinksError errorValue;

    public ListSharedLinksErrorException(String str, String str2, LocalizedText localizedText, ListSharedLinksError listSharedLinksError) {
        super(str2, localizedText, buildMessage(str, localizedText, listSharedLinksError));
        if (listSharedLinksError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = listSharedLinksError;
    }
}
