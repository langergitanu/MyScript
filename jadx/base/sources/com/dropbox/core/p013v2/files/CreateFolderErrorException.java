package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class CreateFolderErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final CreateFolderError errorValue;

    public CreateFolderErrorException(String str, String str2, LocalizedText localizedText, CreateFolderError createFolderError) {
        super(str2, localizedText, buildMessage(str, localizedText, createFolderError));
        if (createFolderError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = createFolderError;
    }
}
