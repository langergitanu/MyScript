package com.dropbox.core.p013v2.paper;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class ListUsersCursorErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final ListUsersCursorError errorValue;

    public ListUsersCursorErrorException(String str, String str2, LocalizedText localizedText, ListUsersCursorError listUsersCursorError) {
        super(str2, localizedText, buildMessage(str, localizedText, listUsersCursorError));
        if (listUsersCursorError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = listUsersCursorError;
    }
}
