package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class MembersSuspendErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final MembersSuspendError errorValue;

    public MembersSuspendErrorException(String str, String str2, LocalizedText localizedText, MembersSuspendError membersSuspendError) {
        super(str2, localizedText, buildMessage(str, localizedText, membersSuspendError));
        if (membersSuspendError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = membersSuspendError;
    }
}
