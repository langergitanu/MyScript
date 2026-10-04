package com.dropbox.core.p013v2.fileproperties;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class PropertiesSearchContinueErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final PropertiesSearchContinueError errorValue;

    public PropertiesSearchContinueErrorException(String str, String str2, LocalizedText localizedText, PropertiesSearchContinueError propertiesSearchContinueError) {
        super(str2, localizedText, buildMessage(str, localizedText, propertiesSearchContinueError));
        if (propertiesSearchContinueError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = propertiesSearchContinueError;
    }
}
