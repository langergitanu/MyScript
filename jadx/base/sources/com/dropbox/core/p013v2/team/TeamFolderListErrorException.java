package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class TeamFolderListErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final TeamFolderListError errorValue;

    public TeamFolderListErrorException(String str, String str2, LocalizedText localizedText, TeamFolderListError teamFolderListError) {
        super(str2, localizedText, buildMessage(str, localizedText, teamFolderListError));
        if (teamFolderListError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = teamFolderListError;
    }
}
