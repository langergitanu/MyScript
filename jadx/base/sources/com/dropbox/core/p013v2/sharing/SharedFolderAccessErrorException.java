package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class SharedFolderAccessErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final SharedFolderAccessError errorValue;

    public SharedFolderAccessErrorException(String str, String str2, LocalizedText localizedText, SharedFolderAccessError sharedFolderAccessError) {
        super(str2, localizedText, buildMessage(str, localizedText, sharedFolderAccessError));
        if (sharedFolderAccessError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = sharedFolderAccessError;
    }
}
