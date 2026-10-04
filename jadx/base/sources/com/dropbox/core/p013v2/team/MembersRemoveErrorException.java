package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class MembersRemoveErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final MembersRemoveError errorValue;

    public MembersRemoveErrorException(String str, String str2, LocalizedText localizedText, MembersRemoveError membersRemoveError) {
        super(str2, localizedText, buildMessage(str, localizedText, membersRemoveError));
        if (membersRemoveError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = membersRemoveError;
    }
}
