package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class CreateSharedLinkWithSettingsErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final CreateSharedLinkWithSettingsError errorValue;

    public CreateSharedLinkWithSettingsErrorException(String str, String str2, LocalizedText localizedText, CreateSharedLinkWithSettingsError createSharedLinkWithSettingsError) {
        super(str2, localizedText, buildMessage(str, localizedText, createSharedLinkWithSettingsError));
        if (createSharedLinkWithSettingsError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = createSharedLinkWithSettingsError;
    }
}
