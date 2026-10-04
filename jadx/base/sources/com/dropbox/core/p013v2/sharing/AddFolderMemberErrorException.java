package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class AddFolderMemberErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final AddFolderMemberError errorValue;

    public AddFolderMemberErrorException(String str, String str2, LocalizedText localizedText, AddFolderMemberError addFolderMemberError) {
        super(str2, localizedText, buildMessage(str, localizedText, addFolderMemberError));
        if (addFolderMemberError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = addFolderMemberError;
    }
}
