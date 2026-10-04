package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class AddSecondaryEmailsErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final AddSecondaryEmailsError errorValue;

    public AddSecondaryEmailsErrorException(String str, String str2, LocalizedText localizedText, AddSecondaryEmailsError addSecondaryEmailsError) {
        super(str2, localizedText, buildMessage(str, localizedText, addSecondaryEmailsError));
        if (addSecondaryEmailsError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = addSecondaryEmailsError;
    }
}
