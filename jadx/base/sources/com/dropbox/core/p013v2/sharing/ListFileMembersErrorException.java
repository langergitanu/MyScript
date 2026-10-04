package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class ListFileMembersErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final ListFileMembersError errorValue;

    public ListFileMembersErrorException(String str, String str2, LocalizedText localizedText, ListFileMembersError listFileMembersError) {
        super(str2, localizedText, buildMessage(str, localizedText, listFileMembersError));
        if (listFileMembersError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = listFileMembersError;
    }
}
