package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class ListMembersAppsErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final ListMembersAppsError errorValue;

    public ListMembersAppsErrorException(String str, String str2, LocalizedText localizedText, ListMembersAppsError listMembersAppsError) {
        super(str2, localizedText, buildMessage(str, localizedText, listMembersAppsError));
        if (listMembersAppsError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = listMembersAppsError;
    }
}
