package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class BaseTagErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final BaseTagError errorValue;

    public BaseTagErrorException(String str, String str2, LocalizedText localizedText, BaseTagError baseTagError) {
        super(str2, localizedText, buildMessage(str, localizedText, baseTagError));
        if (baseTagError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = baseTagError;
    }
}
