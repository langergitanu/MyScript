package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class GetThumbnailBatchErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final GetThumbnailBatchError errorValue;

    public GetThumbnailBatchErrorException(String str, String str2, LocalizedText localizedText, GetThumbnailBatchError getThumbnailBatchError) {
        super(str2, localizedText, buildMessage(str, localizedText, getThumbnailBatchError));
        if (getThumbnailBatchError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = getThumbnailBatchError;
    }
}
