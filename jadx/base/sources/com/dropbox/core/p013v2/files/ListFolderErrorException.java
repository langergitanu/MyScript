package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class ListFolderErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final ListFolderError errorValue;

    public ListFolderErrorException(String str, String str2, LocalizedText localizedText, ListFolderError listFolderError) {
        super(str2, localizedText, buildMessage(str, localizedText, listFolderError));
        if (listFolderError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = listFolderError;
    }
}
