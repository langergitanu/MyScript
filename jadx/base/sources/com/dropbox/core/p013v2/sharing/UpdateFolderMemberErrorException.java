package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class UpdateFolderMemberErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final UpdateFolderMemberError errorValue;

    public UpdateFolderMemberErrorException(String str, String str2, LocalizedText localizedText, UpdateFolderMemberError updateFolderMemberError) {
        super(str2, localizedText, buildMessage(str, localizedText, updateFolderMemberError));
        if (updateFolderMemberError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = updateFolderMemberError;
    }
}
