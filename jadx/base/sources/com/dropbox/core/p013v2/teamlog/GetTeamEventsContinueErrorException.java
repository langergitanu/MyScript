package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class GetTeamEventsContinueErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final GetTeamEventsContinueError errorValue;

    public GetTeamEventsContinueErrorException(String str, String str2, LocalizedText localizedText, GetTeamEventsContinueError getTeamEventsContinueError) {
        super(str2, localizedText, buildMessage(str, localizedText, getTeamEventsContinueError));
        if (getTeamEventsContinueError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = getTeamEventsContinueError;
    }
}
