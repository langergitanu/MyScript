package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class MembersListErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final MembersListError errorValue;

    public MembersListErrorException(String str, String str2, LocalizedText localizedText, MembersListError membersListError) {
        super(str2, localizedText, buildMessage(str, localizedText, membersListError));
        if (membersListError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = membersListError;
    }
}
