package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class RemoveFileMemberErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final RemoveFileMemberError errorValue;

    public RemoveFileMemberErrorException(String str, String str2, LocalizedText localizedText, RemoveFileMemberError removeFileMemberError) {
        super(str2, localizedText, buildMessage(str, localizedText, removeFileMemberError));
        if (removeFileMemberError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = removeFileMemberError;
    }
}
