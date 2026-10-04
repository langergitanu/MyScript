package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class MembersListContinueErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final MembersListContinueError errorValue;

    public MembersListContinueErrorException(String str, String str2, LocalizedText localizedText, MembersListContinueError membersListContinueError) {
        super(str2, localizedText, buildMessage(str, localizedText, membersListContinueError));
        if (membersListContinueError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = membersListContinueError;
    }
}
