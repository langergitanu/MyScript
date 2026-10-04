package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class LockFileErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final LockFileError errorValue;

    public LockFileErrorException(String str, String str2, LocalizedText localizedText, LockFileError lockFileError) {
        super(str2, localizedText, buildMessage(str, localizedText, lockFileError));
        if (lockFileError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = lockFileError;
    }
}
