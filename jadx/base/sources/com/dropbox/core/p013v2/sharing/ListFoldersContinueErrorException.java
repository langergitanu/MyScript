package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class ListFoldersContinueErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final ListFoldersContinueError errorValue;

    public ListFoldersContinueErrorException(String str, String str2, LocalizedText localizedText, ListFoldersContinueError listFoldersContinueError) {
        super(str2, localizedText, buildMessage(str, localizedText, listFoldersContinueError));
        if (listFoldersContinueError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = listFoldersContinueError;
    }
}
