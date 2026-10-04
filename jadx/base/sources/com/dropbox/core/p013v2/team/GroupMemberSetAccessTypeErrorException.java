package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class GroupMemberSetAccessTypeErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final GroupMemberSetAccessTypeError errorValue;

    public GroupMemberSetAccessTypeErrorException(String str, String str2, LocalizedText localizedText, GroupMemberSetAccessTypeError groupMemberSetAccessTypeError) {
        super(str2, localizedText, buildMessage(str, localizedText, groupMemberSetAccessTypeError));
        if (groupMemberSetAccessTypeError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = groupMemberSetAccessTypeError;
    }
}
