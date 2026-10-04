package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class ExcludedUsersListContinueErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final ExcludedUsersListContinueError errorValue;

    public ExcludedUsersListContinueErrorException(String str, String str2, LocalizedText localizedText, ExcludedUsersListContinueError excludedUsersListContinueError) {
        super(str2, localizedText, buildMessage(str, localizedText, excludedUsersListContinueError));
        if (excludedUsersListContinueError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = excludedUsersListContinueError;
    }
}
