package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class AlphaGetMetadataErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final AlphaGetMetadataError errorValue;

    public AlphaGetMetadataErrorException(String str, String str2, LocalizedText localizedText, AlphaGetMetadataError alphaGetMetadataError) {
        super(str2, localizedText, buildMessage(str, localizedText, alphaGetMetadataError));
        if (alphaGetMetadataError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = alphaGetMetadataError;
    }
}
