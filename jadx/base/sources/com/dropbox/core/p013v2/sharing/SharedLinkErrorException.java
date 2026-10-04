package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class SharedLinkErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final SharedLinkError errorValue;

    public SharedLinkErrorException(String str, String str2, LocalizedText localizedText, SharedLinkError sharedLinkError) {
        super(str2, localizedText, buildMessage(str, localizedText, sharedLinkError));
        if (sharedLinkError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = sharedLinkError;
    }
}
