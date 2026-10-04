package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class RevokeLinkedAppErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final RevokeLinkedAppError errorValue;

    public RevokeLinkedAppErrorException(String str, String str2, LocalizedText localizedText, RevokeLinkedAppError revokeLinkedAppError) {
        super(str2, localizedText, buildMessage(str, localizedText, revokeLinkedAppError));
        if (revokeLinkedAppError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = revokeLinkedAppError;
    }
}
