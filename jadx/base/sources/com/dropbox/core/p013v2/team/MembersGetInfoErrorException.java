package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class MembersGetInfoErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final MembersGetInfoError errorValue;

    public MembersGetInfoErrorException(String str, String str2, LocalizedText localizedText, MembersGetInfoError membersGetInfoError) {
        super(str2, localizedText, buildMessage(str, localizedText, membersGetInfoError));
        if (membersGetInfoError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = membersGetInfoError;
    }
}
