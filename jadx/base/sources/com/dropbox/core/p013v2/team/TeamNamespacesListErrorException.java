package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class TeamNamespacesListErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final TeamNamespacesListError errorValue;

    public TeamNamespacesListErrorException(String str, String str2, LocalizedText localizedText, TeamNamespacesListError teamNamespacesListError) {
        super(str2, localizedText, buildMessage(str, localizedText, teamNamespacesListError));
        if (teamNamespacesListError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = teamNamespacesListError;
    }
}
