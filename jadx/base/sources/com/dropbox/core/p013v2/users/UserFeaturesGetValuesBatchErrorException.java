package com.dropbox.core.p013v2.users;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class UserFeaturesGetValuesBatchErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final UserFeaturesGetValuesBatchError errorValue;

    public UserFeaturesGetValuesBatchErrorException(String str, String str2, LocalizedText localizedText, UserFeaturesGetValuesBatchError userFeaturesGetValuesBatchError) {
        super(str2, localizedText, buildMessage(str, localizedText, userFeaturesGetValuesBatchError));
        if (userFeaturesGetValuesBatchError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = userFeaturesGetValuesBatchError;
    }
}
