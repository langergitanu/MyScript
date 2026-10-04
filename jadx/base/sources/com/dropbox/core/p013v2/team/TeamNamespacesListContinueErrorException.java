package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class TeamNamespacesListContinueErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final TeamNamespacesListContinueError errorValue;

    public TeamNamespacesListContinueErrorException(String str, String str2, LocalizedText localizedText, TeamNamespacesListContinueError teamNamespacesListContinueError) {
        super(str2, localizedText, buildMessage(str, localizedText, teamNamespacesListContinueError));
        if (teamNamespacesListContinueError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = teamNamespacesListContinueError;
    }
}
