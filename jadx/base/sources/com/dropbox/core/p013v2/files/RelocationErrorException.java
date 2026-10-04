package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class RelocationErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final RelocationError errorValue;

    public RelocationErrorException(String str, String str2, LocalizedText localizedText, RelocationError relocationError) {
        super(str2, localizedText, buildMessage(str, localizedText, relocationError));
        if (relocationError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = relocationError;
    }
}
