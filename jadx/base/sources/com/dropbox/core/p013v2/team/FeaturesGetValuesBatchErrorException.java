package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class FeaturesGetValuesBatchErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final FeaturesGetValuesBatchError errorValue;

    public FeaturesGetValuesBatchErrorException(String str, String str2, LocalizedText localizedText, FeaturesGetValuesBatchError featuresGetValuesBatchError) {
        super(str2, localizedText, buildMessage(str, localizedText, featuresGetValuesBatchError));
        if (featuresGetValuesBatchError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = featuresGetValuesBatchError;
    }
}
