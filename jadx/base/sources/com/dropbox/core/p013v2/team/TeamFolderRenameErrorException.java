package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class TeamFolderRenameErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final TeamFolderRenameError errorValue;

    public TeamFolderRenameErrorException(String str, String str2, LocalizedText localizedText, TeamFolderRenameError teamFolderRenameError) {
        super(str2, localizedText, buildMessage(str, localizedText, teamFolderRenameError));
        if (teamFolderRenameError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = teamFolderRenameError;
    }
}
