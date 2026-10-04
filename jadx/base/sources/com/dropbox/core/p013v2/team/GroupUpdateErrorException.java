package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class GroupUpdateErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final GroupUpdateError errorValue;

    public GroupUpdateErrorException(String str, String str2, LocalizedText localizedText, GroupUpdateError groupUpdateError) {
        super(str2, localizedText, buildMessage(str, localizedText, groupUpdateError));
        if (groupUpdateError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = groupUpdateError;
    }
}
