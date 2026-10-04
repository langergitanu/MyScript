package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class PaperUpdateErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final PaperUpdateError errorValue;

    public PaperUpdateErrorException(String str, String str2, LocalizedText localizedText, PaperUpdateError paperUpdateError) {
        super(str2, localizedText, buildMessage(str, localizedText, paperUpdateError));
        if (paperUpdateError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = paperUpdateError;
    }
}
