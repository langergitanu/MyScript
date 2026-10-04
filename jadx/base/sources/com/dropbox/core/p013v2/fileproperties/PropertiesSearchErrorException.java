package com.dropbox.core.p013v2.fileproperties;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class PropertiesSearchErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final PropertiesSearchError errorValue;

    public PropertiesSearchErrorException(String str, String str2, LocalizedText localizedText, PropertiesSearchError propertiesSearchError) {
        super(str2, localizedText, buildMessage(str, localizedText, propertiesSearchError));
        if (propertiesSearchError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = propertiesSearchError;
    }
}
