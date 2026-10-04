package com.dropbox.core.p013v2.fileproperties;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class UpdatePropertiesErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final UpdatePropertiesError errorValue;

    public UpdatePropertiesErrorException(String str, String str2, LocalizedText localizedText, UpdatePropertiesError updatePropertiesError) {
        super(str2, localizedText, buildMessage(str, localizedText, updatePropertiesError));
        if (updatePropertiesError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = updatePropertiesError;
    }
}
