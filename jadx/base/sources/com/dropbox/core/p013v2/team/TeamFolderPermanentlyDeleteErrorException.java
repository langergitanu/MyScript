package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class TeamFolderPermanentlyDeleteErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final TeamFolderPermanentlyDeleteError errorValue;

    public TeamFolderPermanentlyDeleteErrorException(String str, String str2, LocalizedText localizedText, TeamFolderPermanentlyDeleteError teamFolderPermanentlyDeleteError) {
        super(str2, localizedText, buildMessage(str, localizedText, teamFolderPermanentlyDeleteError));
        if (teamFolderPermanentlyDeleteError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = teamFolderPermanentlyDeleteError;
    }
}
