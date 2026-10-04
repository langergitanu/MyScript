package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class RevokeDeviceSessionBatchErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final RevokeDeviceSessionBatchError errorValue;

    public RevokeDeviceSessionBatchErrorException(String str, String str2, LocalizedText localizedText, RevokeDeviceSessionBatchError revokeDeviceSessionBatchError) {
        super(str2, localizedText, buildMessage(str, localizedText, revokeDeviceSessionBatchError));
        if (revokeDeviceSessionBatchError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = revokeDeviceSessionBatchError;
    }
}
