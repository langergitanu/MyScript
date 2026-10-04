package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class MembersSetProfileErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final MembersSetProfileError errorValue;

    public MembersSetProfileErrorException(String str, String str2, LocalizedText localizedText, MembersSetProfileError membersSetProfileError) {
        super(str2, localizedText, buildMessage(str, localizedText, membersSetProfileError));
        if (membersSetProfileError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = membersSetProfileError;
    }
}
