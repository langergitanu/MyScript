package com.dropbox.core.p013v2.account;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes4.dex */
public class SetProfilePhotoErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final SetProfilePhotoError errorValue;

    public SetProfilePhotoErrorException(String str, String str2, LocalizedText localizedText, SetProfilePhotoError setProfilePhotoError) {
        super(str2, localizedText, buildMessage(str, localizedText, setProfilePhotoError));
        if (setProfilePhotoError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = setProfilePhotoError;
    }
}
