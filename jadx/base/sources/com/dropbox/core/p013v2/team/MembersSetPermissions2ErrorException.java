package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class MembersSetPermissions2ErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final MembersSetPermissions2Error errorValue;

    public MembersSetPermissions2ErrorException(String str, String str2, LocalizedText localizedText, MembersSetPermissions2Error membersSetPermissions2Error) {
        super(str2, localizedText, buildMessage(str, localizedText, membersSetPermissions2Error));
        if (membersSetPermissions2Error == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = membersSetPermissions2Error;
    }
}
