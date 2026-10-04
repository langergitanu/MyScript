package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class AddFileMemberErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final AddFileMemberError errorValue;

    public AddFileMemberErrorException(String str, String str2, LocalizedText localizedText, AddFileMemberError addFileMemberError) {
        super(str2, localizedText, buildMessage(str, localizedText, addFileMemberError));
        if (addFileMemberError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = addFileMemberError;
    }
}
