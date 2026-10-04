package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class ListFolderLongpollErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final ListFolderLongpollError errorValue;

    public ListFolderLongpollErrorException(String str, String str2, LocalizedText localizedText, ListFolderLongpollError listFolderLongpollError) {
        super(str2, localizedText, buildMessage(str, localizedText, listFolderLongpollError));
        if (listFolderLongpollError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = listFolderLongpollError;
    }
}
