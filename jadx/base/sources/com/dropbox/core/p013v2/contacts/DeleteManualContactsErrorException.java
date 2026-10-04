package com.dropbox.core.p013v2.contacts;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class DeleteManualContactsErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final DeleteManualContactsError errorValue;

    public DeleteManualContactsErrorException(String str, String str2, LocalizedText localizedText, DeleteManualContactsError deleteManualContactsError) {
        super(str2, localizedText, buildMessage(str, localizedText, deleteManualContactsError));
        if (deleteManualContactsError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = deleteManualContactsError;
    }
}
