package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class GroupCreateErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final GroupCreateError errorValue;

    public GroupCreateErrorException(String str, String str2, LocalizedText localizedText, GroupCreateError groupCreateError) {
        super(str2, localizedText, buildMessage(str, localizedText, groupCreateError));
        if (groupCreateError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = groupCreateError;
    }
}
