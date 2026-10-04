package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadZipErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final DownloadZipError errorValue;

    public DownloadZipErrorException(String str, String str2, LocalizedText localizedText, DownloadZipError downloadZipError) {
        super(str2, localizedText, buildMessage(str, localizedText, downloadZipError));
        if (downloadZipError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = downloadZipError;
    }
}
