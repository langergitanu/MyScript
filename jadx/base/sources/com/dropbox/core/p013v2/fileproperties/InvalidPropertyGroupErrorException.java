package com.dropbox.core.p013v2.fileproperties;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class InvalidPropertyGroupErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final InvalidPropertyGroupError errorValue;

    public InvalidPropertyGroupErrorException(String str, String str2, LocalizedText localizedText, InvalidPropertyGroupError invalidPropertyGroupError) {
        super(str2, localizedText, buildMessage(str, localizedText, invalidPropertyGroupError));
        if (invalidPropertyGroupError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = invalidPropertyGroupError;
    }
}
