package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class LegalHoldsGetPolicyErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final LegalHoldsGetPolicyError errorValue;

    public LegalHoldsGetPolicyErrorException(String str, String str2, LocalizedText localizedText, LegalHoldsGetPolicyError legalHoldsGetPolicyError) {
        super(str2, localizedText, buildMessage(str, localizedText, legalHoldsGetPolicyError));
        if (legalHoldsGetPolicyError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = legalHoldsGetPolicyError;
    }
}
