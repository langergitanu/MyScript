package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class PreviewErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final PreviewError errorValue;

    public PreviewErrorException(String str, String str2, LocalizedText localizedText, PreviewError previewError) {
        super(str2, localizedText, buildMessage(str, localizedText, previewError));
        if (previewError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = previewError;
    }
}
