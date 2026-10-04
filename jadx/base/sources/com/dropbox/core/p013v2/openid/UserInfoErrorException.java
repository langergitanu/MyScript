package com.dropbox.core.p013v2.openid;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class UserInfoErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final UserInfoError errorValue;

    public UserInfoErrorException(String str, String str2, LocalizedText localizedText, UserInfoError userInfoError) {
        super(str2, localizedText, buildMessage(str, localizedText, userInfoError));
        if (userInfoError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = userInfoError;
    }
}
