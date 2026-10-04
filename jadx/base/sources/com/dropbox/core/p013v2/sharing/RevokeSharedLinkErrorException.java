package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class RevokeSharedLinkErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final RevokeSharedLinkError errorValue;

    public RevokeSharedLinkErrorException(String str, String str2, LocalizedText localizedText, RevokeSharedLinkError revokeSharedLinkError) {
        super(str2, localizedText, buildMessage(str, localizedText, revokeSharedLinkError));
        if (revokeSharedLinkError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = revokeSharedLinkError;
    }
}
