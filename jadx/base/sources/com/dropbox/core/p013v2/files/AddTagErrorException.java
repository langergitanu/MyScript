package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class AddTagErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final AddTagError errorValue;

    public AddTagErrorException(String str, String str2, LocalizedText localizedText, AddTagError addTagError) {
        super(str2, localizedText, buildMessage(str, localizedText, addTagError));
        if (addTagError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = addTagError;
    }
}
