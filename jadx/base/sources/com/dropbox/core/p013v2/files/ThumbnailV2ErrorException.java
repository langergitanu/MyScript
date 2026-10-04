package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class ThumbnailV2ErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final ThumbnailV2Error errorValue;

    public ThumbnailV2ErrorException(String str, String str2, LocalizedText localizedText, ThumbnailV2Error thumbnailV2Error) {
        super(str2, localizedText, buildMessage(str, localizedText, thumbnailV2Error));
        if (thumbnailV2Error == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = thumbnailV2Error;
    }
}
