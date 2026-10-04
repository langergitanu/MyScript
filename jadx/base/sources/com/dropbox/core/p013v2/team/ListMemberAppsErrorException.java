package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class ListMemberAppsErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final ListMemberAppsError errorValue;

    public ListMemberAppsErrorException(String str, String str2, LocalizedText localizedText, ListMemberAppsError listMemberAppsError) {
        super(str2, localizedText, buildMessage(str, localizedText, listMemberAppsError));
        if (listMemberAppsError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = listMemberAppsError;
    }
}
