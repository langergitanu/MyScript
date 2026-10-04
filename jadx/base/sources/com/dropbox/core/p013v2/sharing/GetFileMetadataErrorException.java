package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class GetFileMetadataErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final GetFileMetadataError errorValue;

    public GetFileMetadataErrorException(String str, String str2, LocalizedText localizedText, GetFileMetadataError getFileMetadataError) {
        super(str2, localizedText, buildMessage(str, localizedText, getFileMetadataError));
        if (getFileMetadataError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = getFileMetadataError;
    }
}
