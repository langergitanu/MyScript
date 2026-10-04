package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class TeamFolderArchiveErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final TeamFolderArchiveError errorValue;

    public TeamFolderArchiveErrorException(String str, String str2, LocalizedText localizedText, TeamFolderArchiveError teamFolderArchiveError) {
        super(str2, localizedText, buildMessage(str, localizedText, teamFolderArchiveError));
        if (teamFolderArchiveError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = teamFolderArchiveError;
    }
}
