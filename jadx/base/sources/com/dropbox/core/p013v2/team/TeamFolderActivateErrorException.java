package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class TeamFolderActivateErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final TeamFolderActivateError errorValue;

    public TeamFolderActivateErrorException(String str, String str2, LocalizedText localizedText, TeamFolderActivateError teamFolderActivateError) {
        super(str2, localizedText, buildMessage(str, localizedText, teamFolderActivateError));
        if (teamFolderActivateError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = teamFolderActivateError;
    }
}
