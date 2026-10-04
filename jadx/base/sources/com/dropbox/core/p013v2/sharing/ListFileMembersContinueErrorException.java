package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class ListFileMembersContinueErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final ListFileMembersContinueError errorValue;

    public ListFileMembersContinueErrorException(String str, String str2, LocalizedText localizedText, ListFileMembersContinueError listFileMembersContinueError) {
        super(str2, localizedText, buildMessage(str, localizedText, listFileMembersContinueError));
        if (listFileMembersContinueError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = listFileMembersContinueError;
    }
}
