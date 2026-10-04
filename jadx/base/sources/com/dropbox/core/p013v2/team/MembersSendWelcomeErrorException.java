package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class MembersSendWelcomeErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final MembersSendWelcomeError errorValue;

    public MembersSendWelcomeErrorException(String str, String str2, LocalizedText localizedText, MembersSendWelcomeError membersSendWelcomeError) {
        super(str2, localizedText, buildMessage(str, localizedText, membersSendWelcomeError));
        if (membersSendWelcomeError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = membersSendWelcomeError;
    }
}
