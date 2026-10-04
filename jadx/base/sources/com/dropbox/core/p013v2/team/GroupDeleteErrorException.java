package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class GroupDeleteErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final GroupDeleteError errorValue;

    public GroupDeleteErrorException(String str, String str2, LocalizedText localizedText, GroupDeleteError groupDeleteError) {
        super(str2, localizedText, buildMessage(str, localizedText, groupDeleteError));
        if (groupDeleteError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = groupDeleteError;
    }
}
