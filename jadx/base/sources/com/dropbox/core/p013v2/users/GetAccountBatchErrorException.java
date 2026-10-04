package com.dropbox.core.p013v2.users;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class GetAccountBatchErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final GetAccountBatchError errorValue;

    public GetAccountBatchErrorException(String str, String str2, LocalizedText localizedText, GetAccountBatchError getAccountBatchError) {
        super(str2, localizedText, buildMessage(str, localizedText, getAccountBatchError));
        if (getAccountBatchError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = getAccountBatchError;
    }
}
