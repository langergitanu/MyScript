package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class ListFilesContinueErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final ListFilesContinueError errorValue;

    public ListFilesContinueErrorException(String str, String str2, LocalizedText localizedText, ListFilesContinueError listFilesContinueError) {
        super(str2, localizedText, buildMessage(str, localizedText, listFilesContinueError));
        if (listFilesContinueError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = listFilesContinueError;
    }
}
