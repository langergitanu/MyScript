package com.dropbox.core.p013v2.paper;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class PaperDocUpdateErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final PaperDocUpdateError errorValue;

    public PaperDocUpdateErrorException(String str, String str2, LocalizedText localizedText, PaperDocUpdateError paperDocUpdateError) {
        super(str2, localizedText, buildMessage(str, localizedText, paperDocUpdateError));
        if (paperDocUpdateError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = paperDocUpdateError;
    }
}
