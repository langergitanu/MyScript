package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class PaperCreateErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final PaperCreateError errorValue;

    public PaperCreateErrorException(String str, String str2, LocalizedText localizedText, PaperCreateError paperCreateError) {
        super(str2, localizedText, buildMessage(str, localizedText, paperCreateError));
        if (paperCreateError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = paperCreateError;
    }
}
