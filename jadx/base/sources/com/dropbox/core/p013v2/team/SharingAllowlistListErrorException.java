package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class SharingAllowlistListErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final SharingAllowlistListError errorValue;

    public SharingAllowlistListErrorException(String str, String str2, LocalizedText localizedText, SharingAllowlistListError sharingAllowlistListError) {
        super(str2, localizedText, buildMessage(str, localizedText, sharingAllowlistListError));
        if (sharingAllowlistListError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = sharingAllowlistListError;
    }
}
