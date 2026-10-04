package com.dropbox.core.p013v2.filerequests;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class ListFileRequestsContinueErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final ListFileRequestsContinueError errorValue;

    public ListFileRequestsContinueErrorException(String str, String str2, LocalizedText localizedText, ListFileRequestsContinueError listFileRequestsContinueError) {
        super(str2, localizedText, buildMessage(str, localizedText, listFileRequestsContinueError));
        if (listFileRequestsContinueError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = listFileRequestsContinueError;
    }
}
