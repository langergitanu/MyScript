package com.dropbox.core.p013v2.paper;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class ListDocsCursorErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final ListDocsCursorError errorValue;

    public ListDocsCursorErrorException(String str, String str2, LocalizedText localizedText, ListDocsCursorError listDocsCursorError) {
        super(str2, localizedText, buildMessage(str, localizedText, listDocsCursorError));
        if (listDocsCursorError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = listDocsCursorError;
    }
}
