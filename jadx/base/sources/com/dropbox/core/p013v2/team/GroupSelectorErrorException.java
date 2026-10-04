package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class GroupSelectorErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final GroupSelectorError errorValue;

    public GroupSelectorErrorException(String str, String str2, LocalizedText localizedText, GroupSelectorError groupSelectorError) {
        super(str2, localizedText, buildMessage(str, localizedText, groupSelectorError));
        if (groupSelectorError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = groupSelectorError;
    }
}
