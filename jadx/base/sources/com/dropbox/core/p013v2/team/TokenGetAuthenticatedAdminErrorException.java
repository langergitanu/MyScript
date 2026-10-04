package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class TokenGetAuthenticatedAdminErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final TokenGetAuthenticatedAdminError errorValue;

    public TokenGetAuthenticatedAdminErrorException(String str, String str2, LocalizedText localizedText, TokenGetAuthenticatedAdminError tokenGetAuthenticatedAdminError) {
        super(str2, localizedText, buildMessage(str, localizedText, tokenGetAuthenticatedAdminError));
        if (tokenGetAuthenticatedAdminError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = tokenGetAuthenticatedAdminError;
    }
}
