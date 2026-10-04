package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class UnshareFolderErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final UnshareFolderError errorValue;

    public UnshareFolderErrorException(String str, String str2, LocalizedText localizedText, UnshareFolderError unshareFolderError) {
        super(str2, localizedText, buildMessage(str, localizedText, unshareFolderError));
        if (unshareFolderError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = unshareFolderError;
    }
}
