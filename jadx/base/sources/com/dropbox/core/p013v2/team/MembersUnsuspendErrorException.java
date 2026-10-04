package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class MembersUnsuspendErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final MembersUnsuspendError errorValue;

    public MembersUnsuspendErrorException(String str, String str2, LocalizedText localizedText, MembersUnsuspendError membersUnsuspendError) {
        super(str2, localizedText, buildMessage(str, localizedText, membersUnsuspendError));
        if (membersUnsuspendError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = membersUnsuspendError;
    }
}
