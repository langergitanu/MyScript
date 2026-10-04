package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class TeamFolderListContinueErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final TeamFolderListContinueError errorValue;

    public TeamFolderListContinueErrorException(String str, String str2, LocalizedText localizedText, TeamFolderListContinueError teamFolderListContinueError) {
        super(str2, localizedText, buildMessage(str, localizedText, teamFolderListContinueError));
        if (teamFolderListContinueError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = teamFolderListContinueError;
    }
}
