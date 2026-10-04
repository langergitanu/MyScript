package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class GetSharedLinkFileErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final GetSharedLinkFileError errorValue;

    public GetSharedLinkFileErrorException(String str, String str2, LocalizedText localizedText, GetSharedLinkFileError getSharedLinkFileError) {
        super(str2, localizedText, buildMessage(str, localizedText, getSharedLinkFileError));
        if (getSharedLinkFileError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = getSharedLinkFileError;
    }
}
