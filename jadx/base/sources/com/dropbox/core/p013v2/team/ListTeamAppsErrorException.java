package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class ListTeamAppsErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final ListTeamAppsError errorValue;

    public ListTeamAppsErrorException(String str, String str2, LocalizedText localizedText, ListTeamAppsError listTeamAppsError) {
        super(str2, localizedText, buildMessage(str, localizedText, listTeamAppsError));
        if (listTeamAppsError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = listTeamAppsError;
    }
}
