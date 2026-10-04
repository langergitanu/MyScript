package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class ListFolderContinueErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final ListFolderContinueError errorValue;

    public ListFolderContinueErrorException(String str, String str2, LocalizedText localizedText, ListFolderContinueError listFolderContinueError) {
        super(str2, localizedText, buildMessage(str, localizedText, listFolderContinueError));
        if (listFolderContinueError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = listFolderContinueError;
    }
}
