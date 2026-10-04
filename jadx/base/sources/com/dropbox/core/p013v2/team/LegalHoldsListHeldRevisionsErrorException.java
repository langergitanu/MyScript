package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class LegalHoldsListHeldRevisionsErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final LegalHoldsListHeldRevisionsError errorValue;

    public LegalHoldsListHeldRevisionsErrorException(String str, String str2, LocalizedText localizedText, LegalHoldsListHeldRevisionsError legalHoldsListHeldRevisionsError) {
        super(str2, localizedText, buildMessage(str, localizedText, legalHoldsListHeldRevisionsError));
        if (legalHoldsListHeldRevisionsError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = legalHoldsListHeldRevisionsError;
    }
}
