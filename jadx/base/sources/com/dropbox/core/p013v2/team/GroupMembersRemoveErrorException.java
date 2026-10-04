package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class GroupMembersRemoveErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final GroupMembersRemoveError errorValue;

    public GroupMembersRemoveErrorException(String str, String str2, LocalizedText localizedText, GroupMembersRemoveError groupMembersRemoveError) {
        super(str2, localizedText, buildMessage(str, localizedText, groupMembersRemoveError));
        if (groupMembersRemoveError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = groupMembersRemoveError;
    }
}
