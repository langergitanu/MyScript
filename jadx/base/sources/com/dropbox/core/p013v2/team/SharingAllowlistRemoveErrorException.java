package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class SharingAllowlistRemoveErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final SharingAllowlistRemoveError errorValue;

    public SharingAllowlistRemoveErrorException(String str, String str2, LocalizedText localizedText, SharingAllowlistRemoveError sharingAllowlistRemoveError) {
        super(str2, localizedText, buildMessage(str, localizedText, sharingAllowlistRemoveError));
        if (sharingAllowlistRemoveError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = sharingAllowlistRemoveError;
    }
}
