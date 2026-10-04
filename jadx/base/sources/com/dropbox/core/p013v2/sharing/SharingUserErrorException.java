package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class SharingUserErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final SharingUserError errorValue;

    public SharingUserErrorException(String str, String str2, LocalizedText localizedText, SharingUserError sharingUserError) {
        super(str2, localizedText, buildMessage(str, localizedText, sharingUserError));
        if (sharingUserError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = sharingUserError;
    }
}
