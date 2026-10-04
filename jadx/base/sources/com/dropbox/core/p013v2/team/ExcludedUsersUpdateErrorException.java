package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class ExcludedUsersUpdateErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final ExcludedUsersUpdateError errorValue;

    public ExcludedUsersUpdateErrorException(String str, String str2, LocalizedText localizedText, ExcludedUsersUpdateError excludedUsersUpdateError) {
        super(str2, localizedText, buildMessage(str, localizedText, excludedUsersUpdateError));
        if (excludedUsersUpdateError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = excludedUsersUpdateError;
    }
}
