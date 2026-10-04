package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class UploadSessionFinishErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final UploadSessionFinishError errorValue;

    public UploadSessionFinishErrorException(String str, String str2, LocalizedText localizedText, UploadSessionFinishError uploadSessionFinishError) {
        super(str2, localizedText, buildMessage(str, localizedText, uploadSessionFinishError));
        if (uploadSessionFinishError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = uploadSessionFinishError;
    }
}
