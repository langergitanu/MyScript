package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class GroupsPollErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final GroupsPollError errorValue;

    public GroupsPollErrorException(String str, String str2, LocalizedText localizedText, GroupsPollError groupsPollError) {
        super(str2, localizedText, buildMessage(str, localizedText, groupsPollError));
        if (groupsPollError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = groupsPollError;
    }
}
