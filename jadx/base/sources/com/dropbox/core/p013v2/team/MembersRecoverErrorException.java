package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class MembersRecoverErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final MembersRecoverError errorValue;

    public MembersRecoverErrorException(String str, String str2, LocalizedText localizedText, MembersRecoverError membersRecoverError) {
        super(str2, localizedText, buildMessage(str, localizedText, membersRecoverError));
        if (membersRecoverError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = membersRecoverError;
    }
}
