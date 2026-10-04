package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class LegalHoldsPolicyUpdateErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final LegalHoldsPolicyUpdateError errorValue;

    public LegalHoldsPolicyUpdateErrorException(String str, String str2, LocalizedText localizedText, LegalHoldsPolicyUpdateError legalHoldsPolicyUpdateError) {
        super(str2, localizedText, buildMessage(str, localizedText, legalHoldsPolicyUpdateError));
        if (legalHoldsPolicyUpdateError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = legalHoldsPolicyUpdateError;
    }
}
