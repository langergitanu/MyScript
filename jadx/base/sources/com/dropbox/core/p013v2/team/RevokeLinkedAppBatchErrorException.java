package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class RevokeLinkedAppBatchErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final RevokeLinkedAppBatchError errorValue;

    public RevokeLinkedAppBatchErrorException(String str, String str2, LocalizedText localizedText, RevokeLinkedAppBatchError revokeLinkedAppBatchError) {
        super(str2, localizedText, buildMessage(str, localizedText, revokeLinkedAppBatchError));
        if (revokeLinkedAppBatchError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = revokeLinkedAppBatchError;
    }
}
