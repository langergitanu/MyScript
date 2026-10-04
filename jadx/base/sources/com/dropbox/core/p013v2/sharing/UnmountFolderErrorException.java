package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class UnmountFolderErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final UnmountFolderError errorValue;

    public UnmountFolderErrorException(String str, String str2, LocalizedText localizedText, UnmountFolderError unmountFolderError) {
        super(str2, localizedText, buildMessage(str, localizedText, unmountFolderError));
        if (unmountFolderError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = unmountFolderError;
    }
}
