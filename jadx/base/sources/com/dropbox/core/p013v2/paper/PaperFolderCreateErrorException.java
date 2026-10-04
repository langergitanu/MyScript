package com.dropbox.core.p013v2.paper;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class PaperFolderCreateErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final PaperFolderCreateError errorValue;

    public PaperFolderCreateErrorException(String str, String str2, LocalizedText localizedText, PaperFolderCreateError paperFolderCreateError) {
        super(str2, localizedText, buildMessage(str, localizedText, paperFolderCreateError));
        if (paperFolderCreateError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = paperFolderCreateError;
    }
}
