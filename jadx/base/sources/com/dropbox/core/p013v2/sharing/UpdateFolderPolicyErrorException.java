package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class UpdateFolderPolicyErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final UpdateFolderPolicyError errorValue;

    public UpdateFolderPolicyErrorException(String str, String str2, LocalizedText localizedText, UpdateFolderPolicyError updateFolderPolicyError) {
        super(str2, localizedText, buildMessage(str, localizedText, updateFolderPolicyError));
        if (updateFolderPolicyError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = updateFolderPolicyError;
    }
}
