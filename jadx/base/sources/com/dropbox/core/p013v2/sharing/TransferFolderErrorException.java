package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class TransferFolderErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final TransferFolderError errorValue;

    public TransferFolderErrorException(String str, String str2, LocalizedText localizedText, TransferFolderError transferFolderError) {
        super(str2, localizedText, buildMessage(str, localizedText, transferFolderError));
        if (transferFolderError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = transferFolderError;
    }
}
