package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/* JADX INFO: loaded from: classes5.dex */
public class MembersDeleteProfilePhotoErrorException extends DbxApiException {
    private static final long serialVersionUID = 0;
    public final MembersDeleteProfilePhotoError errorValue;

    public MembersDeleteProfilePhotoErrorException(String str, String str2, LocalizedText localizedText, MembersDeleteProfilePhotoError membersDeleteProfilePhotoError) {
        super(str2, localizedText, buildMessage(str, localizedText, membersDeleteProfilePhotoError));
        if (membersDeleteProfilePhotoError == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = membersDeleteProfilePhotoError;
    }
}
