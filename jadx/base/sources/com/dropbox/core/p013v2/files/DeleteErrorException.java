package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class DeleteErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final DeleteError errorValue;

    public DeleteErrorException(String str, String str2, LocalizedText localizedText, DeleteError deleteError) {
        super(str2, localizedText, buildMessage(str, localizedText, deleteError));
        if (deleteError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = deleteError;
    }
}
