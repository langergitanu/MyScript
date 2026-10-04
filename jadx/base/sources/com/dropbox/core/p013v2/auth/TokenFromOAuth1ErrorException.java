package com.dropbox.core.p013v2.auth;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class TokenFromOAuth1ErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final TokenFromOAuth1Error errorValue;

    public TokenFromOAuth1ErrorException(String str, String str2, LocalizedText localizedText, TokenFromOAuth1Error tokenFromOAuth1Error) {
        super(str2, localizedText, buildMessage(str, localizedText, tokenFromOAuth1Error));
        if (tokenFromOAuth1Error == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = tokenFromOAuth1Error;
    }
}
