package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class ExportErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final ExportError errorValue;

    public ExportErrorException(String str, String str2, LocalizedText localizedText, ExportError exportError) {
        super(str2, localizedText, buildMessage(str, localizedText, exportError));
        if (exportError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = exportError;
    }
}
