package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class TeamFolderCreateErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final TeamFolderCreateError errorValue;

    public TeamFolderCreateErrorException(String str, String str2, LocalizedText localizedText, TeamFolderCreateError teamFolderCreateError) {
        super(str2, localizedText, buildMessage(str, localizedText, teamFolderCreateError));
        if (teamFolderCreateError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = teamFolderCreateError;
    }
}
