package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class SharingAllowlistAddErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final SharingAllowlistAddError errorValue;

    public SharingAllowlistAddErrorException(String str, String str2, LocalizedText localizedText, SharingAllowlistAddError sharingAllowlistAddError) {
        super(str2, localizedText, buildMessage(str, localizedText, sharingAllowlistAddError));
        if (sharingAllowlistAddError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = sharingAllowlistAddError;
    }
}
