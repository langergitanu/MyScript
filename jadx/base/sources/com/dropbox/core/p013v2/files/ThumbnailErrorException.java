package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class ThumbnailErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final ThumbnailError errorValue;

    public ThumbnailErrorException(String str, String str2, LocalizedText localizedText, ThumbnailError thumbnailError) {
        super(str2, localizedText, buildMessage(str, localizedText, thumbnailError));
        if (thumbnailError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = thumbnailError;
    }
}
