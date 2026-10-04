package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class ModifySharedLinkSettingsErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final ModifySharedLinkSettingsError errorValue;

    public ModifySharedLinkSettingsErrorException(String str, String str2, LocalizedText localizedText, ModifySharedLinkSettingsError modifySharedLinkSettingsError) {
        super(str2, localizedText, buildMessage(str, localizedText, modifySharedLinkSettingsError));
        if (modifySharedLinkSettingsError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = modifySharedLinkSettingsError;
    }
}
